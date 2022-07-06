package com.ls.awajimatradeeder.Tranx;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class PaymentPlan {
    public String doCreateFlutterwavePayment(Pamentplancreatepayload pamentplancreatepayload) {
        LSPaymentServices paymentservices = new LSPaymentServices();

        String payload = null;
        try {
            payload = new JSONObject(String.valueOf(pamentplancreatepayload)).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String response = null;
        try {
            response = paymentservices.dopaymentplancreate(payload, pamentplancreatepayload);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String doCreatePayStackPayment(PaystackPlan paystackPlan) {
        LSPaymentServices paymentservices = new LSPaymentServices();

        String payload = null;
        try {
            payload = new JSONObject(String.valueOf(paystackPlan)).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String response = null;
        try {
            response = paymentservices.doPayStackPaymentplancreate(payload, paystackPlan);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    public String dolistpayment(Paymentplanfetch paymentplanfetch) {
        LSPaymentServices paymentservices = new LSPaymentServices();

        String payload = null;
        try {
            payload = new JSONObject(String.valueOf(paymentplanfetch)).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String response = paymentservices.dopaymentplanlist(payload, paymentplanfetch);
        return response;
    }
    /*public String dofetchpayment(@Context HttpServletRequest request) {
        PaymentServices paymentservices = new PaymentServices();

        String id = null;
        try {
            id = new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(paymentplan.class.getName()).log(Level.SEVERE, null, ex);
        }

        String q = null;
        try {
            q = new String(request.getParameter("q").getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PaymentPlan.class.getName()).log(Level.SEVERE, null, ex);
        }

        String seckey = null;
        try {
            seckey = new String(request.getParameter("seckey").getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(paymentplan.class.getName()).log(Level.SEVERE, null, ex);
        }

        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("seckey", seckey);
        sParaTemp.put("id", id);
        sParaTemp.put("q", q);

        String response = null;
        try {
            response = paymentservices.dopaymentplanfetch(sParaTemp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }*/


    public String docancelpayment(Paymentplanfetch paymentplanfetch) {
        LSPaymentServices paymentservices = new LSPaymentServices();

        String response = null;
        try {
            response = paymentservices.dopaymentplancancel(paymentplanfetch);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    public String doeditpayment(Paymentplanfetch paymentplanfetch) {
        LSPaymentServices paymentservices = new LSPaymentServices();

        String response = paymentservices.dopaymentplanedit(paymentplanfetch);
        return response;
    }
}
