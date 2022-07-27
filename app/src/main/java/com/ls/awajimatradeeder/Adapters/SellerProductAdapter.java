package com.ls.awajimatradeeder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ls.awajimatradeeder.Classes.PictureImage;
import com.ls.awajimatradeeder.Classes.SellerProduct;
import com.ls.awajimatradeeder.R;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class SellerProductAdapter extends RecyclerView.Adapter<SellerProductAdapter.ViewHolder> implements  Filterable {

    private List<SellerProduct> sellerProductList;
    private ArrayList<SellerProduct> sellerProducts = new ArrayList<>();
    private List<SellerProduct> itemsListFilter = new ArrayList<>();
    private Context mcontext;
    int resources;
    private OnClickListener callback;
    private LayoutInflater mInflater;
    private String sellerProductPic;
    private SellerProduct sellerProduct;

    public SellerProductAdapter(Context mcontext, ArrayList<SellerProduct> sellerProducts1,OnClickListener callback) {
        this.sellerProducts = sellerProducts1;
        this.mcontext = mcontext;
        this.callback = callback;
    }

    public SellerProductAdapter(Context context, int resources, ArrayList<SellerProduct> sellerProducts1,OnClickListener callback) {
        this.sellerProducts = sellerProducts1;
        this.mcontext = context;
        this.resources = resources;
        this.callback = callback;

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    itemsListFilter = sellerProducts;
                } else {
                    List<SellerProduct> filteredList = new ArrayList<>();
                    for (SellerProduct sellerProduct1 : sellerProducts) {
                        if (sellerProduct1.getSellerProductName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(sellerProduct1);
                        }
                    }
                    itemsListFilter = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = itemsListFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                itemsListFilter = (ArrayList<SellerProduct>) filterResults.values;

                notifyDataSetChanged();
            }
        };
    }
    public void filterAll( String pack ) {

        itemsListFilter.clear();

        if (pack.length() < 0) {
            itemsListFilter.addAll(sellerProducts);
        } else {
            for (SellerProduct ls : sellerProducts) {

                if (ls.getSellerProductName().contains(pack)) {

                    itemsListFilter.add(ls);

                }

            }
            notifyDataSetChanged();
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.seller_product_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SellerProduct sellerProduct = sellerProducts.get(position);

        if(sellerProduct !=null){
            sellerProductPic = sellerProduct.getSellerProductPicImage();
        }
        holder.callback = callback;
        holder.status.setText(MessageFormat.format("Type:{0}", sellerProduct.getSellerProductStatus()));
        holder.txtShippingFee.setText(MessageFormat.format("Delivery:{0}", sellerProduct.getSellerProductShippingFee()));
        holder.txtDelivery.setText(MessageFormat.format("Shipping Fee:{0}", sellerProduct.isDeliveryAvailable()));
        holder.txtQty.setText(MessageFormat.format("Qty:{0}", sellerProduct.getSellerProductQty()));
        holder.currency.setText(MessageFormat.format("Currency:{0}", sellerProduct.getSellerProductCurrency()));
        holder.txtTittle.setText(MessageFormat.format("Tittle:{0}", sellerProduct.getSellerProductName()));
        holder.txtDescrip.setText(MessageFormat.format("Desc:{0},{1}", sellerProduct.getSellerProductDisc()));
        holder.txtLoc.setText(MessageFormat.format("Location:{0},{1}", sellerProduct.getSellerProductLoc()));
        holder.txtPrice.setText(MessageFormat.format("Package Amount: NGN{0}", String.format("%.2f", sellerProduct.getSellerProductPrice())));

        //Glide.with(mcontext).load(sellerProductPic).fitCenter().into(holder.productImage);

        Glide.with(mcontext)
                .load(sellerProductPic)
                .error(R.drawable.user1)
                .override(200, 100)
                .centerCrop()
                .into(holder.productImage);

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.btnMore.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        holder.status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null){
                    callback.onItemClick(sellerProduct);
                }
            }
        });
        holder.txtDescrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null){
                    callback.onItemClick(sellerProduct);
                }
            }
        });
        holder.txtTittle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null){
                    callback.onItemClick(sellerProduct);
                }
            }
        });
        holder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null){
                    callback.onItemClick(sellerProduct);
                }
            }
        });

    }
    @Override
    public int getItemCount() {
        return (null != sellerProducts ? sellerProducts.size() : 0);
    }

    public void setCallback(OnClickListener callback) {
        this.callback = callback;
    }

    public OnClickListener getCallback() {
        return callback;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public AppCompatImageView productImage;
        private TextView txtTittle,txtDescrip,txtLoc,txtPrice,txtQty,currency, status,txtDelivery,txtShippingFee;
        public AppCompatButton btnMore;
        private ArrayList<PictureImage> profPicImages;

        protected OnClickListener callback;

        public ViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.b_prod_pic);
            txtTittle = itemView.findViewById(R.id.product_name);
            txtDescrip = itemView.findViewById(R.id.prod_description);
            txtLoc = itemView.findViewById(R.id.prod_loc);
            txtPrice = itemView.findViewById(R.id.prod_price);
            btnMore = itemView.findViewById(R.id.buttonProduct_More);

            txtQty = itemView.findViewById(R.id.prod_qty);
            currency = itemView.findViewById(R.id.prod_currency);
            status = itemView.findViewById(R.id.product_status);
            itemView.setOnClickListener(this);



        }
        public void setCallback(OnClickListener callback) {
            this.callback = callback;
        }

        @Override
        public void onClick(View view) {
            onItemClick(view, getAdapterPosition());
        }
    }

    private void onItemClick(View view, int adapterPosition) {
        onItemClick(view, adapterPosition);


    }

    public interface OnClickListener {
        //void onItemClick(int position, View view);
        void onItemClick(SellerProduct sellerProduct);
    }


}
