package com.example.ass2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context context;
    private ArrayList site_user_id, site_user_name, site_user_phone;

    UserAdapter(Context context, ArrayList site_user_id, ArrayList site_user_name, ArrayList site_user_phone){
        this.context = context;
        this.site_user_id = site_user_id;
        this.site_user_name = site_user_name;
        this.site_user_phone = site_user_phone;


    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.owner_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.site_user_id_txt.setText(String.valueOf(site_user_id.get(position)));
        holder.site_user_name_txt.setText(String.valueOf(site_user_name.get(position)));
        holder.site_user_phone_txt.setText(String.valueOf(site_user_phone.get(position)));



    }

    @Override
    public int getItemCount() {
        return site_user_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView site_user_id_txt, site_user_name_txt, site_user_phone_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            site_user_id_txt = itemView.findViewById(R.id.site_user_id_txt);
            site_user_name_txt = itemView.findViewById(R.id.site_user_name_txt);
            site_user_phone_txt = itemView.findViewById(R.id.site_user_phone_txt);
        }
    }
}
