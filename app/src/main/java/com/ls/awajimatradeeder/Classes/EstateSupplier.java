package com.ls.awajimatradeeder.Classes;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class EstateSupplier implements Serializable, Parcelable {
    private int estateSupplierID;
    private String estateSupplierFName;
    private String estateSupplierSName;
    private String estateSupplierPhoneNo;
    private String estateSupplierEmail;
    private String estateSupplierAddress;
    private String estateSupplierIDType;
    private String estateSupplierIDentity;
    private String estateSupplierBusinessName;
    private String estateSupplierBusinessAddress;
    private String estateSupplierBusinessPhoneNo;
    private String estateSupplierStatus;
    private String estateSupplierType;
    private String estateSupplierDescrip;
    private Uri estateSupplierProduct;

    protected EstateSupplier(Parcel in) {
        estateSupplierID = in.readInt();
        estateSupplierFName = in.readString();
        estateSupplierSName = in.readString();
        estateSupplierPhoneNo = in.readString();
        estateSupplierEmail = in.readString();
        estateSupplierAddress = in.readString();
        estateSupplierIDType = in.readString();
        estateSupplierIDentity = in.readString();
        estateSupplierBusinessName = in.readString();
        estateSupplierBusinessAddress = in.readString();
        estateSupplierBusinessPhoneNo = in.readString();
        estateSupplierStatus = in.readString();
        estateSupplierType = in.readString();
        estateSupplierDescrip = in.readString();
        estateSupplierProduct = in.readParcelable(Uri.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(estateSupplierID);
        dest.writeString(estateSupplierFName);
        dest.writeString(estateSupplierSName);
        dest.writeString(estateSupplierPhoneNo);
        dest.writeString(estateSupplierEmail);
        dest.writeString(estateSupplierAddress);
        dest.writeString(estateSupplierIDType);
        dest.writeString(estateSupplierIDentity);
        dest.writeString(estateSupplierBusinessName);
        dest.writeString(estateSupplierBusinessAddress);
        dest.writeString(estateSupplierBusinessPhoneNo);
        dest.writeString(estateSupplierStatus);
        dest.writeString(estateSupplierType);
        dest.writeString(estateSupplierDescrip);
        dest.writeParcelable(estateSupplierProduct, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EstateSupplier> CREATOR = new Creator<EstateSupplier>() {
        @Override
        public EstateSupplier createFromParcel(Parcel in) {
            return new EstateSupplier(in);
        }

        @Override
        public EstateSupplier[] newArray(int size) {
            return new EstateSupplier[size];
        }
    };

    public int getEstateSupplierID() {
        return estateSupplierID;
    }

    public void setEstateSupplierID(int estateSupplierID) {
        this.estateSupplierID = estateSupplierID;
    }

    public String getEstateSupplierFName() {
        return estateSupplierFName;
    }

    public void setEstateSupplierFName(String estateSupplierFName) {
        this.estateSupplierFName = estateSupplierFName;
    }

    public String getEstateSupplierSName() {
        return estateSupplierSName;
    }

    public void setEstateSupplierSName(String estateSupplierSName) {
        this.estateSupplierSName = estateSupplierSName;
    }

    public String getEstateSupplierPhoneNo() {
        return estateSupplierPhoneNo;
    }

    public void setEstateSupplierPhoneNo(String estateSupplierPhoneNo) {
        this.estateSupplierPhoneNo = estateSupplierPhoneNo;
    }

    public String getEstateSupplierEmail() {
        return estateSupplierEmail;
    }

    public void setEstateSupplierEmail(String estateSupplierEmail) {
        this.estateSupplierEmail = estateSupplierEmail;
    }

    public String getEstateSupplierAddress() {
        return estateSupplierAddress;
    }

    public void setEstateSupplierAddress(String estateSupplierAddress) {
        this.estateSupplierAddress = estateSupplierAddress;
    }

    public String getEstateSupplierIDType() {
        return estateSupplierIDType;
    }

    public void setEstateSupplierIDType(String estateSupplierIDType) {
        this.estateSupplierIDType = estateSupplierIDType;
    }

    public String getEstateSupplierIDentity() {
        return estateSupplierIDentity;
    }

    public void setEstateSupplierIDentity(String estateSupplierIDentity) {
        this.estateSupplierIDentity = estateSupplierIDentity;
    }

    public String getEstateSupplierBusinessName() {
        return estateSupplierBusinessName;
    }

    public void setEstateSupplierBusinessName(String estateSupplierBusinessName) {
        this.estateSupplierBusinessName = estateSupplierBusinessName;
    }

    public String getEstateSupplierBusinessAddress() {
        return estateSupplierBusinessAddress;
    }

    public void setEstateSupplierBusinessAddress(String estateSupplierBusinessAddress) {
        this.estateSupplierBusinessAddress = estateSupplierBusinessAddress;
    }

    public String getEstateSupplierBusinessPhoneNo() {
        return estateSupplierBusinessPhoneNo;
    }

    public void setEstateSupplierBusinessPhoneNo(String estateSupplierBusinessPhoneNo) {
        this.estateSupplierBusinessPhoneNo = estateSupplierBusinessPhoneNo;
    }

    public String getEstateSupplierStatus() {
        return estateSupplierStatus;
    }

    public void setEstateSupplierStatus(String estateSupplierStatus) {
        this.estateSupplierStatus = estateSupplierStatus;
    }

    public String getEstateSupplierType() {
        return estateSupplierType;
    }

    public void setEstateSupplierType(String estateSupplierType) {
        this.estateSupplierType = estateSupplierType;
    }

    public String getEstateSupplierDescrip() {
        return estateSupplierDescrip;
    }

    public void setEstateSupplierDescrip(String estateSupplierDescrip) {
        this.estateSupplierDescrip = estateSupplierDescrip;
    }

    public Uri getEstateSupplierProduct() {
        return estateSupplierProduct;
    }

    public void setEstateSupplierProduct(Uri estateSupplierProduct) {
        this.estateSupplierProduct = estateSupplierProduct;
    }
}
