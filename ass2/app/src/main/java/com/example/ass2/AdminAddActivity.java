package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminAddActivity extends AppCompatActivity {
    EditText siteNameEditText, siteOwnerEditText, siteLocationEditText, siteAmountEditText;
    Button adminSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add);
        siteNameEditText = findViewById(R.id.siteNameEditText);
        siteOwnerEditText = findViewById(R.id.siteOwnerEditText);
        siteLocationEditText = findViewById(R.id.siteLocationEditText);
        siteAmountEditText = findViewById(R.id.siteAmountEditText);
        adminSaveButton = findViewById(R.id.adminSaveButton);
        adminSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminDatabaseHelper adDB = new AdminDatabaseHelper(AdminAddActivity.this);
                adDB.addSite(siteNameEditText.getText().toString().trim(),siteOwnerEditText.getText().toString().trim(),siteLocationEditText.getText().toString().trim(),Integer.parseInt(siteAmountEditText.getText().toString().trim()));
            }
        });

    }
}