package com.maku.zawaditestapp.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maku.zawaditestapp.POJO.SearchedByName;
import com.maku.zawaditestapp.R;
import com.maku.zawaditestapp.ui.RestaurantActivity;
import com.maku.zawaditestapp.ui.RestaurantDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class MyRestaurantViewAdapt0er extends RecyclerView.Adapter<MyRestaurantViewAdapt0er.ViewHolder> {

    private ArrayList<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public MyRestaurantViewAdapt0er(RestaurantActivity restaurantActivity,  ArrayList<String> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(restaurantActivity);;
    }

    @NonNull
    @Override
    public MyRestaurantViewAdapt0er.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.restaurant_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRestaurantViewAdapt0er.ViewHolder viewHolder, int i) {

        String name = mData.get(i);
        viewHolder.myTextView.setText(name);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setClickListener(RestaurantActivity restaurantActivity) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView myTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvRestaurantName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
            int i = getAdapterPosition();

            switch (i){
                case 0:
                    Intent intent1=new Intent(v.getContext(), RestaurantDetailActivity.class);
                    intent1.putExtra("restaurant" , mData.get(i));
                    v.getContext().startActivity(intent1);
                    Log.d("MyRestaurant", "onClick: " + mData.get(i));
                    Toast.makeText(v.getContext(), "Recycle Click " +mData.get(i) , Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                Intent intent=new Intent(v.getContext(), RestaurantDetailActivity.class);
                intent.putExtra("restaurant" , mData.get(i));
                v.getContext().startActivity(intent);
                    Log.d("MyRestaurant", "onClick: " + mData.get(i));
                    Toast.makeText(v.getContext(), "Recycle Click " +mData.get(i) , Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Intent intent2=new Intent(v.getContext(),RestaurantDetailActivity.class);
                intent2.putExtra("restaurant" , mData.get(i));
                v.getContext().startActivity(intent2);
                Log.d("MyRestaurant", "onClick: " + mData.get(i));
                Toast.makeText(v.getContext(), "Recycle Click " +mData.get(i) , Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Intent intent3=new Intent(v.getContext(),RestaurantDetailActivity.class);
                intent3.putExtra("restaurant" , mData.get(i));
                v.getContext().startActivity(intent3);
                Log.d("MyRestaurant", "onClick: " + mData.get(i));
                Toast.makeText(v.getContext(), "Recycle Click " +mData.get(i) , Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Intent intent4=new Intent(v.getContext(),RestaurantDetailActivity.class);
                intent4.putExtra("restaurant" , mData.get(i));
                v.getContext().startActivity(intent4);
                Log.d("MyRestaurant", "onClick: " + mData.get(i));
                Toast.makeText(v.getContext(), "Recycle Click " +mData.get(i) , Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
