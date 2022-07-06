package com.ls.awajimatradeeder.Classes;


import static com.ls.awajimatradeeder.Classes.MTradeAccount.MTRADE_ACCT_ID;
import static com.ls.awajimatradeeder.Classes.MTradeAccount.MTRADE_ACCT_TABLE;

public class WeeklyTrade {
    public static final String TRADE_TABLE = "wTradeAcctTable";
    public static final String TRADE_ID = "wTradeID";
    public static final String TRADE_SYMBOL = "wTradeSymbol";
    public static final String TRADE_LOT_SIZE = "wTradeLotSize";
    public static final String TRADE_TYPE = "wTradeType";
    public static final String TRADE_SWAP = "wTradeSwap";
    public static final String TRADE_SPREAD = "wTradeSpread";
    public static final String TRADE_STOP_LOSS = "wTradeStopLoss";
    public static final String TRADE_TAKE_PROFIT = "wTradeTakeProfit";
    public static final String TRADE_STATUS = "wTradeStatus";
    public static final String TRADE_START_DATE = "wTradeStartDate";
    public static final String TRADE_END_DATE = "wTradeEndDate";
    public static final String TRADE_COMMENT = "wTradeComment";
    public static final String TRADE_TACCT_ID = "wTrade_Trade_Acct_ID";


    public static final String CREATE_TRADE_TABLE = "CREATE TABLE IF NOT EXISTS " + TRADE_TABLE + " (" + TRADE_ID + " INTEGER, " + TRADE_TACCT_ID + " INTEGER , " +
            TRADE_SYMBOL + " TEXT , " + TRADE_TYPE + " TEXT , " +
            TRADE_LOT_SIZE + " TEXT , " + TRADE_SWAP + " TEXT , " + TRADE_SPREAD + " TEXT, " + TRADE_STOP_LOSS + " TEXT, " + TRADE_TAKE_PROFIT + " TEXT, " + TRADE_START_DATE + " TEXT, " + TRADE_COMMENT + " DATE, " +TRADE_END_DATE + " TEXT, " + TRADE_STATUS + " TEXT, " + "FOREIGN KEY(" + TRADE_TACCT_ID + ") REFERENCES " + MTRADE_ACCT_TABLE + "(" + MTRADE_ACCT_ID + "),"+
            "PRIMARY KEY(" + TRADE_ID + "))";
}
