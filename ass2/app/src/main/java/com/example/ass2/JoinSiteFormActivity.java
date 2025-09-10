package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class JoinSiteFormActivity extends AppCompatActivity {
    EditText fullNameEditText, phoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_site_form);
    }

    public void onSubmit(View view) {
        fullNameEditText = findViewById(R.id.fullNameEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        String fullName = fullNameEditText.getText().toString();
        String phoneNumber = phoneNumberEditText.getText().toString();

        OwnerDatabaseHelper ownerDB = new OwnerDatabaseHelper(JoinSiteFormActivity.this);
        ownerDB.addMember(fullNameEditText.getText().toString().trim(), Integer.valueOf(phoneNumberEditText.getText().toString().trim()));

        Toast.makeText(this, "Added "+ fullName + " into Site.", Toast.LENGTH_SHORT).show();

    }

    public void onAddMore(View view) {
        EditText fullNameEditText = findViewById(R.id.fullNameEditText);
        EditText phoneNumberEditText = findViewById(R.id.phoneNumberEditText);fullNameEditText.setText("");
        phoneNumberEditText.setText("");


    }

    public void backMapsActivity(View view) {
        Intent i1 = new Intent(JoinSiteFormActivity.this, MapsActivity.class);
        setResult(101, i1);
        finish();
    }
}