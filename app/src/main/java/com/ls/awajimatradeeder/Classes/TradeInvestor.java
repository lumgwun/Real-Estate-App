package com.ls.awajimatradeeder.Classes;

import static com.ls.awajimatradeeder.Classes.Account.ACCOUNTS_TABLE;
import static com.ls.awajimatradeeder.Classes.Account.ACCOUNT_NO;
import static com.ls.awajimatradeeder.Classes.NextOfKin.NOK_PROF_ID;
import static com.ls.awajimatradeeder.Classes.NextOfKin.NOK_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;

public class TradeInvestor {
    public static final String TRADEE_TABLE = "tradee_table";
    public static final String TRADEE_ID = "tradee_id";
    public static final String TRADEE_SURNAME = "tradee_surname";
    public static final String TRADEE_FIRSTNAME = "tradee_first_name";
    public static final String TRADEE_EMAIL = "tradee_email";
    public static final String TRADEE_GENDER = "tradee_gender";
    public static final String TRADEE_PHONE = "tradee_phone";
    public static final String TRADEE_DATE_JOINED = "tradee_join_date";
    public static final String TRADEE_STATUS = "tradee_status";
    public static final String TRADEE_COUNTRY = "tradee_country";
    public static final String TRADEE_USERNAME = "tradee_username";
    public static final String TRADEE_OFFICE = "tradee_office";
    public static final String TRADEE_REFERRER_ID = "tradee_ReferrerID";
    public static final String TRADEE_NOK_ID = "tradee_NokID";
    public static final String TRADEE_PROFILE_ID = "tradee_Prof_ID";
    public static final String TRADEE_ACCT_ID = "tradee_Acct_ID";

    public static final String CREATE_TRADEE_TABLE = "CREATE TABLE " + TRADEE_TABLE + " (" + TRADEE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TRADEE_SURNAME + " TEXT, " + TRADEE_FIRSTNAME + " TEXT, " + TRADEE_EMAIL + " TEXT, " + TRADEE_PHONE + " TEXT, " + TRADEE_GENDER + " TEXT, " + TRADEE_DATE_JOINED + " TEXT, " +
            TRADEE_USERNAME + " TEXT, " + TRADEE_OFFICE + " TEXT, " + TRADEE_REFERRER_ID + " INTEGER, "+ TRADEE_COUNTRY + " TEXT, " + TRADEE_STATUS + " TEXT, " + TRADEE_NOK_ID + " INTEGER, "+ TRADEE_PROFILE_ID + " INTEGER, "+"FOREIGN KEY(" + TRADEE_PROFILE_ID  + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + ")," +"FOREIGN KEY(" + TRADEE_ACCT_ID  + ") REFERENCES " + ACCOUNTS_TABLE + "(" + ACCOUNT_NO + ")," + "FOREIGN KEY(" + TRADEE_NOK_ID + ") REFERENCES " + NOK_TABLE + "(" + NOK_PROF_ID + "))";

}
