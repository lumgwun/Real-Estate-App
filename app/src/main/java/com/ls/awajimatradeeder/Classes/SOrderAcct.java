package com.ls.awajimatradeeder.Classes;

import java.util.ArrayList;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;

public class SOrderAcct {
    public static final String SO_ACCT_TABLE = "sOAcctTable";
    public static final String SO_ACCOUNT_NO = "sO_Account_id";
    public static final String SO_ACCOUNT_NAME = "sO_AccountName";
    public static final String SO_ACCOUNT_BALANCE = "sO_AccountBalance";
    public static final String SO_ACCT_PROF_ID = "sO_Acct_Prof_id";

    public static final String CREATE_SO_ACCT_TABLE = "CREATE TABLE IF NOT EXISTS " + SO_ACCT_TABLE + " (" + SO_ACCOUNT_NO + " INTEGER, " + SO_ACCT_PROF_ID + " INTEGER , " +
             SO_ACCOUNT_NAME +"TEXT,"+ SO_ACCOUNT_BALANCE + " REAL, " +"FOREIGN KEY(" + SO_ACCT_PROF_ID  + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + ")," +
            "PRIMARY KEY(" + SO_ACCOUNT_NO +  "))";


    private ArrayList<Transaction> soTranXs;

    private int soAcctID=1108213;
    private int soAcctProfID;
    private String soAcctName;
    private Double soAcctBalance;
    private Transaction so_tranx;
    private ArrayList<SOrder> so_Acct_sOs;
    private static Long nextAcNum = 88769912L;

    public SOrderAcct() {

        super();
    }

    public SOrderAcct(int profileID, String accountName, int skyLightAcctNo,double accountBalance) {
        this.soAcctProfID = profileID;
        this.soAcctName = accountName;
        this.soAcctID = skyLightAcctNo;
        this.soAcctBalance = accountBalance;

    }

    public int getSoAcctID() {
        return soAcctID;
    }

    public void setSoAcctID(int soAcctID) {
        this.soAcctID = soAcctID;
    }

    public int getSoAcctProfID() {
        return soAcctProfID;
    }

    public void setSoAcctProfID(int soAcctProfID) {
        this.soAcctProfID = soAcctProfID;
    }

    public String getSoAcctName() {
        return soAcctName;
    }

    public void setSoAcctName(String soAcctName) {
        this.soAcctName = soAcctName;
    }

    public Double getSoAcctBalance() {
        return soAcctBalance;
    }

    public void setSoAcctBalance(Double soAcctBalance) {
        this.soAcctBalance = soAcctBalance;
    }

    public Transaction getSo_tranx() {
        return so_tranx;
    }

    public void setSo_tranx(Transaction so_tranx) {
        this.so_tranx = so_tranx;
    }

    public ArrayList<SOrder> getSo_Acct_sOs() {
        return so_Acct_sOs;
    }

    public void setSo_Acct_sOs(ArrayList<SOrder> so_Acct_sOs) {
        this.so_Acct_sOs = so_Acct_sOs;
    }
}
