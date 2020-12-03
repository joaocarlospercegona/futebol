package com.example.futebol.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterTimes extends RecyclerView.Adapter<AdapterTimes.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, owner;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
