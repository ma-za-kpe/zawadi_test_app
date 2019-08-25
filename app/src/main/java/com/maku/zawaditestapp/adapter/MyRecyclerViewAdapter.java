package com.maku.zawaditestapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maku.zawaditestapp.R;
import com.maku.zawaditestapp.model.formules;
import com.maku.zawaditestapp.ui.MainActivity;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<formules> mFormules;
    private LayoutInflater mInflater;
//    private ItemClickListener mClickListener;

    public MyRecyclerViewAdapter(MainActivity mainActivity, ArrayList<formules> mFormules) {
        this.mFormules = mFormules;
        this.mInflater =  LayoutInflater.from(mainActivity);
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recyclerview_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder viewHolder, int i) {
        String formule = mFormules.get(i).getFormule().toString();
        String url = mFormules.get(i).getUrl().toString();
        viewHolder.myFormule.setText(formule);
        viewHolder.myUrl.setText(url);
    }

    @Override
    public int getItemCount() {
        return mFormules.size();
    }

    public void setClickListener(MainActivity mainActivity) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView myFormule;
        TextView myUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myFormule = itemView.findViewById(R.id.tvformularName);
            myUrl = itemView.findViewById(R.id.tvformularUrl);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

//            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }

//        // convenience method for getting data at click position
//        formules getItem(int id) {
//            return mFormules.get(id);
//        }
//
//        // allows clicks events to be caught
//        void setClickListener(ItemClickListener itemClickListener) {
//            this.mClickListener = itemClickListener;
//        }
//
//        // parent activity will implement this method to respond to click events
//        public interface ItemClickListener {
//            void onItemClick(View view, int position);
//        }
    }
}
