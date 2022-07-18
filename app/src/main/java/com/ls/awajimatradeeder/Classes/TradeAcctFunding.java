package com.ls.awajimatradeeder.Classes;

import static com.ls.awajimatradeeder.Classes.MTradeAccount.MTRADE_ACCT_ID;
import static com.ls.awajimatradeeder.Classes.MTradeAccount.MTRADE_ACCT_TABLE;

public class TradeAcctFunding {
    public static final String FUNDING_TABLE = "fundingTable";
    public static final String FUNDING_ID = "funding_ID";
    public static final String FUNDING_AMOUNT = "funding_Amt";
    public static final String FUNDING_BALANCE_BEFORE = "funding_BalanceBefore";
    public static final String FUNDING_DATE = "funding_Date";
    public static final String FUNDING_MTRADE_ID = "funding_MTID";

    public static final String CREATE_FUNDING_TABLE = "CREATE TABLE IF NOT EXISTS " + FUNDING_TABLE + " (" + FUNDING_ID + " INTEGER, " + FUNDING_MTRADE_ID + " INTEGER , " +
            FUNDING_BALANCE_BEFORE + " REAL , " + FUNDING_AMOUNT + " REAL , " +
            FUNDING_DATE + " TEXT , "  + "FOREIGN KEY(" + FUNDING_MTRADE_ID + ") REFERENCES " + MTRADE_ACCT_TABLE + "(" + MTRADE_ACCT_ID + "),"+
            "PRIMARY KEY(" + FUNDING_ID + "))";
}
