package com.ls.awajimatradeeder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.ls.awajimatradeeder.Classes.PictureImage;
import com.ls.awajimatradeeder.R;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class PictureImgAdapter extends RecyclerView.Adapter<PictureImgAdapter.ViewHolder> {

    private ArrayList<PictureImage> pictureImageArrayList;
    private List<PictureImage> sellerProductList;
    private Context mcontext;
    int resources;
    private OnClickListener callback;
    private LayoutInflater mInflater;

    public PictureImgAdapter(Context mcontext, ArrayList<PictureImage> pictureImages, OnClickListener callback) {
        this.pictureImageArrayList = pictureImages;
        this.mcontext = mcontext;
        this.callback = callback;
    }

    public PictureImgAdapter(Context context, int resources, ArrayList<PictureImage> imageArrayList, OnClickListener callback) {
        this.pictureImageArrayList = imageArrayList;
        this.mcontext = context;
        this.resources = resources;
        this.callback = callback;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.pic_img_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PictureImage pictureImage = pictureImageArrayList.get(position);
        holder.callback = callback;
        holder.status.setText(MessageFormat.format("Status:{0}", pictureImage.getPicImageStatus()));
        holder.txtTittle.setText(MessageFormat.format("Tittle:{0}", pictureImage.getPicImageTittle()));
        holder.txtPurpose.setText(MessageFormat.format("Desc:{0},{1}", pictureImage.getPicImagePurpose()));
        holder.txtProductID.setText(MessageFormat.format("Product ID:{0},{1}", pictureImage.getPicImageSellerProductID()));
        holder.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.btnBack.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });

    }
    @Override
    public int getItemCount() {
        return (null != pictureImageArrayList ? pictureImageArrayList.size() : 0);
    }

    public void setCallback(OnClickListener callback) {
        this.callback = callback;
    }

    public OnClickListener getCallback() {
        return callback;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public AppCompatImageView productImage;
        private TextView txtTittle, txtPurpose, txtProductID, status;
        public AppCompatButton btnBack;
        protected OnClickListener callback;

        public ViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.picImage);
            txtTittle = itemView.findViewById(R.id.pic_tittle);
            txtPurpose = itemView.findViewById(R.id.pic_purpose);
            txtProductID = itemView.findViewById(R.id.pic_product_ID);
            btnBack = itemView.findViewById(R.id.btn_pix_More);
            status = itemView.findViewById(R.id.pic_status);
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

    }

    public interface OnClickListener {
        //void onItemClick(int position, View view);
        void onItemClick(PictureImage pictureImage);
    }

}
