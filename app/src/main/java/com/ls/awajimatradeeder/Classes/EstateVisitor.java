package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class EstateVisitor implements Serializable, Parcelable {
    private int estateVisitorID;
    private int estateVisitorFName;
    private int estateVisitorSName;
    private int estateVisitorCount;
    private String estateVisitorPhoneNo;
    private String estateVisitorEmail;
    private String estateVisitorAddress;
    private String estateVisitorPicture;
    public EstateVisitor() {
        super();

    }

    protected EstateVisitor(Parcel in) {
        estateVisitorID = in.readInt();
        estateVisitorFName = in.readInt();
        estateVisitorSName = in.readInt();
        estateVisitorCount = in.readInt();
        estateVisitorPhoneNo = in.readString();
        estateVisitorEmail = in.readString();
        estateVisitorAddress = in.readString();
        estateVisitorPicture = in.readString();
    }

    public static final Creator<EstateVisitor> CREATOR = new Creator<EstateVisitor>() {
        @Override
        public EstateVisitor createFromParcel(Parcel in) {
            return new EstateVisitor(in);
        }

        @Override
        public EstateVisitor[] newArray(int size) {
            return new EstateVisitor[size];
        }
    };

    public int getEstateVisitorID() {
        return estateVisitorID;
    }

    public void setEstateVisitorID(int estateVisitorID) {
        this.estateVisitorID = estateVisitorID;
    }

    public int getEstateVisitorFName() {
        return estateVisitorFName;
    }

    public void setEstateVisitorFName(int estateVisitorFName) {
        this.estateVisitorFName = estateVisitorFName;
    }

    public int getEstateVisitorSName() {
        return estateVisitorSName;
    }

    public void setEstateVisitorSName(int estateVisitorSName) {
        this.estateVisitorSName = estateVisitorSName;
    }

    public int getEstateVisitorCount() {
        return estateVisitorCount;
    }

    public void setEstateVisitorCount(int estateVisitorCount) {
        this.estateVisitorCount = estateVisitorCount;
    }

    public String getEstateVisitorPhoneNo() {
        return estateVisitorPhoneNo;
    }

    public void setEstateVisitorPhoneNo(String estateVisitorPhoneNo) {
        this.estateVisitorPhoneNo = estateVisitorPhoneNo;
    }

    public String getEstateVisitorEmail() {
        return estateVisitorEmail;
    }

    public void setEstateVisitorEmail(String estateVisitorEmail) {
        this.estateVisitorEmail = estateVisitorEmail;
    }

    public String getEstateVisitorAddress() {
        return estateVisitorAddress;
    }

    public void setEstateVisitorAddress(String estateVisitorAddress) {
        this.estateVisitorAddress = estateVisitorAddress;
    }

    public String getEstateVisitorPicture() {
        return estateVisitorPicture;
    }

    public void setEstateVisitorPicture(String estateVisitorPicture) {
        this.estateVisitorPicture = estateVisitorPicture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(estateVisitorID);
        parcel.writeInt(estateVisitorFName);
        parcel.writeInt(estateVisitorSName);
        parcel.writeInt(estateVisitorCount);
        parcel.writeString(estateVisitorPhoneNo);
        parcel.writeString(estateVisitorEmail);
        parcel.writeString(estateVisitorAddress);
        parcel.writeString(estateVisitorPicture);
    }
}
