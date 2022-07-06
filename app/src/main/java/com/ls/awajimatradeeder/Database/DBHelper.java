package com.ls.awajimatradeeder.Database;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ls.awajimatradeeder.Membership.MshipSubAct;

import java.util.ArrayList;
import java.util.HashMap;

import static com.ls.awajimatradeeder.Classes.Account.ACCOUNTS_TABLE;
import static com.ls.awajimatradeeder.Classes.Account.ACCOUNT_TYPES_TABLE;
import static com.ls.awajimatradeeder.Classes.Account.CREATE_ACCOUNTS_TABLE;
import static com.ls.awajimatradeeder.Classes.Account.CREATE_ACCOUNT_TYPE_TABLE;
import static com.ls.awajimatradeeder.Classes.MTradeAccount.CREATE_MTRADE_ACCT_TABLE;
import static com.ls.awajimatradeeder.Classes.MTradeAccount.MTRADE_ACCT_TABLE;
import static com.ls.awajimatradeeder.Classes.NextOfKin.CREATE_NOK_TABLE;
import static com.ls.awajimatradeeder.Classes.NextOfKin.NOK_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.CREATE_PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_PASSWORD;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_USERNAME;
import static com.ls.awajimatradeeder.Classes.TradeInvestor.CREATE_TRADEE_TABLE;
import static com.ls.awajimatradeeder.Classes.TradeInvestor.TRADEE_TABLE;
import static com.ls.awajimatradeeder.Classes.Transaction.CREATE_TRANSACTIONS_TABLE;
import static com.ls.awajimatradeeder.Classes.Transaction.TRANSACTIONS_TABLE;
import static com.ls.awajimatradeeder.Classes.WeeklyTrade.CREATE_TRADE_TABLE;
import static com.ls.awajimatradeeder.Classes.WeeklyTrade.TRADE_TABLE;
import static java.lang.String.valueOf;

public class DBHelper extends SQLiteOpenHelper {
    private ContentResolver myCR;
    private SQLiteDatabase myDB;
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
        sqLiteDatabase.execSQL(CREATE_PROFILES_TABLE);
        sqLiteDatabase.execSQL(CREATE_NOK_TABLE);
        sqLiteDatabase.execSQL(CREATE_ACCOUNT_TYPE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TRADEE_TABLE);
        sqLiteDatabase.execSQL(CREATE_ACCOUNTS_TABLE);
        sqLiteDatabase.execSQL(CREATE_TRANSACTIONS_TABLE);
        sqLiteDatabase.execSQL(CREATE_TRADE_TABLE);
        sqLiteDatabase.execSQL(CREATE_MTRADE_ACCT_TABLE);



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
        onCreate(sqLiteDatabase);

    }
    private static DBHelper instance;

    public static synchronized DBHelper getHelper(Context context) {
        if (instance == null)
            instance = new DBHelper(context);
        return instance;
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
}
