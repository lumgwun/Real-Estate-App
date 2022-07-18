package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class EstateEmergency implements Serializable, Parcelable {
    private int estateEmergID;
    private String emergType;
    private double emergLat;
    private double emergLng;
    private int estateEmergReporterID;
    private String emergReporter;
    private String emergReportStatus;

    public EstateEmergency() {
        super();

    }

    protected EstateEmergency(Parcel in) {
        estateEmergID = in.readInt();
        emergType = in.readString();
        emergLat = in.readDouble();
        emergLng = in.readDouble();
        estateEmergReporterID = in.readInt();
        emergReporter = in.readString();
        emergReportStatus = in.readString();
    }

    public static final Creator<EstateEmergency> CREATOR = new Creator<EstateEmergency>() {
        @Override
        public EstateEmergency createFromParcel(Parcel in) {
            return new EstateEmergency(in);
        }

        @Override
        public EstateEmergency[] newArray(int size) {
            return new EstateEmergency[size];
        }
    };

    public int getEstateEmergID() {
        return estateEmergID;
    }

    public void setEstateEmergID(int estateEmergID) {
        this.estateEmergID = estateEmergID;
    }

    public String getEmergType() {
        return emergType;
    }

    public void setEmergType(String emergType) {
        this.emergType = emergType;
    }

    public double getEmergLat() {
        return emergLat;
    }

    public void setEmergLat(double emergLat) {
        this.emergLat = emergLat;
    }

    public double getEmergLng() {
        return emergLng;
    }

    public void setEmergLng(double emergLng) {
        this.emergLng = emergLng;
    }

    public int getEstateEmergReporterID() {
        return estateEmergReporterID;
    }

    public void setEstateEmergReporterID(int estateEmergReporterID) {
        this.estateEmergReporterID = estateEmergReporterID;
    }

    public String getEmergReporter() {
        return emergReporter;
    }

    public void setEmergReporter(String emergReporter) {
        this.emergReporter = emergReporter;
    }

    public String getEmergReportStatus() {
        return emergReportStatus;
    }

    public void setEmergReportStatus(String emergReportStatus) {
        this.emergReportStatus = emergReportStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(estateEmergID);
        parcel.writeString(emergType);
        parcel.writeDouble(emergLat);
        parcel.writeDouble(emergLng);
        parcel.writeInt(estateEmergReporterID);
        parcel.writeString(emergReporter);
        parcel.writeString(emergReportStatus);
    }
}
