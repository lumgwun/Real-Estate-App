package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class SellerProduct implements Serializable, Parcelable {
    private int SellerProductID;
    private int SellerProductNo;
    private int SellerProductProfID;
    private int SellerProductAcctID;
    private String SellerProductName;
    private String SellerProductDisc;
    private String SellerProductType;
    private String sellerProductLoc;
    private double sellerProductPrice;
    private int sellerProductQty;
    private String sellerProductUnitOfMeasurement;
    private String sellerProductCurrency;
    private String sellerProductStatus;
    private boolean isDeliveryAvailable;
    private double sellerProductShippingFee;

    private int SellerImageCount;
    private SellerProduct sellerProduct;
    private PictureImage sellerProductPicImage;
    private ArrayList<PictureImage> pictureImages;



    public SellerProduct() {

        super();
    }

    public SellerProduct(int sellerProductNo, SellerProduct sellerProduct1) {
        this.SellerProductNo = sellerProductNo;
        this.sellerProduct = sellerProduct1;

    }

    protected SellerProduct(Parcel in) {
        SellerProductID = in.readInt();
        SellerProductNo = in.readInt();
        SellerProductProfID = in.readInt();
        SellerProductAcctID = in.readInt();
        SellerProductName = in.readString();
        SellerProductDisc = in.readString();
        SellerProductType = in.readString();
        sellerProductLoc = in.readString();
        sellerProductPrice = in.readDouble();
        sellerProductQty = in.readInt();
        sellerProductUnitOfMeasurement = in.readString();
        sellerProductStatus = in.readString();
        SellerImageCount = in.readInt();
        sellerProduct = in.readParcelable(SellerProduct.class.getClassLoader());
    }

    public static final Creator<SellerProduct> CREATOR = new Creator<SellerProduct>() {
        @Override
        public SellerProduct createFromParcel(Parcel in) {
            return new SellerProduct(in);
        }

        @Override
        public SellerProduct[] newArray(int size) {
            return new SellerProduct[size];
        }
    };
    public void addPictureImage(PictureImage sellerProductPicImage) {
        pictureImages= new ArrayList<>();
        SellerImageCount = pictureImages.size() + 1;
        sellerProductPicImage = new PictureImage(SellerImageCount,sellerProductPicImage);
        pictureImages.add(sellerProductPicImage);
    }

    public int getSellerProductID() {
        return SellerProductID;
    }

    public void setSellerProductID(int sellerProductID) {
        SellerProductID = sellerProductID;
    }

    public int getSellerProductNo() {
        return SellerProductNo;
    }

    public void setSellerProductNo(int sellerProductNo) {
        SellerProductNo = sellerProductNo;
    }

    public int getSellerProductProfID() {
        return SellerProductProfID;
    }

    public void setSellerProductProfID(int sellerProductProfID) {
        SellerProductProfID = sellerProductProfID;
    }

    public int getSellerProductAcctID() {
        return SellerProductAcctID;
    }

    public void setSellerProductAcctID(int sellerProductAcctID) {
        SellerProductAcctID = sellerProductAcctID;
    }

    public String getSellerProductName() {
        return SellerProductName;
    }

    public void setSellerProductName(String sellerProductName) {
        SellerProductName = sellerProductName;
    }

    public String getSellerProductDisc() {
        return SellerProductDisc;
    }

    public void setSellerProductDisc(String sellerProductDisc) {
        SellerProductDisc = sellerProductDisc;
    }

    public String getSellerProductType() {
        return SellerProductType;
    }

    public void setSellerProductType(String sellerProductType) {
        SellerProductType = sellerProductType;
    }

    public String getSellerProductLoc() {
        return sellerProductLoc;
    }

    public void setSellerProductLoc(String sellerProductLoc) {
        this.sellerProductLoc = sellerProductLoc;
    }

    public double getSellerProductPrice() {
        return sellerProductPrice;
    }

    public void setSellerProductPrice(double sellerProductPrice) {
        this.sellerProductPrice = sellerProductPrice;
    }

    public ArrayList<PictureImage> getPictureImages() {
        return pictureImages;
    }

    public void setPictureImages(ArrayList<PictureImage> pictureImages) {
        this.pictureImages = pictureImages;
    }

    public int getSellerProductQty() {
        return sellerProductQty;
    }

    public void setSellerProductQty(int sellerProductQty) {
        this.sellerProductQty = sellerProductQty;
    }

    public String getSellerProductUnitOfMeasurement() {
        return sellerProductUnitOfMeasurement;
    }

    public void setSellerProductUnitOfMeasurement(String sellerProductUnitOfMeasurement) {
        this.sellerProductUnitOfMeasurement = sellerProductUnitOfMeasurement;
    }

    public String getSellerProductStatus() {
        return sellerProductStatus;
    }

    public void setSellerProductStatus(String sellerProductStatus) {
        this.sellerProductStatus = sellerProductStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(SellerProductID);
        parcel.writeInt(SellerProductNo);
        parcel.writeInt(SellerProductProfID);
        parcel.writeInt(SellerProductAcctID);
        parcel.writeString(SellerProductName);
        parcel.writeString(SellerProductDisc);
        parcel.writeString(SellerProductType);
        parcel.writeString(sellerProductLoc);
        parcel.writeDouble(sellerProductPrice);
        parcel.writeInt(sellerProductQty);
        parcel.writeString(sellerProductUnitOfMeasurement);
        parcel.writeString(sellerProductStatus);
        parcel.writeInt(SellerImageCount);
        parcel.writeParcelable(sellerProduct, i);
    }

    public String getSellerProductCurrency() {
        return sellerProductCurrency;
    }

    public void setSellerProductCurrency(String sellerProductCurrency) {
        this.sellerProductCurrency = sellerProductCurrency;
    }

    public PictureImage getSellerProductPicImage() {
        return sellerProductPicImage;
    }

    public void setSellerProductPicImage(PictureImage sellerProductPicImage) {
        this.sellerProductPicImage = sellerProductPicImage;
    }

    public boolean isDeliveryAvailable() {
        return isDeliveryAvailable;
    }

    public void setDeliveryAvailable(boolean deliveryAvailable) {
        isDeliveryAvailable = deliveryAvailable;
    }

    public double getSellerProductShippingFee() {
        return sellerProductShippingFee;
    }

    public void setSellerProductShippingFee(double sellerProductShippingFee) {
        this.sellerProductShippingFee = sellerProductShippingFee;
    }
}
