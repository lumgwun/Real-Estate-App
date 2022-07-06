package com.ls.awajimatradeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import com.ls.awajimatradeeder.Accountant.AccountantBO;
import com.ls.awajimatradeeder.Admin.AdminDrawerAct;
import com.ls.awajimatradeeder.Database.DBHelper;
import com.ls.awajimatradeeder.SuperAdmin.SuperAdminOffice;
import com.ls.awajimatradeeder.Tellers.TellerHomeChoices;

public class LoginDirAct extends AppCompatActivity {
    int profileID,customerID;
    String machinePref;
    Uri pictureLink;
    SharedPreferences sharedPref;
    Bundle userExtras;
    private static final String PREF_NAME = "Tradeeder";
    private DBHelper dbHelper;
    String machineUser,userName, office,state,role,dbRole,joinedDate,password,surname, email,phoneNO, firstName, dob,gender,address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login_dir);
        setTitle("Login Director");
        userExtras= new Bundle();
        dbHelper=new DBHelper(this);
        userExtras=getIntent().getExtras();
        sharedPref= getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        machinePref = sharedPref.getString("Machine", "");
        profileID = sharedPref.getInt("PROFILE_ID", 0);
        userName = sharedPref.getString("PROFILE_USERNAME", "");
        office = sharedPref.getString("PROFILE_OFFICE", "");
        state = sharedPref.getString("PROFILE_STATE", "");
        role = sharedPref.getString("PROFILE_ROLE", "");
        password = sharedPref.getString("PROFILE_PASSWORD", "");
        joinedDate = sharedPref.getString("PROFILE_DATE_JOINED", "");
        surname = sharedPref.getString("PROFILE_SURNAME", "");
        email = sharedPref.getString("PROFILE_EMAIL", "");
        phoneNO = sharedPref.getString("PROFILE_PHONE", "");
        firstName = sharedPref.getString("PROFILE_FIRSTNAME", "");
        dob = sharedPref.getString("PROFILE_DOB", "");
        customerID = sharedPref.getInt("CUSTOMER_ID", 0);
        gender = sharedPref.getString("PROFILE_GENDER", "");
        address = sharedPref.getString("PROFILE_ADDRESS", "");
        pictureLink = Uri.parse(sharedPref.getString("PICTURE_URI", ""));

        machinePref = sharedPref.getString("Machine", "");
        profileID = sharedPref.getInt("PROFILE_ID", 0);
        userName = sharedPref.getString("USER_NAME", "");
        office = sharedPref.getString("USER_OFFICE", "");
        state = sharedPref.getString("USER_STATE", "");
        role = sharedPref.getString("USER_ROLE", "");

        joinedDate = sharedPref.getString("USER_DATE_JOINED", "");
        password = sharedPref.getString("USER_PASSWORD", "");
        surname = sharedPref.getString("USER_SURNAME", "");
        email = sharedPref.getString("EMAIL_ADDRESS", "");
        phoneNO = sharedPref.getString("USER_PHONE", "");
        firstName = sharedPref.getString("USER_FIRSTNAME", "");
        dob = sharedPref.getString("USER_DOB", "");
        customerID = sharedPref.getInt("CUSTOMER_ID", 0);
        gender = sharedPref.getString("USER_GENDER", "");
        address = sharedPref.getString("USER_ADDRESS", "");
        pictureLink = Uri.parse(sharedPref.getString("PICTURE_URI", ""));
        dbRole=dbHelper.getProfileRoleByUserNameAndPassword(userName,password);

        if(userExtras ==null) {
            if(dbRole !=null){
                if (dbRole.equalsIgnoreCase("SuperAdmin")) {

                    Intent tellerIntent = new Intent(this, SuperAdminOffice.class);
                    tellerIntent.putExtra("PROFILE_ID", profileID);
                    tellerIntent.putExtra("PROFILE_USERNAME", userName);
                    tellerIntent.putExtra("PROFILE_PASSWORD", password);
                    tellerIntent.putExtra("PROFILE_OFFICE", office);
                    tellerIntent.putExtra("PROFILE_STATE", state);
                    tellerIntent.putExtra("PROFILE_ROLE", role);
                    tellerIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    tellerIntent.putExtra("PROFILE_EMAIL", email);
                    tellerIntent.putExtra("PROFILE_PHONE", phoneNO);
                    tellerIntent.putExtra("PROFILE_FIRSTNAME", firstName);
                    tellerIntent.putExtra("PROFILE_SURNAME", surname);
                    tellerIntent.putExtra("PROFILE_DOB", dob);
                    tellerIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    tellerIntent.putExtra("CUSTOMER_ID", customerID);
                    tellerIntent.putExtra("PROFILE_GENDER", gender);
                    tellerIntent.putExtra("PROFILE_ADDRESS", address);
                    tellerIntent.putExtra("PROFILE_ADDRESS", address);
                    tellerIntent.putExtra("PICTURE_URI", pictureLink);
                    startActivity(tellerIntent);
                }
                if (dbRole.equalsIgnoreCase("BlockedUser")) {

                    Intent tellerIntent = new Intent(this, BlockedUserAct.class);
                    tellerIntent.putExtra("PROFILE_ID", profileID);
                    tellerIntent.putExtra("PROFILE_USERNAME", userName);
                    tellerIntent.putExtra("PROFILE_PASSWORD", password);
                    tellerIntent.putExtra("PROFILE_OFFICE", office);
                    tellerIntent.putExtra("PROFILE_STATE", state);
                    tellerIntent.putExtra("PROFILE_ROLE", role);
                    tellerIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    tellerIntent.putExtra("PROFILE_EMAIL", email);
                    tellerIntent.putExtra("PROFILE_PHONE", phoneNO);
                    tellerIntent.putExtra("PROFILE_FIRSTNAME", firstName);
                    tellerIntent.putExtra("PROFILE_SURNAME", surname);
                    tellerIntent.putExtra("PROFILE_DOB", dob);
                    tellerIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    tellerIntent.putExtra("CUSTOMER_ID", customerID);
                    tellerIntent.putExtra("PROFILE_GENDER", gender);
                    tellerIntent.putExtra("PROFILE_ADDRESS", address);
                    tellerIntent.putExtra("PROFILE_ADDRESS", address);
                    tellerIntent.putExtra("PICTURE_URI", pictureLink);
                    startActivity(tellerIntent);
                }
                if (dbRole.equalsIgnoreCase("Accountant")) {

                    Intent tellerIntent = new Intent(this, AccountantBO.class);
                    tellerIntent.putExtra("PROFILE_ID", profileID);
                    tellerIntent.putExtra("PROFILE_USERNAME", userName);
                    tellerIntent.putExtra("PROFILE_PASSWORD", password);
                    tellerIntent.putExtra("PROFILE_OFFICE", office);
                    tellerIntent.putExtra("PROFILE_STATE", state);
                    tellerIntent.putExtra("PROFILE_ROLE", role);
                    tellerIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    tellerIntent.putExtra("PROFILE_EMAIL", email);
                    tellerIntent.putExtra("PROFILE_PHONE", phoneNO);
                    tellerIntent.putExtra("PROFILE_FIRSTNAME", firstName);
                    tellerIntent.putExtra("PROFILE_SURNAME", surname);
                    tellerIntent.putExtra("PROFILE_DOB", dob);
                    tellerIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    tellerIntent.putExtra("CUSTOMER_ID", customerID);
                    tellerIntent.putExtra("PROFILE_GENDER", gender);
                    tellerIntent.putExtra("PROFILE_ADDRESS", address);
                    tellerIntent.putExtra("PROFILE_ADDRESS", address);
                    tellerIntent.putExtra("PICTURE_URI", pictureLink);
                    startActivity(tellerIntent);
                }
                if (dbRole.equalsIgnoreCase("Teller")) {

                    Intent tellerIntent = new Intent(this, TellerHomeChoices.class);
                    tellerIntent.putExtra("PROFILE_ID", profileID);
                    tellerIntent.putExtra("PROFILE_USERNAME", userName);
                    tellerIntent.putExtra("PROFILE_PASSWORD", password);
                    tellerIntent.putExtra("PROFILE_OFFICE", office);
                    tellerIntent.putExtra("PROFILE_STATE", state);
                    tellerIntent.putExtra("PROFILE_ROLE", role);
                    tellerIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    tellerIntent.putExtra("PROFILE_EMAIL", email);
                    tellerIntent.putExtra("PROFILE_PHONE", phoneNO);
                    tellerIntent.putExtra("PROFILE_FIRSTNAME", firstName);
                    tellerIntent.putExtra("PROFILE_SURNAME", surname);
                    tellerIntent.putExtra("PROFILE_DOB", dob);
                    tellerIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    tellerIntent.putExtra("CUSTOMER_ID", customerID);
                    tellerIntent.putExtra("PROFILE_GENDER", gender);
                    tellerIntent.putExtra("PROFILE_ADDRESS", address);
                    tellerIntent.putExtra("PROFILE_ADDRESS", address);
                    tellerIntent.putExtra("PICTURE_URI", pictureLink);
                    startActivity(tellerIntent);
                }
                if (dbRole.equalsIgnoreCase("Admin")) {
                    Intent adminIntent = new Intent(this, AdminDrawerAct.class);

                    adminIntent.putExtra("PROFILE_ID", profileID);
                    adminIntent.putExtra("PROFILE_USERNAME", userName);
                    adminIntent.putExtra("PROFILE_PASSWORD", password);
                    adminIntent.putExtra("PROFILE_OFFICE", office);
                    adminIntent.putExtra("PROFILE_STATE", state);
                    adminIntent.putExtra("PROFILE_ROLE", role);
                    adminIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    adminIntent.putExtra("PROFILE_EMAIL", email);
                    adminIntent.putExtra("PROFILE_PHONE", phoneNO);
                    adminIntent.putExtra("PROFILE_FIRSTNAME", firstName);
                    adminIntent.putExtra("PROFILE_SURNAME", surname);
                    adminIntent.putExtra("PROFILE_DOB", dob);
                    adminIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    adminIntent.putExtra("CUSTOMER_ID", customerID);
                    adminIntent.putExtra("PROFILE_GENDER", gender);
                    adminIntent.putExtra("PROFILE_ADDRESS", address);
                    adminIntent.putExtra("PROFILE_ADDRESS", address);
                    adminIntent.putExtra("PICTURE_URI", pictureLink);

                    adminIntent.putExtra("USER_NAME", userName);
                    adminIntent.putExtra("PROFILE_ID", profileID);
                    adminIntent.putExtra("USER_PASSWORD", password);
                    adminIntent.putExtra("USER_OFFICE", office);
                    adminIntent.putExtra("USER_STATE", state);
                    adminIntent.putExtra("USER_ROLE", role);
                    adminIntent.putExtra("USER_DATE_JOINED", joinedDate);
                    adminIntent.putExtra("EMAIL_ADDRESS", email);
                    adminIntent.putExtra("USER_PHONE", phoneNO);
                    adminIntent.putExtra("USER_FIRSTNAME", firstName);
                    adminIntent.putExtra("USER_SURNAME", surname);
                    adminIntent.putExtra("USER_DOB", dob);
                    adminIntent.putExtra("USER_DATE_JOINED", joinedDate);
                    adminIntent.putExtra("CUSTOMER_ID", customerID);
                    adminIntent.putExtra("USER_GENDER", gender);
                    adminIntent.putExtra("USER_ADDRESS", address);
                    adminIntent.putExtra("PICTURE_URI", pictureLink);
                    startActivity(adminIntent);
                }
                if (dbRole.equalsIgnoreCase("Customer")) {
                    //btnCustomer.setVisibility(View.VISIBLE);
                    Intent customerIntent = new Intent(this, UserDashBoard.class);

                    customerIntent.putExtra("PROFILE_ID", profileID);
                    customerIntent.putExtra("PROFILE_USERNAME", userName);
                    customerIntent.putExtra("PROFILE_PASSWORD", password);
                    customerIntent.putExtra("PROFILE_OFFICE", office);
                    customerIntent.putExtra("PROFILE_STATE", state);
                    customerIntent.putExtra("PROFILE_ROLE", role);
                    customerIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    customerIntent.putExtra("PROFILE_EMAIL", email);
                    customerIntent.putExtra("PROFILE_PHONE", phoneNO);
                    customerIntent.putExtra("PROFILE_FIRSTNAME", firstName);
                    customerIntent.putExtra("PROFILE_SURNAME", surname);
                    customerIntent.putExtra("PROFILE_DOB", dob);
                    customerIntent.putExtra("PROFILE_DATE_JOINED", joinedDate);
                    customerIntent.putExtra("CUSTOMER_ID", customerID);
                    customerIntent.putExtra("PROFILE_GENDER", gender);
                    customerIntent.putExtra("PROFILE_ADDRESS", address);
                    customerIntent.putExtra("PROFILE_ADDRESS", address);
                    customerIntent.putExtra("PICTURE_URI", pictureLink);

                    startActivity(customerIntent);
                }


            }


        }



        if (userExtras != null) {
            if(sharedPref==null){

                machinePref = sharedPref.getString("Machine", "");
                profileID = sharedPref.getInt("PROFILE_ID", 0);
                userName = sharedPref.getString("PROFILE_USERNAME", "");
                office = sharedPref.getString("PROFILE_OFFICE", "");
                state = sharedPref.getString("PROFILE_STATE", "");
                role = sharedPref.getString("PROFILE_ROLE", "");
                password = sharedPref.getString("PROFILE_PASSWORD", "");
                joinedDate = sharedPref.getString("PROFILE_DATE_JOINED", "");
                surname = sharedPref.getString("PROFILE_SURNAME", "");
                email = sharedPref.getString("PROFILE_EMAIL", "");
                phoneNO = sharedPref.getString("PROFILE_PHONE", "");
                firstName = sharedPref.getString("PROFILE_FIRSTNAME", "");
                dob = sharedPref.getString("PROFILE_DOB", "");
                customerID = sharedPref.getInt("CUSTOMER_ID", 0);
                gender = sharedPref.getString("PROFILE_GENDER", "");
                address = sharedPref.getString("PROFILE_ADDRESS", "");
                pictureLink = Uri.parse(sharedPref.getString("PICTURE_URI", ""));


            }


        }
        if (userExtras == null) {
            if(sharedPref !=null){

                try {
                    machinePref = sharedPref.getString("Machine", "");
                    profileID = sharedPref.getInt("PROFILE_ID", 0);
                    userName = sharedPref.getString("PROFILE_USERNAME", "");
                    office = sharedPref.getString("PROFILE_OFFICE", "");
                    state = sharedPref.getString("PROFILE_STATE", "");
                    role = sharedPref.getString("PROFILE_ROLE", "");
                    password = sharedPref.getString("PROFILE_PASSWORD", "");
                    joinedDate = sharedPref.getString("PROFILE_DATE_JOINED", "");
                    surname = sharedPref.getString("PROFILE_SURNAME", "");
                    email = sharedPref.getString("PROFILE_EMAIL", "");
                    phoneNO = sharedPref.getString("PROFILE_PHONE", "");
                    firstName = sharedPref.getString("PROFILE_FIRSTNAME", "");
                    dob = sharedPref.getString("PROFILE_DOB", "");
                    customerID = sharedPref.getInt("CUSTOMER_ID", 0);
                    gender = sharedPref.getString("PROFILE_GENDER", "");
                    address = sharedPref.getString("PROFILE_ADDRESS", "");
                    pictureLink = Uri.parse(sharedPref.getString("PICTURE_URI", ""));


                } catch (NullPointerException e) {
                    e.printStackTrace();
                }



            }

        }
    }
}