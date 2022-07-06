package com.ls.awajimatradeeder.Classes;

import java.util.ArrayList;

public class SubTradeAcct {
    WeeklyTrade weeklyTrade;
    TradeAcctFunding tradeAcctFunding;
    TradeAcctWithdrawal tradeAcctWithdrawal;
    private ArrayList<WeeklyTrade> weeklyTrades;
    private String leverage;
    public static final String STA_INVESTOR_PERCENTAGE = "sTAInvestorPercentage";
    public static final String STA_TRADER_PERCENTAGE = "sTATraderPercentage";
    public static final String STA_COMPANY_PERCENTAGE = "sTACompanyPercentage";
    public static final String STA_INITIAL_CAPITAL = "sTAInitialC";
    public static final String STA_BALANCE = "sTABalance";
}
