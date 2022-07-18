package com.ls.awajimatradeeder.Database;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.Nullable;

import com.ls.awajimatradeeder.Classes.Account;
import com.ls.awajimatradeeder.Classes.Birthday;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Classes.SOrder;
import com.ls.awajimatradeeder.Classes.SupportMessage;
import com.ls.awajimatradeeder.Classes.TimeLine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static com.ls.awajimatradeeder.Classes.Account.ACCOUNTS_TABLE;
import static com.ls.awajimatradeeder.Classes.Account.ACCOUNT_BALANCE;
import static com.ls.awajimatradeeder.Classes.Account.ACCOUNT_BANK;
import static com.ls.awajimatradeeder.Classes.Account.ACCOUNT_NAME;
import static com.ls.awajimatradeeder.Classes.Account.ACCOUNT_NO;
import static com.ls.awajimatradeeder.Classes.Account.ACCOUNT_PROF_ID;
import static com.ls.awajimatradeeder.Classes.Account.ACCOUNT_TYPE;
import static com.ls.awajimatradeeder.Classes.Account.ACCOUNT_TYPES_TABLE;
import static com.ls.awajimatradeeder.Classes.Account.BANK_ACCT_NO;
import static com.ls.awajimatradeeder.Classes.Account.CREATE_ACCOUNTS_TABLE;
import static com.ls.awajimatradeeder.Classes.Account.CREATE_ACCOUNT_TYPE_TABLE;
import static com.ls.awajimatradeeder.Classes.Birthday.BIRTHDAY_DAYS_BTWN;
import static com.ls.awajimatradeeder.Classes.Birthday.BIRTHDAY_DAYS_REMAINING;
import static com.ls.awajimatradeeder.Classes.Birthday.BIRTHDAY_ID;
import static com.ls.awajimatradeeder.Classes.Birthday.BIRTHDAY_STATUS;
import static com.ls.awajimatradeeder.Classes.Birthday.BIRTHDAY_TABLE;
import static com.ls.awajimatradeeder.Classes.Birthday.B_DOB;
import static com.ls.awajimatradeeder.Classes.Birthday.B_EMAIL;
import static com.ls.awajimatradeeder.Classes.Birthday.B_FIRSTNAME;
import static com.ls.awajimatradeeder.Classes.Birthday.B_PHONE;
import static com.ls.awajimatradeeder.Classes.Birthday.B_PROF_ID;
import static com.ls.awajimatradeeder.Classes.Birthday.B_SURNAME;
import static com.ls.awajimatradeeder.Classes.Birthday.CREATE_BIRTHDAY_TABLE;
import static com.ls.awajimatradeeder.Classes.MTradeAccount.CREATE_MTRADE_ACCT_TABLE;
import static com.ls.awajimatradeeder.Classes.MTradeAccount.MTRADE_ACCT_ACCT_ID;
import static com.ls.awajimatradeeder.Classes.MTradeAccount.MTRADE_ACCT_BALANCE;
import static com.ls.awajimatradeeder.Classes.MTradeAccount.MTRADE_ACCT_ID;
import static com.ls.awajimatradeeder.Classes.MTradeAccount.MTRADE_ACCT_PROFID;
import static com.ls.awajimatradeeder.Classes.MTradeAccount.MTRADE_ACCT_TABLE;
import static com.ls.awajimatradeeder.Classes.NextOfKin.CREATE_NOK_TABLE;
import static com.ls.awajimatradeeder.Classes.NextOfKin.NOK_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.CREATE_PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ADDRESS;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_COUNTRY;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_DATE_JOINED;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_DEVICE_ID;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_DOB;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_EMAIL;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_FIRSTNAME;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_GENDER;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_IDENTITY;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID_TYPE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_NEXT_OF_KINID;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_OFFICE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_PASSWORD;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_PHONE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_PICTURE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ROLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_STATE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_STATUS;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_SURNAME;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_USERNAME;
import static com.ls.awajimatradeeder.Classes.Profile.PROF_SPONSOR_ID;
import static com.ls.awajimatradeeder.Classes.SOrder.CREATE_SO_TABLE;
import static com.ls.awajimatradeeder.Classes.SOrder.SO_ACCT_NO;
import static com.ls.awajimatradeeder.Classes.SOrder.SO_AMOUNT_DIFF;
import static com.ls.awajimatradeeder.Classes.SOrder.SO_DAILY_AMOUNT;
import static com.ls.awajimatradeeder.Classes.SOrder.SO_END_DATE;
import static com.ls.awajimatradeeder.Classes.SOrder.SO_EXPECTED_AMOUNT;
import static com.ls.awajimatradeeder.Classes.SOrder.SO_ID;
import static com.ls.awajimatradeeder.Classes.SOrder.SO_PROF_ID;
import static com.ls.awajimatradeeder.Classes.SOrder.SO_RECEIVED_AMOUNT;
import static com.ls.awajimatradeeder.Classes.SOrder.SO_START_DATE;
import static com.ls.awajimatradeeder.Classes.SOrder.SO_STATUS;
import static com.ls.awajimatradeeder.Classes.SOrder.STANDING_ORDER_TABLE;
import static com.ls.awajimatradeeder.Classes.SOrderAcct.CREATE_SO_ACCT_TABLE;
import static com.ls.awajimatradeeder.Classes.SOrderAcct.SO_ACCOUNT_BALANCE;
import static com.ls.awajimatradeeder.Classes.SOrderAcct.SO_ACCOUNT_NAME;
import static com.ls.awajimatradeeder.Classes.SOrderAcct.SO_ACCOUNT_NO;
import static com.ls.awajimatradeeder.Classes.SOrderAcct.SO_ACCT_PROF_ID;
import static com.ls.awajimatradeeder.Classes.SOrderAcct.SO_ACCT_TABLE;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_ADMIN_ID;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_ADMIN_NAME;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_BRANCH_OFFICE;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_DETAILS;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_ID;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_OTP;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_PHONENO;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_PROF_ID;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_PURPOSE;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_RECIPIENT;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_RECIPIENT_ID;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_SENDER;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_SENDING_APP_OWNER;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_TABLE;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_TIME;
import static com.ls.awajimatradeeder.Classes.SupportMessage.MESSAGE_VIEWED;
import static com.ls.awajimatradeeder.Classes.TimeLine.CREATE_TIMELINE_TABLE;
import static com.ls.awajimatradeeder.Classes.TimeLine.TIMELINE_DETAILS;
import static com.ls.awajimatradeeder.Classes.TimeLine.TIMELINE_ID;
import static com.ls.awajimatradeeder.Classes.TimeLine.TIMELINE_PROF_ID;
import static com.ls.awajimatradeeder.Classes.TimeLine.TIMELINE_TABLE;
import static com.ls.awajimatradeeder.Classes.TimeLine.TIMELINE_TIME;
import static com.ls.awajimatradeeder.Classes.TimeLine.TIMELINE_TITTLE;
import static com.ls.awajimatradeeder.Classes.TradeAcctFunding.CREATE_FUNDING_TABLE;
import static com.ls.awajimatradeeder.Classes.TradeAcctFunding.FUNDING_TABLE;
import static com.ls.awajimatradeeder.Classes.TradeInvestor.CREATE_TRADEE_TABLE;
import static com.ls.awajimatradeeder.Classes.TradeInvestor.TRADEE_TABLE;
import static com.ls.awajimatradeeder.Classes.Trader.CREATE_TRADER_TABLE;
import static com.ls.awajimatradeeder.Classes.Trader.TRADER_TABLE;
import static com.ls.awajimatradeeder.Classes.Transaction.CREATE_TRANSACTIONS_TABLE;
import static com.ls.awajimatradeeder.Classes.Transaction.TRANSACTIONS_TABLE;
import static com.ls.awajimatradeeder.Classes.WeeklyTrade.CREATE_TRADE_TABLE;
import static com.ls.awajimatradeeder.Classes.WeeklyTrade.TRADE_TABLE;
import static java.lang.String.valueOf;

public class DBHelper extends SQLiteOpenHelper {
    private ContentResolver myCR;
    private SQLiteDatabase sqLiteDatabase;
    private SQLiteOpenHelper sqLiteOpenHelper;
    private HashMap hp;
    SharedPreferences userPref;
    private Context context;
    public static String DB_PATH = "/data/Tradeeder/databases/";

    public static final String DATABASE_NAME = "Tradeeder.db";
    private static final String LOG = DBHelper.class.getName();
    public static final int DATABASE_VERSION = 1;
    public static final int DATABASE_NEW_VERSION = 2;

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public static <T> T getPassword(int profileID) {
        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_PROFILES_TABLE);
            sqLiteDatabase.execSQL(CREATE_NOK_TABLE);
            sqLiteDatabase.execSQL(CREATE_ACCOUNT_TYPE_TABLE);
            sqLiteDatabase.execSQL(CREATE_TRADEE_TABLE);
            sqLiteDatabase.execSQL(CREATE_ACCOUNTS_TABLE);
            sqLiteDatabase.execSQL(CREATE_TRANSACTIONS_TABLE);
            sqLiteDatabase.execSQL(CREATE_TRADE_TABLE);
            sqLiteDatabase.execSQL(CREATE_MTRADE_ACCT_TABLE);
            sqLiteDatabase.execSQL(CREATE_TRADER_TABLE);
            sqLiteDatabase.execSQL(CREATE_BIRTHDAY_TABLE);
            sqLiteDatabase.execSQL(CREATE_SO_TABLE);
            sqLiteDatabase.execSQL(CREATE_SO_ACCT_TABLE);
            sqLiteDatabase.execSQL(CREATE_TIMELINE_TABLE);
            sqLiteDatabase.execSQL(CREATE_FUNDING_TABLE);
            sqLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteException e) {
            e.printStackTrace();
            android.util.Log.e("DBHelper Table error", e.getMessage());
        }
        finally{

            sqLiteDatabase.endTransaction();
        }




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NOK_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ACCOUNT_TYPES_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TRADEE_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ACCOUNTS_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TRANSACTIONS_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PROFILES_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TRADE_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MTRADE_ACCT_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TRADER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BIRTHDAY_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + STANDING_ORDER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SO_ACCT_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TIMELINE_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FUNDING_TABLE);

        onCreate(sqLiteDatabase);

    }
    private static DBHelper instance;

    public static synchronized DBHelper getHelper(Context context) {
        if (instance == null)
            instance = new DBHelper(context);
        return instance;
    }
    private boolean checkDataBase() {
        SQLiteDatabase tempDB = null;
        try {
            String myPath = DB_PATH + DATABASE_NAME;
            tempDB = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {
            Log.e("Skylight App - check", e.getMessage());
        }
        if (tempDB != null)
            //tempDB.close();
            return tempDB != null ? true : false;
        return false;
    }

    public void copyDataBase() throws IOException {
        try {
            InputStream myInput = context.getAssets().open(DATABASE_NAME);
            String outputFileName = DB_PATH + DATABASE_NAME;
            OutputStream myOutput = new FileOutputStream(outputFileName);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }

            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (Exception e) {
            Log.e("tle99 - copyDatabase", e.getMessage());
        }

    }
    private synchronized SQLiteDatabase openWrite(SQLiteOpenHelper handler) {
        if (handler != null) {
            return handler.getWritableDatabase();
        }
        return null;
    }

    private synchronized SQLiteDatabase openRead(SQLiteOpenHelper handler) {
        if (handler != null) {
            return handler.getReadableDatabase();
        }
        return null;
    }

    private synchronized void close(SQLiteDatabase db) {
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DATABASE_NAME;
        sqLiteDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        sqLiteDatabase.execSQL("PRAGMA foreign_keys=ON");
    }
    public SQLiteDatabase openDataBase(SQLiteDatabase db) {
        if(db.isOpen()){
            sqLiteDatabase.execSQL("PRAGMA foreign_keys=ON");
            return sqLiteDatabase;
        }
        //sqLiteDatabase = db.getWritableDatabase();
        sqLiteDatabase.execSQL("PRAGMA foreign_keys=ON");
        return sqLiteDatabase;
    }


    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();

        if (dbExist) {
            openDataBase();
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                Log.e("App - create", e.getMessage());
            }
        }

    }

    public String getProfileRoleByUserNameAndPassword(String username,String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String name=null;
        String selection = PROFILE_USERNAME + "=? AND " + PROFILE_PASSWORD + "=?";
        String[] selectionArgs = new String[]{valueOf(username), valueOf(password)};
        Cursor cursor = db.query(PROFILES_TABLE, null, selection, selectionArgs, null, null, null);
        if (cursor.getCount() < 1)
        {
            cursor.close();
            return "NOT EXIST";
        }

        if(cursor!=null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    name=cursor.getColumnName(17);
                } while (cursor.moveToNext());
                cursor.close();
            }

        }

        db.close();
        return name;
    }


    private Profile getProfile(String phoneNumber) {
        SQLiteDatabase db = getReadableDatabase();
        Profile profile = new Profile();

        @SuppressLint("Recycle") Cursor cursor = db.query(PROFILES_TABLE,
                null,
                PROFILE_PHONE + "=?",
                new String[]{String.valueOf(phoneNumber)},
                null,
                null,
                null);
        if (cursor.moveToLast()) {
            try {
                profile.setProfileUserName(cursor.getString(1));
            } catch (Exception e) {
                e.printStackTrace();
            }
            profile.setProfileLastName(cursor.getString(1));
            profile.setProfileFirstName(cursor.getString(2));
            profile.setProfilePhoneNumber(cursor.getString(3));
            profile.setProfileEmail(cursor.getString(4));
            profile.setProfileGender(cursor.getString(6));
            profile.setProfileOffice(cursor.getString(14));
            profile.setProfileDob(cursor.getString(4));
            profile.setProfileAddress(cursor.getString(7));
            return profile;

        }else {
            Log.e("error! not found", "We could not find that User ");
            return profile;

        }
    }
    public ArrayList<String> getProfileName(String machine) {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = PROFILE_ROLE + "=?";
        String[] selectionArgs = new String[]{machine};
        String[] colums = {PROFILE_FIRSTNAME, PROFILE_SURNAME};

        try (Cursor res = db.query(PROFILES_TABLE, colums, selection, selectionArgs, null,
                null, null)) {
            res.moveToFirst();

            while (!res.isAfterLast()) {
                array_list.add(res.getString(16));
                res.moveToNext();
            }
        }
        return array_list;
    }
    public List<String> getAllProfiles(){
        List<String> listUsers = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {PROFILE_SURNAME, PROFILE_FIRSTNAME};
        Cursor c=null;

        try {
            c = db.rawQuery("SELECT * FROM " + PROFILES_TABLE , columns);
            if(c == null) return null;

            String name;
            c.moveToFirst();
            do {
                name = c.getString(1);
                listUsers.add(name);
            } while (c.moveToNext());
            c.close();
        } catch (Exception e) {
            Log.e("tle99", e.getMessage());
        }

        db.close();

        return listUsers;
    }
    public String getUserPassword(int profileID,String phoneNo) {
        SQLiteDatabase db = this.getReadableDatabase();
        String password=null;
        String selection = PROFILE_ID + "=? AND " + PROFILE_PHONE + "=?";
        String[] selectionArgs = new String[]{valueOf(profileID), valueOf(phoneNo)};
        Cursor cursor = db.query(PROFILES_TABLE, null, selection, selectionArgs, null, null, null);

        if (cursor.getCount() < 1)
        {
            cursor.close();
            return "NOT EXIST";
        }

        if(cursor!=null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    password=cursor.getColumnName(19);
                } while (cursor.moveToNext());
                cursor.close();
            }

        }

        db.close();
        return password;
    }
    public String getUserName(int profileID, String phoneNo) {
        SQLiteDatabase db = this.getReadableDatabase();
        String userName=null;
        String selection = PROFILE_ID + "=? AND " + PROFILE_PHONE + "=?";
        String[] selectionArgs = new String[]{valueOf(profileID), valueOf(phoneNo)};
        Cursor cursor = db.query(PROFILES_TABLE, null, selection, selectionArgs, null, null, null);
        if (cursor.getCount() < 1)
        {
            cursor.close();
            return "NOT EXIST";
        }

        if(cursor!=null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    userName=cursor.getColumnName(18);
                } while (cursor.moveToNext());
                cursor.close();
            }

        }

        db.close();
        return userName;
    }
    public Cursor getSimpleProfileFromCursor(ArrayList<Profile> profileArrayList, Cursor cursor) {
        while (cursor.moveToNext()) {
            int profileID = cursor.getInt(0);
            String surname = cursor.getString(1);
            String firstName = cursor.getString(2);
            String phone = cursor.getString(3);
            String email = cursor.getString(4);
            profileArrayList.add(new Profile(profileID,surname,firstName,phone,email));
        }
        return cursor;
    }
    public ArrayList<Profile> getAllProfilesF() {
        ArrayList<Profile> profiles = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(PROFILES_TABLE, null, null, null, null,
                null, null);
        if(cursor!=null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    getSimpleProfileFromCursor(profiles, cursor);
                } while (cursor.moveToNext());
                cursor.close();
            }

        }

        return profiles;
    }

    /*public ArrayList<Profile> getTradeInvestorsForProfile(int profileID) {
        ArrayList<Profile> profileArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = PROFILE_ROLE + "=?";
        String[] selectionArgs = new String[]{String.valueOf(profileID)};
        Cursor cursor = db.query(PROFILES_TABLE, null,  selection, selectionArgs, null,
                null, null);

        if(cursor!=null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    getSimpleProfileFromCursor(profileArrayList, cursor);
                } while (cursor.moveToNext());
                cursor.close();
            }

        }


        return profileArrayList;

    }*/

    public boolean updateSurName(String surName, int profileID) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_SURNAME, surName);
        String selection = PROFILE_ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(profileID)};
        return sqLiteDatabase.update(PROFILES_TABLE, contentValues, selection, selectionArgs)
                > 0;
    }
    public boolean updateProfileIdentity(String identityType,Uri identityDoc, int profileID) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_ID_TYPE, identityType);
        contentValues.put(PROFILE_IDENTITY, String.valueOf(identityDoc));
        String selection = PROFILE_ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(profileID)};
        return sqLiteDatabase.update(PROFILES_TABLE, contentValues, selection, selectionArgs)
                > 0;
    }
    public boolean updateProfileCountry(String country, int profileID) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_COUNTRY, country);
        String selection = PROFILE_ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(profileID)};
        return sqLiteDatabase.update(PROFILES_TABLE, contentValues, selection, selectionArgs)
                > 0;
    }
    public boolean updateFirstName(String firstName, int profileID) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_FIRSTNAME, firstName);
        String selection = PROFILE_ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(profileID)};
        return sqLiteDatabase.update(PROFILES_TABLE, contentValues, selection, selectionArgs)
                > 0;
    }
    public boolean updateProfileUserName(String name, int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_USERNAME, name);
        String selection = PROFILE_ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        return sqLiteDatabase.update(PROFILES_TABLE, contentValues, selection, selectionArgs)
                > 0;

    }
    public boolean updateProfilePassword(String password, int profileID) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_USERNAME, password);
        String selection = PROFILE_ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(profileID)};
        return sqLiteDatabase.update(PROFILES_TABLE, contentValues, selection, selectionArgs)
                > 0;

    }

    public boolean updatePhoneNumber(String phoneNumber, int profileID) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_PHONE, phoneNumber);
        String selection = PROFILE_ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(profileID)};
        return sqLiteDatabase.update(PROFILES_TABLE, contentValues, selection, selectionArgs)
                > 0;
    }

    public boolean updateProfileEmail(String emailAddress, int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_EMAIL, emailAddress);
        String selection = PROFILE_ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        return sqLiteDatabase.update(PROFILES_TABLE, contentValues, selection, selectionArgs)
                > 0;

    }

    public boolean updateProfileAddress(String address, int id) {
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(PROFILE_ADDRESS, address);
            String selection = PROFILE_ID + "=?";
            String[] selectionArgs = new String[]{String.valueOf(id)};
            return sqLiteDatabase.update(PROFILES_TABLE, contentValues, selection, selectionArgs)
                    > 0;

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }




    public boolean updateProfileStatus(String status, int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_STATUS, status);
        String selection = PROFILE_ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        return sqLiteDatabase.update(PROFILES_TABLE, contentValues, selection, selectionArgs)
                > 0;
    }

    public long insertProfilePicture(int profileID, Uri profilePicture) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_ID, profileID);
        contentValues.put(PROFILE_PICTURE, valueOf(profilePicture));
        return sqLiteDatabase.insert(PROFILES_TABLE, null, contentValues);
    }

    public void updateProfilePicture(int profileID, Uri profilePicture) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues packageValues = new ContentValues();
        String selection = PROFILE_ID + "=? AND " + PROFILE_PICTURE +"=?";
        String[] selectionArgs = new String[]{valueOf(profileID), valueOf(profilePicture)};
        packageValues.put(PROFILE_PICTURE, String.valueOf(profilePicture));
        db.update(PROFILES_TABLE, packageValues, selection, selectionArgs);
        db.close();


    }
    public void updateProfileRole(int profileID, String role) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PROFILE_ROLE, role);
        String selection = PROFILE_ID + "=?";
        String[] selectionArgs = new String[]{valueOf(profileID)};
        db.update(PROFILES_TABLE, values, selection,
                selectionArgs);

    }

    public long insertBirthDay3(Birthday birthday1) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String birthdayD = birthday1.getbDate();
        String surName =birthday1.getbSurName();
        String firstName =birthday1.getbFirstName();
        String phone =birthday1.getbPhoneNumber();
        String email =birthday1.getbEmail();
        String Status =birthday1.getbStatus();
        int birthdayId =birthday1.getBirthdayID();
        Calendar calendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = mdformat.format(calendar.getTime());

        ContentValues contentValues = new ContentValues();
        contentValues.put(BIRTHDAY_ID, birthdayId);
        contentValues.put(B_DOB, birthdayD);
        contentValues.put(BIRTHDAY_STATUS, Status);
        contentValues.put(B_SURNAME, surName);
        contentValues.put(B_FIRSTNAME, firstName);
        contentValues.put(B_PHONE, phone);
        contentValues.put(B_EMAIL, email);
        contentValues.put(BIRTHDAY_DAYS_BTWN, birthday1.getDaysInBetween(currentDate,birthdayD));
        contentValues.put(BIRTHDAY_DAYS_REMAINING, birthday1.getFormattedDaysRemainingString(currentDate,birthdayD));
        sqLiteDatabase.insert(BIRTHDAY_TABLE,null,contentValues);
        sqLiteDatabase.close();

        return birthdayId;
    }
    public ArrayList<Birthday> getBirthdayFromTodayDate(String myDate) {
        ArrayList<Birthday> birthdayArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = B_DOB + "=?";
        String[] selectionArgs = new String[]{myDate};
        Cursor cursor = db.query(BIRTHDAY_TABLE, null, selection, selectionArgs, null, null, null);

        getBirthdaysFromCursorAdmin(birthdayArrayList, cursor);

        cursor.close();
        db.close();

        return birthdayArrayList;
    }

    public ArrayList<Birthday> getAllBirthDays() {
        ArrayList<Birthday> birthdays = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(BIRTHDAY_TABLE, null, null, null, null,
                null, null);
        getBirthdaysFromCursorAdmin(birthdays, cursor);

        cursor.close();
        db.close();

        return birthdays;
    }
    public boolean checkBirthdayExist(String birthday) {
        int count=0;

        SQLiteDatabase db = this.getReadableDatabase();
        String selection = B_DOB + "=?";
        String[] selectionArgs = new String[]{String.valueOf((birthday))};

        Cursor cursor = db.query(BIRTHDAY_TABLE, null, selection, selectionArgs, null, null, null);

        if(cursor!=null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    count = cursor.getCount();
                } while (cursor.moveToNext());
                cursor.close();
            }

        }

        return count > 0;
    }

    private void getBirthdaysFromCursorAdmin(ArrayList<Birthday> birthdays, Cursor cursor) {
        while (cursor.moveToNext()) {

            int profileID = cursor.getInt(0);
            int birthdayID = cursor.getInt(1);
            String name = cursor.getString(3) + ","+ cursor.getString(2);
            String phoneNumber = cursor.getString(5);
            String email = cursor.getString(4);
            String date = cursor.getString(6);
            int daysBTWN = cursor.getInt(8);
            String daysRemaining = cursor.getString(7);
            String status = cursor.getString(9);

            birthdays.add(new Birthday(profileID, birthdayID, name, phoneNumber, email,date,daysBTWN,daysRemaining, status));
        }

    }

    public long saveNewMessage(SupportMessage message) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String messageDetails = message.getMessageDetails();
        int messageProfID = message.getMessageID();
        int messageRecipientID = message.getMessageRecipientID();
        String messageRecipient = message.getMessageRecipient();
        String messageTimeStamp = message.getMessageTime();
        String messagePurpose = message.getMessageType();
        String messageOffice = message.getMessageOffice();
        String messagePhoneNo = message.getMessagePhoneNo();
        int messageNo = message.getMessageNo();
        int messageOTP = message.getMessageOTP();
        int messageAdminID = message.getMessageAdminID();
        String sender = message.getMessageSendingAppOwner();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MESSAGE_PROF_ID, messageProfID);
        contentValues.put(MESSAGE_RECIPIENT_ID, messageRecipientID);
        contentValues.put(MESSAGE_RECIPIENT, messageRecipient);
        contentValues.put(MESSAGE_PURPOSE, messagePurpose);
        contentValues.put(MESSAGE_BRANCH_OFFICE, messageOffice);
        contentValues.put(MESSAGE_SENDER, sender);
        contentValues.put(MESSAGE_DETAILS, messageDetails);
        contentValues.put(MESSAGE_ADMIN_ID, messageAdminID);
        contentValues.put(MESSAGE_VIEWED, messageNo);
        contentValues.put(MESSAGE_PHONENO, messagePhoneNo);
        contentValues.put(MESSAGE_OTP, messageOTP);
        contentValues.put(MESSAGE_TIME, messageTimeStamp);
        return sqLiteDatabase.insert(MESSAGE_TABLE, null, contentValues);
    }

    public ArrayList<SupportMessage> getAllMessages() {
        ArrayList<SupportMessage> messages = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(MESSAGE_TABLE, null, null, null, null,
                null, null);
        getMessagesFromCursor(messages, cursor);
        cursor.close();
        db.close();

        return messages;

    }
    public ArrayList<SupportMessage> getMessagesToday(String todayDate) {
        ArrayList<SupportMessage> messages = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {MESSAGE_SENDER, MESSAGE_PURPOSE,MESSAGE_DETAILS,MESSAGE_TIME};
        String selection = MESSAGE_TIME + "=?";
        String[] selectionArgs = new String[]{valueOf(todayDate)};
        Cursor cursor = db.query(MESSAGE_TABLE, columns, selection, selectionArgs, null, null, null);
        getMessagesFromCursor(messages, cursor);
        cursor.close();

        return messages;
    }

    protected void getMessagesFromCursor(ArrayList<SupportMessage> messageArrayList, Cursor cursor) {
        while (cursor.moveToNext()) {

            int profileID = (cursor.getInt(0));
            int messageID = (cursor.getInt(1));
            int messageRecipientID = cursor.getInt(2);
            int messageAdminID = cursor.getInt(3);
            String adminName = cursor.getString(4);
            String purpose = cursor.getString(5);
            String details = cursor.getString(6);
            String sender = cursor.getString(7);
            String recipient = cursor.getString(8);
            String time = cursor.getString(9);
            int views = cursor.getInt(10);
            String office = cursor.getString(11);
            String sendingAppOwner = cursor.getString(12);
            messageArrayList.add(new SupportMessage(messageID,profileID,messageRecipientID,messageAdminID,adminName,purpose,details,sendingAppOwner,sender,recipient,time,views,office));
        }

    }
    public long insertStandingOrder(SOrder standingOrder, int profileID) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int uID=standingOrder.getSoID();
        long so_Acct_No=standingOrder.getSo_Acct_No();
        String so_start_date =standingOrder.getSo_start_date();
        String soStatus =standingOrder.getSoStatus();
        double expectedAmount =standingOrder.getSo_ExpectedAmount();
        double receivedAmount =standingOrder.getSo_ReceivedAmount();
        double amountDiff =standingOrder.getSo_AmountDiff();
        double soDailyAmount =standingOrder.getSoDailyAmount();
        String so_end_date =standingOrder.getSo_end_date();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SO_ID, uID);
        contentValues.put(SO_PROF_ID, profileID);
        contentValues.put(SO_DAILY_AMOUNT, soDailyAmount);
        contentValues.put(SO_EXPECTED_AMOUNT, expectedAmount);
        contentValues.put(SO_RECEIVED_AMOUNT, receivedAmount);
        contentValues.put(SO_AMOUNT_DIFF, amountDiff);
        contentValues.put(SO_ACCT_NO, so_Acct_No);
        contentValues.put(SO_STATUS, soStatus);
        contentValues.put(SO_START_DATE, so_start_date);
        contentValues.put(SO_END_DATE, so_end_date);
        return sqLiteDatabase.insert(STANDING_ORDER_TABLE, null, contentValues);

    }
    public long saveNewProfile(Profile profile, Birthday birthday) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PROFILE_ID, profile.getProfileID());
        cv.put(PROFILE_SURNAME, profile.getProfileLastName());
        cv.put(PROFILE_FIRSTNAME, profile.getProfileFirstName());
        cv.put(PROFILE_PHONE, profile.getProfilePhoneNumber());
        cv.put(PROFILE_EMAIL, profile.getProfileEmail());
        cv.put(PROFILE_DOB, profile.getProfileDob());
        cv.put(PROFILE_GENDER, profile.getProfileGender());
        cv.put(PROFILE_ADDRESS, profile.getProfileAddress());
        cv.put(PROFILE_ID_TYPE, profile.getProfileIdentityType());
        cv.put(PROFILE_IDENTITY, profile.getProfileIDentity());
        cv.put(PROFILE_STATE, profile.getProfileState());
        cv.put(PROFILE_OFFICE, profile.getProfileOffice());
        cv.put(PROFILE_DATE_JOINED, profile.getProfileDateJoined());
        cv.put(PROFILE_ROLE, profile.getProfileRole());
        cv.put(PROFILE_USERNAME, profile.getProfileUserName());
        cv.put(PROFILE_PASSWORD, profile.getProfilePassword());
        cv.put(PROFILE_PICTURE, String.valueOf(profile.getProfilePicture()));
        cv.put(PROF_SPONSOR_ID, profile.getProfileSponsorID());
        cv.put(PROFILE_COUNTRY, profile.getProfileCountry());
        cv.put(PROFILE_DEVICE_ID, profile.getProfileDeviceID());
        cv.put(PROFILE_STATUS, profile.getProfileStatus());
        cv.put(PROFILE_NEXT_OF_KINID, profile.getProfNOKId());

        ContentValues birthdayValue = new ContentValues();
        birthdayValue.put(B_PROF_ID, birthday.getbProfileID());
        birthdayValue.put(B_DOB, birthday.getbDate());
        db.insertOrThrow(BIRTHDAY_TABLE, null, birthdayValue);
        return db.insertOrThrow(PROFILES_TABLE, null, cv);
    }
    public long saveTestProfile(Profile profile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PROFILE_ID, profile.getProfileID());
        cv.put(PROFILE_SURNAME, profile.getProfileLastName());
        cv.put(PROFILE_FIRSTNAME, profile.getProfileFirstName());
        cv.put(PROFILE_PHONE, profile.getProfilePhoneNumber());
        cv.put(PROFILE_EMAIL, profile.getProfileEmail());
        cv.put(PROFILE_DOB, profile.getProfileDob());
        cv.put(PROFILE_GENDER, profile.getProfileGender());
        cv.put(PROFILE_ADDRESS, profile.getProfileAddress());
        cv.put(PROFILE_ID_TYPE, profile.getProfileIdentityType());
        cv.put(PROFILE_IDENTITY, profile.getProfileIDentity());
        cv.put(PROFILE_STATE, profile.getProfileState());
        cv.put(PROFILE_OFFICE, profile.getProfileOffice());
        cv.put(PROFILE_DATE_JOINED, profile.getProfileDateJoined());
        cv.put(PROFILE_ROLE, profile.getProfileRole());
        cv.put(PROFILE_USERNAME, profile.getProfileUserName());
        cv.put(PROFILE_PASSWORD, profile.getProfilePassword());
        cv.put(PROFILE_PICTURE, String.valueOf(profile.getProfilePicture()));
        cv.put(PROF_SPONSOR_ID, profile.getProfileSponsorID());
        cv.put(PROFILE_COUNTRY, profile.getProfileCountry());
        cv.put(PROFILE_DEVICE_ID, profile.getProfileDeviceID());
        cv.put(PROFILE_STATUS, profile.getProfileStatus());
        cv.put(PROFILE_NEXT_OF_KINID, profile.getProfNOKId());
        db.insertOrThrow(PROFILES_TABLE, null, cv);
        db.close();

        return 0;
    }
    public Profile getProfileFromUserNameAndPassword(String userName,String password) {
        //long rv = -1;
        Profile profile = null;
        Cursor csr = null;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String selection = PROFILE_USERNAME + "=? AND " + PROFILE_PASSWORD + "=?";
        String[] selectionArgs = new String[]{userName, password};
        String[] columns = {PROFILE_ID, PROFILE_FIRSTNAME, PROFILE_OFFICE,PROFILE_PHONE,PROFILE_ROLE,PROFILE_SURNAME};
        csr = sqLiteDatabase.query(PROFILES_TABLE,columns,selection,selectionArgs,null,null,null);
        if (csr.moveToFirst()) {
            profile = new Profile();

            profile.setProfileID(csr.getInt(0));
            profile.setProfileEmail(csr.getString(2));
            profile.setProfileOffice(csr.getString(6));
            profile.setProfileFirstName(csr.getString(7));
            profile.setProfileLastName(csr.getString(8));
            profile.setProfileRole(csr.getString(15));
            profile.setProfileDateJoined(csr.getString(16));

        }
        return profile;


    }
    public long insertAccount(int profileID2,  String accountName, int accountNumber, double accountBalance) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ACCOUNT_PROF_ID, profileID2);
        contentValues.put(ACCOUNT_NAME, accountName);
        contentValues.put(ACCOUNT_NO, accountNumber);
        contentValues.put(ACCOUNT_BALANCE, accountBalance);
        return  sqLiteDatabase.insert(ACCOUNTS_TABLE, null, contentValues);

    }
    public long insertSOAcct(int profileID2,  String accountName, int accountNumber, double accountBalance) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SO_ACCT_PROF_ID, profileID2);
        contentValues.put(SO_ACCOUNT_NO, accountName);
        contentValues.put(SO_ACCOUNT_NAME, accountNumber);
        contentValues.put(SO_ACCOUNT_BALANCE, accountBalance);
        return  sqLiteDatabase.insert(SO_ACCT_TABLE, null, contentValues);

    }
    public long insertInvAcct(int profileID2,  String accountName, int invAcctNumber,int accountNumber, double accountBalance) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MTRADE_ACCT_PROFID, profileID2);
        contentValues.put(ACCOUNT_NAME, accountName);
        contentValues.put(MTRADE_ACCT_ID, invAcctNumber);
        contentValues.put(MTRADE_ACCT_BALANCE, accountBalance);
        contentValues.put(MTRADE_ACCT_ACCT_ID, accountNumber);
        return  sqLiteDatabase.insert(MTRADE_ACCT_TABLE, null, contentValues);

    }
    public long insertNewMessage(int messageID, int profileID, int recipientID,int adminID,String sendingAppOwner,String office, String adminName, String purposeOfMessage, String message, String sender, String sendee, String time) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MESSAGE_PROF_ID, profileID);
        contentValues.put(MESSAGE_ID, messageID);
        contentValues.put(MESSAGE_ADMIN_ID, adminID);
        contentValues.put(MESSAGE_RECIPIENT_ID, recipientID);
        contentValues.put(MESSAGE_ADMIN_NAME, adminName);
        contentValues.put(MESSAGE_PURPOSE, purposeOfMessage);
        contentValues.put(MESSAGE_DETAILS, message);
        contentValues.put(MESSAGE_SENDER, sender);
        contentValues.put(MESSAGE_RECIPIENT, sendee);
        contentValues.put(MESSAGE_SENDING_APP_OWNER, sendingAppOwner);
        contentValues.put(MESSAGE_BRANCH_OFFICE, office);
        contentValues.put(MESSAGE_TIME, time);
        return sqLiteDatabase.insert(MESSAGE_TABLE, null, contentValues);

    }

    public void updateMessage(int messageID,String newMessage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues documentUpdateValues = new ContentValues();
        documentUpdateValues.put(MESSAGE_DETAILS, newMessage);
        String selection = MESSAGE_ID + "=?";
        String[] selectionArgs = new String[]{valueOf(messageID)};
        db.update(MESSAGE_TABLE, documentUpdateValues, selection, selectionArgs);
        //db.close();


    }
    private void getTimeLinesFromCursorAdmin(ArrayList<TimeLine> codeArrayList, Cursor cursor) {
        while (cursor.moveToNext()) {
            int ownerProfileId = cursor.getInt(0);
            int timelineID = cursor.getInt(1);
            String tittle = cursor.getString(2);
            String details = cursor.getString(3);
            String time = cursor.getString(5);
            String status = cursor.getString(6);
            codeArrayList.add(new TimeLine(timelineID, ownerProfileId,tittle, details,time, status));
        }


    }
    public long insertTimeLine(int profileID, String tittle,String details,String time) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TIMELINE_TITTLE, tittle);
        contentValues.put(TIMELINE_DETAILS, details);
        contentValues.put(TIMELINE_TIME, time);
        contentValues.put(TIMELINE_PROF_ID, profileID);
        return sqLiteDatabase.insert(TIMELINE_TABLE, null, contentValues);
    }
    public ArrayList<TimeLine> getTimeLinesForProfile(int profileID) {
        ArrayList<TimeLine> timeLines = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TIMELINE_PROF_ID + "=?";
        String[] selectionArgs = new String[]{valueOf(profileID)};

        Cursor cursor = db.query(TIMELINE_TABLE, null,  selection, selectionArgs, null, null, null);
        if(cursor!=null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    getTimeLinesFromCursorAdmin(timeLines, cursor);
                } while (cursor.moveToNext());
                cursor.close();
            }

        }
        db.close();

        return timeLines;
    }


    public int getProfileID(String userName, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {PROFILE_ID};
        int profileID=0;
        String selection = PROFILE_USERNAME + "=? AND " + PROFILE_PASSWORD + "=?";
        String[] selectionArgs = new String[]{userName, password};

        @SuppressLint("Recycle") Cursor profileIDCursor = db.query(PROFILES_TABLE,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (profileIDCursor.moveToNext()) {
            profileID = profileIDCursor.getInt(0);
        }
        if (profileIDCursor != null)
            if (profileIDCursor.getCount() > 0) {
                profileIDCursor.close();
            }


        return profileID;
    }

    public Bitmap getProfilePicture(int eatSuperAdminprofileID) {
        Uri picturePath = getPicturePath(eatSuperAdminprofileID);
        if (picturePath == null ){
            return null;

        }else {
            return (BitmapFactory.decodeFile(String.valueOf(picturePath)));


        }
    }
    public Uri getPicturePath(int eatSuperAdminprofileID) {

        SQLiteDatabase db = getReadableDatabase();
        String selection = PROFILE_ID + "=?";
        String[] selectionArgs = new String[]{valueOf(eatSuperAdminprofileID)};

        try (Cursor reportCursor = db.query(PROFILES_TABLE, null, selection, selectionArgs, null, null,
                null)) {
            reportCursor.moveToNext();
            int column_index = reportCursor.getColumnIndexOrThrow(PROFILE_PICTURE);

            return Uri.parse(reportCursor.getString(column_index));

        }

    }
    /*public Bitmap getDocPicture(int savingsId) {

        try {
            Uri picturePath = getDocPicturePath(savingsId);
            if (picturePath == null )
                return (null);

            return (BitmapFactory.decodeFile(String.valueOf(picturePath)));

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public Uri getDocPicturePath(int savingsId) {

        try {
            SQLiteDatabase db = getReadableDatabase();
            Uri picturePath;
            try (Cursor reportCursor = db.query(DOCUMENT_TABLE,
                    null,
                    DOCUMENT_REPORT_NO + "=?",
                    new String[]{String.valueOf(savingsId)},
                    null,
                    null,
                    null)) {
                reportCursor.moveToNext();
                int column_index = reportCursor.getColumnIndexOrThrow(DOCUMENT_URI);
                return Uri.parse(reportCursor.getString(column_index));

            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }


        //return (picturePath);
        return null;
    }*/
}
