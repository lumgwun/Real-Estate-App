package com.ls.awajimatradeeder.Classes;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class EstateChat implements Serializable, Parcelable {
    private  int chatID;
    private  int chatEstateID;
    private  int chatFromProfID;
    private  int chatToProfID;
    private String chatFrom;
    private String chatTo;
    private String chatDate;
    private String chatStatus;
    private Uri chatPicture;

    public EstateChat() {
        super();

    }

    protected EstateChat(Parcel in) {
        chatID = in.readInt();
        chatEstateID = in.readInt();
        chatFromProfID = in.readInt();
        chatToProfID = in.readInt();
        chatFrom = in.readString();
        chatTo = in.readString();
        chatDate = in.readString();
        chatStatus = in.readString();
        chatPicture = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<EstateChat> CREATOR = new Creator<EstateChat>() {
        @Override
        public EstateChat createFromParcel(Parcel in) {
            return new EstateChat(in);
        }

        @Override
        public EstateChat[] newArray(int size) {
            return new EstateChat[size];
        }
    };

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public int getChatEstateID() {
        return chatEstateID;
    }

    public void setChatEstateID(int chatEstateID) {
        this.chatEstateID = chatEstateID;
    }

    public int getChatFromProfID() {
        return chatFromProfID;
    }

    public void setChatFromProfID(int chatFromProfID) {
        this.chatFromProfID = chatFromProfID;
    }

    public int getChatToProfID() {
        return chatToProfID;
    }

    public void setChatToProfID(int chatToProfID) {
        this.chatToProfID = chatToProfID;
    }

    public String getChatFrom() {
        return chatFrom;
    }

    public void setChatFrom(String chatFrom) {
        this.chatFrom = chatFrom;
    }

    public String getChatTo() {
        return chatTo;
    }

    public void setChatTo(String chatTo) {
        this.chatTo = chatTo;
    }

    public String getChatDate() {
        return chatDate;
    }

    public void setChatDate(String chatDate) {
        this.chatDate = chatDate;
    }

    public String getChatStatus() {
        return chatStatus;
    }

    public void setChatStatus(String chatStatus) {
        this.chatStatus = chatStatus;
    }

    public Uri getChatPicture() {
        return chatPicture;
    }

    public void setChatPicture(Uri chatPicture) {
        this.chatPicture = chatPicture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(chatID);
        parcel.writeInt(chatEstateID);
        parcel.writeInt(chatFromProfID);
        parcel.writeInt(chatToProfID);
        parcel.writeString(chatFrom);
        parcel.writeString(chatTo);
        parcel.writeString(chatDate);
        parcel.writeString(chatStatus);
        parcel.writeParcelable(chatPicture, i);
    }
}
