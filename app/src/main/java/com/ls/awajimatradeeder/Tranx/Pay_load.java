package com.ls.awajimatradeeder.Tranx;

public class Pay_load {
    private String PBFPubKey;
    private String client;
    private String alg;
    public String getPBFPubKey() {
        return PBFPubKey;
    }


    public void setPBFPubKey(String PBFPubKey) {
        this.PBFPubKey = PBFPubKey;
    }


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }


    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }
}
