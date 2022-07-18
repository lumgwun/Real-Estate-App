package com.ls.awajimatradeeder.EstateProperty;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.ls.awajimatradeeder.CameraAct;
import com.ls.awajimatradeeder.Classes.EstateAdmin;
import com.ls.awajimatradeeder.Classes.EstateAppartment;
import com.ls.awajimatradeeder.Classes.EstateJob;
import com.ls.awajimatradeeder.Classes.EstateLettingSales;
import com.ls.awajimatradeeder.Classes.EstateLoan;
import com.ls.awajimatradeeder.Classes.EstateMeeting;
import com.ls.awajimatradeeder.Classes.EstateOccupant;
import com.ls.awajimatradeeder.Classes.EstateSuperAdmin;
import com.ls.awajimatradeeder.Classes.EstateVisitor;
import com.ls.awajimatradeeder.Classes.PrefManager;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Database.DBHelper;
import com.ls.awajimatradeeder.R;
import com.ls.awajimatradeeder.SignTabMainAct;
import com.ls.awajimatradeeder.Tradee.TradeInvAct;
import com.rom4ek.arcnavigationview.ArcNavigationView;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class EstateOfficeAct extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    public static final String KEY = "SuperAdminOffice.KEY";
    GridLayout maingrid;
    Button btnOurPrivacyPolicy,btnInvestment;
    private SharedPreferences userPreferences;
    PrefManager prefManager;
    private Gson gson,gson1;
    private String json,json1,SharedPrefSuperUser;
    private LinearLayout linearLayout;

    private AppCompatImageView imgTime;

    private EstateSuperAdmin estateSuperAdmin;

    private int eatSuperAdminprofileID;
    Button btnMore;
    CardView cardViewPackges,cardViewGrpSavings,cardViewHistory, cardViewStandingOrders, cardViewOrders, cardViewSupport;

    AppCompatTextView extName, textID, textEmergencyToday, textVisitorsToday, textInvestments, textSuppliesRequest;
    FrameLayout frameLayout1,frameLayout2;
    CircleImageView profileImage;
    private Profile profile;

    private AppCompatTextView txtMessage;
    private AppCompatTextView txtEstateBalance;
    private AppCompatTextView balance;
    private AppCompatTextView txtpropRequest;
    private AppCompatTextView txtAllAppartments;
    private String userName;
    private AppCompatTextView reports;
    private AppCompatTextView txtAllSubs,txtBank,txtbankAcctName, txtBankAcctNo,txtBankAcctBalance,txtUserName;

    Intent data;
    FloatingActionButton floatingActionButton;
    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    String surname,firstName,names, dateOfToday;
    ImageButton hideLayouts;
    long customersToday,saving, activePackagesToday;
    double grpSavingsToday;
    CircleImageView imgProfilePic;
    Button btnMyGrpSavings;
    private Profile userProfile;
    int allCus,allUsers;
    private Date today;
    Date currentDate;
    DBHelper applicationDb;
    double totalAdminBalance;
    private Uri pictureLink;
    private EstateAdmin estateAdmin;
    private EstateOccupant estateOccupant;
    private static final String PREF_NAME = "Tradeeder";
    private List<EstateLoan> estateLoans;
    private List<EstateMeeting> estateMeetings;
    private List<EstateUsers> estateUsers;
    private List<EstateAppartment> estateAppartments;
    private List<EstateLettingSales> lettingSales;
    private List<EstateVisitor> estateVisitors;
    private List<EstateJob> estateJobs;
    SQLiteDatabase sqLiteDatabase;
    DBHelper dbHelper;

    String machineUser, office,state,role,dbRole,joinedDate,password, email,phoneNO, dob,gender,address;

    String SharedPrefUserPassword,SharedPrefCusID,SharedPrefUserMachine,SharedPrefUserName,SharedPrefProfileID;

    ActivityResultLauncher<Intent> startSuperPictureActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {
                    switch (result.getResultCode()) {
                        case Activity.RESULT_OK:
                            Intent data = result.getData();
                            if (data != null) {
                                Uri pictureUri = data.getData();
                                Picasso.get().load(pictureUri).into(profileImage);
                            }
                            Bundle bundle = null;
                            if (data != null) {
                                bundle = result.getData().getExtras();
                            }

                            Bitmap thumbnail = null;
                            if (bundle != null) {
                                thumbnail = (Bitmap) bundle.get("data");
                            }
                            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                            if (thumbnail != null) {
                                thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
                            }

                            File destination = new File(Environment.getExternalStorageDirectory(),
                                    System.currentTimeMillis() + ".jpg");
                            FileOutputStream fo;
                            try {
                                //destination.createNewFile();
                                fo = new FileOutputStream(destination);
                                try {
                                    fo.write(bytes.toByteArray());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    fo.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }


                            //Bitmap takenImage = BitmapFactory.decodeFile(photoFile.getAbsolutePath());

                            /*if (data != null) {
                                pictureUri = data.getData();
                                Picasso.get().load(pictureUri).into(photoPrOP);
                            }*/
                            Toast.makeText(EstateOfficeAct.this, "successful ", Toast.LENGTH_SHORT).show();
                            finish();
                            break;
                        case Activity.RESULT_CANCELED:
                            Toast.makeText(EstateOfficeAct.this, "cancelled", Toast.LENGTH_SHORT).show();
                            finish();
                            break;
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_estate_office);
        toolbar = (Toolbar) findViewById(R.id.toolbar_super);
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        gson = new Gson();
        gson1 = new Gson();
        estateLoans= new ArrayList<>();
        estateAppartments= new ArrayList<>();
        estateJobs= new ArrayList<>();
        estateMeetings= new ArrayList<>();
        estateUsers= new ArrayList<>();
        estateVisitors= new ArrayList<>();
        userProfile=new Profile();
        estateAdmin= new EstateAdmin();
        estateOccupant= new EstateOccupant();
        estateSuperAdmin =new EstateSuperAdmin();
        applicationDb = new DBHelper(this);
        dbHelper = new DBHelper(this);
        SharedPrefUserName=userPreferences.getString("PROFILE_USERNAME", "");
        SharedPrefUserPassword=userPreferences.getString("PROFILE_PASSWORD", "");
        SharedPrefUserMachine=userPreferences.getString("machine", "");
        SharedPrefProfileID=userPreferences.getString("PROFILE_ID", "");
        eatSuperAdminprofileID = userPreferences.getInt("PROFILE_ID", 0);
        userName = userPreferences.getString("PROFILE_USERNAME", "");
        office = userPreferences.getString("PROFILE_OFFICE", "");
        state = userPreferences.getString("PROFILE_STATE", "");
        role = userPreferences.getString("PROFILE_ROLE", "");
        password = userPreferences.getString("PROFILE_PASSWORD", "");
        dbRole=applicationDb.getProfileRoleByUserNameAndPassword(userName,password);

        joinedDate = userPreferences.getString("PROFILE_DATE_JOINED", "");
        surname = userPreferences.getString("PROFILE_SURNAME", "");
        email = userPreferences.getString("PROFILE_EMAIL", "");
        phoneNO = userPreferences.getString("PROFILE_PHONE", "");
        firstName = userPreferences.getString("PROFILE_FIRSTNAME", "");
        dob = userPreferences.getString("PROFILE_DOB", "");
        gender = userPreferences.getString("PROFILE_GENDER", "");
        address = userPreferences.getString("PROFILE_ADDRESS", "");
        pictureLink = Uri.parse(userPreferences.getString("PICTURE_URI", ""));

        //json = userPreferences.getString("LastProfileUsed", "");
        json = userPreferences.getString("LastEstateSuperAdminProfileUsed", "");
        userProfile = gson1.fromJson(json1, Profile.class);
        estateSuperAdmin = gson.fromJson(json, EstateSuperAdmin.class);

        txtBank = findViewById(R.id.cus_BankN);
        txtbankAcctName = findViewById(R.id.cus_BankText);
        txtBankAcctNo = findViewById(R.id.cus_BankNo33);
        txtBankAcctBalance = findViewById(R.id.cus_BankBalance4444);

        txtUserName = findViewById(R.id.eo_username);
        txtAllAppartments = findViewById(R.id.my_appartments);
        txtAllSubs = findViewById(R.id.my_subscriptions);

        txtEstateBalance = findViewById(R.id.estate_balance);
        txtpropRequest = findViewById(R.id.est_prop_request);
        //txtSavingsToday.setOnClickListener(this);
        extName = findViewById(R.id.super_name);
        textID = findViewById(R.id.est_admin_id);
        textEmergencyToday = findViewById(R.id.est_emerg_today);

        textVisitorsToday = findViewById(R.id.est_visitors_today);
        //textCustomersToday.setOnClickListener(this);

        textSuppliesRequest = findViewById(R.id.est_supplies_request);

        //textAllUsers.setOnClickListener(this);
        imgProfilePic = findViewById(R.id.profile_image_est);
        //txtAllStandingOrders.setOnClickListener(this);

        RecyclerView recyclerAppartments = findViewById(R.id.cardRecylerV22);
        RecyclerView recyclerVisitors = findViewById(R.id.cardRecylerV11);
        RecyclerView recyclerLettingSales = findViewById(R.id.cardRecylerVV);
        RecyclerView recyclerViewJob = findViewById(R.id.recylerVJob);

        /*  if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            //dbHelper = new DBHelper(this);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            try {
                standingOrders = dbHelper.getStandingOrdersToday(todayDate);
                paymentCodeArrayList=dbHelper.getAllSavingsCodes();

                skyLightPackages = dbHelper.getPackageEndingToday1(todayDate);

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            try {
                customerDailyReports3 = dbHelper.getAllReportsAdmin();


            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            try {
                accounts = dbHelper.getAllAccounts();


            } catch (NullPointerException e) {
                e.printStackTrace();
            }



        }*/

        /*   LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerStandingOrder.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerStandingOrder.getContext(),
                layoutManager.getOrientation());
        recyclerStandingOrder.addItemDecoration(dividerItemDecoration);
        recyclerStandingOrder.setItemAnimator(new DefaultItemAnimator());
        standingOrderAdapter = new StandingOrderAdapter(AdminPackageActivity.this,standingOrders);
        recyclerStandingOrder.setAdapter(standingOrderAdapter);
        standingOrderAdapter.setWhenClickListener(this);  */

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav_EstateO);

        bottomNavigationView.setSelectedItemId(R.id.est_NullP);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.estateHome:
                        startActivity(new Intent(EstateOfficeAct.this, EstateOfficeAct.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.est_NullP:
                        return true;
                    case R.id.estate_finance:
                        startActivity(new Intent(EstateOfficeAct.this, EstateFinanceAct.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.estate_chat:
                        startActivity(new Intent(EstateOfficeAct.this, EstateChatAct.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.estate_admin:
                        startActivity(new Intent(EstateOfficeAct.this, EstateAdminAct.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


        Calendar calendar = Calendar.getInstance();
        currentDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd/MM/yyyy", Locale.getDefault());

        try {
            dateOfToday =dateFormat.format(currentDate);
            today = dateFormat.parse(dateOfToday);


        } catch (ParseException ignored) {
        }



        //sPackages = findViewById(R.id.cus_packages);



        if(estateSuperAdmin !=null){
            eatSuperAdminprofileID = estateSuperAdmin.getEstateProfileID();
            Bitmap bitmap = applicationDb.getProfilePicture(eatSuperAdminprofileID);
            imgProfilePic.setImageBitmap(bitmap);
        }
        imgProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSuperPictureActivityForResult.launch(new Intent(EstateOfficeAct.this, CameraAct.class));

            }
        });


        ArcNavigationView navigationView = (ArcNavigationView) findViewById(R.id.nav_view_estate);
        navigationView.setNavigationItemSelectedListener(this);
        drawer = findViewById(R.id.est_drawer);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.setHomeAsUpIndicator(R.drawable.home_fg);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Real Estate BackOffice");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon5_fg);

        btnMyGrpSavings =findViewById(R.id.myGrpSavings);
        linearLayout=findViewById(R.id.linearGrid);
        maingrid=(GridLayout) findViewById(R.id.ViewSuper);
        imgTime = findViewById(R.id.superGreetings);
        setSingleEvent(maingrid);

        btnMyGrpSavings.setOnClickListener(this::myGrpSavings);
        try {

            txtAllAppartments.setOnClickListener(this::gpPackages);
            textVisitorsToday.setText(MessageFormat.format("Visitors today:{0}", customersToday));
            textEmergencyToday.setText(MessageFormat.format("Emergencies:{0}", allCus));
            textSuppliesRequest.setText(MessageFormat.format("Property Request:{0}", allUsers));
        } catch (NullPointerException e) {
            System.out.println("Oops!");
        }
        StringBuilder welcomeString = new StringBuilder();


        calendar = Calendar.getInstance();

        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 5 && timeOfDay < 12) {
            //welcomeString.append(getString(R.string.good_morning));
            imgTime.setImageResource(R.drawable.good_morning1);
        } else if (timeOfDay >= 12 && timeOfDay < 17) {
            welcomeString.append(getString(R.string.good_afternoon));
            imgTime.setImageResource(R.drawable.good_day);
        } else {
            welcomeString.append(getString(R.string.good_evening));
            imgTime.setImageResource(R.drawable.good_evening2);
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
                .append("Skylight Super Admin")
                .append("How are you? ")
                .append(getString(R.string.happy))
                .append(dow);


        setupHeader();


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
        drawer = findViewById(R.id.est_drawer);
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

    private void setupHeader() {

        ArcNavigationView navigationView = (ArcNavigationView) findViewById(R.id.nav_view_estate);
        navigationView.setNavigationItemSelectedListener(this);
        drawer = findViewById(R.id.est_drawer);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.setHomeAsUpIndicator(R.drawable.home_fg);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Estate BackOffice");

        View headerView = navigationView.getHeaderView(0);

        DBHelper applicationDb = new DBHelper(this);
        if(estateSuperAdmin !=null){
            eatSuperAdminprofileID = estateSuperAdmin.getEstateProfileID();
            Bitmap bitmap = applicationDb.getProfilePicture(eatSuperAdminprofileID);
            CircleImageView imgProfilePic = headerView.findViewById(R.id.profile_image_cus);
            imgProfilePic.setImageBitmap(bitmap);
        }




    }
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void setSingleEvent(GridLayout gridLayout) {
        for(int i = 0; i<gridLayout.getChildCount();i++){
            CardView cardView=(CardView)gridLayout.getChildAt(i);
            final int finalI= i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch(finalI) {
                        case 0:
                            Intent myIntent = new Intent(EstateOfficeAct.this, VisitationAct.class);
                            myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(myIntent);
                            break;
                        case 1:
                            Intent myIntent1 = new Intent(EstateOfficeAct.this, EstateMeetingAct.class);
                            myIntent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(myIntent1);
                            break;
                        case 2:
                            Intent myIntent2 = new Intent(EstateOfficeAct.this, EstateUserCreator.class);
                            myIntent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(myIntent2);
                            break;
                        case 3:
                            Intent myIntent3 = new Intent(EstateOfficeAct.this, EstateChatAct.class);
                            myIntent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(myIntent3);
                            break;

                        case 4:
                            Intent myIntent4 = new Intent(EstateOfficeAct.this, EstateElectionAct.class);
                            myIntent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(myIntent4);
                            break;

                        case 5:
                            Intent myIntent5 = new Intent(EstateOfficeAct.this, EstateMarketAct.class);
                            myIntent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(myIntent5);
                            break;

                        default:
                    }
                    Toast.makeText(EstateOfficeAct.this,"Clicked at index "+ finalI,
                            Toast.LENGTH_SHORT).show();

                }
            });

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.estate_super_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_estateBO:
                Intent mainIntent = new Intent(this, EstateOfficeAct.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainIntent);
                return true;
            case R.id.estate_timelines:
                Intent timelineIntent = new Intent(this, EstateTimelineAct.class);
                timelineIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(timelineIntent);
                return true;

            case R.id.estate_user_creator:
                Intent active = new Intent(EstateOfficeAct.this, EstateUserCreator.class);
                startActivity(active);
                return true;
            case R.id.est_emergency:
                Intent pIntent = new Intent(this, EstateEmergAct.class);
                pIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pIntent);
                return true;

            case R.id.est_visitation:
                Intent tIntent = new Intent(this, VisitationAct.class);
                tIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(tIntent);
                return true;
            case R.id.est_Sub:
                Intent supportInt = new Intent(EstateOfficeAct.this, EstateFinanceAct.class);
                startActivity(supportInt);
                return true;

            case R.id.nav_logoutSuper:
                Toast.makeText(this, "Logging out", Toast.LENGTH_SHORT).show();
                SharedPreferences preferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                Intent loginIntent = new Intent(this, SignTabMainAct.class);
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
            case R.id.nav_estateBO:

                Intent intent = new Intent(EstateOfficeAct.this, EstateOfficeAct.class);
                startActivity(intent);
                break;
            case R.id.estate_admin:
                Intent timelineIntent = new Intent(this, EstateAdminAct.class);
                timelineIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(timelineIntent);
                break;
            case R.id.est_chat1:
                Intent active = new Intent(EstateOfficeAct.this, EstateChatAct.class);
                startActivity(active);
                break;
            case R.id.estate_timelines:
                Intent pIntent = new Intent(this, EstateTimelineAct.class);
                pIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pIntent);
                break;

            case R.id.estate_finance2:
                Intent tIntent = new Intent(this, EstateFinanceAct.class);
                tIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(tIntent);
                break;

            case R.id.est_emergency:
                Intent supportInt = new Intent(EstateOfficeAct.this, EstateEmergAct.class);
                startActivity(supportInt);
                break;
            case R.id.est_loan:
                Intent aIntent = new Intent(this, EstateLoanAct.class);
                aIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(aIntent);
                break;
            case R.id.est_Grp_Savings:
                Intent so1Intent = new Intent(this, EstateGSavingsAct.class);
                so1Intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(so1Intent);
                break;
            case R.id.est_visitation:
                Intent loanIntent = new Intent(this, VisitationAct.class);
                loanIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(loanIntent);
                break;

            case R.id.est_supplies:
                Intent payNowIntent = new Intent(this, EstateMarketAct.class);
                payNowIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(payNowIntent);
                break;

            case R.id.navsupportSuper:
                Intent sIntent = new Intent(this, MyEstatePropAct.class);
                sIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(sIntent);
                break;

            case R.id.est_meetings:
                Intent uIntent = new Intent(this, EstateMeetingAct.class);
                uIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(uIntent);
                break;

            case R.id.est_elections:
                Intent electIntent = new Intent(this, EstateElectionAct.class);
                electIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(electIntent);
                break;


            case R.id.est_logout:
                Toast.makeText(this, "Logging out", Toast.LENGTH_SHORT).show();
                SharedPreferences preferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                Intent loginIntent = new Intent(EstateOfficeAct.this, SignTabMainAct.class);
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
            case R.id.myTradings:
                Intent active = new Intent(EstateOfficeAct.this, TradeInvAct.class);
                active.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(active);
                break;
            case R.id.myLoans:
                Intent history = new Intent(EstateOfficeAct.this, EstateLoanAct.class);
                history.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(history);
                break;
            case R.id.myGrpSavings:
                Intent timelineIntent = new Intent(EstateOfficeAct.this, EstateGSavingsAct.class);
                timelineIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(timelineIntent);
                break;

        }


    }


    public void goSoSuper(View view) {
        /*Intent so1Intent = new Intent(this, AdminSOTabAct.class);
        so1Intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(so1Intent);*/
    }

    public void gpPackages(View view) {
        /*Intent pIntent = new Intent(this, AdminTabActivity.class);
        pIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(pIntent);*/

    }

    public void myAppartments(View view) {
        Intent loanIntent = new Intent(this, EstateAppartAct.class);
        loanIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(loanIntent);
    }

    public void myGrpSavings(View view) {
        Intent loanIntent = new Intent(this, EstateGSavingsAct.class);
        loanIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(loanIntent);
    }

    public void myLoans(View view) {
        Intent pIntent = new Intent(this, EstateLoanAct.class);
        pIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(pIntent);
    }

    public void myTrading(View view) {
        Intent pIntent = new Intent(this, TradeInvAct.class);
        pIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(pIntent);
    }

    public void myEstSubs(View view) {
        Intent pIntent = new Intent(this, EstateFinanceAct.class);
        pIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(pIntent);
    }

    public void goReturns(View view) {
        Intent pIntent = new Intent(this, TradeInvAct.class);
        pIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(pIntent);
    }
}