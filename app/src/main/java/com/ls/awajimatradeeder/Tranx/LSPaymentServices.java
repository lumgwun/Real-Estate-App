package com.ls.awajimatradeeder.Tranx;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

public class LSPaymentServices {
    public String doflwbankpayment(String params, BankPayload bankpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = new HttpPost((OurConfig.LIVE_CHARGE_URL));
            Log.d("Our Coop. App payment response :::", params);
            //    {
//  "PBFPubKey": "FLWPUBK-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx-X",
//  "client": "VodhvFFsni0CBeieHPq9HTuG5lbNPgmD5rbEw6Uxb0TD9eD9B3VM5uZ1B5lC3thQMbPypNBCAYwSybPo9pNJUIXSNhgdzsqG8eEggSJhWYv+4HToZxWamqsWrUqNUgvaCws3iPTAJOy0fPuHI53dSaMbq/EeHnGrdosfSuAGvm/L6joVVb6e7vyZ4bJl9bJyT73INhSN5glUAvHElup+AOYVoyQiQ1gN7PmW6I0DrUiiC1GSq87zk8rt7Xv31OBja7Ib+znEHBfcI/Ii36HbQF2MunOy2oAteyWIbr3cTyUuyERroRKL769f3NMxUQw5iQ39LU0KgmP2XvgMQONcuiPJWlJ9LzG8ngqCZNFGQ5yIvYrUiiufPowa7A8sAgaoIQQMt0OWGijfpJ4CeAA9/s1Bv03ZhhX2",
//  "alg": "3DES-24"
//}
            Pay_load pay_load = new Pay_load();
            pay_load.setPBFPubKey(OurConfig.SKYLIGHT_PUBLIC_KEY);
            pay_load.setClient(params);
            pay_load.setAlg("alg");

            JSONObject requestJSON = new JSONObject();
            try {
                requestJSON.put("PBFPubKey", pay_load.getPBFPubKey());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                requestJSON.put("client", pay_load.getClient());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            requestJSON.put("alg", pay_load.getAlg());

            StringEntity input = new StringEntity(requestJSON.toString());
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);

            HttpResponse response = client.execute(post);
            Log.d("Our Coop. App payment response code :::", String.valueOf(response.getStatusLine().getStatusCode()));
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Log.d("Our Coop. App payment request", result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            if (response.getStatusLine().getStatusCode() == 500) {
                return "there is an error with the data";
            } else {
                return result.toString();
            }

        } catch (IOException ex) {
            Log.d("error", Arrays.toString(ex.getStackTrace()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }



    public String dopaymentplancreate(String params, Pamentplancreatepayload pamentplancreatepayload) throws IOException {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post  = new HttpPost((OurConfig.PAYMENT_PLAN_CREATE_LIVE_URL));


            post.setHeader("ContentType", "application/json");
            Log.d("do plan create :::", params);
            //System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);
            Log.d("plan create response code :::", String.valueOf(response.getStatusLine().getStatusCode()));
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Log.d("plan create request", result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            if (response.getStatusLine().getStatusCode() == 500) {
                return "there is an error with the data";
            } else {
                return result.toString();
            }

        } catch (UnsupportedEncodingException ex) {
            Log.d("Error", Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }

    public String doPayStackPaymentplancreate(String params, PaystackPlan paystackPlan) throws IOException {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpPost post  = new HttpPost((OurConfig.PAYSTACK_PLAN_CREATE_URL));
            post.setHeader("ContentType", "application/json");
            Log.d("do plan create :::", params);
            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            post.setEntity(input);
            HttpResponse response = client.execute(post);
            Log.d("plan create response code :::", String.valueOf(response.getStatusLine().getStatusCode()));
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Log.d("plan create request", result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            if (response.getStatusLine().getStatusCode() == 500) {
                return "there is an error with the data";
            } else {
                return result.toString();
            }

        } catch (UnsupportedEncodingException ex) {
            Log.d("Error", Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }


    public String dopaymentplanlist(String params, Paymentplanfetch paymentplanfetch) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post  = new HttpPost((OurConfig.PAYMENT_PLAN_LIVE_URL));


            post.setHeader("ContentType", "application/json");
            Log.d("do refund response :::", params);
            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            post.setEntity(input);
            HttpResponse response = client.execute(post);
            Log.d("do refund response code :::", String.valueOf(response.getStatusLine().getStatusCode()));
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Log.d("dorefund request", result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            if (response.getStatusLine().getStatusCode() == 500) {
                return "there is an error with the data";
            } else {
                return result.toString();
            }

        } catch (IOException ex) {
            Log.d("Error", Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }

    public String dopaymentplanfetch(Map<String, String> sParaTemp) throws IOException {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            String id = sParaTemp.get("id");
            String q = sParaTemp.get("q");
            String seckey = OurConfig.SKYLIGHT_SECRET_KEY;

            HttpPost post = null;

            if (id != null && q != null) {
                post = new HttpPost((OurConfig.PAYMENT_PLAN_LIVE_URL + seckey + id + q));
            } else if (id != null) {
                post = new HttpPost((OurConfig.PAYMENT_PLAN_LIVE_URL + seckey + id));
            } else if (q != null) {
                post = new HttpPost((OurConfig.PAYMENT_PLAN_LIVE_URL + seckey + q));
            } else {
                post = new HttpPost((OurConfig.PAYMENT_PLAN_LIVE_URL + seckey));
            }
            post.setHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(post);

            Log.d("do refund response code :::", String.valueOf(response.getStatusLine().getStatusCode()));
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Log.d("do refund request", result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            if (response.getStatusLine().getStatusCode() == 500) {
                return "there is an error with the data";
            } else {
                return result.toString();
            }

        } catch (UnsupportedEncodingException ex) {
            Log.d("Error", Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }

    public String dopaymentplancancel(Paymentplanfetch paymentplanfetch) throws IOException {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            String id = paymentplanfetch.getId();
            String seckey = OurConfig.SKYLIGHT_SECRET_KEY;

            HttpPost post = new HttpPost((OurConfig.PAYMENT_PLAN_CANCEL_LIVE_URL + id + "/cancel"));


            post.setHeader("ContentType", "application/json");

            JSONObject queryRequest = null;
            try {
                queryRequest = new JSONObject()
                        .put("seckey", OurConfig.SKYLIGHT_SECRET_KEY);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            StringEntity input = new StringEntity(queryRequest.toString());
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);
            Log.d("do payment plan cancel response code :::", String.valueOf(response.getStatusLine().getStatusCode()));
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Log.d("do payment plan cancel request", result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            if (response.getStatusLine().getStatusCode() == 500) {
                return "there is an error with the data";
            } else {
                return result.toString();
            }

        } catch (UnsupportedEncodingException ex) {
            Log.d("Error", Arrays.toString(ex.getStackTrace()));

        }
        return null;
    }

    //    public String dopaymentplancancel(Map<String, String> sParaTemp) {
//        StringBuilder result = new StringBuilder();
//        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
//
//            String id = sParaTemp.get("id");
//            String seckey = raveConfig.SECRET_KEY;
//
//            HttpPost post = new HttpPost((raveConfig.PAYMENT_PLAN_CANCEL_SANDBOX_URL+id+"/cancel"));
//            post.setHeader("ContentType", "application/json");
//
//
//            HttpResponse response = client.execute(post);
//
//            LOG.info("dopaymentplancancel response code ::: " + response.getStatusLine().getStatusCode());
//            BufferedReader rd = new BufferedReader(
//                    new InputStreamReader(response.getEntity().getContent()));
//
//            String line;
//            while ((line = rd.readLine()) != null) {
//                result.append(line);
//            }
//            LOG.info("dopaymentplancancel request" + result.toString());
//            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
//                return null;
//            }
//            if (response.getStatusLine().getStatusCode() == 500) {
//                return "there is an error with the data";
//            } else {
//                return result.toString();
//            }
//
//        } catch (UnsupportedEncodingException ex) {
//            LOG.error(Arrays.toString(ex.getStackTrace()));
//        } catch (IOException ex) {
//            LOG.error(Arrays.toString(ex.getStackTrace()));
//        }
//        return null;
//    }
    public String dopaymentplanedit(Paymentplanfetch paymentplanfetch) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            String id = paymentplanfetch.getId();

            HttpPost post = new HttpPost((OurConfig.PAYMENT_PLAN_CANCEL_LIVE_URL + id + "/edit"));

            post.setHeader("ContentType", "application/json");

            JSONObject queryRequest = null;
            try {
                queryRequest = new JSONObject()
                        .put("seckey", OurConfig.SKYLIGHT_SECRET_KEY)
                        .put("name", paymentplanfetch.getName())
                        .put("status", paymentplanfetch.getStatus());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            StringEntity input = null;
            if (queryRequest != null) {
                input = new StringEntity(queryRequest.toString());
            }
            if (input != null) {
                input.setContentType("application/json");
            }
            //System.out.println("input ===>" + input);
            post.setEntity(input);

            HttpResponse response = client.execute(post);
            Log.d("Response", String.valueOf(response.getStatusLine().getStatusCode()));
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Log.d("do payment plan edit request", result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            if (response.getStatusLine().getStatusCode() == 500) {
                return "there is an error with the data";
            } else {
                return result.toString();
            }

        } catch (UnsupportedEncodingException ex) {
            Log.d("Response", Arrays.toString(ex.getStackTrace()));
        } catch (IOException ex) {
            Log.d("Error", Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }

    //    public String dopaymentplanedit(Map<String, String> sParaTemp, String params) {
//        StringBuilder result = new StringBuilder();
//        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
//
//            String id = sParaTemp.get("id");
//            String seckey = raveConfig.SECRET_KEY;
//
//            HttpPost post = new HttpPost((raveConfig.PAYMENT_PLAN_CANCEL_SANDBOX_URL+id+"/cancel"));
//            post.setHeader("ContentType", "application/json");
//
//            StringEntity input = new StringEntity(params);
//            input.setContentType("application/json");
//            //System.out.println("input ===>" + input);
//            post.setEntity(input);
//
//            HttpResponse response = client.execute(post);
//
//            LOG.info("dopaymentplanedit response code ::: " + response.getStatusLine().getStatusCode());
//            BufferedReader rd = new BufferedReader(
//                    new InputStreamReader(response.getEntity().getContent()));
//
//            String line;
//            while ((line = rd.readLine()) != null) {
//                result.append(line);
//            }
//            LOG.info("dopaymentplanedit request" + result.toString());
//            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
//                return null;
//            }
//            if (response.getStatusLine().getStatusCode() == 500) {
//                return "there is an error with the data";
//            } else {
//                return result.toString();
//            }
//
//        } catch (UnsupportedEncodingException ex) {
//            LOG.error(Arrays.toString(ex.getStackTrace()));
//        } catch (IOException ex) {
//            LOG.error(Arrays.toString(ex.getStackTrace()));
//        }
//        return null;
//    }
    public String doflwcardpayment(String params, CardPayload cardpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = new HttpPost((OurConfig.LIVE_CHARGE_URL));
            Log.d("Response", params);
            Pay_load pay_load = new Pay_load();
//            pay_load.setPBFPubKey(raveConfig.PUBLIC_KEY);
            pay_load.setPBFPubKey(cardpayload.getPBFPubKey());
            pay_load.setClient(params);
            pay_load.setAlg("alg");

            JSONObject requestJSON = new JSONObject();
            // requestJSON.put("PBFPubKey", raveConfig.PUBLIC_KEY);
            try {
                requestJSON.put("PBFPubKey", cardpayload.getPBFPubKey());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                requestJSON.put("client", params);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                requestJSON.put("alg", OurConfig.alg);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            StringEntity input = new StringEntity(requestJSON.toString());
            input.setContentType("application/json");
            post.setEntity(input);
            HttpResponse response = client.execute(post);
            Log.d("Response", String.valueOf(response.getStatusLine().getStatusCode()));
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Log.d("Response", result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            return result.toString();

        } catch (UnsupportedEncodingException ex) {
            Log.d("Error", Arrays.toString(ex.getStackTrace()));
        } catch (IOException ex) {
            Log.d("Error Response", Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }

    public String dotokencharge(String params, TokenChargePayload tokenchargepayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post  = new HttpPost((OurConfig.TOKENIZED_CHARGE_URL_LIVE));

            Log.d("do qrpayment response ::: ", params);
            //System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);
            Log.d("do qrpayment response code :::", String.valueOf(response.getStatusLine().getStatusCode()));
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Log.d("do qrpayment request", result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            if (response.getStatusLine().getStatusCode() == 500) {
                return "there is an error with the data";
            } else {
                return result.toString();
            }

        } catch (IOException ex) {
            Log.d("Error Response", Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }

    public String dotokenupdate(TokenChargePayload tokenchargepayload) throws IOException {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            String embed_token = tokenchargepayload.getToken();

            HttpPost post = new HttpPost((OurConfig.TOKEN_UPDATE_URL_LIVE + embed_token + "/update_customer"));
            Log.d("doqrpayment response :::", String.valueOf(tokenchargepayload));
            //System.out.println("params ===>" + tokenchargepayload);

            JSONObject requestJSON = new JSONObject();
            requestJSON.put("email", tokenchargepayload.getEmail());
            requestJSON.put("secret_key", tokenchargepayload.getSECKEY());

            StringEntity input = new StringEntity(requestJSON.toString());
            input.setContentType("application/json");
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            Log.d("doqrpayment response code :::", String.valueOf(response.getStatusLine().getStatusCode()));

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Log.d("doqrpayment request", result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            if (response.getStatusLine().getStatusCode() == 500) {
                return "there is an error with the data";
            } else {
                return result.toString();
            }

        } catch (UnsupportedEncodingException | JSONException ex) {
            Log.d("onResponse", Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }
}
