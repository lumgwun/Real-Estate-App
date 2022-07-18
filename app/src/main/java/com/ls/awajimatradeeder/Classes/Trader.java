package com.ls.awajimatradeeder.Classes;

import java.util.ArrayList;

import static com.ls.awajimatradeeder.Classes.NextOfKin.NOK_PROF_ID;
import static com.ls.awajimatradeeder.Classes.NextOfKin.NOK_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;

public class Trader {
    public static final String TRADER_TABLE = "trader_table";
    private String traderLastName;

    private String traderFirstName;
    private String traderType;

    private String traderPhoneNumber;

    private String traderEmail;

    private String traderDob;

    private String traderGender;

    private String traderAddress;

    private String traderOffice;

    private String traderDateJoined;
    private String traderState;

    private String traderRole;
    private String traderCountry;

    private String traderUserName;

    private String traderPassword;
    private String traderStatus;
    private ArrayList<Guarantor> traderGuarantors;

    private int traderSponsorID;
    private NextOfKin traderNextOfKin;
    public static final String TRADER_SURNAME = "trader_surname";
    public static final String TRADER_FIRSTNAME = "trader_first_name";
    public static final String TRADER_EMAIL = "trader_email";
    public static final String TRADER_DOB = "trader_dob";
    public static final String TRADER_ADDRESS = "trader_address";
    public static final String TRADER_GENDER = "trader_gender";
    public static final String TRADER_PHONE = "trader_phone";
    public static final String TRADER_CLASS = "trader_Class";
    public static final String TRADER_DATE_JOINED = "trader_join_date";
    public static final String TRADER_NEXT_OF_KINID = "trader_next_of_kinId";
    public static final String TRADER_STATUS = "trader_status";
    public static final String TRADER_PASSWORD = "trader_passCode";
    public static final String TRADER_DEVICE_ID = "trader_DeviceID";
    public static final String TRADER_COUNTRY = "trader_country";
    public static final String TRADER_ID = "trader_id";

    public static final String TRADER_PICTURE = "trader_picture_uri";
    public static final String TRADER_USERNAME = "trader_username";
    public static final String TRADER_ID_TYPE = "trader_ID_Type";
    public static final String TRADER_IDENTITY = "trader_Identity";
    public static final String TRADER_STATE = "trader_state";
    public static final String TRADER_OFFICE = "trader_office";
    public static final String TRADER_SPONSOR_ID = "trader_SponsorID";
    public static final String TRADER_PROFILE_ID = "trader_ProfID";

    public static final String CREATE_TRADER_TABLE = "CREATE TABLE " + TRADER_TABLE + " (" + TRADER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TRADER_SURNAME + " TEXT, " + TRADER_FIRSTNAME + " TEXT, " + TRADER_PHONE + " TEXT, " + TRADER_EMAIL + " TEXT, " + TRADER_DOB + " TEXT, " + TRADER_GENDER + " TEXT, " +
            TRADER_ADDRESS + " TEXT, " + TRADER_ID_TYPE + " TEXT, " + TRADER_IDENTITY + " TEXT, "+ TRADER_DEVICE_ID + " TEXT, " + TRADER_NEXT_OF_KINID + " INTEGER, " + TRADER_PICTURE + " TEXT, " + TRADER_STATE + " TEXT, " + TRADER_COUNTRY + " TEXT, " + TRADER_OFFICE + " TEXT, " + TRADER_DATE_JOINED + " TEXT, " + TRADER_CLASS + " TEXT, " + TRADER_USERNAME + " TEXT, " + TRADER_PASSWORD + " TEXT, " + TRADER_STATUS + " TEXT, " +  TRADER_SPONSOR_ID + " INTEGER,"+ TRADER_PROFILE_ID + " INTEGER," + "FOREIGN KEY(" + TRADER_PROFILE_ID + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + "))";


    public String getTraderLastName() {
        return traderLastName;
    }

    public void setTraderLastName(String traderLastName) {
        this.traderLastName = traderLastName;
    }

    public String getTraderFirstName() {
        return traderFirstName;
    }

    public void setTraderFirstName(String traderFirstName) {
        this.traderFirstName = traderFirstName;
    }

    public String getTraderType() {
        return traderType;
    }

    public void setTraderType(String traderType) {
        this.traderType = traderType;
    }

    public String getTraderPhoneNumber() {
        return traderPhoneNumber;
    }

    public void setTraderPhoneNumber(String traderPhoneNumber) {
        this.traderPhoneNumber = traderPhoneNumber;
    }

    public String getTraderEmail() {
        return traderEmail;
    }

    public void setTraderEmail(String traderEmail) {
        this.traderEmail = traderEmail;
    }

    public String getTraderDob() {
        return traderDob;
    }

    public void setTraderDob(String traderDob) {
        this.traderDob = traderDob;
    }

    public String getTraderGender() {
        return traderGender;
    }

    public void setTraderGender(String traderGender) {
        this.traderGender = traderGender;
    }

    public String getTraderAddress() {
        return traderAddress;
    }

    public void setTraderAddress(String traderAddress) {
        this.traderAddress = traderAddress;
    }

    public String getTraderOffice() {
        return traderOffice;
    }

    public void setTraderOffice(String traderOffice) {
        this.traderOffice = traderOffice;
    }

    public String getTraderDateJoined() {
        return traderDateJoined;
    }

    public void setTraderDateJoined(String traderDateJoined) {
        this.traderDateJoined = traderDateJoined;
    }

    public String getTraderState() {
        return traderState;
    }

    public void setTraderState(String traderState) {
        this.traderState = traderState;
    }

    public String getTraderRole() {
        return traderRole;
    }

    public void setTraderRole(String traderRole) {
        this.traderRole = traderRole;
    }

    public String getTraderCountry() {
        return traderCountry;
    }

    public void setTraderCountry(String traderCountry) {
        this.traderCountry = traderCountry;
    }

    public String getTraderUserName() {
        return traderUserName;
    }

    public void setTraderUserName(String traderUserName) {
        this.traderUserName = traderUserName;
    }

    public String getTraderPassword() {
        return traderPassword;
    }

    public void setTraderPassword(String traderPassword) {
        this.traderPassword = traderPassword;
    }

    public String getTraderStatus() {
        return traderStatus;
    }

    public void setTraderStatus(String traderStatus) {
        this.traderStatus = traderStatus;
    }

    public ArrayList<Guarantor> getTraderGuarantors() {
        return traderGuarantors;
    }

    public void setTraderGuarantors(ArrayList<Guarantor> traderGuarantors) {
        this.traderGuarantors = traderGuarantors;
    }

    public int getTraderSponsorID() {
        return traderSponsorID;
    }

    public void setTraderSponsorID(int traderSponsorID) {
        this.traderSponsorID = traderSponsorID;
    }

    public NextOfKin getTraderNextOfKin() {
        return traderNextOfKin;
    }

    public void setTraderNextOfKin(NextOfKin traderNextOfKin) {
        this.traderNextOfKin = traderNextOfKin;
    }
}
