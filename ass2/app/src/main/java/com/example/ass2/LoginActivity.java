package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button buttonLogin, signupButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        buttonLogin = findViewById(R.id.buttonLogin);
        signupButton = findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent1);
            }
        });
        DB = new DBHelper(this);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                Boolean checkuserpass = DB.checkusernamepassword(user, pass);

                if (user.equals("") || pass.equals("")) {

                    Toast.makeText(LoginActivity.this, "Please enter all the fields.", Toast.LENGTH_SHORT).show();
                } else {
                    if(user.equals("admin") && pass.equals("26062002") && checkuserpass == true){
                        Intent intent1 = new Intent(LoginActivity.this, AdminMainActivity.class);
                        startActivity(intent1);
                        Toast.makeText(LoginActivity.this, "Welcome Admin!", Toast.LENGTH_SHORT).show();
                    } else {

                    if (checkuserpass == true) {
                        Toast.makeText(LoginActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(LoginActivity.this, ChoosingActivity.class);
                        startActivity(intent1);
                    }
                    else{
                            Toast.makeText(LoginActivity.this, "Incorrect account, try again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}