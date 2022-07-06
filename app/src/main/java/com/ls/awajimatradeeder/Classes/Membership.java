package com.ls.awajimatradeeder.Classes;

public class Membership {
    private int membershipID;
    private double membershipAmount;
    private String membershipType;
    private  String membershipCDate;
    private  String membershipSDate;
    private  String membershipEDate;

    public Membership(int mCountNo, Membership membership1) {

    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public int getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(int membershipID) {
        this.membershipID = membershipID;
    }

    public double getMembershipAmount() {
        return membershipAmount;
    }

    public void setMembershipAmount(double membershipAmount) {
        this.membershipAmount = membershipAmount;
    }

    public String getMembershipSDate() {
        return membershipSDate;
    }

    public void setMembershipSDate(String membershipSDate) {
        this.membershipSDate = membershipSDate;
    }

    public String getMembershipEDate() {
        return membershipEDate;
    }

    public void setMembershipEDate(String membershipEDate) {
        this.membershipEDate = membershipEDate;
    }

    public String getMembershipCDate() {
        return membershipCDate;
    }

    public void setMembershipCDate(String membershipCDate) {
        this.membershipCDate = membershipCDate;
    }
}
