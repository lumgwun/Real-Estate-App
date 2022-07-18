package com.ls.awajimatradeeder.Trader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Classes.Trader;
import com.ls.awajimatradeeder.Database.DBHelper;
import com.ls.awajimatradeeder.EstateProperty.AgentOfficeAct;
import com.ls.awajimatradeeder.R;
import com.ls.awajimatradeeder.ReferralAct;

import java.security.SecureRandom;
import java.util.Random;

public class TraderDashboardAct extends AppCompatActivity {
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
        setContentView(R.layout.act_trader_dashboard);
        userProfile=new Profile();
        trader= new Trader();
        gson = new Gson();
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        json = userPreferences.getString("LastProfileUsed", "");
        userProfile = gson.fromJson(json, Profile.class);
        json1 = userPreferences.getString("LastTraderProfileUsed", "");
        trader = gson1.fromJson(json1, Trader.class);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_trader_Nav);

        bottomNavigationView.setSelectedItemId(R.id.traderTNull);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.tradingHome:
                        startActivity(new Intent(TraderDashboardAct.this, TradingAct.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.traderTNull:
                        return true;
                    case R.id.traderTrades:
                        startActivity(new Intent(TraderDashboardAct.this,MyTrades.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.traderProfits:
                        startActivity(new Intent(TraderDashboardAct.this,MyTradeProfitsAct.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.traderInvRef:
                        startActivity(new Intent(TraderDashboardAct.this, ReferralAct.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}