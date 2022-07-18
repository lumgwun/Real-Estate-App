package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class EstateDriver implements Serializable, Parcelable {
    private  int estateDriverID;
    private  int estateDriverProfID;
    private String estateDriverFName;
    private String estateDriverSName;
    private String estateDriverVehicleNo;
    private String estateDriverPhoneNo;
    private String estateDriverEmail;
    private String estateDriverStatus;
    private String estateDriveVehicleColor;

    public EstateDriver() {
        super();

    }

    protected EstateDriver(Parcel in) {
        estateDriverID = in.readInt();
        estateDriverProfID = in.readInt();
        estateDriverFName = in.readString();
        estateDriverSName = in.readString();
        estateDriverVehicleNo = in.readString();
        estateDriverPhoneNo = in.readString();
        estateDriverEmail = in.readString();
        estateDriverStatus = in.readString();
        estateDriveVehicleColor = in.readString();
    }

    public static final Creator<EstateDriver> CREATOR = new Creator<EstateDriver>() {
        @Override
        public EstateDriver createFromParcel(Parcel in) {
            return new EstateDriver(in);
        }

        @Override
        public EstateDriver[] newArray(int size) {
            return new EstateDriver[size];
        }
    };

    public int getEstateDriverID() {
        return estateDriverID;
    }

    public void setEstateDriverID(int estateDriverID) {
        this.estateDriverID = estateDriverID;
    }

    public int getEstateDriverProfID() {
        return estateDriverProfID;
    }

    public void setEstateDriverProfID(int estateDriverProfID) {
        this.estateDriverProfID = estateDriverProfID;
    }

    public String getEstateDriverFName() {
        return estateDriverFName;
    }

    public void setEstateDriverFName(String estateDriverFName) {
        this.estateDriverFName = estateDriverFName;
    }

    public String getEstateDriverSName() {
        return estateDriverSName;
    }

    public void setEstateDriverSName(String estateDriverSName) {
        this.estateDriverSName = estateDriverSName;
    }

    public String getEstateDriverVehicleNo() {
        return estateDriverVehicleNo;
    }

    public void setEstateDriverVehicleNo(String estateDriverVehicleNo) {
        this.estateDriverVehicleNo = estateDriverVehicleNo;
    }

    public String getEstateDriverPhoneNo() {
        return estateDriverPhoneNo;
    }

    public void setEstateDriverPhoneNo(String estateDriverPhoneNo) {
        this.estateDriverPhoneNo = estateDriverPhoneNo;
    }

    public String getEstateDriverEmail() {
        return estateDriverEmail;
    }

    public void setEstateDriverEmail(String estateDriverEmail) {
        this.estateDriverEmail = estateDriverEmail;
    }

    public String getEstateDriverStatus() {
        return estateDriverStatus;
    }

    public void setEstateDriverStatus(String estateDriverStatus) {
        this.estateDriverStatus = estateDriverStatus;
    }

    public String getEstateDriveVehicleColor() {
        return estateDriveVehicleColor;
    }

    public void setEstateDriveVehicleColor(String estateDriveVehicleColor) {
        this.estateDriveVehicleColor = estateDriveVehicleColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(estateDriverID);
        parcel.writeInt(estateDriverProfID);
        parcel.writeString(estateDriverFName);
        parcel.writeString(estateDriverSName);
        parcel.writeString(estateDriverVehicleNo);
        parcel.writeString(estateDriverPhoneNo);
        parcel.writeString(estateDriverEmail);
        parcel.writeString(estateDriverStatus);
        parcel.writeString(estateDriveVehicleColor);
    }
}
