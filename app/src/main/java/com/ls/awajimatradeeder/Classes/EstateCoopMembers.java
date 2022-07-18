package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class EstateCoopMembers implements Serializable, Parcelable {
    private int coopMID;
    private String coopMName;
    private String coopMStatus;

    protected EstateCoopMembers(Parcel in) {
        coopMID = in.readInt();
        coopMName = in.readString();
        coopMStatus = in.readString();
    }

    public static final Creator<EstateCoopMembers> CREATOR = new Creator<EstateCoopMembers>() {
        @Override
        public EstateCoopMembers createFromParcel(Parcel in) {
            return new EstateCoopMembers(in);
        }

        @Override
        public EstateCoopMembers[] newArray(int size) {
            return new EstateCoopMembers[size];
        }
    };

    public int getCoopMID() {
        return coopMID;
    }

    public void setCoopMID(int coopMID) {
        this.coopMID = coopMID;
    }

    public String getCoopMName() {
        return coopMName;
    }

    public void setCoopMName(String coopMName) {
        this.coopMName = coopMName;
    }

    public String getCoopMStatus() {
        return coopMStatus;
    }

    public void setCoopMStatus(String coopMStatus) {
        this.coopMStatus = coopMStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(coopMID);
        parcel.writeString(coopMName);
        parcel.writeString(coopMStatus);
    }
}
