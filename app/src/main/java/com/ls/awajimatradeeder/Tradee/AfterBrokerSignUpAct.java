package com.ls.awajimatradeeder.Tradee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Classes.Trader;
import com.ls.awajimatradeeder.Database.DBHelper;
import com.ls.awajimatradeeder.R;

import java.security.SecureRandom;
import java.util.Random;

public class AfterBrokerSignUpAct extends AppCompatActivity {
    private static final String PREF_NAME = "Tradeeder";
    SharedPreferences userPreferences;
    Random ran;
    private double accountBalance;
    SecureRandom random;
    DBHelper dbHelper;
    Profile userProfile;
    Trader trader;
    Gson gson,gson1;
    String json,json1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_after_b_sup);
        userProfile=new Profile();
        trader= new Trader();
        gson = new Gson();
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        json = userPreferences.getString("LastProfileUsed", "");
        userProfile = gson.fromJson(json, Profile.class);
        json1 = userPreferences.getString("LastTraderProfileUsed", "");
        trader = gson1.fromJson(json1, Trader.class);
    }
}