package com.ls.awajimatradeeder.Tranx;

public class TokenChargePayload {
    private String currency;
    private String SECKEY;
    private String token;
    private String country;
    private String amount;
    private String email;
    private String firstname;
    private String lastname;
    private String IP;
    private String txRef;
    private String test;
    public String getTest() {
        return test;
    }


    public void setTest(String test) {
        this.test = test;
    }


    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public String getSECKEY() {
        return SECKEY;
    }


    public void setSECKEY(String SECKEY) {
        this.SECKEY = SECKEY;
    }


    public String getToken() {
        return token;
    }


    public void setToken(String token) {
        this.token = token;
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    public String getAmount() {
        return amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getIP() {
        return IP;
    }


    public void setIP(String IP) {
        this.IP = IP;
    }


    public String getTxRef() {
        return txRef;
    }

    public void setTxRef(String txRef) {
        this.txRef = txRef;
    }
}
