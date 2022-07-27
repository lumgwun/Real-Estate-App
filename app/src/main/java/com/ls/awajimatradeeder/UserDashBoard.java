package com.ls.awajimatradeeder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.ls.awajimatradeeder.Adapters.EstateLoanAdapter;
import com.ls.awajimatradeeder.Adapters.JobAdapter;
import com.ls.awajimatradeeder.Adapters.PictureImgAdapter;
import com.ls.awajimatradeeder.Adapters.SellerProductAdapter;
import com.ls.awajimatradeeder.Adapters.WeeklyTradeAdapter;
import com.ls.awajimatradeeder.Classes.EstateJob;
import com.ls.awajimatradeeder.Classes.EstateLoan;
import com.ls.awajimatradeeder.Classes.EstateProperty;
import com.ls.awajimatradeeder.Classes.PictureImage;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Classes.Property;
import com.ls.awajimatradeeder.Classes.SellerProduct;
import com.ls.awajimatradeeder.Classes.Trader;
import com.ls.awajimatradeeder.Classes.Utils;
import com.ls.awajimatradeeder.Classes.WeeklyTrade;
import com.ls.awajimatradeeder.Database.DBHelper;
import com.ls.awajimatradeeder.EstateProperty.MyEstatePropAct;
import com.ls.awajimatradeeder.EstateProperty.PropertyAct;
import com.ls.awajimatradeeder.Loan.LoanListAct;
import com.ls.awajimatradeeder.Logistics.LogisticsAct;
import com.ls.awajimatradeeder.Tradee.TradeInvAct;
import com.ls.awajimatradeeder.Trader.TradingAct;
import com.rom4ek.arcnavigationview.ArcNavigationView;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserDashBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{
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
    RecyclerView recyclerViewAllPro,recyclerViewLoans,recyclerViewBottomSheet,recyclerViewMyEstProp,recyclerViewJob,recyclerViewWholeSale,recyclerViewTrade;
    EstateLoanAdapter estateLoanAdapter;
    SellerProductAdapter sellerProductAdapter;
    JobAdapter jobAdapter;
    private PictureImgAdapter pictureImageAdapter;
    ArrayList<PictureImage> pictureImageArrayList ;
    WeeklyTradeAdapter weeklyTradeAdapter;
    ArrayList<EstateLoan> estateLoans ;
    ArrayList<Property> properties;
    ArrayList<SellerProduct> sellerProducts;
    ArrayList<WeeklyTrade> weeklyTrades;
    ArrayList<EstateProperty> estateProperties ;
    ArrayList<EstateJob> estateJobs;
    private AppCompatImageView userProfPic,imgProfGreetings;
    private AppCompatTextView txtUserName,txtTradeReturns,txtBankAcctNo,txtBankName,txtAcctBalance,txtBankBalance,txtPropServicePaid,txtTradeProfits,txtEWalletBalance,txtProfID,txtProfile_name;
    private Button btnTrading,btnLoans,btnGrpSavings;
    private CircleImageView profilePix;
    private PictureImgAdapter.OnClickListener pixImgOnClickListener;
    private SellerProductAdapter.OnClickListener sellerPOnClickListener;
    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    private BottomSheetBehavior behavior;
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_user);
        userProfile=new Profile();
        trader= new Trader();
        gson = new Gson();
        estateLoans= new ArrayList<>();
        properties= new ArrayList<>();
        sellerProducts= new ArrayList<>();
        weeklyTrades= new ArrayList<>();
        estateProperties= new ArrayList<>();
        estateJobs= new ArrayList<>();
        pictureImageArrayList= new ArrayList<>();
        utils= new Utils();
        ArcNavigationView navigationView = (ArcNavigationView) findViewById(R.id.user_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawer = findViewById(R.id.user_drawer);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.setHomeAsUpIndicator(R.drawable.home_fg);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("User BackOffice");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ps_backspace);
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        json = userPreferences.getString("LastProfileUsed", "");
        userProfile = gson.fromJson(json, Profile.class);
        json1 = userPreferences.getString("LastTraderProfileUsed", "");
        trader = gson1.fromJson(json1, Trader.class);
        recyclerViewAllPro = findViewById(R.id.allPropRecycler);
        recyclerViewJob = findViewById(R.id.recylerVJob);
        recyclerViewMyEstProp = findViewById(R.id.myEstRecycler);
        recyclerViewTrade = findViewById(R.id.weeklyTradeRecycler);
        recyclerViewWholeSale = findViewById(R.id.wholeSaleRecycler);
        recyclerViewLoans = findViewById(R.id.recylerVLoans);
        recyclerViewBottomSheet = findViewById(R.id.bottom_sheet_recycler_view);
        userProfPic = findViewById(R.id.user_pics);
        txtUserName = findViewById(R.id.profile_username);
        txtTradeReturns = findViewById(R.id.user_TradeReturns);
        txtAcctBalance = findViewById(R.id.user_AcctBalance);
        txtEWalletBalance = findViewById(R.id.prof_AcctBal);
        imgProfGreetings = findViewById(R.id.profGreetings);
        profilePix = findViewById(R.id.profile_image_user);
        txtProfile_name = findViewById(R.id.profile_nameU);
        txtProfID = findViewById(R.id.profile_idU);
        txtPropServicePaid = findViewById(R.id.prop_serviceText);
        txtBankBalance = findViewById(R.id.profile_BankBalance44);
        txtBankName = findViewById(R.id.prof_BankN);
        txtBankAcctNo = findViewById(R.id.profile_BankNo3);

        btnGrpSavings = findViewById(R.id.profileGrpSavings);
        btnGrpSavings.setOnClickListener(this::profileGrpSavings);
        btnGrpSavings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnLoans = findViewById(R.id.profileLoans);
        btnLoans.setOnClickListener(this::profileLoans);
        btnLoans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnTrading = findViewById(R.id.profileTradings);
        btnTrading.setOnClickListener(this::profileTrading);
        btnTrading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        recyclerViewWholeSale.setLayoutManager(new GridLayoutManager(this, 2));
        sellerProductAdapter = new SellerProductAdapter(this, sellerProducts,sellerPOnClickListener);
        sellerProductAdapter.setCallback(sellerPOnClickListener);
        recyclerViewWholeSale.setAdapter(sellerProductAdapter);

        recyclerViewBottomSheet.setLayoutManager(new GridLayoutManager(this, 2));
        pictureImageAdapter = new PictureImgAdapter(this, pictureImageArrayList,pixImgOnClickListener);
        pictureImageAdapter.setCallback(pixImgOnClickListener);
        recyclerViewBottomSheet.setAdapter(pictureImageAdapter);
        Calendar calendar = Calendar.getInstance();


        StringBuilder welcomeString = new StringBuilder();


        calendar = Calendar.getInstance();

        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 5 && timeOfDay < 12) {
            //welcomeString.append(getString(R.string.good_morning));
            imgProfGreetings.setImageResource(R.drawable.good_morning1);
        } else if (timeOfDay >= 12 && timeOfDay < 17) {
            welcomeString.append(getString(R.string.good_afternoon));
            imgProfGreetings.setImageResource(R.drawable.good_day);
        } else {
            welcomeString.append(getString(R.string.good_evening));
            imgProfGreetings.setImageResource(R.drawable.good_evening2);
        }



        int day = calendar.get(Calendar.DAY_OF_WEEK);

        String[] days = getResources().getStringArray(R.array.days);
        String dow = "";

        switch (day) {
            case Calendar.SUNDAY:
                dow = days[0];
                break;
            case Calendar.MONDAY:
                dow = days[1];
                break;
            case Calendar.TUESDAY:
                dow = days[2];
                break;
            case Calendar.WEDNESDAY:
                dow = days[3];
                break;
            case Calendar.THURSDAY:
                dow = days[4];
                break;
            case Calendar.FRIDAY:
                dow = days[5];
                break;
            case Calendar.SATURDAY:
                dow = days[6];
                break;
            default:
                break;
        }
        welcomeString.append(", ")
                .append(" Coop. App User")
                .append("How are you? ")
                .append(getString(R.string.happy))
                .append(dow);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setPeekHeight(0);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
            }
        });



        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.userHome:
                        startActivity(new Intent(UserDashBoard.this,UserDashBoard.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.app_properties:
                        startActivity(new Intent(UserDashBoard.this, PropertyAct.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.user_logistics:
                        startActivity(new Intent(UserDashBoard.this, LogisticsAct.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.app_makeMoney:
                        startActivity(new Intent(UserDashBoard.this, TradingAct.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.marketPlace:
                        startActivity(new Intent(UserDashBoard.this, WholeSaleMarketAct.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.OurLoans:
                        startActivity(new Intent(UserDashBoard.this,LoanAct.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
    public void showDrawerButton() {

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.syncState();
    }

    public void showUpButton() {
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void setupDrawerListener() {
        drawer = findViewById(R.id.user_drawer);
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        });
    }



    public void myTradeReturns(View view) {
    }

    public void myAcctBalance(View view) {
    }

    public void profileTrading(View view) {
    }

    public void profileLoans(View view) {
    }

    public void profileGrpSavings(View view) {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dashboard:
                Intent mainIntent = new Intent(this, UserDashBoard.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainIntent);
                return true;
            case R.id.abtUs:
                Intent timelineIntent = new Intent(this, AboutUsAct.class);
                timelineIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(timelineIntent);
                return true;

            case R.id.ourP:
                Intent active = new Intent(UserDashBoard.this, OurPrivPolAct.class);
                startActivity(active);
                return true;
            case R.id.profileSettings:
                Intent pIntent = new Intent(this, SettingAct.class);
                pIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pIntent);
                return true;

            case R.id.nav_logoutSuper:
                Toast.makeText(this, "Logging out", Toast.LENGTH_SHORT).show();
                SharedPreferences preferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                Intent loginIntent = new Intent(this, LoginAct.class);
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(loginIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.gen_dashboard:

                Intent intent = new Intent(UserDashBoard.this, UserDashBoard.class);
                startActivity(intent);
                break;
            case R.id.all_timelines:
                Intent timelineIntent = new Intent(this, TimelineAct.class);
                timelineIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(timelineIntent);
                break;
            case R.id.all_job_board:
                Intent active = new Intent(UserDashBoard.this, MyJobBoadAct.class);
                startActivity(active);
                break;
            case R.id.all_properties:
                Intent pIntent = new Intent(this, MyProperties.class);
                pIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pIntent);
                break;

            case R.id.all_delivery:
                Intent tIntent = new Intent(this, MyDeliveryAct.class);
                tIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(tIntent);
                break;

            case R.id.all_sub:
                Intent supportInt = new Intent(UserDashBoard.this, MySubAct.class);
                startActivity(supportInt);
                break;
            case R.id.all_transfers:
                Intent aIntent = new Intent(this, MyTransfersAct.class);
                aIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(aIntent);
                break;
            case R.id.all_so:
                Intent so1Intent = new Intent(this, MySoAct.class);
                so1Intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(so1Intent);
                break;
            case R.id.all_Grp_Savings:
                Intent loanIntent = new Intent(this, MyGrpSavingsAct.class);
                loanIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(loanIntent);
                break;

            case R.id.all_chat:
                Intent payNowIntent = new Intent(this, MyChatAct.class);
                payNowIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(payNowIntent);
                break;

            case R.id.all_prop:
                Intent sIntent = new Intent(this, MyProperties.class);
                sIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(sIntent);
                break;

            case R.id.all_supplies:
                Intent uIntent = new Intent(this, WholeSaleMarketAct.class);
                uIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(uIntent);
                break;


            case R.id.nav_logoutSuper:
                Toast.makeText(this, "Logging out", Toast.LENGTH_SHORT).show();
                SharedPreferences preferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                Intent loginIntent = new Intent(UserDashBoard.this, LoginAct.class);
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(loginIntent);
                finish();
                break;
        }
        return true;

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profileTradings:
                Intent active = new Intent(UserDashBoard.this, TradeInvAct.class);
                active.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(active);
                break;
            case R.id.profileLoans:
                Intent history = new Intent(UserDashBoard.this, LoanAct.class);
                history.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(history);
                break;
            case R.id.profileGrpSavings:
                Intent timelineIntent = new Intent(UserDashBoard.this, GrpSavingsAct.class);
                timelineIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(timelineIntent);
                break;

        }


    }
}