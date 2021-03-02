package com.example.projectconvert.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.example.projectconvert.R;

public class MainActivity extends AppCompatActivity {

    Button massBtn, tempBtn, dataBtn, gpsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        massBtn = findViewById(R.id.button3);
        tempBtn = findViewById(R.id.button);
        dataBtn = findViewById(R.id.button4);
        gpsBtn = findViewById(R.id.button2);
        massBtn.setOnClickListener((v) -> {
            Intent intent = new Intent(this, MassConverter.class);
            startActivity(intent);
        });

        tempBtn.setOnClickListener((v) -> {
            Intent intent = new Intent(this, TempConverter.class);
            startActivity(intent);
        });

        dataBtn.setOnClickListener((v) -> {
            Intent intent = new Intent(this, DataConverter.class);
            startActivity(intent);
        });



        gpsBtn.setOnClickListener((v) -> {
            final String appPackageName = getPackageName();
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }

        });
    }
}