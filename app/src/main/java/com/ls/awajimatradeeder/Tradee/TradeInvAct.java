package com.ls.awajimatradeeder.Tradee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ls.awajimatradeeder.EstateProperty.AgentOfficeAct;
import com.ls.awajimatradeeder.R;
import com.ls.awajimatradeeder.Trader.TradingAct;

public class TradeInvAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_trade_inv);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav_tradeInv);

        bottomNavigationView.setSelectedItemId(R.id.my_Null);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.tradeeHome:
                        startActivity(new Intent(TradeInvAct.this, TradingAct.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.my_Null:
                        return true;
                    case R.id.my_weeklyTrade:
                        startActivity(new Intent(TradeInvAct.this,MyWeeklyTrades.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.tradeTranx:
                        startActivity(new Intent(TradeInvAct.this,MyTradeTranxAct.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.my_withdrawals:
                        startActivity(new Intent(TradeInvAct.this,MyWithdrawals.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}