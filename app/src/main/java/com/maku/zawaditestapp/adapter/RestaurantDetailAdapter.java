package com.maku.zawaditestapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maku.zawaditestapp.POJO.Search;
import com.maku.zawaditestapp.POJO.SearchedByName;
import com.maku.zawaditestapp.R;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDetailAdapter extends RecyclerView.Adapter<RestaurantDetailAdapter.ViewHolder> {

    private List<SearchedByName> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public RestaurantDetailAdapter(List<SearchedByName> data, Context context) {
        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public RestaurantDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.detail_row, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_row, parent, false);
        return new RestaurantDetailAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantDetailAdapter.ViewHolder holder, int i) {
        String name = mData.get(i).getName();
        String price = String.valueOf(mData.get(i).getPrice());
        holder.mTextView.setText(name);
        holder.mTextViewPrice.setText(price);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        TextView mTextViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(R.id.nom);
            mTextViewPrice = itemView.findViewById(R.id.price);
        }
    }
}
