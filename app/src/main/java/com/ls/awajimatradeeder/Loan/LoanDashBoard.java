package com.ls.awajimatradeeder.Loan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ls.awajimatradeeder.R;
import com.ls.awajimatradeeder.UserDashBoard;

public class LoanDashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_loan_dash_board);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navLoan);

        bottomNavigationView.setSelectedItemId(R.id.loanHome);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.loanHome:
                        startActivity(new Intent(LoanDashBoard.this, UserDashBoard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.loanList:
                        startActivity(new Intent(LoanDashBoard.this,LoanListAct.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.newLoan:
                        startActivity(new Intent(LoanDashBoard.this,NewLoanAct.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}