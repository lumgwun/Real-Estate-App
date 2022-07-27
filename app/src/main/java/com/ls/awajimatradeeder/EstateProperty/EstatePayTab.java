package com.ls.awajimatradeeder.EstateProperty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.ls.awajimatradeeder.Classes.PrefManager;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.R;
import com.ls.awajimatradeeder.UserDashBoard;

public class EstatePayTab extends TabActivity {
    private SharedPreferences userPreferences;
    PrefManager prefManager;
    private Gson gson;
    private String json;

    private Profile userProfile;
    private String profileID;
    Intent data;
    private AppBarLayout appBarLayout;
    FloatingActionButton floatingActionButton,floatingActionButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_esate_pay_tab);
        setTitle("Stocks Tab");
        floatingActionButton = findViewById(R.id.fab_admin_Home_in);
        floatingActionButton2 = findViewById(R.id.fab_admin_home);
        Resources resources = getResources();
        TabWidget tabs = findViewById(android.R.id.tabs);
        TabHost tabhost = (TabHost) findViewById(android.R.id.tabhost);
        tabhost.setup();
        Toolbar toolbar = (Toolbar) findViewById(R.id.web_toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_admin_inv);
        Intent stocksTransferIntent = new Intent().setClass(this, EstatePaymentAct.class);
        @SuppressLint("UseCompatLoadingForDrawables") TabHost.TabSpec itemCollection = tabhost
                .newTabSpec("One time")
                .setIndicator("", resources.getDrawable(R.drawable.icon1_fg))
                .setContent(stocksTransferIntent);


        Intent intentB = new Intent().setClass(this, EstateSOPaymentAct.class);
        @SuppressLint("UseCompatLoadingForDrawables") TabHost.TabSpec stocksOverview = tabhost
                .newTabSpec("Stocks Overview")
                .setIndicator("", resources.getDrawable(R.drawable.icon5_fg))
                .setContent(intentB);

        Intent intentList = new Intent().setClass(this, EstateFinanceAct.class);
        @SuppressLint("UseCompatLoadingForDrawables") TabHost.TabSpec newStocks = tabhost
                .newTabSpec("New Stocks")
                .setIndicator("", resources.getDrawable(R.drawable.icon2_fg))
                .setContent(intentList);

        tabhost.addTab(itemCollection);
        tabhost.addTab(stocksOverview);
        tabhost.addTab(newStocks);
        tabhost.setCurrentTab(0);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminHomeHistory();
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminSkyPackage();
            }
        });


    }


    public void adminHomeHistory() {

        Intent intent = new Intent(this, UserDashBoard.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("PROFILE_ID", profileID);
        Toast.makeText(this, "Taking you to the Dashboard", Toast.LENGTH_LONG).show();
        startActivity(intent);
        finish();
    }

    public void adminSkyPackage() {

        Intent intent = new Intent(this, EstateOfficeAct.class);
        Toast.makeText(this, "Taking you to the History area", Toast.LENGTH_LONG).show();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("PROFILE_ID", profileID);
        startActivity(intent);



    }
}