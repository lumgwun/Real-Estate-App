package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class EstateLettingSales implements Serializable, Parcelable {
    private  int eLSID;
    private  int eLSEstateID;
    private  int eLSProfID;
    private  int eLSReferrerProfID;
    private  String eLSStartDate;
    private  String eLSEndDate;
    private  String eLSDateOfPayment;
    private  int eLSDateOfConfirmation;
    private  String eLSDateOfHandover;
    private  String eLSStatus;

    public EstateLettingSales() {
        super();

    }

    protected EstateLettingSales(Parcel in) {
        eLSID = in.readInt();
        eLSEstateID = in.readInt();
        eLSProfID = in.readInt();
        eLSReferrerProfID = in.readInt();
        eLSStartDate = in.readString();
        eLSEndDate = in.readString();
        eLSDateOfPayment = in.readString();
        eLSDateOfConfirmation = in.readInt();
        eLSDateOfHandover = in.readString();
        eLSStatus = in.readString();
    }

    public static final Creator<EstateLettingSales> CREATOR = new Creator<EstateLettingSales>() {
        @Override
        public EstateLettingSales createFromParcel(Parcel in) {
            return new EstateLettingSales(in);
        }

        @Override
        public EstateLettingSales[] newArray(int size) {
            return new EstateLettingSales[size];
        }
    };

    public int geteLSID() {
        return eLSID;
    }

    public void seteLSID(int eLSID) {
        this.eLSID = eLSID;
    }

    public String geteLSStartDate() {
        return eLSStartDate;
    }

    public void seteLSStartDate(String eLSStartDate) {
        this.eLSStartDate = eLSStartDate;
    }

    public String geteLSEndDate() {
        return eLSEndDate;
    }

    public void seteLSEndDate(String eLSEndDate) {
        this.eLSEndDate = eLSEndDate;
    }

    public String geteLSDateOfPayment() {
        return eLSDateOfPayment;
    }

    public void seteLSDateOfPayment(String eLSDateOfPayment) {
        this.eLSDateOfPayment = eLSDateOfPayment;
    }

    public int geteLSDateOfConfirmation() {
        return eLSDateOfConfirmation;
    }

    public void seteLSDateOfConfirmation(int eLSDateOfConfirmation) {
        this.eLSDateOfConfirmation = eLSDateOfConfirmation;
    }

    public String geteLSDateOfHandover() {
        return eLSDateOfHandover;
    }

    public void seteLSDateOfHandover(String eLSDateOfHandover) {
        this.eLSDateOfHandover = eLSDateOfHandover;
    }

    public String geteLSStatus() {
        return eLSStatus;
    }

    public void seteLSStatus(String eLSStatus) {
        this.eLSStatus = eLSStatus;
    }

    public int geteLSEstateID() {
        return eLSEstateID;
    }

    public void seteLSEstateID(int eLSEstateID) {
        this.eLSEstateID = eLSEstateID;
    }

    public int geteLSProfID() {
        return eLSProfID;
    }

    public void seteLSProfID(int eLSProfID) {
        this.eLSProfID = eLSProfID;
    }

    public int geteLSReferrerProfID() {
        return eLSReferrerProfID;
    }

    public void seteLSReferrerProfID(int eLSReferrerProfID) {
        this.eLSReferrerProfID = eLSReferrerProfID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(eLSID);
        parcel.writeInt(eLSEstateID);
        parcel.writeInt(eLSProfID);
        parcel.writeInt(eLSReferrerProfID);
        parcel.writeString(eLSStartDate);
        parcel.writeString(eLSEndDate);
        parcel.writeString(eLSDateOfPayment);
        parcel.writeInt(eLSDateOfConfirmation);
        parcel.writeString(eLSDateOfHandover);
        parcel.writeString(eLSStatus);
    }
}
