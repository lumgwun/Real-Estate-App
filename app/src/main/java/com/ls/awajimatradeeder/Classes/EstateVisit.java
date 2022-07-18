package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class EstateVisit implements Serializable, Parcelable {
    private  int visitID;
    private String visitDate;
    private String visitTimeIn;
    private String visitTimeOut;
    private int visitAppartmentID;
    private int visitNoOfPersons;
    private int visitCode;
    private String visitStatus;
    public EstateVisit() {
        super();

    }

    protected EstateVisit(Parcel in) {
        visitID = in.readInt();
        visitDate = in.readString();
        visitTimeIn = in.readString();
        visitTimeOut = in.readString();
        visitAppartmentID = in.readInt();
        visitNoOfPersons = in.readInt();
        visitCode = in.readInt();
        visitStatus = in.readString();
    }

    public static final Creator<EstateVisit> CREATOR = new Creator<EstateVisit>() {
        @Override
        public EstateVisit createFromParcel(Parcel in) {
            return new EstateVisit(in);
        }

        @Override
        public EstateVisit[] newArray(int size) {
            return new EstateVisit[size];
        }
    };

    public int getVisitID() {
        return visitID;
    }

    public void setVisitID(int visitID) {
        this.visitID = visitID;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitTimeIn() {
        return visitTimeIn;
    }

    public void setVisitTimeIn(String visitTimeIn) {
        this.visitTimeIn = visitTimeIn;
    }

    public String getVisitTimeOut() {
        return visitTimeOut;
    }

    public void setVisitTimeOut(String visitTimeOut) {
        this.visitTimeOut = visitTimeOut;
    }

    public int getVisitAppartmentID() {
        return visitAppartmentID;
    }

    public void setVisitAppartmentID(int visitAppartmentID) {
        this.visitAppartmentID = visitAppartmentID;
    }

    public int getVisitNoOfPersons() {
        return visitNoOfPersons;
    }

    public void setVisitNoOfPersons(int visitNoOfPersons) {
        this.visitNoOfPersons = visitNoOfPersons;
    }

    public int getVisitCode() {
        return visitCode;
    }

    public void setVisitCode(int visitCode) {
        this.visitCode = visitCode;
    }

    public String getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(String visitStatus) {
        this.visitStatus = visitStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(visitID);
        parcel.writeString(visitDate);
        parcel.writeString(visitTimeIn);
        parcel.writeString(visitTimeOut);
        parcel.writeInt(visitAppartmentID);
        parcel.writeInt(visitNoOfPersons);
        parcel.writeInt(visitCode);
        parcel.writeString(visitStatus);
    }
}
