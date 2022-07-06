package com.ls.awajimatradeeder.Classes;

import com.ls.awajimatradeeder.Database.DBHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;
import static com.ls.awajimatradeeder.Classes.TradeInvestor.TRADEE_ID;
import static com.ls.awajimatradeeder.Classes.TradeInvestor.TRADEE_TABLE;
import static com.ls.awajimatradeeder.Classes.Transaction.TRANSACTIONS_TABLE;
import static com.ls.awajimatradeeder.Classes.Transaction.TRANSACTION_ID;

public class Account {
    public static final String ACCOUNTS_TABLE = "accounts";
    public static final String ACCOUNT_BANK = "account_bank";
    public static final String ACCOUNT_NO = "a_id";
    public static final String ACCOUNT_NAME = "account_name";
    public static final String ACCOUNT_BALANCE = "account_balance";
    public static final String ACCOUNT_TYPE = "account_type";
    public static final String BANK_ACCT_NO = "bank_acct_no";
    public static final String BANK_ACCT_BALANCE = "bank_acct_Balance";

    public static final String ACCOUNT_TYPES_TABLE = "account_type_table";
    public static final String ACCOUNT_TYPE_INTEREST = "acct_type_interest";
    public static final String ACCOUNT_TYPE_ID = "acct_type_number";
    public static final String ACCOUNT_TRADEE_ID = "acct_Tradee_Id";
    public static final String ACCOUNT_TYPE_NO_F = "acct_F_Key";
    public static final String ACCOUNT_PROF_ID = "acct_prof_number";
    public static final String ACCOUNT_TX_ID = "acct_TX_ID";


    public static final String CREATE_ACCOUNT_TYPE_TABLE = "CREATE TABLE " + ACCOUNT_TYPES_TABLE + " (" + ACCOUNT_TYPE_ID + " INTEGER, " +
            ACCOUNT_TYPE_NO_F + " INTEGER, " + ACCOUNT_TYPE + " TEXT , " + ACCOUNT_TYPE_INTEREST + " FLOAT , " +
            "PRIMARY KEY(" + ACCOUNT_TYPE_ID + "), " + "FOREIGN KEY(" + ACCOUNT_TYPE_NO_F + ") REFERENCES " + ACCOUNTS_TABLE + "(" + ACCOUNT_NO + "))";


    public static final String CREATE_ACCOUNTS_TABLE = "CREATE TABLE IF NOT EXISTS " + ACCOUNTS_TABLE + " (" + ACCOUNT_NO + " INTEGER , " + BANK_ACCT_NO + "TEXT," + ACCOUNT_PROF_ID + " INTEGER , " +
            ACCOUNT_TRADEE_ID + " INTEGER , " + ACCOUNT_TX_ID + " INTEGER , " +
            ACCOUNT_TYPE + " TEXT , " + ACCOUNT_BANK + " TEXT , " + ACCOUNT_NAME + " TEXT, " + ACCOUNT_BALANCE + " FLOAT, "  + BANK_ACCT_BALANCE + "FLOAT, "+"FOREIGN KEY(" + ACCOUNT_PROF_ID  + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + ")," +"FOREIGN KEY(" + ACCOUNT_TRADEE_ID + ") REFERENCES " + TRADEE_TABLE + "(" + TRADEE_ID + ")," + "FOREIGN KEY(" + ACCOUNT_TX_ID + ") REFERENCES " + TRANSACTIONS_TABLE + "(" + TRANSACTION_ID + ")," +
            "PRIMARY KEY(" + ACCOUNT_NO + "))";

    private int skyLightAcctNo =100321;

    private String acct_BankNo;
    private String accountBankBalance;
    private String accountBank;
    private double accountBalance;
    private int accountProfID;
    private int accountTradeeID;
    DBHelper dbHelper;

    private String accountName;

    private Currency acctCurrency;
    Transaction transaction;
    double interest;
    private String image;
    private BigDecimal balance1 = null;
    private BigDecimal interestRate = BigDecimal.ZERO;
    private ArrayList<Transaction> transactions;
    private int id_For_BigDecimal = -1;
    private int type_BigDecimal = -1;



    public Account(){
        super();

    }

    public String getAcct_BankNo() {
        return acct_BankNo;
    }

    public void setAcct_BankNo(String acct_BankNo) {
        this.acct_BankNo = acct_BankNo;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getAccountProfID() {
        return accountProfID;
    }

    public void setAccountProfID(int accountProfID) {
        this.accountProfID = accountProfID;
    }

    public int getAccountTradeeID() {
        return accountTradeeID;
    }

    public void setAccountTradeeID(int accountTradeeID) {
        this.accountTradeeID = accountTradeeID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountBankBalance() {
        return accountBankBalance;
    }

    public void setAccountBankBalance(String accountBankBalance) {
        this.accountBankBalance = accountBankBalance;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }
}
