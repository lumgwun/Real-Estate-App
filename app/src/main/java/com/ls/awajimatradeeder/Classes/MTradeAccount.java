package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import com.ls.awajimatradeeder.Database.DBHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

import static com.ls.awajimatradeeder.Classes.Account.ACCOUNTS_TABLE;
import static com.ls.awajimatradeeder.Classes.Account.ACCOUNT_NO;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;

public class MTradeAccount implements Parcelable, Serializable {
    public static final String MTRADE_ACCT_TABLE = "mTradeAcctTable";
    public static final String MTRADE_ACCT_ID = "mTradeAcctID";
    public static final String MTRADE_ACCT_BROKER = "mBroker";
    public static final String MTRADE_ACCT_TELLERID = "mTATellerID";
    public static final String MTRADE_ACCT_PROFID = "mTradeAcctProfID";
    public static final String MTRADE_GEN_ACCT_ID = "mTA_Gen_AcctID";
    public static final String MTRADE_ACCT_OFFICE_ID = "mTA_OfficeID";
    public static final String MTRADE_ACCT_TYPE = "mTradeAcctType";
    public static final String MTRADE_ACCT_NAME = "mTradeAcctName";
    public static final String MTRADE_ACCT_USERNAME = "mTradeAcct_UserName";
    public static final String MTRADE_ACCT_PASSWORD = "mTradeAcctPswd";
    public static final String MTRADE_INITIAL_AMOUNT = "mTradeBeginningAmt";
    public static final String MTRADE_ACCT_START_DATE = "mTradeAcctStartDate";
    public static final String MTRADE_ACCT_END_DATE = "mTradeAcctEndDate";
    public static final String MTRADE_ACCT_STATUS = "mTradeAcctStatus";
    public static final String MTRADE_ACCT_BALANCE = "mTradeAcctBalance";
    public static final String MTRADE_ACCT_ACCT_ID = "mTradeAcct_AcctID";

    public static final String CREATE_MTRADE_ACCT_TABLE = "CREATE TABLE IF NOT EXISTS " + MTRADE_ACCT_TABLE + " (" + MTRADE_ACCT_ID + " INTEGER, " + MTRADE_ACCT_ACCT_ID + " INTEGER , " + MTRADE_ACCT_TELLERID + " INTEGER , " +
            MTRADE_ACCT_PROFID + " INTEGER , " + MTRADE_GEN_ACCT_ID + " INTEGER , " + MTRADE_ACCT_OFFICE_ID + " INTEGER , " + MTRADE_ACCT_BROKER + " TEXT , " + MTRADE_ACCT_TYPE + " TEXT , " + MTRADE_ACCT_NAME + " TEXT , " + MTRADE_ACCT_USERNAME + " TEXT, " + MTRADE_ACCT_PASSWORD + " TEXT, " + MTRADE_INITIAL_AMOUNT + " FLOAT, " + MTRADE_ACCT_START_DATE + " TEXT, " + MTRADE_ACCT_END_DATE + " TEXT, " + MTRADE_ACCT_BALANCE + " FLOAT, " + MTRADE_ACCT_STATUS + " TEXT, "  + "FOREIGN KEY(" + MTRADE_ACCT_ACCT_ID + ") REFERENCES " + ACCOUNTS_TABLE + "(" + ACCOUNT_NO + "),"+ "FOREIGN KEY(" + MTRADE_ACCT_TELLERID + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + "),"+
            "PRIMARY KEY(" + MTRADE_ACCT_ID + "))";

    private static int nextAcNum = 88769912;
    DBHelper dbHelper;

    private String mTBrokerName;
    private String mTradeAcctName;
    private String mTradeAcctType;
    private String mTradeAcctEmail;
    private String mTradeAcctPassword;
    private double mTradeAcctInitialD;
    private double mTradeAcctInvPercentage;
    private int mTradeAcctID;
    private double mTraderPercentage;
    private double mTradeACompanyPercentage;
    private String mTradeAcctStartDate;
    private String mTradeAcctEndDate;
    private String mTradeAcctStatus;
    private ArrayList<TradeAcctWithdrawal> mTWithdrawals;
    private ArrayList<TradeAcctFunding> mTFundings;

    private ArrayList<SubTradeAcct> mTSubTradeAccts;
    private SubTradeAcct mTSubTradeAcct;
    private TradeAcctFunding mTradeAcctFunding;
    private TradeAcctWithdrawal mTradeAcctWithdrawal;
    private ArrayList<TradeAcctFunding> mTradeAcctFundings;
    private ArrayList<TradeAcctWithdrawal> mTradeAcctWithdrawals;
    private ArrayList<WeeklyTrade> mTWeeklyTrades;

    public MTradeAccount() {
        super();

    }


    public MTradeAccount(int tradeAcctID, String mTBrokerName, String tradeAcctType, String tradeAcctUserName, String tradeAcctPassword, double initialDeposit, double invPercentage, double mTraderPercentage, double companyPercentage, String tradeAcctStartDate, String tradeAcctEndDate, String tradeAcctStatus) {
        this.mTradeAcctID = tradeAcctID;
        this.mTBrokerName = mTBrokerName;
        this.mTradeAcctType = tradeAcctType;
        this.mTradeAcctName = tradeAcctUserName;
        this.mTradeAcctPassword = tradeAcctPassword;
        this.mTradeAcctInitialD = initialDeposit;
        this.mTradeAcctInvPercentage = invPercentage;
        this.mTraderPercentage = mTraderPercentage;
        this.mTradeACompanyPercentage = companyPercentage;
        this.mTradeAcctStartDate = tradeAcctStartDate;
        this.mTradeAcctEndDate = tradeAcctEndDate;
        this.mTradeAcctStatus = tradeAcctStatus;
    }


    protected MTradeAccount(Parcel in) {
        mTBrokerName = in.readString();
        mTradeAcctName = in.readString();
        mTradeAcctType = in.readString();
        mTradeAcctEmail = in.readString();
        mTradeAcctPassword = in.readString();
        mTradeAcctInitialD = in.readDouble();
        mTradeAcctInvPercentage = in.readDouble();
        mTradeAcctID = in.readInt();
        mTraderPercentage = in.readDouble();
        mTradeACompanyPercentage = in.readDouble();
        mTradeAcctStartDate = in.readString();
        mTradeAcctEndDate = in.readString();
        mTradeAcctStatus = in.readString();
    }

    public static final Creator<MTradeAccount> CREATOR = new Creator<MTradeAccount>() {
        @Override
        public MTradeAccount createFromParcel(Parcel in) {
            return new MTradeAccount(in);
        }

        @Override
        public MTradeAccount[] newArray(int size) {
            return new MTradeAccount[size];
        }
    };

    /*public String toString() {
        return (mTBrokerName + ""+this.mTraderPercentage +" (NGN" + String.format(Locale.getDefault(), "%.2f",this.initialDeposit) + ")");
    }*/


    public String getmTradeAcctName() {
        return mTradeAcctName;
    }

    public void setmTradeAcctName(String mTradeAcctName) {
        this.mTradeAcctName = mTradeAcctName;
    }

    public String getmTradeAcctType() {
        return mTradeAcctType;
    }

    public void setmTradeAcctType(String mTradeAcctType) {
        this.mTradeAcctType = mTradeAcctType;
    }

    public String getmTradeAcctEmail() {
        return mTradeAcctEmail;
    }

    public void setmTradeAcctEmail(String mTradeAcctEmail) {
        this.mTradeAcctEmail = mTradeAcctEmail;
    }

    public String getmTradeAcctPassword() {
        return mTradeAcctPassword;
    }

    public void setmTradeAcctPassword(String mTradeAcctPassword) {
        this.mTradeAcctPassword = mTradeAcctPassword;
    }

    public double getmTradeAcctInitialD() {
        return mTradeAcctInitialD;
    }

    public void setmTradeAcctInitialD(double mTradeAcctInitialD) {
        this.mTradeAcctInitialD = mTradeAcctInitialD;
    }

    public double getmTradeAcctInvPercentage() {
        return mTradeAcctInvPercentage;
    }

    public void setmTradeAcctInvPercentage(double mTradeAcctInvPercentage) {
        this.mTradeAcctInvPercentage = mTradeAcctInvPercentage;
    }

    public int getmTradeAcctID() {
        return mTradeAcctID;
    }

    public void setmTradeAcctID(int mTradeAcctID) {
        this.mTradeAcctID = mTradeAcctID;
    }

    public double getmTradeACompanyPercentage() {
        return mTradeACompanyPercentage;
    }

    public void setmTradeACompanyPercentage(double mTradeACompanyPercentage) {
        this.mTradeACompanyPercentage = mTradeACompanyPercentage;
    }

    public String getmTradeAcctStartDate() {
        return mTradeAcctStartDate;
    }

    public void setmTradeAcctStartDate(String mTradeAcctStartDate) {
        this.mTradeAcctStartDate = mTradeAcctStartDate;
    }

    public String getmTradeAcctEndDate() {
        return mTradeAcctEndDate;
    }

    public void setmTradeAcctEndDate(String mTradeAcctEndDate) {
        this.mTradeAcctEndDate = mTradeAcctEndDate;
    }

    public String getmTradeAcctStatus() {
        return mTradeAcctStatus;
    }

    public void setmTradeAcctStatus(String mTradeAcctStatus) {
        this.mTradeAcctStatus = mTradeAcctStatus;
    }

    public ArrayList<TradeAcctWithdrawal> getmTWithdrawals() {
        return mTWithdrawals;
    }

    public void setmTWithdrawals(ArrayList<TradeAcctWithdrawal> mTWithdrawals) {
        this.mTWithdrawals = mTWithdrawals;
    }

    public ArrayList<TradeAcctFunding> getmTFundings() {
        return mTFundings;
    }

    public void setmTFundings(ArrayList<TradeAcctFunding> mTFundings) {
        this.mTFundings = mTFundings;
    }

    public ArrayList<SubTradeAcct> getmTSubTradeAccts() {
        return mTSubTradeAccts;
    }

    public void setmTSubTradeAccts(ArrayList<SubTradeAcct> mTSubTradeAccts) {
        this.mTSubTradeAccts = mTSubTradeAccts;
    }

    public SubTradeAcct getmTSubTradeAcct() {
        return mTSubTradeAcct;
    }

    public void setmTSubTradeAcct(SubTradeAcct mTSubTradeAcct) {
        this.mTSubTradeAcct = mTSubTradeAcct;
    }

    public TradeAcctFunding getmTradeAcctFunding() {
        return mTradeAcctFunding;
    }

    public void setmTradeAcctFunding(TradeAcctFunding mTradeAcctFunding) {
        this.mTradeAcctFunding = mTradeAcctFunding;
    }

    public TradeAcctWithdrawal getmTradeAcctWithdrawal() {
        return mTradeAcctWithdrawal;
    }

    public void setmTradeAcctWithdrawal(TradeAcctWithdrawal mTradeAcctWithdrawal) {
        this.mTradeAcctWithdrawal = mTradeAcctWithdrawal;
    }

    public ArrayList<TradeAcctFunding> getmTradeAcctFundings() {
        return mTradeAcctFundings;
    }

    public void setmTradeAcctFundings(ArrayList<TradeAcctFunding> mTradeAcctFundings) {
        this.mTradeAcctFundings = mTradeAcctFundings;
    }

    public ArrayList<TradeAcctWithdrawal> getmTradeAcctWithdrawals() {
        return mTradeAcctWithdrawals;
    }

    public void setmTradeAcctWithdrawals(ArrayList<TradeAcctWithdrawal> mTradeAcctWithdrawals) {
        this.mTradeAcctWithdrawals = mTradeAcctWithdrawals;
    }

    public ArrayList<WeeklyTrade> getmTWeeklyTrades() {
        return mTWeeklyTrades;
    }

    public void setmTWeeklyTrades(ArrayList<WeeklyTrade> mTWeeklyTrades) {
        this.mTWeeklyTrades = mTWeeklyTrades;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTBrokerName);
        parcel.writeString(mTradeAcctName);
        parcel.writeString(mTradeAcctType);
        parcel.writeString(mTradeAcctEmail);
        parcel.writeString(mTradeAcctPassword);
        parcel.writeDouble(mTradeAcctInitialD);
        parcel.writeDouble(mTradeAcctInvPercentage);
        parcel.writeInt(mTradeAcctID);
        parcel.writeDouble(mTraderPercentage);
        parcel.writeDouble(mTradeACompanyPercentage);
        parcel.writeString(mTradeAcctStartDate);
        parcel.writeString(mTradeAcctEndDate);
        parcel.writeString(mTradeAcctStatus);
    }
}
