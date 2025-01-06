package com.example.EnterPriseHelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<CardView> {

    Context context;
    ArrayList<Model> model;
    SingleTonData sd;
    public AdapterClass(Context context, ArrayList<Model> list) {
        this.context = context;
        model = list;

    }

    @NonNull
    @Override
    public CardView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardforone,parent,false);
        return new CardView(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CardView holder, int position) {
        holder.company.setText(model.get(position).Company);
        holder.product.setText(model.get(position).Product);
        holder.quantity.setText(String.valueOf(model.get(position).Quantity + " M"));
        holder.rate.setText(String.valueOf(Float.parseFloat(model.get(position).Rate)));
        holder.total.setText(model.get(position).Total);
        holder.Del.setOnClickListener(view->{
            Log.d("DELDATa", "onBindViewHolder: " + model.get(position).id);
            sd.delData(model.get(position).id);
            notifyItemRemoved(position);
        });

    }

    @Override
    public int getItemCount() {
        return model.size();
    }
}
