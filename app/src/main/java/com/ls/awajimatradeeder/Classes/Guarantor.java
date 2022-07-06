package com.ls.awajimatradeeder.Classes;

public class Guarantor {
    public static final String GUARANTOR_TABLE = "guarantor_Table";
    public static final String GUARANTOR_TABLE_ID = "guarantor_TableID";
    public static final String GUARANTOR_PROF_ID = "guarantor_Prof_ID";
    public static final String GUARANTOR_PHONE = "guarantor_Phone";
    public static final String GUARANTOR_EMAIL = "guarantor_Email";
    public static final String GUARANTOR_ADDRESS = "guarantor_address";
    public static final String GUARANTOR_ID_TYPE = "guarantor_id_type";
    public static final String GUARANTOR_IDENTITY = "guarantor_Id";

    private Guarantor guarantor;
    private int invGuarantorCount;

    public Guarantor() {
        super();

    }

    public Guarantor(Guarantor guarantor1) {
        this.guarantor = guarantor1;

    }
    public Guarantor(int count,Guarantor guarantor1) {
        super();
        this.invGuarantorCount = count;
        this.guarantor = guarantor1;

    }
}
