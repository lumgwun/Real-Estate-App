package com.ls.awajimatradeeder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.util.Base64;
import android.widget.Toast;

import com.ls.awajimatradeeder.Classes.AppConstants;
import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;

import static com.ls.awajimatradeeder.Classes.AppConstants.ACCOUNT_SID;
import static com.ls.awajimatradeeder.Classes.AppConstants.AUTH_TOKEN;
import static com.ls.awajimatradeeder.Classes.AppConstants.FROM;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_PHONE;

public class SMSAct extends AppCompatActivity {
    Bundle smsBundle;
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 340;
    String phoneNumber;
    String smsMessage, cusEmail;
    String from = "Skylight Coop.";
    String to;
    Message message;
    private String subject,body;
    String base64EncodedCredentials;
    Map<String, String> data;
    Session session;
    MimeMessage mimeMessage;
    String host = "https://skylightciacs.com:2096/";
    Integer port;
    final String user="bdm@skylightciacs.com";
    final String password= AppConstants.emailPassword;
    TwilioRestClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_smsact);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Properties properties=new Properties();
        ProcessBuilder process = new ProcessBuilder();
        if (ACCOUNT_SID != null) {
            if (AUTH_TOKEN != null) {
                client = new TwilioRestClient.Builder(ACCOUNT_SID, AUTH_TOKEN).build();
            }
        }
        //client = new TwilioRestClient.Builder(ACCOUNT_SID, AUTH_TOKEN).build();
        //Session session=Session.getInstance(properties,null);

        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.auth", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.quitwait", "false");
        from=FROM;
        /*try {


        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
            Toast.makeText(this, "Something went wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }*/
        session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        mimeMessage=new MimeMessage(session);




        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(Objects.requireNonNull(process.environment().get("PORT")));
        } else {
            port = 4567;
        }

        Twilio.init("AC5e05dc0a793a29dc1da2eabdebd6c28d", "39410e8b813c131da386f3d7bb7f94f7");
        smsBundle= getIntent().getExtras();
        if(smsBundle !=null){
            phoneNumber=smsBundle.getString(PROFILE_PHONE);
            smsMessage=smsBundle.getString("smsMessage");
            //from=smsBundle.getString("from");
            to=smsBundle.getString("to");
            cusEmail=smsBundle.getString("emailAddress");
            subject=smsBundle.getString("subject");

        }
        sendEmail(smsMessage,cusEmail,subject,mimeMessage);
        sendTextMessage(phoneNumber,smsMessage,from,to);
        base64EncodedCredentials = "Basic" + Base64.encodeToString ((ACCOUNT_SID + ":" + AUTH_TOKEN) .getBytes (), Base64.NO_WRAP);
        data = new HashMap<>();
        data.put ("From", from);
        data.put ("To", phoneNumber);
        data.put ("Body", smsMessage);
        sendSMSMessage(phoneNumber,smsMessage,from,to,base64EncodedCredentials,data);

    }
    protected void sendEmail(String smsMessage, String cusEmail, String subject, MimeMessage mimeMessage){
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    mimeMessage.setFrom(new InternetAddress("Skylight Coop."));
                    //DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(), "text/plain"));
                    mimeMessage.setSubject(subject);
                    mimeMessage.setText(smsMessage);
                    mimeMessage.setSender(new InternetAddress("bdm@skylightciacs.com"));
                    //mimeMessage.setDataHandler(handler);


                    if (cusEmail.indexOf(',') > 0)
                        mimeMessage.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(cusEmail));
                    else
                        mimeMessage.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(cusEmail));

                    Transport.send(mimeMessage);
                    System.out.println("message sent successfully....");

                }
                catch (MessagingException mex) {mex.printStackTrace();
                }

            }

        }).start();
    }

    private void sendTextMessage(String phoneNumber, String smsMessage, String from, String to) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)) {
            }
            else { ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_PERMISSIONS_REQUEST_CODE);
            }
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                smsBundle= getIntent().getExtras();
                if(smsBundle !=null){
                    phoneNumber=smsBundle.getString(PROFILE_PHONE);
                    smsMessage=smsBundle.getString("smsMessage");
                    //from=smsBundle.getString("from");
                    to=smsBundle.getString("to");

                }
                from=FROM;
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, smsMessage, null, null);
                Toast.makeText(this, "SMS sent.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(
                        this, "SMS failed, you may try again later.", Toast.LENGTH_LONG).show();
                return;
            }
        } else {
            throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }
    protected void sendSMSMessage(String phoneNumber, String smsMessage, String from, String to, String base64EncodedCredentials, Map<String, String> data) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        from=FROM;
        RequestBody body= RequestBody.Companion.create("{ \"body\": smsMessage,\"to\":phoneNumber,\"from\": from}", MediaType.parse("image/*"));
        //RequestBody body = RequestBody.create(mediaType, "{ \"body\": \"smsMessage\",\"to\" : \"+phoneNumber\",\"from\": \"Skylight\"}");
        Request request = new Request.Builder()
                .url("https://connect.routee.net/sms")
                .post(body)
                .addHeader("authorization", "Bearer 12dc9fe4-7df4-4786-8d7a-a46d307687f4")
                .addHeader("content-type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


        base64EncodedCredentials = "Basic" + Base64.encodeToString ((ACCOUNT_SID + ":" + AUTH_TOKEN) .getBytes (), Base64.NO_WRAP);
        data = new HashMap<>();
        data.put ("From", from);
        data.put ("To", phoneNumber);
        data.put ("Body", smsMessage);
        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ("https://api.twilio.com/2010-04-01/").build ();
        //TwilioApi api = retrofit.create(TwilioApi.class);
        try {
            /*Message message = new MessageCreator(
                    new PhoneNumber(to),
                    new PhoneNumber(from),
                    body).create(client);

            return message.getSid();*/
            /*TwilioRestClient client = new TwilioRestClient.Builder(ACCOUNT_SID, AUTH_TOKEN).build();


            api.sendMessage(ACCOUNT_SID, this.base64EncodedCredentials, this.data)
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {
                            //Send ok
                        }
                        @Override
                        public void onFailure(@NotNull Call<ResponseBody> call, Throwable t) {
                            //Failed
                        }

                    });*/


            /*Twilio.init("AC5e05dc0a793a29dc1da2eabdebd6c28d", "39410e8b813c131da386f3d7bb7f94f7");
             message = com.twilio.rest.api.v2010.account.Message.creator(
                    new com.twilio.type.PhoneNumber(phoneNumber),
                    new com.twilio.type.PhoneNumber("234"+phoneNumber),
                     smsMessage)
                    .create();*/

            /*message = Message.creator(
                    new com.twilio.type.PhoneNumber(phoneNumber),
                    new com.twilio.type.PhoneNumber("234" + phoneNumber),
                    smsMessage)
                    .create(client);*/


        } catch (NoSuchFieldError e) {
            e.printStackTrace();
            Toast.makeText(this, "Something went wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }



        /*List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", "+16518675309"));
        params.add(new BasicNameValuePair("From", "+14158141829"));
        params.add(new BasicNameValuePair("Body", "Hey Jenny! Good luck on the bar exam!"));
        params.add(new BasicNameValuePair("MediaUrl", "http://farm2.static.flickr.com/1075/1404618563_3ed9a44a3a.jpg"));*/



    }
}