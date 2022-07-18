package com.ls.awajimatradeeder.Classes;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class PropertyPicture implements Serializable, Parcelable {
    private  int propertyPicID;
    private  int propertyPicProfID;
    private  int propertyPicPropID;
    private Uri propertyPicImage;
    private String propertyPicTittle;
    private String propertyPicDescrip;
    private Property propertyPicProp;

    public PropertyPicture() {
        super();

    }

    protected PropertyPicture(Parcel in) {
        propertyPicID = in.readInt();
        propertyPicProfID = in.readInt();
        propertyPicImage = in.readParcelable(Uri.class.getClassLoader());
        propertyPicTittle = in.readString();
        propertyPicDescrip = in.readString();
        propertyPicProp = in.readParcelable(Property.class.getClassLoader());
    }

    public static final Creator<PropertyPicture> CREATOR = new Creator<PropertyPicture>() {
        @Override
        public PropertyPicture createFromParcel(Parcel in) {
            return new PropertyPicture(in);
        }

        @Override
        public PropertyPicture[] newArray(int size) {
            return new PropertyPicture[size];
        }
    };

    public int getPropertyPicID() {
        return propertyPicID;
    }

    public void setPropertyPicID(int propertyPicID) {
        this.propertyPicID = propertyPicID;
    }

    public Uri getPropertyPicImage() {
        return propertyPicImage;
    }

    public void setPropertyPicImage(Uri propertyPicImage) {
        this.propertyPicImage = propertyPicImage;
    }

    public String getPropertyPicTittle() {
        return propertyPicTittle;
    }

    public void setPropertyPicTittle(String propertyPicTittle) {
        this.propertyPicTittle = propertyPicTittle;
    }

    public String getPropertyPicDescrip() {
        return propertyPicDescrip;
    }

    public void setPropertyPicDescrip(String propertyPicDescrip) {
        this.propertyPicDescrip = propertyPicDescrip;
    }

    public Property getPropertyPicProp() {
        return propertyPicProp;
    }

    public void setPropertyPicProp(Property propertyPicProp) {
        this.propertyPicProp = propertyPicProp;
    }

    public int getPropertyPicProfID() {
        return propertyPicProfID;
    }

    public void setPropertyPicProfID(int propertyPicProfID) {
        this.propertyPicProfID = propertyPicProfID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(propertyPicID);
        parcel.writeInt(propertyPicProfID);
        parcel.writeParcelable(propertyPicImage, i);
        parcel.writeString(propertyPicTittle);
        parcel.writeString(propertyPicDescrip);
        parcel.writeParcelable(propertyPicProp, i);
    }

    public int getPropertyPicPropID() {
        return propertyPicPropID;
    }

    public void setPropertyPicPropID(int propertyPicPropID) {
        this.propertyPicPropID = propertyPicPropID;
    }
}
