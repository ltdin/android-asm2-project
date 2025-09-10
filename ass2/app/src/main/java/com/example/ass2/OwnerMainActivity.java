package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Currency;

public class OwnerMainActivity extends AppCompatActivity {
    RecyclerView ownerRecyclerView;
    OwnerDatabaseHelper ownerDB;
    ArrayList<String> site_user_id, site_user_name, site_user_phone;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_main);
        ownerRecyclerView = findViewById(R.id.ownerRecyclerView);


        ownerDB = new OwnerDatabaseHelper(OwnerMainActivity.this);
        site_user_id = new ArrayList<>();
        site_user_name = new ArrayList<>();
        site_user_phone = new ArrayList<>();


        storeDataInArray();

        userAdapter = new UserAdapter(OwnerMainActivity.this, site_user_id,site_user_name,site_user_phone);
        ownerRecyclerView.setAdapter(userAdapter);
        ownerRecyclerView.setLayoutManager(new LinearLayoutManager(OwnerMainActivity.this));

    }

    void storeDataInArray(){
        Cursor cursor = ownerDB.readData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                site_user_id.add(cursor.getString(0));
                site_user_name.add(cursor.getString(1));
                site_user_phone.add(cursor.getString(2));


            }
        }
    }
}