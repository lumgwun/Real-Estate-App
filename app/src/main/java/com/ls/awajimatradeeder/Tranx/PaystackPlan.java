package com.ls.awajimatradeeder.Tranx;

public class PaystackPlan {
    private String amount;
    private String name,description,send_sms,currency;
    private String interval;
    private String duration;
    private String seckey;
    private int invoice_limit;
    boolean send_invoices=false;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSend_sms() {
        return send_sms;
    }
    public void setSend_sms(String send_sms) {
        this.send_sms = send_sms;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public int getInvoice_limit() {
        return invoice_limit;
    }

    public void setInvoice_limit(int invoice_limit) {
        this.invoice_limit = invoice_limit;
    }
    public boolean getSend_invoices() {
        return send_invoices;
    }

    public void setSend_invoices(boolean send_invoices) {
        this.send_invoices = send_invoices;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getInterval() {
        return interval;
    }


    public void setInterval(String interval) {
        this.interval = interval;
    }


    public String getDuration() {
        return duration;
    }


    public void setDuration(String duration) {
        this.duration = duration;
    }


    public String getSeckey() {
        return seckey;
    }

    public void setSeckey(String seckey) {
        this.seckey = seckey;
    }
}
