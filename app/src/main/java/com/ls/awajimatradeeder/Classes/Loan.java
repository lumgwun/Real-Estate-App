package com.ls.awajimatradeeder.Classes;

public class Loan {
    private Loan loan;
    private int invLoanCount;

    protected Loan (){
        super();
    }
    public Loan(int loanNumber, Loan loan1) {
        this.invLoanCount = loanNumber;
        this.loan = loan1;

    }
}
