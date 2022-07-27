package com.ls.awajimatradeeder.EstateProperty;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.gson.Gson;
import com.ls.awajimatradeeder.Classes.Estate;
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Database.DBHelper;
import com.ls.awajimatradeeder.R;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class EstRecylerAdapter extends RecyclerView.Adapter<EstRecylerAdapter.ViewHolder> implements ListAdapter, View.OnClickListener, Filterable {

    private Context context;
    private int resource;
    String statusSwitch1;
    private final ArrayList<Estate> estateArrayList;
    DBHelper applicationDb;
    String status;
    Profile userProfile;
    SharedPreferences userPreferences;
    private Gson gson;
    private OnItemsClickListener listener;
    private Estate estate3;
    private List<Estate> estateList;
    private  String name,locality,type,state,country, estStatus,propertyDesc,propertyCurrency,durationForPrice;
    private double price;
    private String propertyPic;
    private Context Mcontext;
    private BottomSheetBehavior mBottomSheetBehavior;


    public EstRecylerAdapter(Context context, int resource, ArrayList<Estate> estateArrayList,OnItemsClickListener listener) {
        super();
        this.context = context;
        this.resource = resource;
        this.estateArrayList = estateArrayList;
        this.listener = listener;
    }
    public EstRecylerAdapter(Context Mcontext, ArrayList<Estate> properties, OnItemsClickListener listener, BottomSheetBehavior mBottomSheetBehavior) {
        this.Mcontext = Mcontext;
        this.estateArrayList = properties;
        this.listener = listener;
        this.mBottomSheetBehavior = mBottomSheetBehavior;
    }

    public EstRecylerAdapter(Context context, ArrayList<Estate> estateArrayList) {
        this.context = context;
        this.estateArrayList = estateArrayList;
    }
    public void setWhenClickListener(OnItemsClickListener listener){
        this.listener = listener;
    }

    @Override
    public EstRecylerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.est_recycler_item, null);
        return new EstRecylerAdapter.ViewHolder(inflate);
    }


    @Override
    public int getItemCount() {
        return (null != estateArrayList ? estateArrayList.size() : 0);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onItemClick(estate3);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    estateList = estateArrayList;
                } else {
                    List<Estate> filteredList = new ArrayList<>();
                    for (Estate property : estateArrayList) {
                        if (property.getEstateState().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(property);
                        }
                    }
                    estateList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = estateArrayList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                estateList = (ArrayList<Estate>) filterResults.values;

                notifyDataSetChanged();
            }
        };
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtEstName;
        public final TextView estAmount;
        public final AppCompatImageView estLogoPic;
        public final AppCompatImageView photoNoProp;

        public final TextView estStatus;
        public final CardView card_view_prop;
        public final TextView estState;
        public final TextView estDesc;

        public final TextView estLocality;
        //public final TextView status;
        public Estate property;
        private Context Mcontext;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            card_view_prop = view.findViewById(R.id.card_view_est);
            estLogoPic = view.findViewById(R.id.est_ICon);
            txtEstName = view.findViewById(R.id.txt_est_tittle);
            estStatus = view.findViewById(R.id._statusEst);
            estState = view.findViewById(R.id.est_state33);
            estAmount = view.findViewById(R.id.est_Price55);
            estDesc = view.findViewById(R.id.est_Desc);
            estLocality = view.findViewById(R.id.est_Locality);
            //propStatus = view.findViewById(R.id.prop_local);
            photoNoProp = view.findViewById(R.id.estICon33);

        }


    }
    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.property = estateArrayList.get(position);
        Estate estate = estateArrayList.get(position);

        if(estate !=null){
            name=estate.getEstateName();
            locality=estate.getEstateLocality();
            state=estate.getEstateState();
            country=estate.getEstateCountry();
            price=estate.getEstPrice();
            durationForPrice=estate.getEstPriceDur();
            propertyDesc=estate.getEstateDescp();
            propertyCurrency=estate.getEstateCurrency();
            propertyPic=estate.getEstateLogo();
            estStatus =estate.getEstateStatus();

        }
        context = holder.mView.getContext();

        holder.txtEstName.setText(MessageFormat.format("Estate Name: {0}", name));
        holder.estStatus.setText(MessageFormat.format("Status: {0}", estStatus));
        holder.estAmount.setText(MessageFormat.format("Price:{0}{1}/{2}", propertyCurrency, String.format("%.2f", price), durationForPrice));
        holder.estDesc.setText(MessageFormat.format("", propertyDesc));
        holder.estState.setText(MessageFormat.format("State.:{0}", state+","+country));
        holder.estLocality.setText(MessageFormat.format("{0}", locality));
        Glide.with(context).load(propertyPic).fitCenter().into(holder.estLogoPic);

        holder.estLogoPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
                    /*if(listener != null){
                        listener.onItemClick(property1);
                    }*/
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        holder.card_view_prop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onItemClick(estate);
                }
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if (id == R.id.est_imageLogo) {
                    if (listener != null) {
                        listener.onItemClick(estate);
                    }
                    if (listener != null) {
                        listener.onItemClick(estate);
                    }
                }
                if (id == R.id.est_Name) {
                    if (listener != null) {
                        listener.onItemClick(estate);
                    }
                }

                if (id == R.id.est_locale) {
                    if (listener != null) {
                        listener.onItemClick(estate);
                    }
                }
                if (id == R.id.est_state) {
                    if (listener != null) {
                        listener.onItemClick(estate);
                    }
                }
                if (id == R.id.est_Desc) {
                    if (listener != null) {
                        listener.onItemClick(estate);
                    }
                }
            }
        };
        if(estStatus !=null){
            if (estStatus.equalsIgnoreCase("available")) {
                holder.estLogoPic.setImageResource(R.drawable.available2);
                holder.estAmount.setTextColor(Color.RED);
            } else if (estStatus.equalsIgnoreCase("notAvailable")) {
                holder.estLogoPic.setImageResource(R.drawable.not_avail);
                holder.estAmount.setTextColor(Color.GREEN);
            }

        }



    }
    public interface OnItemsClickListener{
        void onItemClick(Estate estate);
    }
}
