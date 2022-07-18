package com.ls.awajimatradeeder.Classes;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;

public class TimeLine implements Serializable, Parcelable {
    private int tCount;
    private TimeLine timeLine;
    private int timelineID=140;
    private Profile timelineProfile;
    private String timestamp;
    private String timelineTittle;
    private String timelineDetails;
    private String timelineStatus;
    private int timeLineProfID;
    public TimeLine (){
        super();
    }
    public TimeLine(int timelineC, TimeLine timeLine1) {
        this.tCount = timelineC;
        this.timeLine = timeLine1;

    }
    public static final String TIMELINE_TABLE = "timelineTable";
    public static final String TIMELINE_ID = "_timeLine_id";
    public static final String TIMELINE_TITTLE = "timeline_tittle";
    public static final String TIMELINE_DETAILS = "timeline_details";
    public static final String TIMELINE_LOCATION = "timeline_location";
    public static final String TIMELINE_TIME = "timeline_time";
    public static final String TIMELINE_PROF_ID = "timeLine_ProfID";
    public static final String TIMELINE_STATUS = "timeLine_Status";

    public static final String CREATE_TIMELINE_TABLE = "CREATE TABLE " + TIMELINE_TABLE + " (" + TIMELINE_PROF_ID + " INTEGER NOT NULL, " + TIMELINE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
           + TIMELINE_TITTLE + " TEXT , " + TIMELINE_DETAILS + " TEXT , " + TIMELINE_LOCATION + " TEXT , "  + TIMELINE_TIME + " TEXT , "+ TIMELINE_STATUS + " TEXT , "+ "FOREIGN KEY(" + TIMELINE_PROF_ID + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + "))";

    protected TimeLine(Parcel in) {
        tCount = in.readInt();
        timeLine = in.readParcelable(TimeLine.class.getClassLoader());
        timelineID = in.readInt();
        timestamp = in.readString();
        timelineTittle = in.readString();
        timelineDetails = in.readString();
        timeLineProfID = in.readInt();
        //timeline_Location = in.readParcelable(Location.class.getClassLoader());
    }

    public static final Creator<TimeLine> CREATOR = new Creator<TimeLine>() {
        @Override
        public TimeLine createFromParcel(Parcel in) {
            return new TimeLine(in);
        }

        @Override
        public TimeLine[] newArray(int size) {
            return new TimeLine[size];
        }
    };

    public TimeLine(int timelineID, int ownerProfileId, String tittle, String details, String time, String status) {
        this.timelineID = timelineID;
        this.timeLineProfID = ownerProfileId;
        this.timelineTittle = tittle;
        this.timelineDetails = details;
        this.timelineDetails = status;
        this.timestamp = time;
    }

    public Profile getTimelineProfile() {
        return timelineProfile;
    }

    public void setTimelineProfile(Profile timelineProfile) {
        this.timelineProfile = timelineProfile;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimelineTittle() {
        return timelineTittle;
    }

    public void setTimelineTittle(String timelineTittle) {
        this.timelineTittle = timelineTittle;
    }

    public String getTimelineDetails() {
        return timelineDetails;
    }

    public void setTimelineDetails(String timelineDetails) {
        this.timelineDetails = timelineDetails;
    }

    public int getTimeLineProfID() {
        return timeLineProfID;
    }

    public void setTimeLineProfID(int timeLineProfID) {
        this.timeLineProfID = timeLineProfID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(tCount);
        parcel.writeParcelable(timeLine, i);
        parcel.writeInt(timelineID);
        parcel.writeString(timestamp);
        parcel.writeString(timelineTittle);
        parcel.writeString(timelineDetails);
        parcel.writeInt(timeLineProfID);
    }

    public String getTimelineStatus() {
        return timelineStatus;
    }

    public void setTimelineStatus(String timelineStatus) {
        this.timelineStatus = timelineStatus;
    }
}
