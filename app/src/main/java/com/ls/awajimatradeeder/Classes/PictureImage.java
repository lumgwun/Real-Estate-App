package com.ls.awajimatradeeder.Classes;

import android.net.Uri;

public class PictureImage {
    private int picImageID;
    private int picImageNo;
    private int picImageProfID;
    private int picImageSellerProductID;
    private String picImagePurpose;
    private String picImageTittle;
    private String picImageStatus;
    private int picImageSellerID;
    private Uri picImagePix;
    private PictureImage pictureImage;

    public PictureImage(int sellerImageCount, PictureImage sellerProductPicImage) {
        this.picImageNo = sellerImageCount;
        this.pictureImage = sellerProductPicImage;
    }

    public int getPicImageID() {
        return picImageID;
    }

    public void setPicImageID(int picImageID) {
        this.picImageID = picImageID;
    }

    public int getPicImageNo() {
        return picImageNo;
    }

    public void setPicImageNo(int picImageNo) {
        this.picImageNo = picImageNo;
    }

    public int getPicImageProfID() {
        return picImageProfID;
    }

    public void setPicImageProfID(int picImageProfID) {
        this.picImageProfID = picImageProfID;
    }

    public String getPicImagePurpose() {
        return picImagePurpose;
    }

    public void setPicImagePurpose(String picImagePurpose) {
        this.picImagePurpose = picImagePurpose;
    }

    public int getPicImageSellerID() {
        return picImageSellerID;
    }

    public void setPicImageSellerID(int picImageSellerID) {
        this.picImageSellerID = picImageSellerID;
    }

    public Uri getPicImagePix() {
        return picImagePix;
    }

    public void setPicImagePix(Uri picImagePix) {
        this.picImagePix = picImagePix;
    }

    public String getPicImageStatus() {
        return picImageStatus;
    }

    public void setPicImageStatus(String picImageStatus) {
        this.picImageStatus = picImageStatus;
    }

    public int getPicImageSellerProductID() {
        return picImageSellerProductID;
    }

    public void setPicImageSellerProductID(int picImageSellerProductID) {
        this.picImageSellerProductID = picImageSellerProductID;
    }

    public String getPicImageTittle() {
        return picImageTittle;
    }

    public void setPicImageTittle(String picImageTittle) {
        this.picImageTittle = picImageTittle;
    }
}
