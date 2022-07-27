package com.ls.awajimatradeeder.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.ls.awajimatradeeder.Classes.Estate;
import com.ls.awajimatradeeder.Classes.PinEntryView;
import com.ls.awajimatradeeder.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class EstateSliderAdapter extends SliderViewAdapter<EstateSliderAdapter.SliderAdapterVH> implements View.OnClickListener, Filterable {

    private Context Mcontext;
    private List<Estate> estates = new ArrayList<>();
    private List<Estate> itemsListFilter = new ArrayList<>();
    Context context;
    private ArrayList<Estate> estateArrayList;
    private OnItemsClickListener listener;
    private Estate estate;
    Bundle bundle;
    RequestListener<Drawable> imageListener;
    private BottomSheetBehavior mBottomSheetBehavior;

    public EstateSliderAdapter(Context Mcontext, ArrayList<Estate> estates, OnItemsClickListener listener) {
        this.Mcontext = Mcontext;
        this.estates = estates;
        this.listener = listener;

    }
    public EstateSliderAdapter(Context Mcontext, ArrayList<Estate> estates, OnItemsClickListener listener,BottomSheetBehavior mBottomSheetBehavior) {
        this.Mcontext = Mcontext;
        this.estates = estates;
        this.listener = listener;
        this.mBottomSheetBehavior = mBottomSheetBehavior;

    }
    public void setCallback(OnItemsClickListener callback) {
        this.listener = callback;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.estate_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        Estate estate = estateArrayList.get(position);
        String name=estate.getEstateName();
        String locality=estate.getEstateLocality();
        String desc=estate.getEstateDescp();
        String state=estate.getEstateState();
        String country=estate.getEstateCountry();

        viewHolder.itemName.setText(MessageFormat.format("Item Name.:{0}", name));
        viewHolder.locality.setText(MessageFormat.format("Locale.:{0}", locality));
        viewHolder.propType.setText(MessageFormat.format("Desc.:{0}", desc));
        viewHolder.estateState.setText(MessageFormat.format("State.:{0}", state+","+country));
        Glide.with(Mcontext).load(estate.getEstateLogo()).fitCenter().into(viewHolder.propertyLogo);

        viewHolder.motherLayoutView.setOnClickListener(new View.OnClickListener() {
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

    }
    static class SliderAdapterVH extends SliderViewAdapter.ViewHolder implements View.OnClickListener {
        View itemView;
        ImageView propertyLogo;
        TextView itemName;
        TextView locality;
        TextView propType,estateState;
        OnItemsClickListener listener;
        Estate estate;
        public LinearLayout motherLayoutView;

        public SliderAdapterVH(View itemView) {
            super(itemView);

            propertyLogo = itemView.findViewById(R.id.est_imageLogo);
            itemName = itemView.findViewById(R.id.est_Name);
            locality = itemView.findViewById(R.id.est_locale);
            propType = itemView.findViewById(R.id.est_Desc);
            estateState = itemView.findViewById(R.id.est_state);
            this.itemView = itemView;
            itemView.setOnClickListener(this);

            itemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(estate);
                    }
                }
            });
            locality.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(estate);
                    }
                }
            });

            propertyLogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(estate);
                    }
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(estate);
                    }
                }
            });
            propertyLogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(estate);
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onItemClick(estate);
            }

        }

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) Mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = inflater.inflate(R.layout.estate_item,null);


        return sliderLayout;
    }



    @Override
    public int getCount() {

        return (null != estates ? estates.size() : 0);
    }



    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                estates = (ArrayList<Estate>) results.values;
                notifyDataSetChanged();
            }
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList<Estate> filteredList = new ArrayList<>();
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

                for (Estate dataNames : itemsListFilter) {
                    // filter by title
                    if (dataNames.getEstateName().toLowerCase().trim().contains(searchText)) {
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
            itemsListFilter.addAll(estateArrayList);
        } else {
            for (Estate ls : estateArrayList) {

                if (ls.getEstateLocality().contains(pack)) {

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
        void onItemClick(Estate estate);
    }

}
