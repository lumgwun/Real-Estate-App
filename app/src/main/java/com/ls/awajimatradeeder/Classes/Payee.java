package com.ls.awajimatradeeder.Classes;

public class Payee {
    private Payee payee;
    private int payeeCount;

    protected Payee (){
        super();
    }
    public Payee(int payeeID, Payee payee1) {
        this.payeeCount = payeeID;
        this.payee = payee1;

    }
}
