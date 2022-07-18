package com.ls.awajimatradeeder.EstateProperty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ls.awajimatradeeder.R;

public class AgentOfficeAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_agent_office);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_agent_prop);

        bottomNavigationView.setSelectedItemId(R.id.my_NullProp);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.agentHome:
                        startActivity(new Intent(AgentOfficeAct.this, AgentOfficeAct.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.my_NullProp:
                        return true;
                    case R.id.my_prop:
                        startActivity(new Intent(AgentOfficeAct.this, MyEstatePropAct.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.my_prop_Rev:
                        startActivity(new Intent(AgentOfficeAct.this, MyPropRevAct.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.add_new_prop:
                        startActivity(new Intent(AgentOfficeAct.this, MyNewPropAct.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}