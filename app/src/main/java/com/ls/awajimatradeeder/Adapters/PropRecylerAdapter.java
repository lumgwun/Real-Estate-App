package com.ls.awajimatradeeder.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.net.Uri;
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
import com.ls.awajimatradeeder.Classes.Profile;
import com.ls.awajimatradeeder.Classes.Property;
import com.ls.awajimatradeeder.Database.DBHelper;
import com.ls.awajimatradeeder.R;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class PropRecylerAdapter extends RecyclerView.Adapter<PropRecylerAdapter.ViewHolder> implements ListAdapter, View.OnClickListener, Filterable {

    private Context context;
    private int resource;
    String statusSwitch1;
    private final ArrayList<Property> propertyArrayList;
    DBHelper applicationDb;
    String status;
    Profile userProfile;
    SharedPreferences userPreferences;
    private Gson gson;
    private OnItemsClickListener listener;
    private Property property1;
    private List<Property> properties2;
    private List<Property> properties;
    private  String name,locality,type,state,country,propStatus,propertyDesc,propertyCurrency,durationForPrice;
    private double price;
    private Uri propertyPic;
    private Context Mcontext;
    private BottomSheetBehavior mBottomSheetBehavior;


    public PropRecylerAdapter(Context context, int resource, ArrayList<Property> propertyArrayList,OnItemsClickListener listener) {
        super();
        this.context = context;
        this.resource = resource;
        this.propertyArrayList = propertyArrayList;
        this.listener = listener;
    }
    public PropRecylerAdapter(Context Mcontext, ArrayList<Property> properties, OnItemsClickListener listener, BottomSheetBehavior mBottomSheetBehavior) {
        this.Mcontext = Mcontext;
        this.propertyArrayList = properties;
        this.listener = listener;
        this.mBottomSheetBehavior = mBottomSheetBehavior;
    }

    public PropRecylerAdapter(Context context, ArrayList<Property> properties) {
        this.context = context;
        this.propertyArrayList = properties;
    }
    public void setWhenClickListener(OnItemsClickListener listener){
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.prop_recycler_item, null);
        return new ViewHolder(inflate);
    }


    @Override
    public int getItemCount() {
        return (null != propertyArrayList ? propertyArrayList.size() : 0);
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
            listener.onItemClick(property1);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    properties2 = propertyArrayList;
                } else {
                    List<Property> filteredList = new ArrayList<>();
                    for (Property property : propertyArrayList) {
                        if (property.getPropertyTown().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(property);
                        }
                    }
                    properties2 = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = propertyArrayList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                properties2 = (ArrayList<Property>) filterResults.values;

                notifyDataSetChanged();
            }
        };
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtPropTittle;
        public final TextView propAmount;
        public final AppCompatImageView photoProp;
        public final AppCompatImageView photoNoProp;

        public final TextView propType;
        public final CardView card_view_prop;
        public final TextView propState;
        public final TextView propDesc;

        public final TextView propLocality;
        //public final TextView status;
        public Property property;
        private Context Mcontext;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            card_view_prop = view.findViewById(R.id.card_view_prop);
            photoProp = view.findViewById(R.id.propICon);
            txtPropTittle = view.findViewById(R.id.txt_prop_tittle);
            propType = view.findViewById(R.id._typeOfProp);
            propState = view.findViewById(R.id.prop_state33);
            propAmount = view.findViewById(R.id.prop33_Price);
            propDesc = view.findViewById(R.id.prop33_Desc);
            propLocality = view.findViewById(R.id.prop_local);
            //propStatus = view.findViewById(R.id.prop_local);
            photoNoProp = view.findViewById(R.id.propICon33);

        }


    }
    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.property = propertyArrayList.get(position);
        Property property = propertyArrayList.get(position);

        if(property !=null){
            name=property.getPropertyTittle();
            locality=property.getPropertyTown();
            type=property.getPropertyType();
            state=property.getPropertyState();
            country=property.getPropertyCountry();
            price=property.getPropertyPrice();
            durationForPrice=property.getPropertyPriceDuration();
            propertyDesc=property.getPropertyDesc();
            propertyCurrency=property.getPropertyDesc();
            propertyPic=property.getPropertyPicture();
            propStatus=property.getPropertyStatus();

        }
        context = holder.mView.getContext();


        holder.propType.setText(MessageFormat.format("", type));
        holder.txtPropTittle.setText(MessageFormat.format("Tittle: {0}", name));
        holder.propAmount.setText(MessageFormat.format("Price:{0}{1}/{2}", propertyCurrency, String.format("%.2f", price), durationForPrice));
        holder.propDesc.setText(MessageFormat.format("", propertyDesc));
        holder.propState.setText(MessageFormat.format("State.:{0}", state+","+country));
        holder.propLocality.setText(MessageFormat.format("{0}", locality));
        Glide.with(context).load(propertyPic).fitCenter().into(holder.photoProp);

        holder.photoProp.setOnClickListener(new View.OnClickListener() {
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
                    listener.onItemClick(property);
                }
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if (id == R.id.est_imageLogo) {
                    if (listener != null) {
                        listener.onItemClick(property);
                    }
                    if (listener != null) {
                        listener.onItemClick(property);
                    }
                }
                if (id == R.id.est_Name) {
                    if (listener != null) {
                        listener.onItemClick(property);
                    }
                }

                if (id == R.id.est_locale) {
                    if (listener != null) {
                        listener.onItemClick(property);
                    }
                }
                if (id == R.id.est_state) {
                    if (listener != null) {
                        listener.onItemClick(property);
                    }
                }
                if (id == R.id.est_Desc) {
                    if (listener != null) {
                        listener.onItemClick(property);
                    }
                }
            }
        };
        if(propStatus !=null){
            if (propStatus.equalsIgnoreCase("available")) {
                holder.photoProp.setImageResource(R.drawable.available2);
                holder.propAmount.setTextColor(Color.RED);
            } else if (propStatus.equalsIgnoreCase("notAvailable")) {
                holder.photoProp.setImageResource(R.drawable.not_avail);
                holder.propAmount.setTextColor(Color.GREEN);
            }

        }



    }
    public interface OnItemsClickListener{
        void onItemClick(Property property);
    }
}
