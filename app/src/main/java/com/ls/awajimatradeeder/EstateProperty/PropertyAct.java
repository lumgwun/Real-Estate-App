package com.ls.awajimatradeeder.EstateProperty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ls.awajimatradeeder.R;
import com.ls.awajimatradeeder.UserDashBoard;

public class PropertyAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_property);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navProperty);

        bottomNavigationView.setSelectedItemId(R.id.propertyHome);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.propertyHome:
                        startActivity(new Intent(getApplicationContext(), UserDashBoard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.estateOffice:
                        startActivity(new Intent(getApplicationContext(),EstateOfficeAct.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.agentOffice:
                        startActivity(new Intent(getApplicationContext(),AgentOfficeAct.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}