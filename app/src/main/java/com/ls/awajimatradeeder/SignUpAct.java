package com.ls.awajimatradeeder;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.widget.ContentLoadingProgressBar;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.gson.Gson;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.hbb20.CountryCodePicker;
import com.ls.awajimatradeeder.Classes.Account;
import com.ls.awajimatradeeder.Classes.AdminUser;
import com.ls.awajimatradeeder.Classes.Birthday;
import com.ls.awajimatradeeder.Classes.PinEntryView;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Classes.SOrderAcct;
import com.ls.awajimatradeeder.Classes.SupportMessage;
import com.ls.awajimatradeeder.Classes.TimeLine;
import com.ls.awajimatradeeder.Database.DBHelper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;
import static com.ls.awajimatradeeder.Classes.Account.BANK_ACCT_NO;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ADDRESS;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_COUNTRY;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_DATE_JOINED;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_DEVICE_ID;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_DOB;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_EMAIL;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_FIRSTNAME;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_GENDER;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_IDENTITY;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID_TYPE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_NEXT_OF_KINID;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_OFFICE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_PASSWORD;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_PHONE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_PICTURE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ROLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_STATE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_STATUS;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_SURNAME;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_USERNAME;
import static com.ls.awajimatradeeder.Classes.Profile.PROF_SPONSOR_ID;

@SuppressWarnings("deprecation")
public class SignUpAct extends AppCompatActivity {
    public static final int PICTURE_REQUEST_CODE = 505;
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    SharedPreferences userPreferences;
    AppCompatEditText phone_number;
    AppCompatEditText email_address;
    AppCompatEditText edtNIN;
    String stringNIN, timeLineTime;
    GoogleMap googleMap, mMap;
    AppCompatEditText firstName;
    AppCompatEditText surname1;
    AppCompatEditText userName;
    AppCompatEditText password, edtSponsorID;
    AppCompatEditText address_2;
    Bitmap thumbnail;
    protected DatePickerDialog datePickerDialog;
    Random ran;
    private double accountBalance;
    SecureRandom random;

    Context context;
    String dateOfBirth;
    PreferenceManager preferenceManager;
    private Bundle bundle;
    AppCompatTextView dobText;
    String uPhoneNumber, accountName, skylightMFb;
    private ProgressDialog progressDialog;
    int profileID, birthdayID, messageID;

    private ProgressBar loadingPB;
    String ManagerSurname;
    String managerFirstName, uPassword;
    String managerPhoneNumber1;
    String managerEmail, managerGender;
    String managerAddress;
    private boolean locationPermissionGranted;
    String managerUserName;
    String selectedCountry, selectedGender, selectedState;
    Birthday birthday;

    AppCompatRadioButton rbTeller, rbCustomer;
    String uFirstName, uEmail, uSurname, uAddress, uUserName;

    int virtualAccountNumber, soAccountNumber;
    int profileID1;

    AppCompatSpinner spnState, office, spnGender, spnCountry;
    DBHelper dbHelper;
    Profile managerProfile;

    Location mCurrentLocation = null;
    String daysRemaining;
    int daysBTWN;

    String acct;
    SQLiteDatabase sqLiteDatabase;
    Date date;
    Gson gson, gson1;
    String json, json1, nIN;
    Profile userProfile, lastProfileUsed;
    String officePref;

    private String picturePath;
    private static final int RESULT_LOAD_IMAGE = 1;
    private static final String REQUIRED = "Required";
    private static final int RESULT_CAMERA_CODE = 22;
    int investmentAcctID, loanAcctID;
    int comAcctID;
    int profileFId;
    int birthdayFID;
    int acctFID;
    SQLiteDatabase sqLiteDatabaseObj;
    //daysRemaining = birthday.g(currentDate, dateOfBirth);
    //daysBTWN = birthday.getDaysInBetween(currentDate, dateOfBirth);
    SharedPreferences.Editor editor;
    RadioGroup userTypes;
    ByteArrayOutputStream bytes;
    DBHelper applicationDb;
    DatePicker picker;
    String userProfileType;
    int selectedId, day, month, year, newMonth;
    String userType;
    String userRole, sponsorIDString;
    String selectedUser;
    int sponsorID;
    String address;
    Spinner spnUsers;
    Location customerLoc;
    LatLng userLocation;
    int daysInBetween;
    File destination;
    LatLng cusLatLng;
    double latitude = 0;
    double longitude = 0;
    Geocoder geocoder;
    Bundle userLocBundle;
    ArrayList<Profile> profiles;
    CircleImageView profilePix;
    AppCompatImageView imgGreetings;
    ArrayList<AdminUser> adminUserArrayList;
    private Uri mImageUri;
    //private ProgressBar uploadProgressBar;
    ContentLoadingProgressBar progressBar;

    private int managerProfileID;

    //List<Address> addresses;
    private Calendar cal;
    private static boolean isPersistenceEnabled = false;
    private Account account;
    private SOrderAcct standingOrderAcct, soAcct;
    private FusedLocationProviderClient fusedLocationClient;
    private TimeLine timeLine;
    String joinedDate, profileName;
    String code;
    Profile userProfile1, userProfile2;
    private static final int REQUEST_CHECK_SETTINGS = 1000;
    private String mVerificationId;
    double lat, lng;

    String dob;
    String SharedPrefState, otpMessage, smsMessage;
    //private OtpTextView otpTextView;
    private AppCompatButton btnVerifyOTPAndSignUp;
    private int otpDigit;
    String otpPhoneNumber;
    private LinearLayoutCompat layoutOTP, layoutPreOTP;
    private EditText[] editTexts;
    private Button btnSendOTP;
    Location location;
    private View mapView;
    AppCompatTextView txtLoc, locTxt;
    private LocationRequest request;
    private String email;

    Marker now;

    CameraUpdate cLocation;
    TextView otpTxt;
    private Calendar calendar;

    InstallReferrerClient referrerClient;
    CountryCodePicker ccp;

    String referrer = "";
    private LocationCallback locationCallback;
    public static final Boolean USINGROOM = true;
    //RoomController mRoomDB;

    private String bankAcctNumber;
    private AppCompatActivity SignUpAct;
    PinEntryView edtCode;
    private CardView cardState;
    private AppCompatTextView txtState;


    private static final String PREF_NAME = "Tradeeder";
    private boolean currentlyTracking;
    private LocationManager locationManager;
    String regEx =
            "^(([w-]+.)+[w-]+|([a-zA-Z]{1}|[w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]).([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]).([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[w-]+.)+[a-zA-Z]{2,4})$";

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    SupportMapFragment mapFrag;
    char[] otp;
    ;
    int PERMISSION_ALL = 1;
    String[] PERMISSIONS = {
            Manifest.permission.CAMERA,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
    };

    int PERMISSION_ALL33 = 2;
    String[] PERMISSIONS33 = {
            Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS, Manifest.permission.SEND_SMS
    };

    // private static final String BASE_URL="https://firebasestorage.googleapis.com/";

    ActivityResultLauncher<Intent> mGetPixContent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {
                    switch (result.getResultCode()) {
                        case Activity.RESULT_OK:
                            if (result.getData() != null) {
                                //logo = findViewById(R.id.imageLogo);
                                Intent data = result.getData();
                                mImageUri = data.getData();
                                if (mImageUri != null) {
                                    profilePix.setImageBitmap(getScaledBitmap(mImageUri));
                                } else {
                                    Toast.makeText(SignUpAct.this, "Error getting Photo",
                                            Toast.LENGTH_SHORT).show();
                                }


                            }

                            Toast.makeText(SignUpAct.this, "Image picking returned successful", Toast.LENGTH_SHORT).show();
                            //doProcessing();
                            break;
                        case Activity.RESULT_CANCELED:
                            Toast.makeText(SignUpAct.this, "Activity canceled", Toast.LENGTH_SHORT).show();
                            //finish();
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + result.getResultCode());
                    }
                }
                /*@Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        finish();
                    }
                }*/
            });
    ActivityResultLauncher<Intent> mStartLocForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        if (intent != null) {
                            cusLatLng = intent.getParcelableExtra("CusLatLng");
                        }
                        // Handle the Intent
                    }
                }
            });
    ActivityResultLauncher<Intent> startBankAcctCreationForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        if (intent != null) {
                            bankAcctNumber = intent.getStringExtra("BankAcct");
                        }

                    }
                }
            });


    public static String getDeviceId(Context context) {
        @SuppressLint("HardwareIds") final String deviceId = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        if (deviceId != null) {
            return deviceId;
        } else {
            return Build.SERIAL;
        }
    }

    @SuppressLint("HardwareIds")
    public String getDeviceUUID(Context context) {
        final TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            //return TODO;
        }
        String deviceMobileNo = tm.getLine1Number();

        UUID deviceUuid = new UUID(androidId.hashCode(),
                ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        return deviceUuid.toString();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_sign_up);
        dbHelper = new DBHelper(this);
        setTitle("OnBoarding Arena");
        referrerClient = InstallReferrerClient.newBuilder(this).build();
        getSkylightRefferer(referrerClient);
        imgGreetings = findViewById(R.id.Greetings);
        profilePix = findViewById(R.id.profile_image);
        progressBar = findViewById(R.id.progressB);
        surname1 = findViewById(R.id.surname);
        firstName = findViewById(R.id.first_Name_);
        email_address = findViewById(R.id.email_address);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        phone_number = findViewById(R.id.phone_number);
        address_2 = findViewById(R.id.address_);
        dobText = findViewById(R.id.dob_text_);
        userName = findViewById(R.id.user_name_);
        spnGender = findViewById(R.id.gender);
        spnCountry = findViewById(R.id.oCountry);
        spnState = findViewById(R.id.state);
        password = findViewById(R.id.user_password);
        edtSponsorID = findViewById(R.id.user_sponsor);
        btnSendOTP = findViewById(R.id.sendOTPCode);
        btnVerifyOTPAndSignUp = findViewById(R.id.idBtnVerify);
        edtCode = findViewById(R.id.txt_pin_entry);
        layoutOTP = findViewById(R.id.layoutOtp);
        otpTxt = findViewById(R.id.textOTP);
        txtState = findViewById(R.id.stateOfC);
        cardState = findViewById(R.id.cardState);

        profiles = null;
        birthday = new Birthday();
        profiles = new ArrayList<>();
        managerProfile = new Profile();
        userProfile = new Profile();
        userProfile2= new Profile();
        account = new Account();
        gson1 = new Gson();
        gson = new Gson();
        managerProfile = new Profile();
        standingOrderAcct = new SOrderAcct();
        soAcct = new SOrderAcct();
        account = new Account();
        birthday = new Birthday();
        PrePopulateDB();
        ran = new Random();
        random = new SecureRandom();

        nIN = null;

        otp = new char[4];
        for (int i=0; i<4; i++)
        {
            otp[i]= (char)(random.nextInt(10)+48);
        }

        otpDigit = ThreadLocalRandom.current().nextInt(122, 1631);
        messageID = ThreadLocalRandom.current().nextInt(1125, 10400);
        otpMessage = "&message=" + "Hello Skylight, Your OTP Code is " + otpDigit;

        profileID1 = random.nextInt((int) (Math.random() * 1400) + 1115);
        virtualAccountNumber = random.nextInt((int) (Math.random() * 123045) + 100123);
        soAccountNumber = random.nextInt((int) (Math.random() * 133044) + 100125);
        investmentAcctID = random.nextInt((int) (Math.random() * 1011) + 101360);
        loanAcctID = random.nextInt((int) (Math.random() * 1101) + 1010);
        //SQLiteDataBaseBuild();
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            //dbHelper = new DBHelper(this);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            dbHelper.openDataBase();
            profiles = dbHelper.getAllProfilesF();


        }

        layoutPreOTP = findViewById(R.id.layoutSign);

        userProfile1 = new Profile(100, "New1", "New2", "08069524599", "lumgwuns@gmail.com", "1980-04-19", "female", "Nigeria", "Rivers", "Rivers", "Elelenwo", "2022-04-19", "SuperAdmin", "Skylight4ever", "@Awajima2", "Confirmed", "");
        userProfile2 = new Profile(1000, "New3", "New4", "08059250176", "bener@gmail.com", "25/04/1989", "male", "Nigeria", "Abia", "Rivers", "Elelenwo", "19/04/2022", "CompleteMembership", "Lumgwun", "@Awajima3", "Confirmed", "");
        String tittle="App Testing";
        String details="Lead Developer Testing";
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            dbHelper.openDataBase();
            sqLiteDatabase = dbHelper.getWritableDatabase();
            dbHelper.insertTimeLine(1000, tittle, details,"2022-04-19");

        }
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            dbHelper.openDataBase();
            sqLiteDatabase = dbHelper.getWritableDatabase();
            dbHelper.insertNewMessage(messageID,1000,0,0,"","","","testing","the App is coming","Our App","",joinedDate);

        }
        Birthday birthday= new Birthday(1000,messageID,"Une","","","1983-04-25",0,"","");
        Birthday birthday2= new Birthday(10001,messageID+1,"Uned","","","1983-07-25",0,"","");

        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            //dbHelper = new DBHelper(this);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            dbHelper.openDataBase();
            dbHelper.saveNewProfile(userProfile2,birthday);


        }
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            //dbHelper = new DBHelper(this);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            dbHelper.openDataBase();
            dbHelper.saveNewProfile(userProfile1,birthday2);


        }

        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        json = userPreferences.getString("LastProfileUsed", "");
        managerProfile = gson.fromJson(json, Profile.class);
        json1 = userPreferences.getString("LastTellerProfileUsed", "");
        currentlyTracking = userPreferences.getBoolean("currentlyTracking", false);

        boolean firstTimeLoadingApp = userPreferences.getBoolean("firstTimeLoadingApp", true);
        if (firstTimeLoadingApp) {
            SharedPreferences.Editor editor = userPreferences.edit();
            editor.putBoolean("firstTimeLoadingApp", false);
            editor.putString("deviceID", com.ls.awajimatradeeder.SignUpAct.getDeviceId(this));
            editor.apply();
        }


        cal = Calendar.getInstance();
        dobText.setOnClickListener(this::dobPicker);

        dobText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal = Calendar.getInstance();
                year = cal.get(Calendar.YEAR);
                month = cal.get(Calendar.MONTH);
                newMonth = month + 1;
                day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(SignUpAct.this, R.style.DatePickerDialogStyle, mDateSetListener, day, month, year);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //make transparent background.
                dialog.show();
                dob = year + "-" + newMonth + "-" + day;
                dateOfBirth = day + "-" + newMonth + "-" + year;
                dobText.setText("Your date of Birth:" + dob);

            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int day, int month, int year) {
                Log.d(TAG, "onDateSet: date of Birth: " + day + "-" + month + "-" + year);
                dob = year + "-" + newMonth + "-" + day;
                dateOfBirth = day + "-" + newMonth + "-" + year;
                dobText.setText("Your date of Birth:" + dob);


            }


        };
        dateOfBirth = day + "-" + newMonth + "-" + year;

        //token= getIntent().getStringExtra("TOKEN");
        birthdayID = random.nextInt((int) (Math.random() * 1001) + 1010);
        calendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        joinedDate = mdformat.format(calendar.getTime());

        //dobText.setText("Your date of Birth:"+dateOfBirth);


        if (managerProfile != null) {
            ManagerSurname = managerProfile.getProfileLastName();
            managerFirstName = managerProfile.getProfileFirstName();
            profileID = managerProfile.getProfileID();
            //profileID1=profileID;
            managerPhoneNumber1 = managerProfile.getProfilePhoneNumber();
            managerEmail = managerProfile.getProfileEmail();
            managerUserName = managerProfile.getProfileUserName();
            userType = managerProfile.getProfileUserType();
            userRole = managerProfile.getProfileRole();

        } else {
            profileID = 0;

        }
        edtSponsorID.setText("Your Sponsor's ID:" + profileID);

        profilePix.setOnClickListener(this::doSelectPix);


        StringBuilder welcomeString = new StringBuilder();

        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 5 && timeOfDay < 12) {
            //welcomeString.append(getString(R.string.good_morning));
            imgGreetings.setImageResource(R.drawable.good_morning1);
        } else if (timeOfDay >= 12 && timeOfDay < 17) {
            welcomeString.append(getString(R.string.good_afternoon));
            imgGreetings.setImageResource(R.drawable.good_day);
        } else {
            welcomeString.append(getString(R.string.good_evening));
            imgGreetings.setImageResource(R.drawable.good_evening2);
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


        welcomeString.append("Welcome" + "")
                .append(managerFirstName + "")
                .append("How are you today? ")
                .append(getString(R.string.happy))
                .append(dow);

        spnGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedGender = spnGender.getSelectedItem().toString();
                selectedGender = (String) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //office = findViewById(R.id.office5);
        spnCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCountry = spnCountry.getSelectedItem().toString();
                selectedCountry = (String) parent.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        if(selectedCountry !=null){
            if(selectedCountry.equalsIgnoreCase("Nigeria")){
                cardState.setVisibility(View.VISIBLE);
                txtState.setVisibility(View.VISIBLE);

            }


        }

        spnState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedState = spnState.getSelectedItem().toString();
                selectedState = (String) parent.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        ccp.registerCarrierNumberEditText(phone_number);
        ccp.getFullNumberWithPlus();

        ccp.setPhoneNumberValidityChangeListener(new CountryCodePicker.PhoneNumberValidityChangeListener() {
            @Override
            public void onValidityChanged(boolean isValidNumber) {
                // your code
            }
        });
        email = email_address.getText().toString().trim();

        email_address.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (email.matches(emailPattern) && s.length() > 0) {
                    Toast.makeText(SignUpAct.this, "valid email address", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(SignUpAct.this, "Invalid email address", Toast.LENGTH_SHORT).show();

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        profilePix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hasPermissions(SignUpAct.this, PERMISSIONS)) {
                    ActivityCompat.requestPermissions(SignUpAct.this, PERMISSIONS, PERMISSION_ALL);
                }

                final PopupMenu popup = new PopupMenu(SignUpAct.this, profilePix);
                popup.getMenuInflater().inflate(R.menu.pix_menu, popup.getMenu());
                setTitle("Photo selection in Progress...");

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.Camera) {
                            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(cameraIntent, RESULT_CAMERA_CODE);

                        }

                        if (item.getItemId() == R.id.Gallery) {
                            Intent i = new Intent(
                                    Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                            startActivityForResult(i, RESULT_LOAD_IMAGE);
                        }
                        if (item.getItemId() == R.id.cancel_action) {
                            setTitle("Our App onBoarding");
                        }

                        return true;
                    }
                });
                popup.show();//showing popup menu


            }

            protected void onActivityResult(int requestCode, int resultCode, Intent data) {

                if ((data != null) && requestCode == RESULT_CAMERA_CODE) {
                    mImageUri = data.getData();
                    //dbHelper= new DBHelper(SignUpAct.this);
                    //dbHelper.insertProfilePicture(profileID1,customerID,photoUri);


                }
                if ((data != null) && requestCode == RESULT_LOAD_IMAGE) {
                    mImageUri = data.getData();
                    //dbHelper= new DBHelper(SignUpAct.this);
                    //dbHelper.insertProfilePicture(profileID1,customerID,photoUri);


                }

            }
        });

        if (managerProfile != null) {
            ManagerSurname = managerProfile.getProfileLastName();
            managerFirstName = managerProfile.getProfileFirstName();
            profileID = managerProfile.getProfileID();
            //profileID1=profileID;
            managerPhoneNumber1 = managerProfile.getProfilePhoneNumber();
            managerEmail = managerProfile.getProfileEmail();
            managerUserName = managerProfile.getProfileUserName();
            userType = managerProfile.getProfileUserType();
            userRole = managerProfile.getProfileRole();

        } else {
            profileID = 0;

        }


        btnVerifyOTPAndSignUp.setOnClickListener(this::verifyOTP);

        Animation translater = AnimationUtils.loadAnimation(this, R.anim.bounce);

        btnSendOTP.setOnClickListener(this::sendOTPForProfile);
        //btnSendOTP.startAnimation(translater);

        btnSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(translater);
                uFirstName = firstName.getText().toString().trim();
                uSurname = surname1.getText().toString().trim();
                uEmail = email_address.getText().toString();
                sponsorIDString = edtSponsorID.getText().toString().trim();
                uAddress = Objects.requireNonNull(address_2.getText()).toString();
                uPassword = password.getText().toString().trim();
                uPhoneNumber = Objects.requireNonNull(phone_number.getText()).toString();
                uUserName = userName.getText().toString();
                boolean usernameTaken = false;
                nIN = null;
                profileName = uSurname + "," + uFirstName;
                try {
                    sponsorID = Integer.parseInt(sponsorIDString);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }


                try {

                    if (TextUtils.isEmpty(uFirstName)) {
                        firstName.setError("Please enter Your First Name");
                    } else if (TextUtils.isEmpty(uSurname)) {
                        surname1.setError("Please enter your Last/SurName");
                    } else if (TextUtils.isEmpty(uPassword)) {
                        password.setError("Please enter your Password");
                    } else if (uPhoneNumber.isEmpty() || uPhoneNumber.length() < 11) {
                        phone_number.setError("Enter a valid mobile Number");
                        phone_number.requestFocus();
                    } else if (TextUtils.isEmpty(uUserName)) {
                        userName.setError("Please enter your userName");
                    } else if (TextUtils.isEmpty(uAddress)) {
                        address_2.setError("Please enter Address");
                    } else {

                        layoutOTP.setVisibility(View.VISIBLE);
                        layoutPreOTP.setVisibility(View.GONE);
                        otpTxt.setText("Your OTP is:" + otpDigit);
                        otpPhoneNumber = "+234" + uPhoneNumber;
                        //doOtpNotification();
                        //sendOTPMessage(otpPhoneNumber,otpMessage);
                        //sendOTPVerCode(otpPhoneNumber,mAuth,sponsorID,account,standingOrderAcct,customer,joinedDate,uFirstName,uSurname,uPhoneNumber,uAddress,uUserName,uPassword,customer,customerProfile,nIN,managerProfile,dateOfBirth,selectedGender,selectedOffice,selectedState,birthday,customerManager,dateOfBirth,profileID1,virtualAccountNumber,soAccountNumber, customerID,profileID2,birthdayID, investmentAcctID,itemPurchaseAcctID,promoAcctID,packageAcctID,profiles,customers,tellers,adminUserArrayList,superAdminArrayList);

                        for (int i = 0; i < profiles.size(); i++) {
                            try {
                                if (profiles.get(i).getProfilePhoneNumber().equalsIgnoreCase(uPhoneNumber)) {
                                    Toast.makeText(SignUpAct.this, "This Phone Number is already in use, here", Toast.LENGTH_LONG).show();
                                    return;

                                } else {
                                    layoutOTP.setVisibility(View.VISIBLE);
                                    layoutPreOTP.setVisibility(View.GONE);
                                    otpPhoneNumber = "+234" + uPhoneNumber;
                                    String tittle ="Sign up OTP Code";
                                    String content=otpMessage;
                                    String ticker ="fill it in for verification";
                                    doOtpNotification(tittle,content,ticker,SignUpAct);
                                    SupportMessage supportMessage = new SupportMessage(uPhoneNumber,otpDigit);
                                    sendOTPMessage(otpPhoneNumber, otpMessage);

                                    if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
                                        dbHelper.openDataBase();
                                        sqLiteDatabase = dbHelper.getWritableDatabase();
                                        dbHelper.saveNewMessage(supportMessage);

                                    }


                                    //sendOTPVerCode(otpPhoneNumber,mAuth,sponsorID,account,standingOrderAcct,customer,joinedDate,uFirstName,uSurname,uPhoneNumber,uAddress,uUserName,uPassword,customer,customerProfile,nIN,managerProfile,dateOfBirth,selectedGender,selectedOffice,selectedState,birthday,customerManager,dateOfBirth,profileID1,virtualAccountNumber,soAccountNumber, customerID,profileID2,birthdayID, investmentAcctID,itemPurchaseAcctID,promoAcctID,packageAcctID,profiles,customers,tellers,adminUserArrayList,superAdminArrayList);
                                }
                            } catch (NullPointerException e) {
                                System.out.println("Oops!");
                            }

                        }
                        //long accountNumber = Long.parseLong(String.valueOf((long) (Math.random() * 10501) + 10010));


                    }

                } catch (Exception e) {
                    System.out.println("Oops!");
                }

            }
        });
        btnVerifyOTPAndSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(translater);
                boolean usernameTaken = false;
                nIN = null;
                //long accountNumber = Long.parseLong(String.valueOf((long) (Math.random() * 10501) + 10010));

                otpPhoneNumber = "+234" + uPhoneNumber;
                code = edtCode.getText().toString().trim();

                if (code != null) {
                    if (code.equals(String.valueOf(otpDigit))) {
                        Toast.makeText(SignUpAct.this, "OTP verification, a Success", Toast.LENGTH_SHORT).show();
                        startProfileActivity(sponsorID,  account, standingOrderAcct, joinedDate, uFirstName, uSurname, uPhoneNumber, uAddress, uUserName, uPassword,  nIN, managerProfile, selectedGender,  selectedState, selectedCountry,birthday, dateOfBirth, profileID1, virtualAccountNumber, soAccountNumber, birthdayID, investmentAcctID,loanAcctID,userProfile);

                    } else {
                        Toast.makeText(SignUpAct.this, "Incorrect OTP", Toast.LENGTH_SHORT).show();
                        edtCode.setText("Wrong OTP...");
                        edtCode.requestFocus();
                    }
                    progressBar.setVisibility(View.VISIBLE);

                }


            }
        });

    }

    private void startProfileActivity(int sponsorID, Account account, SOrderAcct standingOrderAcct, String joinedDate, String uFirstName, String uSurname, String uPhoneNumber, String uAddress, String uUserName, String uPassword, String nIN, Profile managerProfile, String selectedGender, String selectedState, String selectedCountry, Birthday birthday, String dateOfBirth, int profileID1, int virtualAccountNumber, int soAccountNumber, int birthdayID, int investmentAcctID, int loanAcctID, Profile userProfile) {
        Toast.makeText(SignUpAct.this, "Gender: " + selectedGender + "," + "Country:" + selectedCountry, Toast.LENGTH_SHORT).show();
        showProgressDialog();
        dbHelper = new DBHelper(this);
        ran = new Random();
        calendar = Calendar.getInstance();
        soAcct = new SOrderAcct();
        sqLiteDatabase = dbHelper.getWritableDatabase();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        timeLineTime = mdformat.format(calendar.getTime());
        String names = uSurname + uFirstName;
        //long customerId = customer.getId();
        //Customer c = new Customer();
        String name = uSurname + "," + uFirstName;
        String managerFullNamesT = ManagerSurname + "," + managerFirstName;
        String namesT = uSurname + "," + uFirstName;

        String timelineDetailsTD = uSurname + "," + uFirstName + "was added as a Customer" + "by" + managerFullNamesT + "@" + timeLineTime;
        String tittleT1 = "Customer Sign Up Alert!";
        String timelineDetailsT11 = "You added" + uSurname + "," + uFirstName + "as a Customer" + "on" + timeLineTime;

        random = new SecureRandom();
        String accountName = uSurname + "," + uFirstName;


        birthdayID = random.nextInt((int) (Math.random() * 1001) + 1010);
        String skylightMFb = "E-Wallet";
        double accountBalance = 0.00;
        String interestRate = "0.0";

        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            dbHelper.openDataBase();
            profiles = dbHelper.getAllProfilesF();
        }
        TimeLine timeLine= new TimeLine(birthdayID,profileID1,tittleT1,timelineDetailsT11,joinedDate,"");


        if (managerProfile != null) {
            ManagerSurname = managerProfile.getProfileLastName();
            managerFirstName = managerProfile.getProfileFirstName();
            profileID = managerProfile.getProfileID();
            managerPhoneNumber1 = managerProfile.getProfilePhoneNumber();
            managerEmail = managerProfile.getProfileEmail();
            managerUserName = managerProfile.getProfileUserName();
            officePref = managerProfile.getProfileOffice();
            managerAddress = managerProfile.getProfileAddress();
            managerGender = managerProfile.getProfileGender();
            managerProfile.addTimeLine(timeLine);

        }
        int finalProfileID = profileID1;

        account = new Account(profileID1,accountName,virtualAccountNumber,0.00);
        standingOrderAcct = new SOrderAcct(profileID1,accountName,soAccountNumber , 0.00);
        birthday = new Birthday(birthdayID, profileID1, name, uPhoneNumber, uEmail, dateOfBirth, 0, "", "");
        userProfile = new Profile(profileID1, uSurname, uFirstName, uPhoneNumber, uEmail, dateOfBirth, selectedGender, uAddress, "", selectedState, "", joinedDate, "Customer", uUserName, uPassword, "pending", "");

        lastProfileUsed = userProfile;
        soAcct=standingOrderAcct;
        if(lastProfileUsed !=null){
            lastProfileUsed.setProfileAccount(account);
            lastProfileUsed.setProfileSOAcct(soAcct);

        }

        sqLiteDatabase = dbHelper.getWritableDatabase();
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            dbHelper.openDataBase();

            dbHelper.insertAccount(profileID1,accountName,virtualAccountNumber,0.00);
        }



        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            dbHelper.openDataBase();
            sqLiteDatabase = dbHelper.getWritableDatabase();
            dbHelper.saveNewProfile(lastProfileUsed,birthday);
        }
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            dbHelper.openDataBase();
            sqLiteDatabase = dbHelper.getWritableDatabase();
            dbHelper.insertTimeLine(profileID1,tittleT1, timelineDetailsTD, timeLineTime);
        }


        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            dbHelper.openDataBase();
            sqLiteDatabase = dbHelper.getWritableDatabase();
            dbHelper.insertSOAcct(profileID1,  accountName,soAccountNumber, 0.00);
        }
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            dbHelper.openDataBase();
            sqLiteDatabase = dbHelper.getWritableDatabase();
            dbHelper.insertInvAcct(profileID1, accountName, investmentAcctID,virtualAccountNumber, 0.00);
        }



    }
    public void verifyOTP(View view) {
        startProfileActivity(sponsorID,  account, standingOrderAcct, joinedDate, uFirstName, uSurname, uPhoneNumber, uAddress, uUserName, uPassword,  nIN, managerProfile, selectedGender,  selectedState, selectedCountry,birthday, dateOfBirth, profileID1, virtualAccountNumber, soAccountNumber, birthdayID, investmentAcctID,loanAcctID,userProfile);

    }


    public void sendOTPForProfile(View view) {
    }

    private void saveMyPreferences(int sponsorID, Account account, SOrderAcct standingOrderAcct, String joinedDate, String uFirstName, String uSurname, String uPhoneNumber, String uAddress, String uUserName, String uPassword, Profile customerProfile, String nIN, Profile managerProfile, String dateOfBirth, String selectedGender, String selectedCountry, String selectedState, Birthday birthday, String ofBirth, int profileID1, int virtualAccountNumber, int soAccountNumber, int birthdayID, int investmentAcctID, int loanAcctID) {
        Bundle userBundle = new Bundle();
        smsMessage = "Welcome to the Skylight  App, may you have the best experience";
        gson = new Gson();
        lastProfileUsed = customerProfile;
        json = gson.toJson(lastProfileUsed);
        sendSMSMessage22(uPhoneNumber, smsMessage);
        userBundle.putString(PROFILE_DOB, dateOfBirth);
        userBundle.putString(PROFILE_EMAIL, uEmail);
        userBundle.putString(PROFILE_OFFICE, "");
        userBundle.putString(PROFILE_FIRSTNAME, uFirstName);
        userBundle.putString(PROFILE_GENDER, selectedGender);
        userBundle.putString(PROFILE_COUNTRY, "");
        userBundle.putString(PROFILE_NEXT_OF_KINID, "");
        userBundle.putString(PROFILE_PHONE, uPhoneNumber);
        userBundle.putString(PROFILE_SURNAME, uSurname);
        userBundle.putString(PROFILE_PICTURE, String.valueOf(mImageUri));
        userBundle.putString(PROFILE_PASSWORD, uPassword);
        userBundle.putString(PROFILE_IDENTITY, nIN);
        userBundle.putString(PROFILE_STATE, selectedState);
        userBundle.putString(PROFILE_ROLE, "Profile");
        userBundle.putString(PROFILE_STATUS, "");
        userBundle.putString(PROFILE_USERNAME, uUserName);
        userBundle.putInt(PROFILE_ID, profileID1);
        userBundle.putString(PROFILE_DATE_JOINED, joinedDate);
        userBundle.putInt(PROF_SPONSOR_ID, sponsorID);
        sendTextMessage(uPhoneNumber, smsMessage);
        Intent intent = new Intent(SignUpAct.this, UserDashBoard.class);
        intent.putExtras(userBundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        Toast.makeText(SignUpAct.this, "Thank you" + "" +
                "for Signing up " + "" + uFirstName + "" + "on the Skylight. App", Toast.LENGTH_LONG).show();
        setResult(Activity.RESULT_OK, new Intent());

        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = userPreferences.edit();
        editor.putString("PROFILE_DOB", dateOfBirth);
        editor.putString("PROFILE_EMAIL", uEmail);
        editor.putString("PROFILE_OFFICE", "");
        editor.putString("PROFILE_FIRSTNAME", uFirstName);
        editor.putString("PROFILE_GENDER", selectedGender);
        editor.putString("PROFILE_COUNTRY", "");
        editor.putString("PROFILE_NEXT_OF_KIN", "");
        editor.putString("PROFILE_PHONE", uPhoneNumber);
        editor.putString("PROFILE_SURNAME", uSurname);
        editor.putString("PROFILE_PICTURE", String.valueOf(mImageUri));
        editor.putString("PROFILE_PASSWORD", uPassword);
        editor.putString("PROFILE_NIN", nIN);
        editor.putString("PROFILE_STATE", selectedState);
        editor.putString("PROFILE_ROLE", "Customer");
        editor.putString("PROFILE_STATUS", "Pending Approval");
        editor.putInt("PROFILE_ID", profileID1);
        editor.putString("PROFILE_DATE_JOINED", joinedDate);
        editor.putString("PROFILE_USERNAME", uUserName);
        editor.putString("PROFILE_ADDRESS", uAddress);
        editor.putString(PROFILE_DOB, dateOfBirth);
        editor.putString(PROFILE_EMAIL, uEmail);
        editor.putString(PROFILE_FIRSTNAME, uFirstName);
        editor.putString(PROFILE_GENDER, selectedGender);
        editor.putString(PROFILE_COUNTRY, "");
        editor.putString(PROFILE_NEXT_OF_KINID, "");
        editor.putString(PROFILE_PHONE, uPhoneNumber);
        editor.putString(PROFILE_SURNAME, uSurname);
        editor.putString(PROFILE_PASSWORD, uPassword);
        editor.putString(PROFILE_IDENTITY, "");
        editor.putString(PROFILE_ID_TYPE, "");
        editor.putString(PROFILE_DEVICE_ID, "");
        editor.putString(PROFILE_STATE, selectedState);
        editor.putString(PROFILE_ROLE, "Profile");
        editor.putString(PROFILE_STATUS, "");
        editor.putInt(PROFILE_ID, profileID1);
        editor.putString(PROFILE_DATE_JOINED, joinedDate);
        editor.putString(PROFILE_USERNAME, uUserName);
        editor.putString(PROFILE_PASSWORD, uPassword);
        editor.putString(PROFILE_SURNAME, uSurname);
        editor.putString(PROFILE_FIRSTNAME, uFirstName);
        editor.putString(PROFILE_PHONE, uPhoneNumber);
        editor.putString(PROFILE_EMAIL, uEmail);
        editor.putString(PROFILE_DOB, dateOfBirth);
        editor.putString(PROFILE_ADDRESS, uAddress);
        editor.putString(PROFILE_GENDER, selectedGender);
        editor.putString(PROFILE_STATE, selectedState);
        editor.putInt("EWalletID", virtualAccountNumber);
        editor.putInt("StandingOrderAcct", soAccountNumber);
        //editor.putLong("TransactionAcctID", transactionAcctID);
        editor.putInt("InvestmentAcctID", investmentAcctID);
        editor.putInt("LoanAcctID", loanAcctID);
        editor.putInt("PROFILE_ID", profileID1);
        editor.putString(PROFILE_ROLE, "Customer");
        editor.putString("LastProfileUsed", json).apply();

        customerProfile.setProfileFirstName(uFirstName);
        customerProfile.setProfileLastName(uSurname);
        customerProfile.setProfileAddress(uAddress);
        customerProfile.setProfileDob(dateOfBirth);
        customerProfile.setProfileDateJoined(joinedDate);
        customerProfile.setProfileEmail(uEmail);
        customerProfile.setProfilePhoneNumber(uPhoneNumber);
        customerProfile.setProfileGender(selectedGender);
        customerProfile.setProfileRole("Profile");
        customerProfile.setProfileUserName(uUserName);
        customerProfile.setProfileState(selectedState);
        customerProfile.setProfileSponsorID(profileID);
        customerProfile.setProfilePicture(mImageUri);


    }
    public void sendTextMessage(String uPhoneNumber, String smsMessage) {
        Bundle smsBundle = new Bundle();
        smsBundle.putString(PROFILE_PHONE, uPhoneNumber);
        smsBundle.putString("USER_PHONE", uPhoneNumber);
        smsBundle.putString("smsMessage", smsMessage);
        //smsBundle.putString("from", "Skylight Coop.");
        smsBundle.putString("to", uPhoneNumber);
        Intent otpIntent = new Intent(SignUpAct.this, SMSAct.class);
        otpIntent.putExtras(smsBundle);
        otpIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        setResult(RESULT_OK, otpIntent);
        //startActivity(itemPurchaseIntent);

    }
    public void sendSMSMessage22(String uPhoneNumber, String smsMessage) {
        Bundle smsBundle = new Bundle();
        smsBundle.putString(PROFILE_PHONE, uPhoneNumber);
        smsBundle.putString("USER_PHONE", uPhoneNumber);
        smsBundle.putString("smsMessage", smsMessage);
        //smsBundle.putString("from", "Skylight Coop.");
        smsBundle.putString("to", uPhoneNumber);
        Intent otpIntent = new Intent(SignUpAct.this, SMSAct.class);
        otpIntent.putExtras(smsBundle);
        otpIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        setResult(RESULT_OK, otpIntent);
        //startActivity(itemPurchaseIntent);

    }


    private void doOtpNotification(String tittle, String content, String ticker, AppCompatActivity signUpAct) {
        Bundle smsBundle = new Bundle();
        smsBundle.putString("tittle", tittle);
        smsBundle.putString("content", content);
        smsBundle.putString("ticker", ticker);
        smsBundle.putParcelable("signUpAct", (Parcelable) signUpAct);
        smsBundle.putString("to", otpPhoneNumber);
        Intent otpIntent = new Intent(SignUpAct.this, NotiAct.class);
        otpIntent.putExtras(smsBundle);
        otpIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }


    public boolean isPhoneNumberValid(String phoneNumber, String countryCode) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

        try {
            Phonenumber.PhoneNumber numberProto = phoneUtil.parse(phoneNumber, countryCode);
            return phoneUtil.isValidNumber(numberProto);
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }

        return false;
    }

    private void getSkylightRefferer(InstallReferrerClient referrerClient) {
        referrerClient.startConnection(new InstallReferrerStateListener() {
            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                switch (responseCode) {
                    case InstallReferrerClient.InstallReferrerResponse.OK:
                        ReferrerDetails response = null;
                        try {
                            response = referrerClient.getInstallReferrer();

                            String referrerUrl = response.getInstallReferrer();

                            long referrerClickTime = response.getReferrerClickTimestampSeconds();

                            long appInstallTime = response.getInstallBeginTimestampSeconds();

                            boolean instantExperienceLaunched = response.getGooglePlayInstantParam();

                            referrer = response.getInstallReferrer();

                            //refrerTV.setText("Referrer is : \n" + referrerUrl + "\n" + "Referrer Click Time is : " + referrerClickTime + "\nApp Install Time : " + appInstallTime);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED:
                        Toast.makeText(SignUpAct.this, "Feature not supported..", Toast.LENGTH_SHORT).show();
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE:
                        Toast.makeText(SignUpAct.this, "Fail to establish connection", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onInstallReferrerServiceDisconnected() {
                Toast.makeText(SignUpAct.this, "Service disconnected..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sendOTPMessage(String otpPhoneNumber, String otpMessage) {
        Bundle smsBundle = new Bundle();
        smsBundle.putString("PROFILE_PHONE", otpPhoneNumber);
        smsBundle.putString("USER_PHONE", otpPhoneNumber);
        smsBundle.putString("smsMessage", otpMessage);
        //smsBundle.putString("from", "Skylight");
        smsBundle.putString("to", otpPhoneNumber);
        Intent otpIntent = new Intent(SignUpAct.this, SMSAct.class);
        otpIntent.putExtras(smsBundle);
        otpIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //startActivity(itemPurchaseIntent);

    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }


    private void PrePopulateDB() {
        dbHelper = new DBHelper(this);
        userProfile1 = new Profile(234, "Emmanuel", "Becky", "08069524599", "urskylight@gmail.com", "1980-04-19", "female", "Skylight", "", "Rivers", "Elelenwo", "2022-04-19", "SuperAdmin", "Skylight4ever", "@Awajima2", "Confirmed", "");
        userProfile2 = new Profile(432, "Benedict", "Benedict", "08059250176", "bener@gmail.com", "25/04/1989", "male", "PH", "", "Rivers", "Elelenwo", "19/04/2022", "Customer", "Lumgwun", "@Awajima3", "Confirmed", "");

        sqLiteDatabase = dbHelper.getWritableDatabase();

        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            dbHelper.openDataBase();
            dbHelper.saveTestProfile(userProfile1);
        }
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            dbHelper.openDataBase();
            dbHelper.saveTestProfile(userProfile2);
        }


        /*if (DatabaseUtils.queryNumEntries(dbHelper.getWritableDatabase(),DATABASE_NAME) < 1) {


        }*/
    }


    @Override
    protected void onStart() {
        super.onStart();
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

    }
    @Override
    protected void onStop() {
        super.onStop();



    }




    private void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(true);//you can cancel it by pressing back button
        progressDialog.setMessage("signing up wait ...");
        progressBar.show();//displays the progress bar
    }

    private void onCaptureImageResult(Intent data) throws IOException {
        FileOutputStream fo = null;
        destination = null;
        if (data != null) {
            thumbnail = (Bitmap) data.getExtras().get("data");
        }
        if (thumbnail != null) {
            bytes = new ByteArrayOutputStream();
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
            destination = new File(Environment.getExternalStorageDirectory(),
                    System.currentTimeMillis() + ".jpg");


        }

        try {
            if (destination != null) {
                destination.createNewFile();
                fo = new FileOutputStream(destination);
                fo.write(bytes.toByteArray());
                fo.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (destination != null) {
            picturePath = destination.getAbsolutePath();
        }

        Glide.with(SignUpAct.this)
                .asBitmap()
                .load(destination)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.drawable.ic_alert)
                //.listener(listener)
                .skipMemoryCache(true)
                .fitCenter()
                .centerCrop()
                .into(profilePix);
    }

    protected void sendSMSMessage() {
        Bundle smsBundle = new Bundle();
        String smsMessage = uFirstName + "" + "Welcome to the Skylight  App, may you have the best experience";
        smsBundle.putString(PROFILE_PHONE, otpPhoneNumber);
        smsBundle.putString("USER_PHONE", otpPhoneNumber);
        smsBundle.putString("smsMessage", smsMessage);
        smsBundle.putString("from", "Skylight");
        smsBundle.putString("to", otpPhoneNumber);
        Intent itemPurchaseIntent = new Intent(SignUpAct.this, SMSAct.class);
        itemPurchaseIntent.putExtras(smsBundle);
        itemPurchaseIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //System.out.println(message2.getSid());;

    }


    public Bitmap getBitmap(String path) {
        Bitmap myBitmap = null;
        File imgFile = new File(path);
        if (imgFile.exists()) {
            myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        }
        return myBitmap;
    }

    private void setResultOk(Uri mImageUri) {
        Intent intent = new Intent();
        profilePix.setImageBitmap(getScaledBitmap(mImageUri));
        setResult(AppCompatActivity.RESULT_OK, intent);
        finish();
    }

    private void setResultCancelled() {
        Intent intent = new Intent();
        setResult(AppCompatActivity.RESULT_CANCELED, intent);
        finish();
    }


    public String getPath(Uri photoUri) {

        String filePath = "";
        if (photoUri != null) {
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(photoUri,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            filePath = cursor.getString(columnIndex);
            cursor.close();
        }
        return filePath;
    }

    private File getDir() {
        File sdDir = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return new File(sdDir, "LS Attachments");
    }

    private Bitmap getScaledBitmap(Uri uri) {
        Bitmap thumb = null;
        try {
            ContentResolver cr = getContentResolver();
            InputStream in = cr.openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;
            thumb = BitmapFactory.decodeStream(in, null, options);
        } catch (FileNotFoundException e) {
            Toast.makeText(SignUpAct.this, "File not found", Toast.LENGTH_SHORT).show();
        }
        return thumb;
    }

    public boolean hasInternetConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public boolean checkInternetConnection() {
        boolean hasInternetConnection = hasInternetConnection();
        if (!hasInternetConnection) {
            showWarningDialog("Internet connection failed");
        }

        return hasInternetConnection;
    }

    public void showWarningDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.button_ok, null);
        builder.show();
    }

    public void dobPicker(View view) {
        cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        newMonth = month + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(SignUpAct.this, R.style.DatePickerDialogStyle, mDateSetListener, day, month, year);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //make transparent background.
        dialog.show();
        dob = year + "-" + newMonth + "-" + day;
        dateOfBirth = day + "-" + newMonth + "-" + year;
        dobText.setText("Your date of Birth:" + dob);


    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


    public void doSelectPix(View view) {
    }
}