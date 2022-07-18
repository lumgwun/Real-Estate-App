package com.ls.awajimatradeeder.Classes;

import android.net.Uri;

public class EstateDoc {
    private  int EstateDocID;
    private  int EstateDocProfID;
    private  int EstateDocEstateID;
    private Uri EstateDocImage;
    private String EstateDocTittle;
    private String EstateDocDescrip;
    private Estate EstateDocEstate;

    public int getEstateDocID() {
        return EstateDocID;
    }

    public void setEstateDocID(int estateDocID) {
        EstateDocID = estateDocID;
    }

    public int getEstateDocProfID() {
        return EstateDocProfID;
    }

    public void setEstateDocProfID(int estateDocProfID) {
        EstateDocProfID = estateDocProfID;
    }

    public int getEstateDocEstateID() {
        return EstateDocEstateID;
    }

    public void setEstateDocEstateID(int estateDocEstateID) {
        EstateDocEstateID = estateDocEstateID;
    }

    public Uri getEstateDocImage() {
        return EstateDocImage;
    }

    public void setEstateDocImage(Uri estateDocImage) {
        EstateDocImage = estateDocImage;
    }

    public String getEstateDocTittle() {
        return EstateDocTittle;
    }

    public void setEstateDocTittle(String estateDocTittle) {
        EstateDocTittle = estateDocTittle;
    }

    public String getEstateDocDescrip() {
        return EstateDocDescrip;
    }

    public void setEstateDocDescrip(String estateDocDescrip) {
        EstateDocDescrip = estateDocDescrip;
    }

    public Estate getEstateDocEstate() {
        return EstateDocEstate;
    }

    public void setEstateDocEstate(Estate estateDocEstate) {
        EstateDocEstate = estateDocEstate;
    }
}
