package com.ls.awajimatradeeder.Classes;

public class InvestmentDeposit {
    private int invDCount;
    private InvestmentDeposit investmentDeposit;
    protected InvestmentDeposit (){
        super();
    }
    public InvestmentDeposit(int invID, InvestmentDeposit investmentDeposit1) {
        this.invDCount = invID;
        this.investmentDeposit = investmentDeposit1;

    }
}
