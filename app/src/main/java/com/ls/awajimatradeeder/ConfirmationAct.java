package com.ls.awajimatradeeder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ls.awajimatradeeder.Classes.PrefManager;

public class ConfirmationAct extends AppCompatActivity {
    private AppCompatButton xConfirmBtn;

    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_confirmation);
        xConfirmBtn = (AppCompatButton) findViewById(R.id.confirmB);
        CheckBox xCheckBox = (CheckBox) findViewById(R.id.checkBox);
        xConfirmBtn.setEnabled(false);
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            //finish();
        }

        xCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (compoundButton.isChecked()) {

                    xConfirmBtn.setEnabled(true);

                    xConfirmBtn.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            prefManager.setFirstTimeLaunch(false);
                            Intent loginRIntent = new Intent(ConfirmationAct.this, SignTabMainAct.class);
                            loginRIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(loginRIntent);
                        }
                    });

                } else if(!compoundButton.isChecked()) {

                    xConfirmBtn.setEnabled(false);
                }
            }
        });
    }
    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(ConfirmationAct.this, SignTabMainAct.class));
        finish();
    }

}