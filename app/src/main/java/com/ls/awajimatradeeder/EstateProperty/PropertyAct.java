package com.ls.awajimatradeeder.EstateProperty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.gson.Gson;
import com.ls.awajimatradeeder.Adapters.PropRecylerAdapter;
import com.ls.awajimatradeeder.Adapters.PropSliderAdapter;
import com.ls.awajimatradeeder.Classes.EstateSuperAdmin;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Classes.Property;
import com.ls.awajimatradeeder.Classes.Trader;
import com.ls.awajimatradeeder.Database.DBHelper;
import com.ls.awajimatradeeder.R;
import com.ls.awajimatradeeder.UserDashBoard;

import java.util.ArrayList;

public class PropertyAct extends AppCompatActivity implements  PropRecylerAdapter.OnItemsClickListener {
    private RecyclerView propPicsRecyclerView,otherLocalePropRView,statePropRView;

    private DividerItemDecoration mDividerItemDecoration;

    private NestedScrollView mNestedScrollView;

    private BottomSheetBehavior mBottomSheetBehavior;

    private AppCompatButton mDelete;
    private ArrayList<Property> propertyArrayListAll;
    private PropRecylerAdapter.OnItemsClickListener listener;
    private PropRecylerAdapter propRecylerAdapter;
    private Bundle proOtherPropBundle;
    private String propLocality,propState;
    private static final String PREF_NAME = "Tradeeder";
    DBHelper dbHelper;
    Profile userProfile;
    Trader trader;
    Gson gson,gson1;
    String json,json1;
    SQLiteDatabase sqLiteDatabase;
    private SharedPreferences userPreferences;
    private EstateSuperAdmin estateSuperAdmin;
    private int profileID,estateSuperAdminID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_property);
        propPicsRecyclerView = (RecyclerView) findViewById(R.id.prop_recyclerview);
        otherLocalePropRView = (RecyclerView) findViewById(R.id.prop_recyclerview);
        statePropRView = (RecyclerView) findViewById(R.id.prop_recyclerview);
        proOtherPropBundle= new Bundle();
        userProfile= new Profile();
        estateSuperAdmin= new EstateSuperAdmin();
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        userProfile = gson.fromJson(json, Profile.class);
        json = userPreferences.getString("LastProfileUsed", "");
        json1 = userPreferences.getString("LastEstateSuperAdminUsed", "");
        estateSuperAdmin = gson1.fromJson(json1, EstateSuperAdmin.class);
        if(userProfile !=null){
            profileID=userProfile.getProfileID();
        }
        if(estateSuperAdmin !=null){
            estateSuperAdminID =estateSuperAdmin.getEstateSuperAdminEstID();
        }
        mNestedScrollView = (NestedScrollView) findViewById(R.id.activity_recyclerview_nsv);
        mDelete = findViewById(R.id.act_prop_delete);
        propertyArrayListAll= new ArrayList<>();
        proOtherPropBundle=getIntent().getExtras();

        mBottomSheetBehavior = BottomSheetBehavior.from(mNestedScrollView);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navP);

        bottomNavigationView.setSelectedItemId(R.id.propertyHome);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.genHome:
                        Intent dashboardIntent = new Intent(PropertyAct.this, UserDashBoard.class);
                        overridePendingTransition(0,0);
                        dashboardIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(dashboardIntent);
                        return true;

                    case R.id.propertyHome:
                        Intent propIntent = new Intent(PropertyAct.this, PropHomeAct.class);
                        overridePendingTransition(0,0);
                        propIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(propIntent);
                        return true;
                    case R.id.estateOffice:
                        Intent estateIntent = new Intent(PropertyAct.this, EstateOfficeAct.class);
                        overridePendingTransition(0,0);
                        estateIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(estateIntent);
                        return true;

                    case R.id.agentOffice:
                        Intent agentIntent = new Intent(PropertyAct.this, AgentOfficeAct.class);
                        overridePendingTransition(0,0);
                        agentIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(agentIntent);
                        return true;
                }
                return false;
            }
        });


        fillRawDataToList();

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        propPicsRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(propPicsRecyclerView.getContext(),
                layoutManager.getOrientation());
        propPicsRecyclerView.addItemDecoration(dividerItemDecoration);
        propPicsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        propRecylerAdapter = new PropRecylerAdapter(this,propertyArrayListAll,listener,mBottomSheetBehavior);
        propPicsRecyclerView.setAdapter(propRecylerAdapter);

        propPicsRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override

            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);

                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

            }

            @Override

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                super.onScrolled(recyclerView, dx, dy);

            }

        });

    }

    private void fillRawDataToList() {

        /*for (int i = 0; i <10 ; i++) {

            propertyArrayListAll.add(i);

        }*/


    }

    @Override
    public void onItemClick(Property property) {

    }
}