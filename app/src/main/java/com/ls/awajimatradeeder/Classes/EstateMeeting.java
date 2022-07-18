package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class EstateMeeting implements Serializable, Parcelable {
    private int estateMeetingID;
    private String estateMeetingDate;
    private String estateMeetingStartTime;
    private String estateMeetingEndTime;
    private String estateMeetingStatus;
    private String estateMeetingConvener;
    private String estateMeetingVenue;
    private String estateMeetingAgender;
    public EstateMeeting() {
        super();

    }

    protected EstateMeeting(Parcel in) {
        estateMeetingID = in.readInt();
        estateMeetingDate = in.readString();
        estateMeetingStartTime = in.readString();
        estateMeetingEndTime = in.readString();
        estateMeetingStatus = in.readString();
        estateMeetingConvener = in.readString();
        estateMeetingVenue = in.readString();
        estateMeetingAgender = in.readString();
    }

    public static final Creator<EstateMeeting> CREATOR = new Creator<EstateMeeting>() {
        @Override
        public EstateMeeting createFromParcel(Parcel in) {
            return new EstateMeeting(in);
        }

        @Override
        public EstateMeeting[] newArray(int size) {
            return new EstateMeeting[size];
        }
    };

    public int getEstateMeetingID() {
        return estateMeetingID;
    }

    public void setEstateMeetingID(int estateMeetingID) {
        this.estateMeetingID = estateMeetingID;
    }

    public String getEstateMeetingDate() {
        return estateMeetingDate;
    }

    public void setEstateMeetingDate(String estateMeetingDate) {
        this.estateMeetingDate = estateMeetingDate;
    }

    public String getEstateMeetingStartTime() {
        return estateMeetingStartTime;
    }

    public void setEstateMeetingStartTime(String estateMeetingStartTime) {
        this.estateMeetingStartTime = estateMeetingStartTime;
    }

    public String getEstateMeetingEndTime() {
        return estateMeetingEndTime;
    }

    public void setEstateMeetingEndTime(String estateMeetingEndTime) {
        this.estateMeetingEndTime = estateMeetingEndTime;
    }

    public String getEstateMeetingStatus() {
        return estateMeetingStatus;
    }

    public void setEstateMeetingStatus(String estateMeetingStatus) {
        this.estateMeetingStatus = estateMeetingStatus;
    }

    public String getEstateMeetingConvener() {
        return estateMeetingConvener;
    }

    public void setEstateMeetingConvener(String estateMeetingConvener) {
        this.estateMeetingConvener = estateMeetingConvener;
    }

    public String getEstateMeetingVenue() {
        return estateMeetingVenue;
    }

    public void setEstateMeetingVenue(String estateMeetingVenue) {
        this.estateMeetingVenue = estateMeetingVenue;
    }

    public String getEstateMeetingAgender() {
        return estateMeetingAgender;
    }

    public void setEstateMeetingAgender(String estateMeetingAgender) {
        this.estateMeetingAgender = estateMeetingAgender;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(estateMeetingID);
        parcel.writeString(estateMeetingDate);
        parcel.writeString(estateMeetingStartTime);
        parcel.writeString(estateMeetingEndTime);
        parcel.writeString(estateMeetingStatus);
        parcel.writeString(estateMeetingConvener);
        parcel.writeString(estateMeetingVenue);
        parcel.writeString(estateMeetingAgender);
    }
}
