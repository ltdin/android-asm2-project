package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Currency;

public class AdminMainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton adminAddButton, adminDeleteButton;
    AdminDatabaseHelper adminDB;
    ArrayList<String> site_id, site_name, site_owner, site_location, site_amount;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        recyclerView = findViewById(R.id.recyclerView);
        adminAddButton = findViewById(R.id.adminAddButton);
        adminDeleteButton = findViewById(R.id.adminDeleteButton);
        adminAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(AdminMainActivity.this, AdminAddActivity.class);
                startActivity(intent6);

            }
        });
        adminDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminDatabaseHelper adDB = new AdminDatabaseHelper(AdminMainActivity.this);
                adDB.deleteAll();
                Toast.makeText(AdminMainActivity.this, "Deleted!", Toast.LENGTH_SHORT).show();
                recreate();

            }
        });

        adminDB = new AdminDatabaseHelper(AdminMainActivity.this);
        site_id = new ArrayList<>();
        site_name = new ArrayList<>();
        site_owner = new ArrayList<>();
        site_location = new ArrayList<>();
        site_amount = new ArrayList<>();

        storeDataInArray();

        customAdapter = new CustomAdapter(AdminMainActivity.this, site_id,site_name,site_owner,site_location,site_amount);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AdminMainActivity.this));

    }

    void storeDataInArray(){
        Cursor cursor = adminDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                site_id.add(cursor.getString(0));
                site_name.add(cursor.getString(1));
                site_owner.add(cursor.getString(2));
                site_location.add(cursor.getString(3));
                site_amount.add(cursor.getString(4));

            }
        }
    }

}