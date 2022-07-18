package com.ls.awajimatradeeder.EstateProperty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ls.awajimatradeeder.Classes.EstateGroupSavings;
import com.ls.awajimatradeeder.Classes.EstateLettingSales;
import com.ls.awajimatradeeder.Classes.EstateLoan;
import com.ls.awajimatradeeder.Classes.EstateSubcription;
import com.ls.awajimatradeeder.Classes.EstateTranx;
import com.ls.awajimatradeeder.R;

import java.util.ArrayList;

public class EstateFinanceAct extends AppCompatActivity {
    private ArrayList<EstateGroupSavings> estateGroupSavings;
    private ArrayList<EstateLoan> estateLoans;
    private ArrayList<EstateTranx> estateTranxes;
    private ArrayList<EstateSubcription> estateSubcriptions;
    private ArrayList<EstateLettingSales> estateLettingSales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_estate_finance);
    }
}