package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class EstateJob implements Serializable, Parcelable {
    private int estateJobID;
    private String estateJobTitle;
    private String estateJobLocation;
    private String estateJobQualification;
    private String estateJobMoreDetails;
    private String estateJobStatus;
    public EstateJob() {
        super();

    }

    protected EstateJob(Parcel in) {
        estateJobID = in.readInt();
        estateJobTitle = in.readString();
        estateJobLocation = in.readString();
        estateJobQualification = in.readString();
        estateJobMoreDetails = in.readString();
        estateJobStatus = in.readString();
    }

    public static final Creator<EstateJob> CREATOR = new Creator<EstateJob>() {
        @Override
        public EstateJob createFromParcel(Parcel in) {
            return new EstateJob(in);
        }

        @Override
        public EstateJob[] newArray(int size) {
            return new EstateJob[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(estateJobID);
        parcel.writeString(estateJobTitle);
        parcel.writeString(estateJobLocation);
        parcel.writeString(estateJobQualification);
        parcel.writeString(estateJobMoreDetails);
        parcel.writeString(estateJobStatus);
    }
}
