package com.ls.awajimatradeeder.Classes;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;

public class NextOfKin {
    public static final String NOK_PICTURE_URI = "nok_picture";
    public static final String NOK_USERNAME = "nok_username";
    public static final String NOK_SURNAME = "nok_SName";
    public static final String NOK_FIRSTNAME = "nok_Fname";
    public static final String NOK_EMAIL = "nok_Email";
    public static final String NOK_PHONE_NO = "nok_PhoneNo";
    public static final String NOK_ID_TYPE = "nok_ID_Type";
    public static final String NOK_IDENTITY = "nok_Identity";
    public static final String NOK_ADDRESS = "nok_Address";
    public static final String NOK_OFFICE = "nok_office";
    public static final String NOK_PROF_ID = "nok_prof_ID";
    public static final String NOK_UPROF_ID = "nok_Uprof_ID";
    public static final String NOK_ID = "nok_ID";
    public static final String NOK_TABLE = "nok_Table";

    public static final String CREATE_NOK_TABLE = "CREATE TABLE " + NOK_TABLE + " (" + NOK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOK_PROF_ID + " INTEGER, " + NOK_UPROF_ID + " INTEGER, " + NOK_SURNAME + " TEXT, " + NOK_FIRSTNAME + " TEXT, " + NOK_EMAIL + " TEXT, " + NOK_PHONE_NO + " TEXT, " +
            NOK_USERNAME + " TEXT, " + NOK_IDENTITY + " TEXT, " + NOK_ID_TYPE + " TEXT, "+ NOK_OFFICE + " TEXT, " + NOK_ADDRESS + " INTEGER, " + NOK_PICTURE_URI + " TEXT, " + "FOREIGN KEY(" + NOK_UPROF_ID + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + "))";


}
