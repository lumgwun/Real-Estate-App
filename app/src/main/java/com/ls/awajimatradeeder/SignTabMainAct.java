package com.ls.awajimatradeeder;

import androidx.appcompat.app.AppCompatActivity;

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

import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Database.DBHelper;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_PASSWORD;

public class SignTabMainAct extends TabActivity {
    private AppBarLayout appBarLayout;
    com.melnykov.fab.FloatingActionButton floatingActionButton;
    Profile userProfile;
    long profileUID2;
    long id;
    String userName;
    String password;
    Bundle getBundle;
    String name;
    com.github.clans.fab.FloatingActionButton fab;
    SharedPreferences userPreferences;
    DBHelper dbHelper;
    Gson gson;
    String json,machine;
    long profileUID;
    Bundle bundle;
    private static final String PREF_NAME = "Tradeeder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_sign_tab_main);
        TabHost tabhost = findViewById(android.R.id.tabhost);
        setTitle("Sign up / Login");
        TabWidget tabs = findViewById(android.R.id.tabs);
        tabhost.setup(getLocalActivityManager());
        Resources resources = getResources();
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        gson = new Gson();
        userProfile=new Profile();
        json = userPreferences.getString("LastProfileUsed", "");
        userProfile = gson.fromJson(json, Profile.class);
        bundle = new Bundle();
        if(userProfile !=null){
            machine=userProfile.getProfileRole();
            profileUID=userProfile.getProfileID();

        }
        floatingActionButton = findViewById(R.id.fab_signinOut5);
        Intent intentSignUp = new Intent().setClass(this, SignUpAct.class);
        @SuppressLint("UseCompatLoadingForDrawables") TabHost.TabSpec tabSpecSignUp = tabhost
                .newTabSpec("Sign up")
                .setIndicator("", resources.getDrawable(R.drawable.icon1_fg))
                .setContent(intentSignUp);

        Intent intentSignIn = new Intent().setClass(this, LoginAct.class);
        @SuppressLint("UseCompatLoadingForDrawables") TabHost.TabSpec tabSpecLogin = tabhost
                .newTabSpec("Sign in")
                .setIndicator("", resources.getDrawable(R.drawable.icon1_fg))
                .setContent(intentSignIn);

        tabhost.addTab(tabSpecSignUp);
        tabhost.addTab(tabSpecLogin);

        tabhost.setCurrentTab(0);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoverAccount();
            }
        });
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(SignTabMainAct.this, tabId, Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void recoverAccount() {
        Intent intent = new Intent(this, PasswordRecovAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
}