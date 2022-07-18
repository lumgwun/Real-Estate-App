package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Seller implements Serializable, Parcelable {
    private int SellerID;
    private int SellerProfID;
    private int SellerAcctID;
    private String SellerLastName;
    private String SellerFirstName;
    private String SellerType;
    private String SellerPhoneNumber;
    private String SellerEmail;
    private String SellerGender;
    private String SellerOfficeAddress;
    private String SellerDateJoined;
    private String SellerPaypalEmail;
    private String SellerCrptoWalletAddress;
    private String SellerCrptoWalletType;
    private String SellerStatus;
    private Profile SellerProfile;
    private Account SellerAccount;
    private ArrayList<SellerProduct> sellerProducts;
    private int SellerProductNo;
    public Seller() {

        super();
    }

    protected Seller(Parcel in) {
        SellerID = in.readInt();
        SellerProfID = in.readInt();
        SellerAcctID = in.readInt();
        SellerLastName = in.readString();
        SellerFirstName = in.readString();
        SellerType = in.readString();
        SellerPhoneNumber = in.readString();
        SellerEmail = in.readString();
        SellerGender = in.readString();
        SellerOfficeAddress = in.readString();
        SellerDateJoined = in.readString();
        SellerPaypalEmail = in.readString();
        SellerCrptoWalletAddress = in.readString();
        SellerCrptoWalletType = in.readString();
        SellerStatus = in.readString();
        SellerProfile = in.readParcelable(Profile.class.getClassLoader());
        SellerAccount = in.readParcelable(Account.class.getClassLoader());
        SellerProductNo = in.readInt();
    }

    public static final Creator<Seller> CREATOR = new Creator<Seller>() {
        @Override
        public Seller createFromParcel(Parcel in) {
            return new Seller(in);
        }

        @Override
        public Seller[] newArray(int size) {
            return new Seller[size];
        }
    };

    public void addSellerProduct(SellerProduct sellerProduct1) {
        sellerProducts= new ArrayList<>();
        SellerProductNo = sellerProducts.size() + 1;
        SellerProduct sellerProduct = new SellerProduct(SellerProductNo,sellerProduct1);
        sellerProducts.add(sellerProduct);
    }

    public int getSellerID() {
        return SellerID;
    }

    public void setSellerID(int sellerID) {
        SellerID = sellerID;
    }

    public int getSellerProfID() {
        return SellerProfID;
    }

    public void setSellerProfID(int sellerProfID) {
        SellerProfID = sellerProfID;
    }

    public int getSellerAcctID() {
        return SellerAcctID;
    }

    public void setSellerAcctID(int sellerAcctID) {
        SellerAcctID = sellerAcctID;
    }

    public String getSellerLastName() {
        return SellerLastName;
    }

    public void setSellerLastName(String sellerLastName) {
        SellerLastName = sellerLastName;
    }

    public String getSellerFirstName() {
        return SellerFirstName;
    }

    public void setSellerFirstName(String sellerFirstName) {
        SellerFirstName = sellerFirstName;
    }

    public String getSellerType() {
        return SellerType;
    }

    public void setSellerType(String sellerType) {
        SellerType = sellerType;
    }

    public String getSellerPhoneNumber() {
        return SellerPhoneNumber;
    }

    public void setSellerPhoneNumber(String sellerPhoneNumber) {
        SellerPhoneNumber = sellerPhoneNumber;
    }

    public String getSellerEmail() {
        return SellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        SellerEmail = sellerEmail;
    }

    public String getSellerGender() {
        return SellerGender;
    }

    public void setSellerGender(String sellerGender) {
        SellerGender = sellerGender;
    }

    public String getSellerOfficeAddress() {
        return SellerOfficeAddress;
    }

    public void setSellerOfficeAddress(String sellerOfficeAddress) {
        SellerOfficeAddress = sellerOfficeAddress;
    }

    public String getSellerDateJoined() {
        return SellerDateJoined;
    }

    public void setSellerDateJoined(String sellerDateJoined) {
        SellerDateJoined = sellerDateJoined;
    }

    public ArrayList<SellerProduct> getSellerProducts() {
        return sellerProducts;
    }

    public void setSellerProducts(ArrayList<SellerProduct> sellerProducts) {
        this.sellerProducts = sellerProducts;
    }

    public String getSellerPaypalEmail() {
        return SellerPaypalEmail;
    }

    public void setSellerPaypalEmail(String sellerPaypalEmail) {
        SellerPaypalEmail = sellerPaypalEmail;
    }

    public String getSellerCrptoWalletAddress() {
        return SellerCrptoWalletAddress;
    }

    public void setSellerCrptoWalletAddress(String sellerCrptoWalletAddress) {
        SellerCrptoWalletAddress = sellerCrptoWalletAddress;
    }

    public String getSellerCrptoWalletType() {
        return SellerCrptoWalletType;
    }

    public void setSellerCrptoWalletType(String sellerCrptoWalletType) {
        SellerCrptoWalletType = sellerCrptoWalletType;
    }

    public String getSellerStatus() {
        return SellerStatus;
    }

    public void setSellerStatus(String sellerStatus) {
        SellerStatus = sellerStatus;
    }

    public Profile getSellerProfile() {
        return SellerProfile;
    }

    public void setSellerProfile(Profile sellerProfile) {
        SellerProfile = sellerProfile;
    }

    public Account getSellerAccount() {
        return SellerAccount;
    }

    public void setSellerAccount(Account sellerAccount) {
        SellerAccount = sellerAccount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(SellerID);
        parcel.writeInt(SellerProfID);
        parcel.writeInt(SellerAcctID);
        parcel.writeString(SellerLastName);
        parcel.writeString(SellerFirstName);
        parcel.writeString(SellerType);
        parcel.writeString(SellerPhoneNumber);
        parcel.writeString(SellerEmail);
        parcel.writeString(SellerGender);
        parcel.writeString(SellerOfficeAddress);
        parcel.writeString(SellerDateJoined);
        parcel.writeString(SellerPaypalEmail);
        parcel.writeString(SellerCrptoWalletAddress);
        parcel.writeString(SellerCrptoWalletType);
        parcel.writeString(SellerStatus);
        parcel.writeParcelable(SellerProfile, i);
        parcel.writeParcelable(SellerAccount, i);
        parcel.writeInt(SellerProductNo);
    }
}
