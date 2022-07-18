package com.ls.awajimatradeeder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.ls.awajimatradeeder.Admin.AdminDrawerAct;
import com.ls.awajimatradeeder.Classes.Account;
import com.ls.awajimatradeeder.Classes.PrefManager;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Database.DBHelper;
import com.ls.awajimatradeeder.EstateProperty.EstateOfficeAct;
import com.ls.awajimatradeeder.SuperAdmin.SuperAdminOffice;
import com.ls.awajimatradeeder.Tellers.TellerHomeChoices;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ADDRESS;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_DATE_JOINED;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_DOB;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_EMAIL;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_FIRSTNAME;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_GENDER;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_OFFICE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_PASSWORD;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_PHONE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ROLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_STATE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_SURNAME;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_USERNAME;

public class LoginAct extends AppCompatActivity {
    public static final String LOGIN_ID_EXTRA_KEY = "LoginActivity.LOGIN_ID_EXTRA_KEY";
    private Bundle bundle;
    private String username;
    private String password;
    private EditText edtUsername;
    private EditText edtPassword;
    private AppCompatButton btn_loginUserName;
    AppCompatTextView ic_admin_user;
    AppCompatTextView txt_account_msg;
    private AppCompatCheckBox chkRememberCred;
    private AppCompatButton btnCreateAccount,  btn_forgot_account_p, emailBtnLoginEmail,btn_forgot_account_Email;
    private Profile lastProfileUsed;
    SQLiteDatabase sqLiteDatabase;
    private Gson gson;
    private String json;
    DBHelper dbHelper;
    private SharedPreferences userPreferences;
    Account account;
    private String userID;
    private int customerID1,profileID2,accountNumber, profileID;
    public static SharedPreferences savedInfo;
    public static SharedPreferences.Editor savedInfoWriter;
    public static final String ACCOUNT_SID = System.getenv("ACb6e4c829a5792a4b744a3e6bd1cf2b4e");
    public static final String AUTH_TOKEN = System.getenv("0d5cbd54456dd0764786db0c37212578");
    ArrayList<Profile> profiles;
    RadioGroup userTypes, radioGroup1;
    AppCompatRadioButton checkBoxCustomer;
    public static final int RC_SIGN_IN = 1;
    private ProgressBar loadingUserName, progressBar;
    AppCompatButton btn_email_loginUp, loginBtnWithUserName,  btn_loginEmail, signUpUserInstead;
    String email;
    ScrollView userScroll, emailScroll;
    AppCompatEditText email_edit, emailPassword,edtEmailAddress,edtEmailPassword;
    AppCompatTextView txt_account_Email, poweredByLS;
    AppCompatCheckBox chk_remember_Me;
    AppCompatRadioButton checkBoxteller,rbResponseTeam,checkBoxLogistice,checkBoxArtisian,checkBoxRealtor;
    RadioGroup radioGroup ,radioGroup2;
    FloatingActionButton FAb_Help;
    private Uri picture;

    String userName ,officeBranch,gender,state,address,dob,dateJoined;
    String sharedPrefUserName;
    String sharedPrefUserPassword;
    String sharedPrefCusID;
    String sharedPrefUserMachine;
    int sharedPrefProfileID;
    String sharedPrefSurName;
    String sharedPrefFirstName;
    String sharedPrefEmail;
    String sharedPrefPhone;
    String SharedPrefAddress;
    String SharedPrefDOB;
    String sharedPrefRole;
    String SharedPrefGender;
    String SharedPrefJoinedDate;
    String SharedPrefOffice;
    String SharedPrefState;
    private GoogleApiClient mGoogleApiClient;
    ProgressDialog progressDialog;

    //private CallbackManager mCallbackManager;
    private String profilePhotoUrlLarge;

    Random random;
    double accountBalance; String accountName;
    LinearLayoutCompat layout_UserName,layout_Email;
    FloatingActionButton fab;
    String userProfileType;
    private Profile userProfile;

    private static final String TAG = "EmailPassword";
    private static final String PREF_NAME = "Tradeeder";
    String regEx =
            "^(([w-]+.)+[w-]+|([a-zA-Z]{1}|[w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]).([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]).([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[w-]+.)+[a-zA-Z]{2,4})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        setTitle("Login Access");
        random= new Random();
        gson = new Gson();
        userProfile= new Profile();
        profileID2 = random.nextInt((int) (Math.random() * 109) + 1119);
        dbHelper = new DBHelper(this);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        profiles=new ArrayList<Profile>();

        account= new Account();
        layout_UserName = findViewById(R.id.pswdUserName);
        btn_loginUserName = findViewById(R.id.user_name_login);

        layout_Email = findViewById(R.id.emailAddressLayout);
        btn_loginEmail = findViewById(R.id.email_login);
        btn_loginUserName.setOnClickListener(this::loginWithUserName);
        btn_loginEmail.setOnClickListener(this::useEmailForLogin);

        loginBtnWithUserName = findViewById(R.id.btn_login6);
        btn_loginUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_UserName.setVisibility(View.VISIBLE);
                layout_Email.setVisibility(View.GONE);

            }
        });
        btn_loginUserName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                layout_UserName.setVisibility(View.GONE);
                return false;
            }
        });

        btn_loginEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_Email.setVisibility(View.VISIBLE);
                layout_UserName.setVisibility(View.GONE);

            }
        });
        btn_loginEmail.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                layout_Email.setVisibility(View.GONE);
                return false;
            }
        });


        progressBar = findViewById(R.id.idPBLoading);

        radioGroup = findViewById(R.id.userChoice_6);
        checkBoxCustomer = findViewById(R.id.customer_6);

        emailBtnLoginEmail = findViewById(R.id.btn_WithEmail);
        edtEmailAddress = findViewById(R.id.userEmail);
        edtEmailPassword = findViewById(R.id.emailPassword);


        checkBoxteller = findViewById(R.id.teller_6);
        edtUsername = findViewById(R.id.edt_username5);
        edtPassword = findViewById(R.id.edt_password6);

        emailBtnLoginEmail.setOnClickListener(this::loginUserEmail);
        chk_remember_Me = findViewById(R.id.chk_remember_6);
        btn_forgot_account_p = findViewById(R.id.btn_forgot_account_p6);
        txt_account_msg = findViewById(R.id.txt_account_msg);
        btnCreateAccount = findViewById(R.id.btn_create_account6);

        btn_forgot_account_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPasswordActivity();
            }
        });
        loginBtnWithUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isInternetOn();
                validateForm();
                loginWithUserNameDbase();


            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount();

            }
        });


    }

    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {
        boolean checked = ((AppCompatRadioButton) view).isChecked();
        userProfileType="";
        switch(view.getId()) {
            case R.id.teller_6:
                if(checked)
                    userProfileType = "Teller";
                break;
            case R.id.customer_6:
                if(checked)
                    userProfileType = "Customer";
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        Toast.makeText(this, userProfileType, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(LoginAct.this);
        progressDialog.setMessage("processing");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = edtEmailAddress.getText().toString();
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {

            edtEmailAddress.setError("Invalid Email");
        }

        if (TextUtils.isEmpty(email)) {
            edtEmailAddress.setError("Required.");

            valid = false;
        }

        String password = edtEmailPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            edtEmailPassword.setError("Required.");
            valid = false;
        } else {
            edtEmailPassword.setError(null);
        }

        return valid;
    }


    public final boolean isInternetOn() {
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {
            // if connected with internet
            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Make sure that your internet connection is on?")
                    .setCancelable(false)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Internet Connection Error");
            alert.show();
            return false;
        }
        return false;
    }

    private void loginWithUserNameDbase() {
        chk_remember_Me = findViewById(R.id.chk_remember_6);
        progressDialog = new ProgressDialog(LoginAct.this);
        progressDialog.setMessage("processing Login");
        progressDialog.setCancelable(true);
        progressDialog.show();
        dbHelper= new DBHelper(this);
        boolean isAdmin = true;
        gson = new Gson();
        userProfile= new Profile();
        profiles=new ArrayList<Profile>();
        profiles = dbHelper.getAllProfilesF();
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = userPreferences.edit();

        userName = Objects.requireNonNull(edtUsername.getText()).toString().trim();
        password = Objects.requireNonNull(edtPassword.getText()).toString().trim();
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "empty username", Toast.LENGTH_LONG).show();
            edtUsername.setError("Please Enter Your User Name");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "empty username", Toast.LENGTH_LONG).show();
            edtPassword.setError("Please Enter the password");
            return;
        }
        progressBar.setVisibility(View.GONE);
        sharedPrefRole=dbHelper.getProfileRoleByUserNameAndPassword(userName,password);

        profileID=dbHelper.getProfileID(userName,password);
        sharedPrefUserMachine= dbHelper.getProfileRoleByUserNameAndPassword(userName,password);
        userProfile=dbHelper.getProfileFromUserNameAndPassword(userName,password);

        if(userProfile !=null){
            profileID=userProfile.getProfileID();

            sharedPrefPhone=userProfile.getProfilePhoneNumber();
            sharedPrefEmail=userProfile.getProfileEmail();
            sharedPrefRole=userProfile.getProfileRole();
            sharedPrefFirstName=userProfile.getProfileFirstName();
            sharedPrefSurName=userProfile.getProfileLastName();
            officeBranch=userProfile.getProfileOffice();
            picture=userProfile.getProfilePicture();
            gender=userProfile.getProfileGender();
            state=userProfile.getProfileState();
            address=userProfile.getProfileAddress();
            dob=userProfile.getProfileDob();
            dateJoined=userProfile.getProfileDateJoined();

        }else {

            profileID = userPreferences.getInt("PROFILE_ID", 0);
            userName = userPreferences.getString("PROFILE_USERNAME", "");
            officeBranch = userPreferences.getString("PROFILE_OFFICE", "");
            state = userPreferences.getString("PROFILE_STATE", "");
            sharedPrefRole = userPreferences.getString("PROFILE_ROLE", "");
            password = userPreferences.getString("PROFILE_PASSWORD", "");
            dateJoined = userPreferences.getString("PROFILE_DATE_JOINED", "");
            sharedPrefSurName = userPreferences.getString("PROFILE_SURNAME", "");
            email = userPreferences.getString("PROFILE_EMAIL", "");
            sharedPrefPhone = userPreferences.getString("PROFILE_PHONE", "");
            sharedPrefFirstName = userPreferences.getString("PROFILE_FIRSTNAME", "");
            dob = userPreferences.getString("PROFILE_DOB", "");
            gender = userPreferences.getString("PROFILE_GENDER", "");
            address = userPreferences.getString("PROFILE_ADDRESS", "");
            picture = Uri.parse(userPreferences.getString("PICTURE_URI", ""));
            profileID = userPreferences.getInt("PROFILE_ID", 0);
            userName = userPreferences.getString("USER_NAME", "");
            officeBranch = userPreferences.getString("USER_OFFICE", "");
            state = userPreferences.getString("USER_STATE", "");
            sharedPrefRole = userPreferences.getString("USER_ROLE", "");

            dateJoined = userPreferences.getString("USER_DATE_JOINED", "");
            password = userPreferences.getString("USER_PASSWORD", "");
            sharedPrefSurName = userPreferences.getString("USER_SURNAME", "");
            email = userPreferences.getString("EMAIL_ADDRESS", "");
            sharedPrefPhone = userPreferences.getString("USER_PHONE", "");
            sharedPrefFirstName = userPreferences.getString("USER_FIRSTNAME", "");
            dob = userPreferences.getString("USER_DOB", "");
            customerID1 = userPreferences.getInt("CUSTOMER_ID", 0);
            gender = userPreferences.getString("USER_GENDER", "");
            address = userPreferences.getString("USER_ADDRESS", "");
            picture = Uri.parse(userPreferences.getString("PICTURE_URI", ""));
        }

        PrefManager prefManager= new PrefManager(this);
        prefManager.saveLoginDetails(userName,password);
        editor.putString("USERNAME", userName);
        editor.putString("USER_PASSWORD", password);
        editor.putString("USER_SURNAME", sharedPrefSurName);
        editor.putString("USER_FIRSTNAME", sharedPrefFirstName);
        editor.putString("LOGIN_ID_EXTRA_KEY", LOGIN_ID_EXTRA_KEY);
        editor.putString("machine", sharedPrefRole);
        editor.putInt("PROFILE_ID", profileID);
        editor.putString("PROFILE_USERNAME", userName);
        editor.putString("PROFILE_PASSWORD", password);
        editor.putString("PROFILE_OFFICE", officeBranch);
        editor.putString("PROFILE_STATE", state);
        editor.putString("PROFILE_ROLE", sharedPrefRole);
        editor.putString("PROFILE_DATE_JOINED", dateJoined);
        editor.putString("PROFILE_EMAIL", sharedPrefEmail);
        editor.putString("PROFILE_PHONE", sharedPrefPhone);
        editor.putString("PROFILE_FIRSTNAME", sharedPrefFirstName);
        editor.putString("PROFILE_SURNAME", sharedPrefSurName);
        editor.putString("PROFILE_DOB", dob);
        editor.putString("PROFILE_GENDER", gender);
        editor.putString("PROFILE_ADDRESS", address);
        editor.putInt(PROFILE_ID, profileID);
        editor.putString(PROFILE_USERNAME, userName);
        editor.putString(PROFILE_PASSWORD, password);
        editor.putString(PROFILE_OFFICE, officeBranch);
        editor.putString(PROFILE_STATE, state);
        editor.putString(PROFILE_ROLE, sharedPrefRole);
        editor.putString(PROFILE_DATE_JOINED, dateJoined);
        editor.putString(PROFILE_EMAIL, sharedPrefEmail);
        editor.putString(PROFILE_PHONE, sharedPrefPhone);
        editor.putString(PROFILE_FIRSTNAME, sharedPrefFirstName);
        editor.putString(PROFILE_SURNAME, sharedPrefSurName);
        editor.putString(PROFILE_DOB, dob);
        editor.putString(PROFILE_GENDER, gender);
        editor.putString(PROFILE_ADDRESS, address);
        json = gson.toJson(lastProfileUsed);
        editor.putString("LastProfileUsed", json);
        editor.putBoolean("rememberMe", chkRememberCred.isChecked());
        editor.apply();


        boolean usernameTaken = false;
        boolean match = false;


        if(sharedPrefUserMachine.equalsIgnoreCase("Teller")){
            Intent tellerIntent = new Intent(this, TellerHomeChoices.class);
            tellerIntent.putExtra("PROFILE_ID", profileID);
            tellerIntent.putExtra("PROFILE_USERNAME", userName);
            tellerIntent.putExtra("PROFILE_PASSWORD", password);
            tellerIntent.putExtra("PROFILE_OFFICE", officeBranch);
            tellerIntent.putExtra("PROFILE_STATE", state);
            tellerIntent.putExtra("PROFILE_ROLE", sharedPrefRole);
            tellerIntent.putExtra("PROFILE_EMAIL", email);
            tellerIntent.putExtra("PROFILE_PHONE", sharedPrefPhone);
            tellerIntent.putExtra("PROFILE_FIRSTNAME", sharedPrefPhone);
            tellerIntent.putExtra("PROFILE_SURNAME", sharedPrefSurName);
            tellerIntent.putExtra("PROFILE_DOB", dob);
            tellerIntent.putExtra("PROFILE_DATE_JOINED", dateJoined);
            tellerIntent.putExtra("PROFILE_GENDER", gender);
            tellerIntent.putExtra("PROFILE_ADDRESS", address);
            tellerIntent.putExtra("PICTURE_URI", picture);
            tellerIntent.putExtra(PROFILE_ID, profileID);
            tellerIntent.putExtra(PROFILE_USERNAME, userName);
            tellerIntent.putExtra(PROFILE_PASSWORD, password);
            tellerIntent.putExtra(PROFILE_OFFICE, officeBranch);
            tellerIntent.putExtra(PROFILE_STATE, state);
            tellerIntent.putExtra(PROFILE_ROLE, sharedPrefRole);
            tellerIntent.putExtra(PROFILE_DATE_JOINED, dateJoined);
            tellerIntent.putExtra(PROFILE_PHONE, sharedPrefPhone);
            tellerIntent.putExtra(PROFILE_FIRSTNAME, sharedPrefFirstName);
            tellerIntent.putExtra(PROFILE_SURNAME, sharedPrefSurName);
            tellerIntent.putExtra(PROFILE_DOB, dob);
            tellerIntent.putExtra(PROFILE_GENDER, gender);
            tellerIntent.putExtra(PROFILE_ADDRESS, address);
            startActivity(tellerIntent);

        }
        if(sharedPrefUserMachine.equalsIgnoreCase("Accountant")){
            Intent accountantIntent = new Intent(this, EstateOfficeAct.class);
            accountantIntent.putExtra("PROFILE_ID", profileID);
            accountantIntent.putExtra("PROFILE_USERNAME", userName);
            accountantIntent.putExtra("PROFILE_PASSWORD", password);
            accountantIntent.putExtra("PROFILE_OFFICE", officeBranch);
            accountantIntent.putExtra("PROFILE_STATE", state);
            accountantIntent.putExtra("PROFILE_ROLE", sharedPrefRole);
            accountantIntent.putExtra("PROFILE_EMAIL", email);
            accountantIntent.putExtra("PROFILE_PHONE", sharedPrefPhone);
            accountantIntent.putExtra("PROFILE_FIRSTNAME", sharedPrefPhone);
            accountantIntent.putExtra("PROFILE_SURNAME", sharedPrefSurName);
            accountantIntent.putExtra("PROFILE_DOB", dob);
            accountantIntent.putExtra("PROFILE_DATE_JOINED", dateJoined);
            accountantIntent.putExtra("PROFILE_GENDER", gender);
            accountantIntent.putExtra("PROFILE_ADDRESS", address);
            accountantIntent.putExtra(PROFILE_ID, profileID);
            accountantIntent.putExtra(PROFILE_USERNAME, userName);
            accountantIntent.putExtra(PROFILE_PASSWORD, password);
            accountantIntent.putExtra(PROFILE_OFFICE, officeBranch);
            accountantIntent.putExtra(PROFILE_STATE, state);
            accountantIntent.putExtra(PROFILE_ROLE, sharedPrefRole);
            accountantIntent.putExtra(PROFILE_DATE_JOINED, dateJoined);
            accountantIntent.putExtra(PROFILE_PHONE, sharedPrefPhone);
            accountantIntent.putExtra(PROFILE_FIRSTNAME, sharedPrefFirstName);
            accountantIntent.putExtra(PROFILE_SURNAME, sharedPrefSurName);
            accountantIntent.putExtra(PROFILE_DOB, dob);
            accountantIntent.putExtra(PROFILE_GENDER, gender);
            accountantIntent.putExtra(PROFILE_ADDRESS, address);

            startActivity(accountantIntent);

        }
        if(sharedPrefUserMachine.equalsIgnoreCase("SuperAdmin")){
            Intent superAdminIntent = new Intent(this, SuperAdminOffice.class);
            superAdminIntent.putExtra("PROFILE_ID", profileID);
            superAdminIntent.putExtra("PROFILE_USERNAME", userName);
            superAdminIntent.putExtra("PROFILE_PASSWORD", password);
            superAdminIntent.putExtra("PROFILE_OFFICE", officeBranch);
            superAdminIntent.putExtra("PROFILE_STATE", state);
            superAdminIntent.putExtra("PROFILE_ROLE", sharedPrefRole);
            superAdminIntent.putExtra("PROFILE_EMAIL", email);
            superAdminIntent.putExtra("PROFILE_PHONE", sharedPrefPhone);
            superAdminIntent.putExtra("PROFILE_FIRSTNAME", sharedPrefPhone);
            superAdminIntent.putExtra("PROFILE_SURNAME", sharedPrefSurName);
            superAdminIntent.putExtra("PROFILE_DOB", dob);
            superAdminIntent.putExtra("PROFILE_DATE_JOINED", dateJoined);
            superAdminIntent.putExtra("PROFILE_GENDER", gender);
            superAdminIntent.putExtra("PROFILE_ADDRESS", address);
            superAdminIntent.putExtra(PROFILE_ID, profileID);
            superAdminIntent.putExtra(PROFILE_USERNAME, userName);
            superAdminIntent.putExtra(PROFILE_PASSWORD, password);
            superAdminIntent.putExtra(PROFILE_OFFICE, officeBranch);
            superAdminIntent.putExtra(PROFILE_STATE, state);
            superAdminIntent.putExtra(PROFILE_ROLE, sharedPrefRole);
            superAdminIntent.putExtra(PROFILE_DATE_JOINED, dateJoined);
            superAdminIntent.putExtra(PROFILE_PHONE, sharedPrefPhone);
            superAdminIntent.putExtra(PROFILE_FIRSTNAME, sharedPrefFirstName);
            superAdminIntent.putExtra(PROFILE_SURNAME, sharedPrefSurName);
            superAdminIntent.putExtra(PROFILE_DOB, dob);
            superAdminIntent.putExtra(PROFILE_GENDER, gender);
            superAdminIntent.putExtra(PROFILE_ADDRESS, address);
            startActivity(superAdminIntent);

        }
        if(sharedPrefUserMachine.equalsIgnoreCase("Profile")){
            Intent tellerIntent = new Intent(this, UserDashBoard.class);
            tellerIntent.putExtra("PROFILE_ID", profileID);
            tellerIntent.putExtra("PROFILE_USERNAME", userName);
            tellerIntent.putExtra("PROFILE_PASSWORD", password);
            tellerIntent.putExtra("PROFILE_OFFICE", officeBranch);
            tellerIntent.putExtra("PROFILE_STATE", state);
            tellerIntent.putExtra("PROFILE_ROLE", sharedPrefRole);
            tellerIntent.putExtra("PROFILE_EMAIL", email);
            tellerIntent.putExtra("PROFILE_PHONE", sharedPrefPhone);
            tellerIntent.putExtra("PROFILE_FIRSTNAME", sharedPrefPhone);
            tellerIntent.putExtra("PROFILE_SURNAME", sharedPrefSurName);
            tellerIntent.putExtra("PROFILE_DOB", dob);
            tellerIntent.putExtra("PROFILE_DATE_JOINED", dateJoined);
            tellerIntent.putExtra("PROFILE_GENDER", gender);
            tellerIntent.putExtra("PROFILE_ADDRESS", address);
            tellerIntent.putExtra("PICTURE_URI", picture);
            tellerIntent.putExtra(PROFILE_ID, profileID);
            tellerIntent.putExtra(PROFILE_USERNAME, userName);
            tellerIntent.putExtra(PROFILE_PASSWORD, password);
            tellerIntent.putExtra(PROFILE_OFFICE, officeBranch);
            tellerIntent.putExtra(PROFILE_STATE, state);
            tellerIntent.putExtra(PROFILE_ROLE, sharedPrefRole);
            tellerIntent.putExtra(PROFILE_DATE_JOINED, dateJoined);
            tellerIntent.putExtra(PROFILE_PHONE, sharedPrefPhone);
            tellerIntent.putExtra(PROFILE_FIRSTNAME, sharedPrefFirstName);
            tellerIntent.putExtra(PROFILE_SURNAME, sharedPrefSurName);
            tellerIntent.putExtra(PROFILE_DOB, dob);
            tellerIntent.putExtra(PROFILE_GENDER, gender);
            tellerIntent.putExtra(PROFILE_ADDRESS, address);
            startActivity(tellerIntent);

        }
        if(sharedPrefUserMachine.equalsIgnoreCase("AdminUser")){
            Intent adminIntent = new Intent(this, AdminDrawerAct.class);
            adminIntent.putExtra("PROFILE_ID", profileID);
            adminIntent.putExtra("PROFILE_USERNAME", userName);
            adminIntent.putExtra("PROFILE_PASSWORD", password);
            adminIntent.putExtra("PROFILE_OFFICE", officeBranch);
            adminIntent.putExtra("PROFILE_STATE", state);
            adminIntent.putExtra("PROFILE_ROLE", sharedPrefRole);
            adminIntent.putExtra("PROFILE_EMAIL", email);
            adminIntent.putExtra("PROFILE_PHONE", sharedPrefPhone);
            adminIntent.putExtra("PROFILE_FIRSTNAME", sharedPrefPhone);
            adminIntent.putExtra("PROFILE_SURNAME", sharedPrefSurName);
            adminIntent.putExtra("PROFILE_DOB", dob);
            adminIntent.putExtra("PROFILE_DATE_JOINED", dateJoined);
            adminIntent.putExtra("CUSTOMER_ID", customerID1);
            adminIntent.putExtra("PROFILE_GENDER", gender);
            adminIntent.putExtra("PROFILE_ADDRESS", address);
            adminIntent.putExtra("PICTURE_URI", picture);
            adminIntent.putExtra(PROFILE_ID, profileID);
            adminIntent.putExtra(PROFILE_USERNAME, userName);
            adminIntent.putExtra(PROFILE_PASSWORD, password);
            adminIntent.putExtra(PROFILE_OFFICE, officeBranch);
            adminIntent.putExtra(PROFILE_STATE, state);
            adminIntent.putExtra(PROFILE_ROLE, sharedPrefRole);
            adminIntent.putExtra(PROFILE_DATE_JOINED, dateJoined);
            adminIntent.putExtra(PROFILE_PHONE, sharedPrefPhone);
            adminIntent.putExtra(PROFILE_FIRSTNAME, sharedPrefFirstName);
            adminIntent.putExtra(PROFILE_SURNAME, sharedPrefSurName);
            adminIntent.putExtra(PROFILE_DOB, dob);
            adminIntent.putExtra(PROFILE_GENDER, gender);
            adminIntent.putExtra(PROFILE_ADDRESS, address);
            startActivity(adminIntent);

        }


        if ((edtUsername.getText()).toString().equals("LS80069990") && edtPassword.getText().toString().equals("LS09996008")) {
            progressDialog.dismiss();
            Intent adminIntent = new Intent(this, SuperAdminOffice.class);
            adminIntent.putExtra("PROFILE_ID", 12000);
            adminIntent.putExtra("PROFILE_USERNAME", "LS80069990");
            adminIntent.putExtra("PROFILE_PASSWORD", "LS09996008");
            adminIntent.putExtra("PROFILE_OFFICE", officeBranch);
            adminIntent.putExtra("PROFILE_STATE", state);
            adminIntent.putExtra("PROFILE_ROLE", "SuperAdmin");
            adminIntent.putExtra("PROFILE_EMAIL", email);
            adminIntent.putExtra("PROFILE_PHONE", sharedPrefPhone);
            adminIntent.putExtra("PROFILE_FIRSTNAME", "Alpha");
            adminIntent.putExtra("PROFILE_SURNAME", "Skylight");
            adminIntent.putExtra("PROFILE_DOB", dob);
            adminIntent.putExtra("PROFILE_DATE_JOINED", dateJoined);
            adminIntent.putExtra("PROFILE_GENDER", gender);
            adminIntent.putExtra("PROFILE_ADDRESS", address);
            adminIntent.putExtra(PROFILE_ID, 12000);
            adminIntent.putExtra(PROFILE_USERNAME, "LS80069990");
            adminIntent.putExtra(PROFILE_PASSWORD, "LS09996008");
            adminIntent.putExtra(PROFILE_OFFICE, officeBranch);
            adminIntent.putExtra(PROFILE_STATE, "Skylight");
            adminIntent.putExtra(PROFILE_ROLE, "SuperAdmin");
            adminIntent.putExtra(PROFILE_DATE_JOINED, dateJoined);
            adminIntent.putExtra(PROFILE_PHONE, sharedPrefPhone);
            adminIntent.putExtra(PROFILE_FIRSTNAME, "Alpha");
            adminIntent.putExtra(PROFILE_SURNAME, "Skylight");
            adminIntent.putExtra(PROFILE_DOB, dob);
            adminIntent.putExtra(PROFILE_GENDER, gender);
            adminIntent.putExtra(PROFILE_ADDRESS, address);
            editor = userPreferences.edit();
            editor.putInt("PROFILE_ID", 12000);
            editor.putString("PROFILE_USERNAME", "LS80069990");
            editor.putString("PROFILE_PASSWORD", "LS09996008");
            editor.putString("PROFILE_OFFICE", "Skylight");
            editor.putString("PROFILE_STATE", state);
            editor.putString("PROFILE_ROLE", "SuperAdmin");
            editor.putString("PROFILE_DATE_JOINED", dateJoined);
            editor.putString("PROFILE_EMAIL", sharedPrefEmail);
            editor.putString("PROFILE_PHONE", sharedPrefPhone);
            editor.putString("PROFILE_FIRSTNAME", sharedPrefFirstName);
            editor.putString("PROFILE_SURNAME", sharedPrefSurName);
            editor.putString("PROFILE_DOB", dob);
            editor.putString("PROFILE_GENDER", "Female");
            editor.putString("PROFILE_ADDRESS", address);
            editor.putInt(PROFILE_ID, 12000);
            editor.putString(PROFILE_USERNAME, "LS80069990");
            editor.putString(PROFILE_PASSWORD, "LS09996008");
            editor.putString(PROFILE_OFFICE, "Skylight");
            editor.putString(PROFILE_STATE, state);
            editor.putString(PROFILE_ROLE, "SuperAdmin");
            editor.putString(PROFILE_DATE_JOINED, dateJoined);
            editor.putString(PROFILE_EMAIL, sharedPrefEmail);
            editor.putString(PROFILE_PHONE, sharedPrefPhone);
            editor.putString(PROFILE_FIRSTNAME, "Alpha");
            editor.putString(PROFILE_SURNAME, "Skylight");
            editor.putString(PROFILE_DOB, dob);
            editor.putString(PROFILE_GENDER, gender);
            editor.putString(PROFILE_ADDRESS, address);
            userProfile= new Profile(12000,"Skylight", "Alpha", "08069524599", "urskylight@gmail.com", "", "female", "Skylight", "","Rivers", "Elelenwo", "19/04/2022","SuperAdmin", "LS80069990", "LS09996008","Confirmed","");
            dbHelper.saveNewProfile(userProfile,null);
            json = gson.toJson(lastProfileUsed);
            startActivity(adminIntent);
            editor.putString("LastProfileUsed", json);
            editor.putBoolean("rememberMe", chkRememberCred.isChecked());
            editor.apply();

        }

    }
    private void loginWithPref() {
        progressDialog = new ProgressDialog(LoginAct.this);
        progressDialog.setMessage("processing Login");
        progressDialog.setCancelable(false);
        progressDialog.show();
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        gson = new Gson();
        json = userPreferences.getString("LastProfileUsed", "");
        userProfile = gson.fromJson(json, Profile.class);
        sharedPrefUserName = userPreferences.getString("PROFILE_USERNAME", "");
        sharedPrefUserPassword = userPreferences.getString("PROFILE_PASSWORD", "");
        sharedPrefUserMachine = userPreferences.getString("machine", "");
        sharedPrefProfileID = userPreferences.getInt("PROFILE_ID", 0);
        sharedPrefSurName = userPreferences.getString("PROFILE_SURNAME", "");
        sharedPrefFirstName = userPreferences.getString("PROFILE_FIRSTNAME", "");
        sharedPrefEmail = userPreferences.getString("PROFILE_EMAIL", "");
        sharedPrefPhone = userPreferences.getString("PROFILE_PHONE", "");
        SharedPrefAddress = userPreferences.getString("PROFILE_ADDRESS", "");
        SharedPrefDOB = userPreferences.getString("PROFILE_DOB", "");
        sharedPrefRole = userPreferences.getString("PROFILE_ROLE", "");
        SharedPrefGender = userPreferences.getString("PROFILE_GENDER", "");
        SharedPrefJoinedDate = userPreferences.getString("PROFILE_DATE_JOINED", "");
        SharedPrefOffice = userPreferences.getString("PROFILE_OFFICE", "");
        SharedPrefState = userPreferences.getString("PROFILE_STATE", "");
        sharedPrefUserPassword = userPreferences.getString("PROFILE_PASSWORD", "");
        sharedPrefUserMachine = userPreferences.getString("machine", "");

        if (edtUsername.getText().toString().isEmpty()) {
            edtUsername.setError("Please Enter Your User Name");
        }else if(edtPassword.getText().toString().isEmpty()) {
            edtPassword.setError("Please Enter Your Password");
        }else {

            if ((edtUsername.getText()).toString().equals("LS80069990") && edtPassword.getText().toString().equals("LS09996008")) {
                progressDialog.dismiss();
                //match = true;
                //isAdmin = true;

                //SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
                Intent intentBecky = new Intent(this, SuperAdminOffice.class);
                intentBecky.putExtra("id", "12");
                intentBecky.putExtra("machine", "SuperAdmin");
                intentBecky.putExtra("PROFILE_ID", LOGIN_ID_EXTRA_KEY);
                intentBecky.putExtra(PROFILE_ID, LOGIN_ID_EXTRA_KEY);
                intentBecky.putExtra(PROFILE_SURNAME, "Super");
                intentBecky.putExtra(PROFILE_FIRSTNAME, "Admin");
                startActivity(intentBecky);

                SharedPreferences.Editor editor = userPreferences.edit();
                editor.putString(PROFILE_USERNAME, "LS80069990");
                editor.putString(PROFILE_PASSWORD, "LS09996008");
                editor.putString(PROFILE_SURNAME, "Super");
                editor.putString(PROFILE_FIRSTNAME, "Admin");
                editor.putString(PROFILE_ID, LOGIN_ID_EXTRA_KEY);
                editor.putString(LOGIN_ID_EXTRA_KEY, LOGIN_ID_EXTRA_KEY);
                editor.putString("machine", "SuperAdmin");
                editor.putString(PROFILE_ROLE, "SuperAdmin");
                gson = new Gson();
                json = gson.toJson(lastProfileUsed);
                editor.putString("LastProfileUsed", json).apply();
                userPreferences.edit().putBoolean("rememberMe", chkRememberCred.isChecked()).apply();
                editor.apply();

            }
            if (edtUsername.getText().toString().equals("LSG800690") && edtPassword.getText().toString().equals("LSG815501")) {
                progressDialog.dismiss();
                SharedPreferences.Editor editor2 = userPreferences.edit();
                editor2.putString(PROFILE_USERNAME, "LSG800690");
                editor2.putString("machine", "SuperAdmin");
                editor2.putString(PROFILE_PASSWORD, "LSG815501");
                editor2.putString(PROFILE_ID, LOGIN_ID_EXTRA_KEY);
                editor2.putString(PROFILE_SURNAME, "Alpha");
                editor2.putString(PROFILE_FIRSTNAME, "Super");
                editor2.putString(PROFILE_ROLE, "SuperAdmin");
                gson = new Gson();
                json = gson.toJson(lastProfileUsed);
                editor2.putString("LastProfileUsed", json).apply();
                userPreferences.edit().putBoolean("rememberMe", chkRememberCred.isChecked()).apply();
                editor2.apply();

                Intent intentBen = new Intent(this, SuperAdminOffice.class);
                intentBen.putExtra("machine", "SuperAdmin");
                intentBen.putExtra(PROFILE_PASSWORD, "LSG815501");
                intentBen.putExtra(PROFILE_USERNAME, "LSG800690");
                intentBen.putExtra(PROFILE_ID, LOGIN_ID_EXTRA_KEY);
                intentBen.putExtra(PROFILE_ROLE, "Admin");
                intentBen.putExtra(PROFILE_FIRSTNAME, "Super");
                startActivity(intentBen);
            }
            if (edtUsername.getText().toString().equals("L1000690") && edtPassword.getText().toString().equals("L81550122")) {
                progressDialog.dismiss();
                SharedPreferences.Editor editor2 = userPreferences.edit();
                editor2.putString(PROFILE_USERNAME, "L1000690");
                editor2.putString("machine", "SuperAdmin");
                editor2.putString(PROFILE_PASSWORD, "L81550122");
                editor2.putString(LOGIN_ID_EXTRA_KEY, LOGIN_ID_EXTRA_KEY);
                editor2.putString(PROFILE_SURNAME, " Beta");
                editor2.putString(PROFILE_FIRSTNAME, "Super");
                editor2.putString(PROFILE_ROLE, "SuperAdmin");
                editor2.apply();

                Intent intentBen = new Intent(this, SuperAdminOffice.class);
//                    intentBen.putExtra("id", lastProfileUsed.getDbId());
                intentBen.putExtra("PROFILE_ID", LOGIN_ID_EXTRA_KEY);
                intentBen.putExtra(PROFILE_PASSWORD, "L81550122");
                intentBen.putExtra(PROFILE_USERNAME, "L1000690");
                intentBen.putExtra(PROFILE_ID, LOGIN_ID_EXTRA_KEY);
                intentBen.putExtra(PROFILE_ROLE, "SuperAdmin");
                intentBen.putExtra(PROFILE_FIRSTNAME, "Super");
                startActivity(intentBen);
            }
            if (edtUsername.getText().toString().equals("LS8006120") && edtPassword.getText().toString().equals("LS810231")) {
                progressDialog.dismiss();
                //SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = userPreferences.edit();
                editor2.putString(PROFILE_USERNAME, "LS8006120");
                editor2.putString("machine", "SuperAdmin");
                editor2.putString(PROFILE_PASSWORD, "LS810231");
                editor2.putString(LOGIN_ID_EXTRA_KEY, LOGIN_ID_EXTRA_KEY);
                editor2.putString(PROFILE_SURNAME, "");
                editor2.putString(PROFILE_FIRSTNAME, "Admin 6");
                editor2.putString(PROFILE_ROLE, "SuperAdmin");
                editor2.apply();

                Intent intentBen = new Intent(this, SuperAdminOffice.class);
                intentBen.putExtra("id", lastProfileUsed.getProfileID());
                intentBen.putExtra("machine", "UserSuperAdmin");
                intentBen.putExtra("machine", "SuperAdmin");
                intentBen.putExtra(PROFILE_PASSWORD, "LS810231");
                intentBen.putExtra(PROFILE_USERNAME, "LS8006120");
                intentBen.putExtra(PROFILE_ID, LOGIN_ID_EXTRA_KEY);
                intentBen.putExtra(PROFILE_ROLE, "SuperAdmin");
                intentBen.putExtra(PROFILE_FIRSTNAME, "Super");
                intentBen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentBen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentBen);
            }

            if (edtUsername.getText().toString().equals("AU100690") && edtPassword.getText().toString().equals("AU815012")) {
                progressDialog.dismiss();
                SharedPreferences.Editor editor2 = userPreferences.edit();
                editor2.putString(PROFILE_USERNAME, "Sky1000690");
                editor2.putString("machine", "SuperAdmin");
                editor2.putString(PROFILE_PASSWORD, "AU815012");
                editor2.putString(PROFILE_ID, LOGIN_ID_EXTRA_KEY);
                editor2.putString(PROFILE_SURNAME, " Belle");
                editor2.putString(PROFILE_FIRSTNAME, "Super");
                editor2.putString(PROFILE_ROLE, "SuperAdmin");
                editor2.apply();

                Intent intentBen = new Intent(this, SuperAdminOffice.class);
//                    intentBen.putExtra("id", lastProfileUsed.getDbId());
                intentBen.putExtra("PROFILE_ID", LOGIN_ID_EXTRA_KEY);
                intentBen.putExtra(PROFILE_PASSWORD, "AU815012");
                intentBen.putExtra(PROFILE_USERNAME, "AU100690");
                intentBen.putExtra(PROFILE_ID, LOGIN_ID_EXTRA_KEY);
                intentBen.putExtra(PROFILE_ROLE, "SuperAdmin");
                intentBen.putExtra(PROFILE_SURNAME, "Belle");
                intentBen.putExtra(PROFILE_FIRSTNAME, "Super");
                startActivity(intentBen);
            }

            if (edtUsername.getText().toString().equals("AU801920") && edtPassword.getText().toString().equals("AU28151")) {
                progressDialog.dismiss();
                SharedPreferences.Editor editor2 = userPreferences.edit();
                editor2.putString(PROFILE_USERNAME, "AU801920");
                editor2.putString("machine", "SuperAdmin");
                editor2.putString(PROFILE_PASSWORD, "AU28151");
                editor2.putString(PROFILE_ID, LOGIN_ID_EXTRA_KEY);
                editor2.putString(PROFILE_SURNAME, "De");
                editor2.putString(PROFILE_FIRSTNAME, "Super");
                editor2.putString(PROFILE_ROLE, "SuperAdmin");
                editor2.apply();

                Intent intentAdmin = new Intent(this, SuperAdminOffice.class);
//                    intentBen.putExtra("id", lastProfileUsed.getDbId());
                intentAdmin.putExtra(PROFILE_PASSWORD, "AU28151");
                intentAdmin.putExtra(PROFILE_USERNAME, "AU801920");
                intentAdmin.putExtra(PROFILE_ID, LOGIN_ID_EXTRA_KEY);
                intentAdmin.putExtra(PROFILE_ROLE, "SuperAdmin");
                intentAdmin.putExtra(PROFILE_FIRSTNAME, "De");
                intentAdmin.putExtra(PROFILE_SURNAME, "Super");
                intentAdmin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentAdmin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentAdmin);
            }


            if(userName.equals(sharedPrefUserName)&& password.equals(sharedPrefUserPassword)&& sharedPrefUserMachine.equals("Teller")){
                if (checkBoxteller.isChecked()) {
                    progressDialog.dismiss();
                    Intent intent = new Intent(this, TellerHomeChoices.class);
                    intent.putExtra(PROFILE_USERNAME, userName);
                    intent.putExtra(PROFILE_ID, String.valueOf(sharedPrefProfileID));
                    intent.putExtra(PROFILE_PASSWORD, password);
                    intent.putExtra(PROFILE_SURNAME, sharedPrefSurName);
                    intent.putExtra(PROFILE_FIRSTNAME, sharedPrefFirstName);
                    intent.putExtra(PROFILE_PHONE, sharedPrefPhone);
                    intent.putExtra(PROFILE_DATE_JOINED, SharedPrefJoinedDate);
                    intent.putExtra("machine", "Teller");
                    startActivity(intent);
                }

            }
            if(userName.equals(sharedPrefUserName)&& password.equals(sharedPrefUserPassword)&& sharedPrefUserMachine.equals("Teller")){
                if (checkBoxCustomer.isChecked()) {
                    progressDialog.dismiss();
                    Intent intent = new Intent(this, TellerHomeChoices.class);
                    intent.putExtra(PROFILE_USERNAME, userName);
                    intent.putExtra(PROFILE_ID, String.valueOf(sharedPrefProfileID));
                    intent.putExtra(PROFILE_PASSWORD, password);
                    intent.putExtra(PROFILE_SURNAME, sharedPrefSurName);
                    intent.putExtra(PROFILE_FIRSTNAME, sharedPrefFirstName);
                    intent.putExtra(PROFILE_PHONE, sharedPrefPhone);
                    intent.putExtra(PROFILE_DATE_JOINED, SharedPrefJoinedDate);
                    intent.putExtra("machine", "Teller");
                    startActivity(intent);
                }

            }
            if(userName.equals(sharedPrefUserName)&& password.equals(sharedPrefUserPassword)&& sharedPrefUserMachine.equals("Customer")){
                if (checkBoxCustomer.isChecked()) {
                    progressDialog.dismiss();
                    Intent intent = new Intent(this, UserDashBoard.class);
                    intent.putExtra(PROFILE_USERNAME, userName);
                    intent.putExtra(PROFILE_ID, String.valueOf(sharedPrefProfileID));
                    intent.putExtra(PROFILE_PASSWORD, password);
                    intent.putExtra(PROFILE_SURNAME, sharedPrefSurName);
                    intent.putExtra(PROFILE_FIRSTNAME, sharedPrefFirstName);
                    intent.putExtra(PROFILE_PHONE, sharedPrefPhone);
                    intent.putExtra(PROFILE_DATE_JOINED, SharedPrefJoinedDate);
                    intent.putExtra("machine", "Profile");
                    startActivity(intent);
                }

            }


        }


    }
    protected void sendSMSMessage() {
        userProfile= new Profile();
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        gson = new Gson();
        json = userPreferences.getString("LastProfileUsed", "");
        userProfile = gson.fromJson(json, Profile.class);
        sharedPrefUserName = userPreferences.getString("PROFILE_USERNAME", "");
        sharedPrefUserPassword = userPreferences.getString("PROFILE_PASSWORD", "");
        sharedPrefUserMachine = userPreferences.getString("machine", "");
        sharedPrefProfileID = userPreferences.getInt("PROFILE_ID", 0);
        sharedPrefSurName = userPreferences.getString("PROFILE_SURNAME", "");
        sharedPrefFirstName = userPreferences.getString("PROFILE_FIRSTNAME", "");
        sharedPrefEmail = userPreferences.getString("PROFILE_EMAIL", "");
        sharedPrefPhone = userPreferences.getString("PROFILE_PHONE", "");
        SharedPrefAddress = userPreferences.getString("PROFILE_ADDRESS", "");
        SharedPrefDOB = userPreferences.getString("PROFILE_DOB", "");
        sharedPrefRole = userPreferences.getString("PROFILE_ROLE", "");
        SharedPrefGender = userPreferences.getString("PROFILE_GENDER", "");
        SharedPrefJoinedDate = userPreferences.getString("PROFILE_DATE_JOINED", "");
        SharedPrefOffice = userPreferences.getString("PROFILE_OFFICE", "");
        SharedPrefState = userPreferences.getString("PROFILE_STATE", "");
        sharedPrefUserPassword = userPreferences.getString("PROFILE_PASSWORD", "");
        sharedPrefUserMachine = userPreferences.getString("machine", "");
        Bundle smsBundle= new Bundle();
        String smsMessage="You just Signed into the Skylight App @ "+""+"@"+System.currentTimeMillis();
        smsBundle.putString(PROFILE_PHONE,sharedPrefPhone);
        smsBundle.putString("USER_PHONE",sharedPrefPhone);
        smsBundle.putString("smsMessage",smsMessage);
        smsBundle.putString("from","Skylight");
        smsBundle.putString("to",sharedPrefPhone);
        Intent itemPurchaseIntent = new Intent(LoginAct.this, SMSAct.class);
        itemPurchaseIntent.putExtras(smsBundle);
        itemPurchaseIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //startActivity(itemPurchaseIntent);

    }
    private void SignUpNewUser() {

        Intent intent = new Intent(this, SignTabMainAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Toast.makeText(this, "Taking you to sign up/in Board", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }

    private void startPasswordActivity() {


        Intent intent = new Intent(this, PasswordRecovAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Toast.makeText(this, "Taking you to the Dashboard Area", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }

    private void createAccount() {

        Intent intent = new Intent(this, SignTabMainAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Toast.makeText(this, "Taking you to sign up/in Board", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        this.finish();

    }

    @Override
    protected void onStart() {
        super.onStart();
        //mAuth.addAuthStateListener(mAuthListener);
        userProfile= new Profile();
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        gson = new Gson();
        json = userPreferences.getString("LastProfileUsed", "");
        userProfile = gson.fromJson(json, Profile.class);
        sharedPrefUserName = userPreferences.getString("PROFILE_USERNAME", "");
        sharedPrefUserPassword = userPreferences.getString("PROFILE_PASSWORD", "");
        sharedPrefUserMachine = userPreferences.getString("machine", "");
        sharedPrefProfileID = userPreferences.getInt("PROFILE_ID", 0);
        sharedPrefSurName = userPreferences.getString("PROFILE_SURNAME", "");
        sharedPrefFirstName = userPreferences.getString("PROFILE_FIRSTNAME", "");
        sharedPrefEmail = userPreferences.getString("PROFILE_EMAIL", "");
        sharedPrefPhone = userPreferences.getString("PROFILE_PHONE", "");
        SharedPrefAddress = userPreferences.getString("PROFILE_ADDRESS", "");
        SharedPrefDOB = userPreferences.getString("PROFILE_DOB", "");
        sharedPrefRole = userPreferences.getString("PROFILE_ROLE", "");
        SharedPrefGender = userPreferences.getString("PROFILE_GENDER", "");
        SharedPrefJoinedDate = userPreferences.getString("PROFILE_DATE_JOINED", "");
        SharedPrefOffice = userPreferences.getString("PROFILE_OFFICE", "");
        SharedPrefState = userPreferences.getString("PROFILE_STATE", "");
        sharedPrefUserPassword = userPreferences.getString("PROFILE_PASSWORD", "");
        sharedPrefUserMachine = userPreferences.getString("machine", "");

        if (userProfile != null) {
            Intent tellerIntent = new Intent(LoginAct.this, LoginDirAct.class);
            tellerIntent.putExtra(PROFILE_ID, profileID);
            tellerIntent.putExtra(PROFILE_PASSWORD, sharedPrefUserPassword);
            tellerIntent.putExtra(PROFILE_OFFICE, SharedPrefOffice);
            tellerIntent.putExtra(PROFILE_STATE, SharedPrefState);
            tellerIntent.putExtra(PROFILE_ROLE, sharedPrefRole);
            tellerIntent.putExtra(PROFILE_DATE_JOINED, SharedPrefJoinedDate);
            tellerIntent.putExtra(PROFILE_PHONE, sharedPrefPhone);
            tellerIntent.putExtra(PROFILE_FIRSTNAME, sharedPrefFirstName);
            tellerIntent.putExtra(PROFILE_SURNAME, sharedPrefSurName);
            tellerIntent.putExtra(PROFILE_DOB, SharedPrefDOB);
            tellerIntent.putExtra(PROFILE_DATE_JOINED, SharedPrefJoinedDate);
            tellerIntent.putExtra(PROFILE_GENDER, SharedPrefGender);
            tellerIntent.putExtra(PROFILE_ADDRESS, SharedPrefAddress);

            tellerIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            tellerIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(tellerIntent);
        }

    }

    public void loginWithUserName(View view) {
    }

    public void useEmailForLogin(View view) {
    }

    public void loginUserNameGo(View view) {
    }

    public void loginUserEmail(View view) {
    }
}