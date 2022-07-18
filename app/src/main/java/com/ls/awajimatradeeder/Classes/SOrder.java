package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;
import static com.ls.awajimatradeeder.Classes.SOrderAcct.SO_ACCOUNT_NO;
import static com.ls.awajimatradeeder.Classes.SOrderAcct.SO_ACCT_TABLE;
import static com.ls.awajimatradeeder.Classes.Transaction.TRANSACTIONS_TABLE;
import static com.ls.awajimatradeeder.Classes.Transaction.TRANSACTION_ID;

public class SOrder implements Serializable, Parcelable {
    private int soID=10;
    private double so_ExpectedAmount;
    private double so_ReceivedAmount;
    private double so_AmountDiff;
    private double soDailyAmount;
    private String soStatus;
    private int so_Acct_No;
    private int so_TotalDays;
    private int so_DaysRemaining;
    private String so_start_date;
    private String so_Names;
    private String so_end_date;
    private double so_Balance;
    private Profile so_Profile;
    private Transaction so_Tranx;
    public static final String STANDING_ORDER_TABLE = "standingOrderTable";
    public static final String SO_ID = "sO_id";
    public static final String SO_DAILY_AMOUNT = "So_Daily_Amount";
    public static final String SO_EXPECTED_AMOUNT = "so_AmountExp";
    public static final String SO_RECEIVED_AMOUNT = "so_AmountReceived";
    public static final String SO_TOTAL_DAYS = "so_TotalDays";
    public static final String SO_DAYS_REMAINING = "so_DaysRem";
    public static final String SO_AMOUNT_DIFF = "so_Amount_Diff";
    public static final String SO_STATUS = "So_status";
    public static final String SO_ACCT_NO = "SO_Acct_no";
    public static final String SO_START_DATE = "SO_Start_Date";
    public static final String SO_END_DATE = "SO_End_Date";
    public static final String SO_PROF_ID = "SO_Prof_ID";
    public static final String SO_TRANX_ID = "SO_Tranx_ID";
    public static final String SO_APPROF_DATE = "SO_APProval_Date";

    public static final String CREATE_SO_TABLE = "CREATE TABLE IF NOT EXISTS " + STANDING_ORDER_TABLE + " (" + SO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SO_DAILY_AMOUNT + " DOUBLE, " +
             SO_EXPECTED_AMOUNT + " DOUBLE , " + SO_RECEIVED_AMOUNT + " DOUBLE , " + SO_TOTAL_DAYS + " DOUBLE , " + SO_AMOUNT_DIFF + " DOUBLE , " +
            SO_DAYS_REMAINING + " DOUBLE , " + SO_STATUS + " TEXT , " + SO_ACCT_NO + " INTEGER , " + SO_START_DATE + " TEXT, " + SO_END_DATE + " TEXT, "+ SO_APPROF_DATE + " TEXT, " + SO_PROF_ID + " INTEGER, " + SO_TRANX_ID + " TEXT, " +"FOREIGN KEY(" + SO_ACCT_NO + ") REFERENCES " + SO_ACCT_TABLE + "(" + SO_ACCOUNT_NO + ")," +"FOREIGN KEY(" + SO_TRANX_ID + ") REFERENCES " + TRANSACTIONS_TABLE + "(" + TRANSACTION_ID + "),"+ "FOREIGN KEY(" + SO_PROF_ID + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + "))";

    protected SOrder(Parcel in) {
        soID = in.readInt();
        so_ExpectedAmount = in.readDouble();
        so_ReceivedAmount = in.readDouble();
        so_AmountDiff = in.readDouble();
        soDailyAmount = in.readDouble();
        soStatus = in.readString();
        so_Acct_No = in.readInt();
        so_TotalDays = in.readInt();
        so_DaysRemaining = in.readInt();
        so_start_date = in.readString();
        so_Names = in.readString();
        so_end_date = in.readString();
        so_Balance = in.readDouble();
    }

    public static final Creator<SOrder> CREATOR = new Creator<SOrder>() {
        @Override
        public SOrder createFromParcel(Parcel in) {
            return new SOrder(in);
        }

        @Override
        public SOrder[] newArray(int size) {
            return new SOrder[size];
        }
    };

    public int getSoID() {
        return soID;
    }

    public void setSoID(int soID) {
        this.soID = soID;
    }

    public double getSo_ExpectedAmount() {
        return so_ExpectedAmount;
    }

    public void setSo_ExpectedAmount(double so_ExpectedAmount) {
        this.so_ExpectedAmount = so_ExpectedAmount;
    }

    public double getSo_ReceivedAmount() {
        return so_ReceivedAmount;
    }

    public void setSo_ReceivedAmount(double so_ReceivedAmount) {
        this.so_ReceivedAmount = so_ReceivedAmount;
    }

    public double getSo_AmountDiff() {
        return so_AmountDiff;
    }

    public void setSo_AmountDiff(double so_AmountDiff) {
        this.so_AmountDiff = so_AmountDiff;
    }

    public double getSoDailyAmount() {
        return soDailyAmount;
    }

    public void setSoDailyAmount(double soDailyAmount) {
        this.soDailyAmount = soDailyAmount;
    }

    public String getSoStatus() {
        return soStatus;
    }

    public void setSoStatus(String soStatus) {
        this.soStatus = soStatus;
    }

    public int getSo_Acct_No() {
        return so_Acct_No;
    }

    public void setSo_Acct_No(int so_Acct_No) {
        this.so_Acct_No = so_Acct_No;
    }

    public int getSo_TotalDays() {
        return so_TotalDays;
    }

    public void setSo_TotalDays(int so_TotalDays) {
        this.so_TotalDays = so_TotalDays;
    }

    public int getSo_DaysRemaining() {
        return so_DaysRemaining;
    }

    public void setSo_DaysRemaining(int so_DaysRemaining) {
        this.so_DaysRemaining = so_DaysRemaining;
    }

    public String getSo_start_date() {
        return so_start_date;
    }

    public void setSo_start_date(String so_start_date) {
        this.so_start_date = so_start_date;
    }

    public String getSo_Names() {
        return so_Names;
    }

    public void setSo_Names(String so_Names) {
        this.so_Names = so_Names;
    }

    public String getSo_end_date() {
        return so_end_date;
    }

    public void setSo_end_date(String so_end_date) {
        this.so_end_date = so_end_date;
    }

    public double getSo_Balance() {
        return so_Balance;
    }

    public void setSo_Balance(double so_Balance) {
        this.so_Balance = so_Balance;
    }

    public Profile getSo_Profile() {
        return so_Profile;
    }

    public void setSo_Profile(Profile so_Profile) {
        this.so_Profile = so_Profile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(soID);
        parcel.writeDouble(so_ExpectedAmount);
        parcel.writeDouble(so_ReceivedAmount);
        parcel.writeDouble(so_AmountDiff);
        parcel.writeDouble(soDailyAmount);
        parcel.writeString(soStatus);
        parcel.writeInt(so_Acct_No);
        parcel.writeInt(so_TotalDays);
        parcel.writeInt(so_DaysRemaining);
        parcel.writeString(so_start_date);
        parcel.writeString(so_Names);
        parcel.writeString(so_end_date);
        parcel.writeDouble(so_Balance);
    }

    public Transaction getSo_Tranx() {
        return so_Tranx;
    }

    public void setSo_Tranx(Transaction so_Tranx) {
        this.so_Tranx = so_Tranx;
    }
}
