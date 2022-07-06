package com.ls.awajimatradeeder.Classes;

public class TranxCode {
    private TranxCode tranxCode;
    private int txCodeCount;

    protected TranxCode (){
        super();
    }
    public TranxCode(int tranxCodeC, TranxCode tranxCode1) {
        this.txCodeCount = tranxCodeC;
        this.tranxCode = tranxCode1;

    }
}
