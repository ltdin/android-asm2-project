package com.example.ass2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList site_id, site_name, site_owner, site_location, site_amount;

    CustomAdapter(Context context, ArrayList site_id, ArrayList site_name, ArrayList site_owner, ArrayList site_location, ArrayList site_amount){
        this.context = context;
        this.site_id = site_id;
        this.site_name = site_name;
        this.site_owner = site_owner;
        this.site_location = site_location;
        this.site_amount = site_amount;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.site_id_txt.setText(String.valueOf(site_id.get(position)));
        holder.site_name_txt.setText(String.valueOf(site_name.get(position)));
        holder.site_owner_txt.setText(String.valueOf(site_owner.get(position)));
        holder.site_location_txt.setText(String.valueOf(site_location.get(position)));
        holder.site_amount_txt.setText(String.valueOf(site_amount.get(position)));


    }

    @Override
    public int getItemCount() {
        return site_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView site_id_txt, site_name_txt, site_owner_txt, site_location_txt, site_amount_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            site_id_txt = itemView.findViewById(R.id.site_id_txt);
            site_name_txt = itemView.findViewById(R.id.site_name_txt);
            site_owner_txt = itemView.findViewById(R.id.site_owner_txt);
            site_location_txt = itemView.findViewById(R.id.site_location_txt);
            site_amount_txt = itemView.findViewById(R.id.site_amount_txt);
        }
    }
}
