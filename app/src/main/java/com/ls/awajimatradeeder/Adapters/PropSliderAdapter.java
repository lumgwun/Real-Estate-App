package com.ls.awajimatradeeder.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.ls.awajimatradeeder.Classes.Property;
import com.ls.awajimatradeeder.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class PropSliderAdapter extends SliderViewAdapter<PropSliderAdapter.SliderAdapterVH> implements View.OnClickListener, Filterable {

    private Context Mcontext;
    private List<Property> propertyArrayList = new ArrayList<>();
    private List<Property> itemsListFilter = new ArrayList<>();
    private ArrayList<Property> properties;
    private OnItemsClickListener listener;
    private Property property;
    Bundle bundle;
    RequestListener<Drawable> imageListener;
    private Integer mSelectedObject;
    private  String name,locality,type,state,country,propertyDesc,propertyCurrency,durationForPrice;
    private double price;
    private Uri propertyPic;

    private BottomSheetBehavior mBottomSheetBehavior;

    public PropSliderAdapter(Context Mcontext, ArrayList<Property> properties, OnItemsClickListener listener, BottomSheetBehavior mBottomSheetBehavior) {
        this.Mcontext = Mcontext;
        this.propertyArrayList = properties;
        this.listener = listener;
        this.mBottomSheetBehavior = mBottomSheetBehavior;
    }
    public PropSliderAdapter(Context Mcontext, ArrayList<Property> properties, OnItemsClickListener listener) {
        this.Mcontext = Mcontext;
        this.propertyArrayList = properties;
        this.listener = listener;
    }


    public void setCallback(OnItemsClickListener callback) {
        this.listener = callback;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.property_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        Property property = properties.get(position);


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

        }
        Mcontext = viewHolder.itemView.getContext();

        viewHolder.propTittle.setText(MessageFormat.format("Item Name.:{0}", name));
        viewHolder.locality.setText(MessageFormat.format("Locale.:{0}", locality));
        viewHolder.desc.setText(MessageFormat.format("Type.:{0}", propertyDesc));
        viewHolder.propPurchaseType.setText(MessageFormat.format("Type.:{0}", type));
        viewHolder.propPrice.setText(MessageFormat.format("Price:{0}{1}/{2}", propertyCurrency, price, durationForPrice));
        viewHolder.propState.setText(MessageFormat.format("State.:{0}", state+","+country));
        Glide.with(Mcontext).load(propertyPic).fitCenter().into(viewHolder.propertyPicture);

        viewHolder.propertyPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onItemClick(property);
                }
            }
        });
        viewHolder.motherLayoutView.setOnClickListener(new View.OnClickListener() {
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

    }
    class SliderAdapterVH extends SliderViewAdapter.ViewHolder implements View.OnClickListener {

        View itemView;
        ImageView propertyPicture;
        TextView propTittle,desc;
        TextView propPrice;
        TextView locality;
        TextView propPurchaseType, propState;
        OnItemsClickListener listener;
        Property property1;
        public CardView motherLayoutView;

        public SliderAdapterVH(View itemView) {
            super(itemView);

            propertyPicture = itemView.findViewById(R.id.prop_imageP);
            propTittle = itemView.findViewById(R.id.prop_Name);
            locality = itemView.findViewById(R.id.property_locale);
            desc = itemView.findViewById(R.id.property_Desc);
            propPurchaseType = itemView.findViewById(R.id.prop_Type);
            propState = itemView.findViewById(R.id.property_state);
            propPrice = itemView.findViewById(R.id.property_Price);
            motherLayoutView = itemView.findViewById(R.id.propCardView);

            this.itemView = itemView;
            itemView.setOnClickListener(this);

            propTittle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(property1);
                    }
                }
            });
            propPrice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(property1);
                    }
                }
            });
            locality.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(property1);
                    }
                }
            });

            propertyPicture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notifyDataSetChanged();
                    /*if(listener != null){
                        listener.onItemClick(property1);
                    }*/
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(property1);
                    }
                }
            });
            propState.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(property1);
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onItemClick(property1);
            }

        }

    }


    @Override
    public int getCount() {

        return (null != properties ? properties.size() : 0);
    }



    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                properties = (ArrayList<Property>) results.values;
                notifyDataSetChanged();
            }
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList<Property> filteredList = new ArrayList<>();
                String searchText = constraint.toString().toLowerCase();
                String[] split = searchText.split(",");
                ArrayList<String> stringArrayList = new ArrayList<>(split.length);
                for (String aSplit : split) {
                    // remove spaces
                    String trim = aSplit.trim();
                    // skip empty entries
                    if (trim.length() > 0)
                        stringArrayList.add(trim);
                }

                for (Property dataNames : itemsListFilter) {
                    // filter by title
                    if (dataNames.getPropertyTown().toLowerCase().trim().contains(searchText)) {
                        filteredList.add(dataNames);
                    }
                }
                results.count = filteredList.size();
                results.values = filteredList;
                return results;
            }

        };
        return filter;
    }
    public void filterAll( String pack ) {

        itemsListFilter.clear();

        if (pack.length() < 0) {
            itemsListFilter.addAll(properties);
        } else {
            for (Property ls : properties) {

                if (ls.getPropertyTown().contains(pack)) {

                    itemsListFilter.add(ls);

                }

            }
            notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View view) {

    }

    public interface OnItemsClickListener{
        void onItemClick(Property property);
    }
}
