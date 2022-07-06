package com.ls.awajimatradeeder.Classes;

public class SupportMessage {
    private SupportMessage supportMessage;
    private int invSupportMessageCount;

    protected SupportMessage (){
        super();
    }
    public SupportMessage(int messageC, SupportMessage supportMessage1) {
        this.invSupportMessageCount = messageC;
        this.supportMessage = supportMessage1;

    }
}
