package com.ls.awajimatradeeder.EstateProperty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.ls.awajimatradeeder.Adapters.EstateSliderAdapter;
import com.ls.awajimatradeeder.Adapters.PropRecylerAdapter;
import com.ls.awajimatradeeder.Adapters.PropSliderAdapter;
import com.ls.awajimatradeeder.Classes.Estate;
import com.ls.awajimatradeeder.Classes.EstateSuperAdmin;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Classes.Property;
import com.ls.awajimatradeeder.Classes.Trader;
import com.ls.awajimatradeeder.Database.DBHelper;
import com.ls.awajimatradeeder.R;
import com.ls.awajimatradeeder.UserDashBoard;
import com.mig35.carousellayoutmanager.CarouselLayoutManager;
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.mig35.carousellayoutmanager.CenterScrollListener;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class PropHomeAct extends AppCompatActivity implements  EstateSliderAdapter.OnItemsClickListener, PropSliderAdapter.OnItemsClickListener{
    Bundle paymentBundle;
    private List<Estate> itemsListFilter = new ArrayList<>();
    private Estate estate;
    private androidx.appcompat.widget.SearchView searchView;
    Gson gson, gson1,gson2;
    String json, json1,json2;
    SharedPreferences.Editor editor;
    private static final String PREF_NAME = "Tradeeder";
    SQLiteDatabase sqLiteDatabase;
    private DBHelper dbHelper;
    private SharedPreferences userPreferences;
    private EstateSliderAdapter.OnItemsClickListener estateClickListener;
    private PropSliderAdapter.OnItemsClickListener propClickListener;
    MenuItem searchItem;
    private SearchManager manager;
    private Profile userProfile;
    private int estateID;
    private EstateSliderAdapter estateSliderAdapter;
    private EstateSliderAdapter estateSliderAdapMy;
    private PropSliderAdapter propSliderAdapterAll;
    private PropSliderAdapter propSliderAdapterMy;
    private PropRecylerAdapter propRecylerAdapterAll;
    private PropRecylerAdapter propRecylerAdapter;
    private ArrayList<Property> propertyArrayListAll;
    private ArrayList<Estate> estateArrayListAll;
    private ArrayList<Estate> estateArrayListMy;
    private ArrayList<Property> propertyArrayListMy;
    private EstateSuperAdmin estateSuperAdmin;
    private int profileID,estateProfID,propertyID,propID,proProfID;
    private int estateSuperAdminID,propertyProfID,newProfID;
    private  SliderView sliderMyProp,sliderOtherProp,sliderMyEstates,sliderOtherEstates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_prop_home);
        setTitle("Global Property Area");
        sliderMyProp = findViewById(R.id.sliderMyProp);
        sliderOtherProp = findViewById(R.id.sliderOtherProp);
        sliderMyEstates = findViewById(R.id.sliderMyEstates);

        sliderOtherEstates = findViewById(R.id.sliderAvailEstates);
        gson = new Gson();
        gson1 = new Gson();
        gson2 = new Gson();
        userProfile= new Profile();
        propertyArrayListAll= new ArrayList<>();
        propertyArrayListMy= new ArrayList<>();
        estateArrayListMy= new ArrayList<>();
        estateArrayListAll= new ArrayList<>();
        estateSuperAdmin= new EstateSuperAdmin();
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        userProfile = gson.fromJson(json, Profile.class);
        json = userPreferences.getString("LastProfileUsed", "");
        json1 = userPreferences.getString("LastEstateSuperAdminUsed", "");
        estateSuperAdmin = gson1.fromJson(json1, EstateSuperAdmin.class);
        if(userProfile !=null){
            profileID=userProfile.getProfileID();
        }
        if(estateSuperAdmin !=null){
            estateSuperAdminID =estateSuperAdmin.getEstateSuperAdminEstID();
        }
        manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        estateSliderAdapter = new EstateSliderAdapter(this, estateArrayListAll, estateClickListener);
        estateSliderAdapMy = new EstateSliderAdapter(this, estateArrayListMy, estateClickListener);
        propSliderAdapterAll = new PropSliderAdapter(this, propertyArrayListAll, propClickListener);
        propSliderAdapterMy = new PropSliderAdapter(this, propertyArrayListMy, propClickListener);
        //page.setAdapter(estateSliderAdapter);
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),1000,2000);



        sliderOtherEstates.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_RTL);
        sliderOtherEstates.setSliderAdapter(estateSliderAdapter);
        estateSliderAdapter.setCallback(estateClickListener);
        sliderOtherEstates.setScrollTimeInSec(3);
        sliderOtherEstates.setAutoCycle(true);
        sliderOtherEstates.startAutoCycle();
        estateSliderAdapter.notifyDataSetChanged();



        sliderOtherProp.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_RTL);
        sliderOtherProp.setSliderAdapter(propSliderAdapterAll);
        propSliderAdapterAll.setCallback(propClickListener);
        sliderOtherProp.setScrollTimeInSec(3);
        sliderOtherProp.setAutoCycle(true);
        sliderOtherProp.startAutoCycle();
        propSliderAdapterAll.notifyDataSetChanged();

        dbHelper= new DBHelper(this);
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        json = userPreferences.getString("LastProfileUsed", "");
        userProfile = gson1.fromJson(json1, Profile.class);

        //RecyclerView recyclerView = findViewById(R.id.recycler_view);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navProperty);
        bottomNavigationView.setSelectedItemId(R.id.propertyHome);
        fillPackageList();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.genHome:
                        Intent dashboardIntent = new Intent(PropHomeAct.this, UserDashBoard.class);
                        overridePendingTransition(0,0);
                        dashboardIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(dashboardIntent);
                        return true;

                    case R.id.propertyHome:
                        Intent propIntent = new Intent(PropHomeAct.this, PropHomeAct.class);
                        overridePendingTransition(0,0);
                        propIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(propIntent);
                        return true;
                    case R.id.estateOffice:
                        Intent estateIntent = new Intent(PropHomeAct.this, EstateOfficeAct.class);
                        overridePendingTransition(0,0);
                        estateIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(estateIntent);
                        return true;

                    case R.id.agentOffice:
                        Intent agentIntent = new Intent(PropHomeAct.this, AgentOfficeAct.class);
                        overridePendingTransition(0,0);
                        agentIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(agentIntent);
                        return true;
                }
                return false;
            }
        });

    }
    private void fillPackageList() {
        propertyArrayListAll = new ArrayList<>();

        propertyArrayListAll.add(new Property(R.drawable.estate1, "For Lease","3 Bedroom Appartment","Fully furnished with all the facilities","Victoria", "Toronto,Canada", "CAD23,000", "5 Years" ));
        propertyArrayListAll.add(new Property(R.drawable.estate2, "For Sale","5 Bedroom Appartment","Newly built","Ilepeju", "Lagos,Nigeria", "NGN 290,000,000", "Forever" ));
        propertyArrayListAll.add(new Property(R.drawable.estate3, "For Let","2 Bedroom Appartments","furnished with modern facilities","London", "United Kingdom", "GBP 10,490", "25 Weeks" ));
        propertyArrayListAll.add(new Property(R.drawable.estate4, "For Sale","6 Bedroom Duplex","with standard facilities","Victoria", "Toronto,Canada", "CAD239,000", "" ));

    }

    @Override
    public void onItemClick(Estate estate) {
        Bundle bundle = new Bundle();
        if(estate !=null){
            estateID=estate.getEstateID();
            estateProfID=estate.getEstateProfileID();
        }
        if(userProfile !=null){
            profileID=userProfile.getProfileID();
        }
        if(estateSuperAdmin !=null){
            estateSuperAdminID =estateSuperAdmin.getEstateSuperAdminEstID();
        }
        bundle.putParcelable("Estate", estate);
        bundle.putInt("EstateID", estateID);
        bundle.putInt("ProfileID", profileID);
        bundle.putInt("EstateSuperAdmin", estateSuperAdminID);

        showBottomSheetDialog(bundle,estateID,estateProfID,estateSuperAdminID);


    }

    private void showBottomSheetDialog(Bundle bundle, int estateID, int profileID, int estateSuperAdminID) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.est_bsheet_dialog);
        sliderMyEstates = findViewById(R.id.sliderMyEstates);
        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        json = userPreferences.getString("LastProfileUsed", "");
        userProfile = gson1.fromJson(json1, Profile.class);
        AppCompatButton btnDeleteEst = bottomSheetDialog.findViewById(R.id.estateDelete);
        if(userProfile !=null){
            newProfID=userProfile.getProfileID();
        }
        if(newProfID==estateProfID){
            if (btnDeleteEst != null) {
                btnDeleteEst.setVisibility(View.VISIBLE);
            }

        }

        LinearLayout estLayout = bottomSheetDialog.findViewById(R.id.myEstPics_Layout);
        CardView OtherEstCard = bottomSheetDialog.findViewById(R.id.otherEstCard);
        RecyclerView OtherEstRecycler = bottomSheetDialog.findViewById(R.id.recyclerViewOtherEstates);
        AppCompatButton btnEstCheckOut = bottomSheetDialog.findViewById(R.id.estateCheckout);
        AppCompatButton btnShareEst = bottomSheetDialog.findViewById(R.id.estateShare);









        sliderMyEstates.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderMyEstates.setSliderAdapter(estateSliderAdapMy);
        estateSliderAdapMy.setCallback(estateClickListener);
        sliderMyEstates.setScrollTimeInSec(6);
        sliderMyEstates.setAutoCycle(true);
        sliderMyEstates.startAutoCycle();
        estateSliderAdapMy.notifyDataSetChanged();

        if (estLayout != null) {
            estLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent payIntent = new Intent(PropHomeAct.this, EstateCheckOutAct.class);
                    payIntent.putExtras(bundle);
                    payIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(payIntent);
                    bottomSheetDialog.dismiss();

                }
            });
        }

        if (btnEstCheckOut != null) {
            btnEstCheckOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(PropHomeAct.this, "Checkout Clicked", Toast.LENGTH_LONG).show();
                    Intent payIntent = new Intent(PropHomeAct.this, EstateCheckOutAct.class);
                    payIntent.putExtras(bundle);
                    payIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(payIntent);
                    bottomSheetDialog.dismiss();
                }
            });
        }

        if (btnShareEst != null) {
            btnShareEst.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(PropHomeAct.this, "Share Clicked", Toast.LENGTH_LONG).show();
                    Intent payIntent = new Intent(PropHomeAct.this, ShareEstLinkAct.class);
                    payIntent.putExtras(bundle);
                    payIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(payIntent);
                    bottomSheetDialog.dismiss();
                }
            });
        }

        if (btnDeleteEst != null) {
            btnDeleteEst.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(PropHomeAct.this, "Delete Clicked", Toast.LENGTH_LONG).show();
                    Intent payIntent = new Intent(PropHomeAct.this, DeleteEstAct.class);
                    payIntent.putExtras(bundle);
                    payIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(payIntent);
                    bottomSheetDialog.dismiss();
                }
            });
        }


        bottomSheetDialog.show();

    }

    @Override
    public void onItemClick(Property property) {
        Bundle bundle = new Bundle();
        if(property !=null){
            propID=property.getPropertyID();
            proProfID=property.getPropertyProfID();
        }
        if(userProfile !=null){
            profileID=userProfile.getProfileID();
        }

        bundle.putParcelable("Property", property);
        bundle.putInt("EstateID", propID);
        bundle.putInt("ProfileID", proProfID);

        showPropBottomSheetDialog(bundle,estateID,proProfID);



        bundle.putParcelable("Estate", property);
        bundle.putInt("EstateID", estateID);
        bundle.putInt("ProfileID", profileID);
        bundle.putInt("EstateSuperAdmin", estateSuperAdminID);
        Intent payIntent = new Intent(PropHomeAct.this, EstateCheckOutAct.class);
        payIntent.putExtras(bundle);
        payIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(payIntent);

    }

    private void showPropBottomSheetDialog(Bundle bundle, int estateID, int proProfID) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.prop_sheet_dialog);
        sliderMyProp = findViewById(R.id.sliderMyProp);
        sliderMyProp.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderMyProp.setSliderAdapter(propSliderAdapterMy);
        propSliderAdapterMy.setCallback(propClickListener);
        sliderMyProp.setScrollTimeInSec(6);
        sliderMyProp.setAutoCycle(true);
        sliderMyProp.startAutoCycle();
        propSliderAdapterMy.notifyDataSetChanged();
        DividerItemDecoration dividerItemDecoration = null;

        userPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        json = userPreferences.getString("LastProfileUsed", "");
        userProfile = gson1.fromJson(json1, Profile.class);
        AppCompatButton btnDeleteProp = bottomSheetDialog.findViewById(R.id.propDelete);
        LinearLayout estLayout = bottomSheetDialog.findViewById(R.id.myPropPics_Layout);
        CardView OtherEstCard = bottomSheetDialog.findViewById(R.id.otherPropCard);
        RecyclerView OtherEstRecycler = bottomSheetDialog.findViewById(R.id.recyclerViewPropOther);
        AppCompatButton btnPropCheckOut = bottomSheetDialog.findViewById(R.id.propCheckout);
        AppCompatButton btnShareProp = bottomSheetDialog.findViewById(R.id.propShare);
        if(userProfile !=null){
            newProfID=userProfile.getProfileID();
        }
        if(newProfID==proProfID){
            if (btnDeleteProp != null) {
                btnDeleteProp.setVisibility(View.VISIBLE);
            }

        }

        propertyArrayListAll = new ArrayList<>();

        propertyArrayListAll.add(new Property(R.drawable.estate1, "For Lease","3 Bedroom Appartment","Fully furnished with all the facilities","Victoria", "Toronto,Canada", "CAD23,000", "5 Years" ));
        propertyArrayListAll.add(new Property(R.drawable.estate2, "For Sale","5 Bedroom Appartment","Newly built","Ilepeju", "Lagos,Nigeria", "NGN 290,000,000", "Forever" ));
        propertyArrayListAll.add(new Property(R.drawable.estate3, "For Let","2 Bedroom Appartments","furnished with modern facilities","London", "United Kingdom", "GBP 10,490", "25 Weeks" ));
        propertyArrayListAll.add(new Property(R.drawable.estate4, "For Sale","6 Bedroom Duplex","with standard facilities","Victoria", "Toronto,Canada", "CAD239,000", "" ));



        LinearLayoutManager propLayoutM
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        if (OtherEstRecycler != null) {
            OtherEstRecycler.setLayoutManager(propLayoutM);
            propRecylerAdapterAll = new PropRecylerAdapter(PropHomeAct.this,propertyArrayListAll);
            OtherEstRecycler.setItemAnimator(new DefaultItemAnimator());
            OtherEstRecycler.setAdapter(propRecylerAdapterAll);
            dividerItemDecoration = new DividerItemDecoration(OtherEstRecycler.getContext(),
                    propLayoutM.getOrientation());
            OtherEstRecycler.addItemDecoration(dividerItemDecoration);
            SnapHelper propSnapHelper = new PagerSnapHelper();
            propSnapHelper.attachToRecyclerView(OtherEstRecycler);
            propSliderAdapterAll.notifyDataSetChanged();

        }


        sliderMyEstates.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderMyEstates.setSliderAdapter(estateSliderAdapMy);
        estateSliderAdapMy.setCallback(estateClickListener);
        sliderMyEstates.setScrollTimeInSec(6);
        sliderMyEstates.setAutoCycle(true);
        sliderMyEstates.startAutoCycle();
        estateSliderAdapMy.notifyDataSetChanged();

        if (estLayout != null) {
            estLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent payIntent = new Intent(PropHomeAct.this, EstateCheckOutAct.class);
                    payIntent.putExtras(bundle);
                    payIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(payIntent);
                    bottomSheetDialog.dismiss();

                }
            });
        }

        if (btnPropCheckOut != null) {
            btnPropCheckOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(PropHomeAct.this, "Checkout Clicked", Toast.LENGTH_LONG).show();
                    Intent payIntent = new Intent(PropHomeAct.this, EstateCheckOutAct.class);
                    payIntent.putExtras(bundle);
                    payIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(payIntent);
                    bottomSheetDialog.dismiss();
                }
            });
        }
        if (btnPropCheckOut != null) {
            btnPropCheckOut.setOnClickListener(this::propCheckOut);
        }
        if (btnShareProp != null) {
            btnShareProp.setOnClickListener(this::propShare);
        }

        if (btnShareProp != null) {
            btnShareProp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(PropHomeAct.this, "Share Clicked", Toast.LENGTH_LONG).show();
                    Intent payIntent = new Intent(PropHomeAct.this, ShareEstLinkAct.class);
                    payIntent.putExtras(bundle);
                    payIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(payIntent);
                    bottomSheetDialog.dismiss();
                }
            });
        }

        if (btnDeleteProp != null) {
            btnDeleteProp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(PropHomeAct.this, "Delete Clicked", Toast.LENGTH_LONG).show();
                    Intent payIntent = new Intent(PropHomeAct.this, DeleteEstAct.class);
                    payIntent.putExtras(bundle);
                    payIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(payIntent);
                    bottomSheetDialog.dismiss();
                }
            });
        }
        if (btnDeleteProp != null) {
            btnDeleteProp.setOnClickListener(this::propDelete);
        }


        bottomSheetDialog.show();

    }

    public void propCheckOut(View view) {
    }

    public void propDelete(View view) {
    }

    public void propShare(View view) {
    }


    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            PropHomeAct.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.prop_user_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (androidx.appcompat.widget.SearchView) menu.findItem(R.id.actionSearchAllProp)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                propSliderAdapterAll.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                propSliderAdapterAll.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.actionSearchAllProp) {
            return true;
        }
        if (id == R.id.actionHome) {
            return true;
        }
        if (id == R.id.actionPropSettings) {
            return true;
        }
        if (id == R.id.actionMyEstateSettings) {
            return true;
        }
        if (id == R.id.actionPropFinances) {
            return true;
        }
        if (id == R.id.actionEstateMeetings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
}