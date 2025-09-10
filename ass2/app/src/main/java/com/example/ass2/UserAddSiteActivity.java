package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class UserAddSiteActivity extends AppCompatActivity {
    private Site site;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add_site);
        site = new Site();
        Intent intent = getIntent();
        site.latitude = intent.getDoubleExtra("latitude", 0);
        site.longitude = intent.getDoubleExtra("longitude", 0);
        EditText resLat = findViewById(R.id.resLat);
        resLat.setText(site.latitude + "");
        EditText resLong = findViewById(R.id.resLong);
        resLong.setText(site.longitude + "");
    }
    public void onConfirmAddSite(View view) {
        EditText resName = findViewById(R.id.resName);
        site.name = resName.getText().toString();
        EditText resOwner = findViewById(R.id.resOwner);
        site.owner = resOwner.getText().toString();
        new PostSite().execute();
    }
    private class PostSite extends AsyncTask<Void,Void,Void> {
        private String status = "";
        @Override
        protected Void doInBackground(Void... voids) {
            status = HttpHandler.postRequest(MapsActivity.SITE_API_URL, site);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(UserAddSiteActivity.this,
                    status, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UserAddSiteActivity.this,
                    MapsActivity.class);
            setResult(101, intent);
            finish();
        }
    }
}