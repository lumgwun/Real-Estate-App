package com.ls.awajimatradeeder.Classes;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;

public class TradeAcctWithdrawal {
    public static final String WITHDRAWAL_TABLE = "withdrawalTable";
    public static final String WITHDRAWAL_ID = "tradeAcctWithDID";
    public static final String TRADE_ACCT_BROKER = "wBroker";
    public static final String TRADE_ACCT_PROFILEID = "tradeAcctWPID";
    public static final String TRADE_ACCT_TYPE = "tradeAcctType";
    public static final String TRADE_ACCT_USERNAME = "tradeAcctUserName";
    public static final String TRADE_ACCT_PASSWORD = "tradeAcctPswd";
    public static final String TRADE_INITIAL_AMOUNT = "tradeBeginningAmt";
    public static final String TRADE_INVESTOR_PERCENTAGE = "tradeInvestorPercentage";
    public static final String TRADE_TRADER_PERCENTAGE = "tradeTraderPercentage";
    public static final String TRADE_COMPANY_PERCENTAGE = "tradeCompanyPercentage";
    public static final String TRADE_ACCT_START_DATE = "tradeAcctStartDate";
    public static final String TRADE_ACCT_END_DATE = "tradeAcctEndDate";
    public static final String TRADE_ACCT_STATUS = "tradeAcctStatus";
    public static final String TRADE_ACCT_W_BALANCE = "tradeAcct_W_Balance";
    public static final String TRADE_ACCT_W_ACCTID = "tradeAcctWID";


    public static final String CREATE_WITHDRAWAL_TABLE = "CREATE TABLE IF NOT EXISTS " + WITHDRAWAL_TABLE + " (" + WITHDRAWAL_ID + " INTEGER, " + TRADE_ACCT_PROFILEID + " INTEGER , " +
            TRADE_ACCT_W_ACCTID + " INTEGER , " + TRADE_ACCT_BROKER + " TEXT , " + TRADE_ACCT_TYPE + " TEXT , " +
            TRADE_ACCT_USERNAME + " TEXT , " + TRADE_ACCT_PASSWORD + " TEXT , " + TRADE_INITIAL_AMOUNT + " TEXT, " + TRADE_ACCT_W_BALANCE + " FLOAT, "+ TRADE_INVESTOR_PERCENTAGE + " TEXT, " + TRADE_TRADER_PERCENTAGE + " TEXT, " + TRADE_COMPANY_PERCENTAGE + " TEXT, " + TRADE_ACCT_START_DATE + " DATE, " + TRADE_ACCT_END_DATE + " DATE, " + TRADE_ACCT_STATUS + " TEXT, " + "FOREIGN KEY(" + TRADE_ACCT_PROFILEID + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + "),"+
            "PRIMARY KEY(" + WITHDRAWAL_ID + "))";
}
