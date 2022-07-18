package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class EstateAppartment implements Serializable, Parcelable {
    private int estateAppartmentID;
    private int estateAppartmentNo;
    private int estateAppartmentName;
    private String estateAppartmentStatus;
    private String estateAppartmentType;

    public EstateAppartment() {
        super();

    }

    protected EstateAppartment(Parcel in) {
        estateAppartmentID = in.readInt();
        estateAppartmentNo = in.readInt();
        estateAppartmentName = in.readInt();
        estateAppartmentStatus = in.readString();
        estateAppartmentType = in.readString();
    }

    public static final Creator<EstateAppartment> CREATOR = new Creator<EstateAppartment>() {
        @Override
        public EstateAppartment createFromParcel(Parcel in) {
            return new EstateAppartment(in);
        }

        @Override
        public EstateAppartment[] newArray(int size) {
            return new EstateAppartment[size];
        }
    };

    public int getEstateAppartmentID() {
        return estateAppartmentID;
    }

    public void setEstateAppartmentID(int estateAppartmentID) {
        this.estateAppartmentID = estateAppartmentID;
    }

    public int getEstateAppartmentNo() {
        return estateAppartmentNo;
    }

    public void setEstateAppartmentNo(int estateAppartmentNo) {
        this.estateAppartmentNo = estateAppartmentNo;
    }

    public int getEstateAppartmentName() {
        return estateAppartmentName;
    }

    public void setEstateAppartmentName(int estateAppartmentName) {
        this.estateAppartmentName = estateAppartmentName;
    }

    public String getEstateAppartmentStatus() {
        return estateAppartmentStatus;
    }

    public void setEstateAppartmentStatus(String estateAppartmentStatus) {
        this.estateAppartmentStatus = estateAppartmentStatus;
    }

    public String getEstateAppartmentType() {
        return estateAppartmentType;
    }

    public void setEstateAppartmentType(String estateAppartmentType) {
        this.estateAppartmentType = estateAppartmentType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(estateAppartmentID);
        parcel.writeInt(estateAppartmentNo);
        parcel.writeInt(estateAppartmentName);
        parcel.writeString(estateAppartmentStatus);
        parcel.writeString(estateAppartmentType);
    }
}
