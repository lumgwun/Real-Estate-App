package com.ls.awajimatradeeder.Classes;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Property implements Serializable, Parcelable {
    private int propertyID;
    private int propertyEstateID;
    private int propertyProfID;
    private String propertyType;
    private String propertyTown;
    private String propertyState;
    private String propertyCountry;
    private Uri propertyPicture;
    private double propertyPrice;
    private String propertyPriceDuration;
    private String propertyStatus;
    private Property propProperty;
    private boolean isEstateProp;
    private ArrayList<PropertyPicture> propertyPictures;

    public Property() {
        super();

    }

    protected Property(Parcel in) {
        propertyID = in.readInt();
        propertyEstateID = in.readInt();
        propertyProfID = in.readInt();
        propertyType = in.readString();
        propertyTown = in.readString();
        propertyState = in.readString();
        propertyCountry = in.readString();
        propertyPicture = in.readParcelable(Uri.class.getClassLoader());
        propertyPrice = in.readDouble();
        propertyPriceDuration = in.readString();
        propertyStatus = in.readString();
        isEstateProp = in.readByte() != 0;
    }

    public static final Creator<Property> CREATOR = new Creator<Property>() {
        @Override
        public Property createFromParcel(Parcel in) {
            return new Property(in);
        }

        @Override
        public Property[] newArray(int size) {
            return new Property[size];
        }
    };

    public Property(Property property1) {
        this.propProperty=property1;

    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getPropertyProfID() {
        return propertyProfID;
    }

    public void setPropertyProfID(int propertyProfID) {
        this.propertyProfID = propertyProfID;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyTown() {
        return propertyTown;
    }

    public void setPropertyTown(String propertyTown) {
        this.propertyTown = propertyTown;
    }

    public String getPropertyState() {
        return propertyState;
    }

    public void setPropertyState(String propertyState) {
        this.propertyState = propertyState;
    }

    public String getPropertyCountry() {
        return propertyCountry;
    }

    public void setPropertyCountry(String propertyCountry) {
        this.propertyCountry = propertyCountry;
    }

    public Uri getPropertyPicture() {
        return propertyPicture;
    }

    public void setPropertyPicture(Uri propertyPicture) {
        this.propertyPicture = propertyPicture;
    }

    public double getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(double propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public String getPropertyPriceDuration() {
        return propertyPriceDuration;
    }

    public void setPropertyPriceDuration(String propertyPriceDuration) {
        this.propertyPriceDuration = propertyPriceDuration;
    }

    public ArrayList<PropertyPicture> getPropertyPictures() {
        return propertyPictures;
    }

    public void setPropertyPictures(ArrayList<PropertyPicture> propertyPictures) {
        this.propertyPictures = propertyPictures;
    }

    public int getPropertyEstateID() {
        return propertyEstateID;
    }

    public void setPropertyEstateID(int propertyEstateID) {
        this.propertyEstateID = propertyEstateID;
    }

    public String getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(String propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public boolean isEstateProp() {
        return isEstateProp;
    }

    public void setEstateProp(boolean estateProp) {
        isEstateProp = estateProp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(propertyID);
        parcel.writeInt(propertyEstateID);
        parcel.writeInt(propertyProfID);
        parcel.writeString(propertyType);
        parcel.writeString(propertyTown);
        parcel.writeString(propertyState);
        parcel.writeString(propertyCountry);
        parcel.writeParcelable(propertyPicture, i);
        parcel.writeDouble(propertyPrice);
        parcel.writeString(propertyPriceDuration);
        parcel.writeString(propertyStatus);
        parcel.writeByte((byte) (isEstateProp ? 1 : 0));
    }
}
