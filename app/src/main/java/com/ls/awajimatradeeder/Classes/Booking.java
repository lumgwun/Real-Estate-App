package com.ls.awajimatradeeder.Classes;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;

public class Booking {
    @SuppressLint("ConstantLocale")
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd", Locale.getDefault());

    public static final String BOOKING_TABLE = "booking_table";

    public static final String BOOKING_STATUS = "booking_status";
    public static final String BOOKING_ID = "booking_id";
    public static final String BOOKING_TITTLE = "booking_tittle";
    public static final String BOOKING_CLIENT_NAME = "booking_name";
    public static final String BOOKING_DATE = "booking_date";
    public static final String BOOKING_LOCATION = "booking_location";
    public static final String BOOKING_PROF_ID = "booking_Prof_ID";
    public static final String BOOKING_OCCURENCE_NO = "booking_occuring_No";
    public static final Boolean ITISRECCURRING = false;


    public static final String CREATE_BOOKING_TABLE = "CREATE TABLE IF NOT EXISTS " + BOOKING_TABLE + " (" + BOOKING_PROF_ID + " INTEGER NOT NULL, " + BOOKING_ID + " INTEGER    , " +
            BOOKING_TITTLE + " TEXT, " + BOOKING_CLIENT_NAME + " TEXT, " + BOOKING_DATE + " TEXT, " + BOOKING_LOCATION + " TEXT, " +
            BOOKING_OCCURENCE_NO + " INTEGER, " + BOOKING_STATUS + " TEXT, " + ITISRECCURRING + " TEXT, " +
            "PRIMARY KEY(" + BOOKING_ID  + "), " + "FOREIGN KEY(" + BOOKING_PROF_ID + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + "))";


}
