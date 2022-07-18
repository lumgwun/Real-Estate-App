package com.ls.awajimatradeeder.Trader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ls.awajimatradeeder.R;
import com.ls.awajimatradeeder.Tradee.TradeInvAct;

public class TradingAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_trading);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_trading);
        bottomNavigationView.setSelectedItemId(R.id.tradeD);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.tradeD:
                        startActivity(new Intent(TradingAct.this,TradingAct.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.tradeInv:
                        startActivity(new Intent(TradingAct.this,TradeInvAct.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.trader:
                        startActivity(new Intent(TradingAct.this, TraderDashboardAct.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}