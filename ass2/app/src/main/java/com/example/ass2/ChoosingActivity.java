package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoosingActivity extends AppCompatActivity {
    Button goToMaps, listMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing);
        goToMaps = findViewById(R.id.goToMaps);
        listMember = findViewById(R.id.listMember);
        goToMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(ChoosingActivity.this, MapsActivity.class);
                startActivity(intent3);
            }
        });
        listMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(ChoosingActivity.this, OwnerMainActivity.class);
                startActivity(intent3);
            }
        });
    }
}