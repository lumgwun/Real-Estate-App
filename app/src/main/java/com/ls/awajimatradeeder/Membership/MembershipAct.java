package com.ls.awajimatradeeder.Membership;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.R;

import java.security.SecureRandom;

public class MembershipAct extends AppCompatActivity {
    private AppCompatTextView txtDuration, txtAmtInUSD,txtAmtInNGN;
    private AppCompatSpinner spnMembershipType;
    private AppCompatButton btnNext;
    private String selectedMembershipType;
    private double amountInUSD, amountInNGN;
    private  Bundle bundle;
    private String planCode;
    private static final String PREF_NAME = "Tradeeder";
    private SharedPreferences userPreferences;
    private Gson gson;
    private int transactionID,profileID;
    private String json,profileEmail,profilePhone,profileSurname,profileFirstName,refID;
    SecureRandom random =new SecureRandom();
    private Profile userProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_membership);
        setTitle("Member onBoarding");
        //txtDuration = findViewById(R.id.mAmount);
        bundle= new Bundle();
        gson = new Gson();
        userProfile= new Profile();
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        transactionID = random.nextInt((int) (Math.random() * 103) + 150);
        refID = "OurCoopApp/"+ transactionID;
        txtAmtInUSD = findViewById(R.id.mAmount);
        txtAmtInNGN = findViewById(R.id.mAmountInNGN);
        spnMembershipType = findViewById(R.id.mTypeSelection);
        btnNext = findViewById(R.id.idBtnNext);
        btnNext.setOnClickListener(this::membershipNext);
        if (userProfile != null) {
            profileID=userProfile.getProfileID();
            profileSurname=userProfile.getProfileLastName();
            profileFirstName=userProfile.getProfileFirstName();
            profilePhone=userProfile.getProfilePhoneNumber();
            profileEmail=userProfile.getProfileEmail();

        }


        spnMembershipType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedMembershipType = spnMembershipType.getSelectedItem().toString();
                selectedMembershipType = (String) parent.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        if(selectedMembershipType !=null){
            if(selectedMembershipType.equalsIgnoreCase("Basic")){
                amountInUSD=1;
                amountInNGN=500;
                txtAmtInUSD.setText("USD"+amountInUSD);
                txtAmtInNGN.setText("NGN"+amountInNGN);
                planCode="PLN_oi6v8ikjiqd4d3q";

            }

        }
        if(selectedMembershipType !=null){
            if(selectedMembershipType.equalsIgnoreCase("Premium")){
                amountInUSD=2;
                amountInNGN=1000;
                txtAmtInUSD.setText("USD"+amountInUSD);
                txtAmtInNGN.setText("NGN"+amountInNGN);
                planCode="PLN_3hkgwkyzs8vrprn";

            }

        }
        if(selectedMembershipType !=null){
            if(selectedMembershipType.equalsIgnoreCase("Classic")){
                amountInUSD=10;
                amountInNGN=5000;
                txtAmtInUSD.setText("USD"+amountInUSD);
                txtAmtInNGN.setText("NGN"+amountInNGN);
                planCode="PLN_vff2dtbw5tzvvdz";


            }

        }
        if(selectedMembershipType !=null){
            if(selectedMembershipType.equalsIgnoreCase("Silver")){
                amountInUSD=20;
                amountInNGN=10000;
                txtAmtInUSD.setText("USD"+amountInUSD);
                txtAmtInNGN.setText("NGN"+amountInNGN);
                planCode="PLN_oi6v8ikjiqd4d3q";


            }

        }
        if(selectedMembershipType !=null){
            if(selectedMembershipType.equalsIgnoreCase("Gold")){
                amountInUSD=100;
                amountInNGN=20000;
                txtAmtInUSD.setText("USD"+amountInUSD);
                txtAmtInNGN.setText("NGN"+amountInNGN);
                planCode="PLN_6yf12da1b7pk4c4";


            }

        }
        if(selectedMembershipType !=null){
            if(selectedMembershipType.equalsIgnoreCase("VIP")){
                amountInUSD=200;
                amountInNGN=50000;
                txtAmtInUSD.setText("USD"+amountInUSD);
                txtAmtInNGN.setText("NGN"+amountInNGN);
                planCode="PLN_u6pweo01ogkw1k2";

            }

        }
        if(selectedMembershipType !=null){
            if(selectedMembershipType.equalsIgnoreCase("VVIP")){
                amountInUSD=200;
                amountInNGN=100000;
                txtAmtInUSD.setText("USD"+amountInUSD);
                txtAmtInNGN.setText("NGN"+amountInNGN);
                planCode="PLN_tudg7wj64fd31ls";

            }

        }
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("MembershipType",selectedMembershipType);
                bundle.putDouble("AmountInUSD",amountInUSD);
                bundle.putDouble("AmountInNGN",amountInNGN);
                bundle.putString("PlanCode",planCode);
                bundle.putString("refID",refID);
                bundle.putString("profileEmail",profileEmail);
                bundle.putString("profilePhone",profilePhone);
                bundle.putInt("TranxID",transactionID);
                Intent membershipIntent = new Intent(MembershipAct.this, MshipSubAct.class);
                membershipIntent.putExtras(bundle);
                membershipIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(membershipIntent);

            }
        });
    }

    public void membershipNext(View view) {
    }
}