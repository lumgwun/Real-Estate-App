package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Currency;

import static com.ls.awajimatradeeder.Classes.Account.ACCOUNTS_TABLE;
import static com.ls.awajimatradeeder.Classes.Account.ACCOUNT_NO;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;
import static com.ls.awajimatradeeder.Classes.TradeInvestor.TRADEE_ID;
import static com.ls.awajimatradeeder.Classes.TradeInvestor.TRADEE_TABLE;

public class Transaction implements Parcelable, Serializable {
    public static final String TRANSACTIONS_TABLE = "transactions";
    public static final String TRANSACTION_ID = "transaction_id";
    public static final String TRANSACTION_SENDING_ACCT = "tranx_sending_acct";
    public static final String TRANSACTION_DEST_ACCT = "tranx_dest_acct";
    public static final String TRANSACTION_PAYEE = "tranx_payee";
    public static final String TRANSACTION_PAYER = "tranx_payer";
    public static final String TRANSACTION_STATUS = "transaction_status";
    public static final String TRANSACTIONS_TYPE = "transaction_type";
    public static final String TRANSACTION_AMOUNT = "transaction_amount";
    public static final String TRANSACTION_DATE = "transaction_date";
    public static final String TRANSACTION_OFFICE_BRANCH = "transaction_office_branch";
    public static final String TRANSACTION_APPROVER = "transaction_approver";
    public static final String TRANSACTION_APPROVAL_DATE = "transaction_approval_Date";
    public static final String TRANSACTION_METHOD_OF_PAYMENT = "transaction_method_of_payment";
    public static final String TRANSACTION_PROF_ID = "transaction_Prof_ID";
    public static final String TRANSACTION_ACCT_ID = "transaction_Acct_ID";
    public static final String TRANSACTION_TRADEE_ID = "transaction_Tradee_ID";


    public static final String CREATE_TRANSACTIONS_TABLE = "CREATE TABLE IF NOT EXISTS " + TRANSACTIONS_TABLE + " (" + TRANSACTION_ID + " INTEGER, " + TRANSACTION_PROF_ID + " INTEGER , " +
            TRANSACTION_TRADEE_ID + " INTEGER , " + TRANSACTION_ACCT_ID + " INTEGER , " + TRANSACTION_DATE + " TEXT, " + TRANSACTION_SENDING_ACCT + " TEXT, " +
            TRANSACTION_DEST_ACCT + " TEXT, " + TRANSACTION_PAYEE + " TEXT, " + TRANSACTION_PAYER + " TEXT, " + TRANSACTION_AMOUNT + " REAL, " +
            TRANSACTIONS_TYPE + " TEXT, " + TRANSACTION_METHOD_OF_PAYMENT + " TEXT, " + TRANSACTION_OFFICE_BRANCH + " TEXT, "+ TRANSACTION_APPROVER + TRANSACTION_APPROVAL_DATE + " TEXT, "+  TRANSACTION_STATUS + " TEXT, " + "PRIMARY KEY(" +TRANSACTION_ID + "), "+"FOREIGN KEY(" + TRANSACTION_PROF_ID  + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + ")," +"FOREIGN KEY(" + TRANSACTION_ACCT_ID  + ") REFERENCES " + ACCOUNTS_TABLE + "(" + ACCOUNT_NO + ")," +"FOREIGN KEY(" + TRANSACTION_TRADEE_ID + ") REFERENCES " + TRADEE_TABLE + "(" + TRADEE_ID + "))";

    protected Transaction(Parcel in) {
        tranxPayer = in.readString();
        tranxBankAcct = in.readString();
        tranxBankAccName = in.readString();
        tranxBankAcctNo = in.readString();
        transactionID = in.readInt();
        tranxDate = in.readString();
        tranxSendingAccount = in.readInt();
        tranxBranchOffice = in.readString();
        approver = in.readString();
        tranxApprovalDate = in.readString();
        tranxDestAcct = in.readInt();
        tranxPayee = in.readString();
        tranxAmount = in.readDouble();
        transactionType = in.readString();
        tranxProfileID = in.readInt();
        tranxAccountId = in.readInt();
        transactionOtherId = in.readString();
        tranxStatus = in.readString();
        tranxMethod = in.readString();
    }

    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel in) {
            return new Transaction(in);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };

    public String getTranxPayer() {
        return tranxPayer;
    }

    public void setTranxPayer(String tranxPayer) {
        this.tranxPayer = tranxPayer;
    }

    public String getTranxBankAcct() {
        return tranxBankAcct;
    }

    public void setTranxBankAcct(String tranxBankAcct) {
        this.tranxBankAcct = tranxBankAcct;
    }

    public String getTranxBankAccName() {
        return tranxBankAccName;
    }

    public void setTranxBankAccName(String tranxBankAccName) {
        this.tranxBankAccName = tranxBankAccName;
    }

    public String getTranxBankAcctNo() {
        return tranxBankAcctNo;
    }

    public void setTranxBankAcctNo(String tranxBankAcctNo) {
        this.tranxBankAcctNo = tranxBankAcctNo;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getTranxDate() {
        return tranxDate;
    }

    public void setTranxDate(String tranxDate) {
        this.tranxDate = tranxDate;
    }

    public int getTranxSendingAccount() {
        return tranxSendingAccount;
    }

    public void setTranxSendingAccount(int tranxSendingAccount) {
        this.tranxSendingAccount = tranxSendingAccount;
    }

    public String getTranxBranchOffice() {
        return tranxBranchOffice;
    }

    public void setTranxBranchOffice(String tranxBranchOffice) {
        this.tranxBranchOffice = tranxBranchOffice;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getTranxApprovalDate() {
        return tranxApprovalDate;
    }

    public void setTranxApprovalDate(String tranxApprovalDate) {
        this.tranxApprovalDate = tranxApprovalDate;
    }

    public int getTranxDestAcct() {
        return tranxDestAcct;
    }

    public void setTranxDestAcct(int tranxDestAcct) {
        this.tranxDestAcct = tranxDestAcct;
    }

    public String getTranxPayee() {
        return tranxPayee;
    }

    public void setTranxPayee(String tranxPayee) {
        this.tranxPayee = tranxPayee;
    }

    public double getTranxAmount() {
        return tranxAmount;
    }

    public void setTranxAmount(double tranxAmount) {
        this.tranxAmount = tranxAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getTranxProfileID() {
        return tranxProfileID;
    }

    public void setTranxProfileID(int tranxProfileID) {
        this.tranxProfileID = tranxProfileID;
    }

    public int getTranxAccountId() {
        return tranxAccountId;
    }

    public void setTranxAccountId(int tranxAccountId) {
        this.tranxAccountId = tranxAccountId;
    }

    public Currency getTranxCurrency() {
        return tranxCurrency;
    }

    public void setTranxCurrency(Currency tranxCurrency) {
        this.tranxCurrency = tranxCurrency;
    }

    public String getTransactionOtherId() {
        return transactionOtherId;
    }

    public void setTransactionOtherId(String transactionOtherId) {
        this.transactionOtherId = transactionOtherId;
    }

    public String getTranxStatus() {
        return tranxStatus;
    }

    public void setTranxStatus(String tranxStatus) {
        this.tranxStatus = tranxStatus;
    }

    public String getTranxMethod() {
        return tranxMethod;
    }

    public void setTranxMethod(String tranxMethod) {
        this.tranxMethod = tranxMethod;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tranxPayer);
        parcel.writeString(tranxBankAcct);
        parcel.writeString(tranxBankAccName);
        parcel.writeString(tranxBankAcctNo);
        parcel.writeInt(transactionID);
        parcel.writeString(tranxDate);
        parcel.writeInt(tranxSendingAccount);
        parcel.writeString(tranxBranchOffice);
        parcel.writeString(approver);
        parcel.writeString(tranxApprovalDate);
        parcel.writeInt(tranxDestAcct);
        parcel.writeString(tranxPayee);
        parcel.writeDouble(tranxAmount);
        parcel.writeString(transactionType);
        parcel.writeInt(tranxProfileID);
        parcel.writeInt(tranxAccountId);
        parcel.writeString(transactionOtherId);
        parcel.writeString(tranxStatus);
        parcel.writeString(tranxMethod);
    }


    public enum TRANSACTION_TYPE {
        PAYMENT, TRANSFER, DEPOSIT,MANUAL_WITHDRAWAL, SAVINGS,LOAN,STANDING_ORDER,
        REFERRALS,BORROWING,GROUP_SAVINGS_DEPOSIT,GROUP_SAVINGS_WITHDRAWAL,WITHDRAWALTX,PROMO,ITEM_PURCHASE,
        RETURNS, IVESTMENT;
    }


    private String tranxPayer;
    private String tranxBankAcct;
    private String tranxBankAccName;
    private String tranxBankAcctNo;

    private int transactionID=10101;
    private String tranxDate;
    private int tranxSendingAccount;
    private String tranxBranchOffice;
    private String approver;
    private String tranxApprovalDate;
    private int tranxDestAcct;
    private String tranxPayee;
    private double tranxAmount;
    private String transactionType;

    private int tranxProfileID;
    private int tranxAccountId;
    private Currency tranxCurrency;
    private String transactionOtherId;
    private String tranxStatus;
    private String tranxMethod;
}

