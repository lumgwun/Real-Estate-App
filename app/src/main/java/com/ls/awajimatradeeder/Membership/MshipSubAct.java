package com.ls.awajimatradeeder.Membership;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ls.awajimatradeeder.Database.DBHelper;
import com.ls.awajimatradeeder.LoginDirAct;
import com.ls.awajimatradeeder.R;
import com.ls.awajimatradeeder.Tranx.LSPaymentServices;
import com.ls.awajimatradeeder.Tranx.OurConfig;
import com.ls.awajimatradeeder.Tranx.PaymentPlan;
import com.ls.awajimatradeeder.Tranx.PaystackPlan;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Objects;

import co.paystack.android.Paystack;
import co.paystack.android.PaystackSdk;
import co.paystack.android.exceptions.ExpiredAccessCodeException;
import co.paystack.android.model.Card;
import co.paystack.android.model.Charge;

import static java.lang.String.valueOf;

public class MshipSubAct extends AppCompatActivity {
    private  Bundle paymentBundle;
    private double amountInNaira;
    private String amountString;
    private PaystackPlan paystackPlan;
    private PaymentPlan paymentPlan;
    private  LSPaymentServices paymentservices;
    private String payload = null;
    private Button btnPay, btnHome,btnHome2;
    private TextView txtAmt;
    private Card card;
    private Charge charge;

    private EditText emailField,c_name1,c_name2,c_phone2,cEmail2,cAddress2;
    private EditText cardNumberField;
    private EditText expiryMonthField;
    private EditText expiryYearField;
    private EditText cvvField;

    private String profileEmail,profilePhone,accessCode, cardNumber,refID, cvv,planCode;
    private int expiryMonth, expiryYear;
    DBHelper dbHelper;
    private static final String PREF_NAME = "Tradeeder";
    ProgressDialog dialog;
    private Card card1;
    private int tranxID;
    private LinearLayoutCompat layoutCompatNow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_mship_sub);
        paymentBundle=getIntent().getExtras();
        dbHelper=new DBHelper(this);
        paystackPlan=new PaystackPlan();
        paymentPlan= new PaymentPlan();
        btnPay = findViewById(R.id.pay_now);
        txtAmt = findViewById(R.id.sub_Amt);
        btnHome2 = findViewById(R.id.home_from_);
        layoutCompatNow = findViewById(R.id.layoutPayNow);
        PaystackSdk.initialize(getApplicationContext());
        PaystackSdk.setPublicKey(OurConfig.PUBLIC_KEY_PAYSTACK);
        cardNumberField = (EditText) findViewById(R.id.edit_card_number);

        expiryMonthField = (EditText) findViewById(R.id.edit_expiry_month);
        expiryYearField = (EditText) findViewById(R.id.edit_expiry_year);
        cvvField = findViewById(R.id.edit_cvv);

        btnHome2.setOnClickListener(this::home2);
        btnPay.setOnClickListener(this::membershipPay);

        paymentservices = new LSPaymentServices();
        if(paymentBundle !=null){
            amountInNaira=paymentBundle.getDouble("AmountInNGN");
            txtAmt.setText("Amount : NGN"+amountInNaira);
            planCode=paymentBundle.getString("planCode");
            refID=paymentBundle.getString("refID");
            profileEmail=paymentBundle.getString("profileEmail");
            profilePhone=paymentBundle.getString("profilePhone");
            tranxID=paymentBundle.getInt("TranxID");

        }
        /*amountString= String.valueOf(amountInNaira);
        paystackPlan.setAmount(amountString);
        paystackPlan.setCurrency("NGN");
        paystackPlan.setDescription("Membership Subscription");
        paystackPlan.setDuration("3");
        paystackPlan.setSend_invoices(true);
        paystackPlan.setInterval("monthly");
        paystackPlan.setName("");
        paystackPlan.setSeckey("");
        paystackPlan.setName("");
        paymentPlan.doCreatePayStackPayment(paystackPlan);
        doPayment(payload,paystackPlan);*/

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    performCharge(true,amountInNaira,planCode,refID,tranxID,profileEmail);
                } catch (Exception e) {
                    Toast.makeText(MshipSubAct.this, "An error occurred while charging card", Toast.LENGTH_LONG).show();


                }

            }
        });
        btnHome = findViewById(R.id.home_from_payment);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Objects.requireNonNull(expiryMonthField).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() == 2 && !s.toString().contains("/")) {
                    s.append("/");
                }
            }

        });

    }
    private void performCharge(boolean local, double amountInNaira, String code, String planCode, int tranxID, String profileEmail) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        charge = new Charge();
        charge.setCard(loadCardFromForm());

        dialog = new ProgressDialog(MshipSubAct.this);
        dialog.setMessage("Performing Coop. transaction... please wait");
        dialog.show();
        accessCode=refID;
        if (local) {

            charge.setEmail(profileEmail);
            charge.setAmount(Integer.parseInt(valueOf(amountInNaira)));
            charge.setCard(card1);
            charge.setReference(refID);
            charge.setPlan(planCode);
            charge.setAccessCode(accessCode);
            try {
                charge.putCustomField("Charged From", "Our Coop.  App");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            chargeCard(amountInNaira);
        } else {
            finish();
        }

    }
    private Card loadCardFromForm() {

        try {
            cardNumber = cardNumberField.getText().toString().trim();
        } catch (Exception ignored) {
        }
        try {
            cvv = cvvField.getText().toString().trim();
        } catch (Exception ignored) {
        }


        card1 = new Card.Builder(cardNumber, 0, 0, "").build();
        card1.setCvc(cvv);

        String sMonth = expiryMonthField.getText().toString().trim();
        //expiryMonth = Integer.parseInt(expiryMonthField.getText().toString().trim());
        int month = 0;
        try {
            month = Integer.parseInt(sMonth);
        } catch (Exception ignored) {
        }

        card1.setExpiryMonth(month);


        String sYear = expiryYearField.getText().toString().trim();
        int year = 0;
        try {
            year = Integer.parseInt(sYear);
        } catch (Exception ignored) {
        }
        card1.setExpiryYear(year);

        return card1;
    }

    private void chargeCard(double amountInNaira) {
        co.paystack.android.Transaction transaction = null;
        PaystackSdk.chargeCard(MshipSubAct.this, charge, new Paystack.TransactionCallback() {
            @Override
            public void onSuccess(co.paystack.android.Transaction transaction) {
                dismissDialog();
                layoutCompatNow.setVisibility(View.GONE);
                setResult(Activity.RESULT_OK);
                setResult(Activity.RESULT_OK, new Intent());
                Toast.makeText(MshipSubAct.this, "Transaction Successful! payment reference: ", Toast.LENGTH_LONG).show();
            }

            @Override
            public void beforeValidate(co.paystack.android.Transaction transaction) {
                Toast.makeText(MshipSubAct.this, transaction.getReference(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(Throwable error, co.paystack.android.Transaction transaction) {
                setResult(Activity.RESULT_CANCELED, new Intent());
                if (error instanceof ExpiredAccessCodeException) {
                    MshipSubAct.this.performCharge(false,amountInNaira,planCode,refID,tranxID,profileEmail);
                    return;
                }

                dismissDialog();

                if (transaction.getReference() != null) {
                    Toast.makeText(MshipSubAct.this, transaction.getReference() + " concluded with error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    txtAmt.setText(String.format("%s  concluded with error: %s %s", transaction.getReference(), error.getClass().getSimpleName(), error.getMessage()));
                    //new verifyOnServer().execute(transaction.getReference());
                } else {
                    Toast.makeText(MshipSubAct.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    txtAmt.setText(String.format("Error: %s %s", error.getClass().getSimpleName(), error.getMessage()));
                }

            }

        });
    }
    private class fetchAccessCodeFromServer extends AsyncTask<String, Void, String> {
        private String error;

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result != null) {
                charge.setAccessCode(result);
                //chargeCard();
                startActivity(new Intent(MshipSubAct.this, LoginDirAct.class));
            } else {
                MshipSubAct.this.txtAmt.setText(String.format("There was a problem getting a new access code form the backend: %s", error));
                dismissDialog();
            }
        }

        @Override
        protected String doInBackground(String... ac_url) {
            try {
                java.net.URL url = new URL(ac_url[0]);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                url.openStream()));

                String inputLine;
                inputLine = in.readLine();
                in.close();
                return inputLine;
            } catch (Exception e) {
                error = e.getClass().getSimpleName() + ": " + e.getMessage();
            }
            return null;
        }
    }
    private void dismissDialog() {
        if ((dialog != null) && dialog.isShowing()) {
            dialog.dismiss();
        }
    }


    public void membershipPay(View view) {
    }

    public void home2(View view) {
    }
}