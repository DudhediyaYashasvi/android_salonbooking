package com.snjb.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class FrontPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // ✅ Ensure this XML file exists

        // Splash delay of 2 seconds then open WelcomeActivity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(FrontPage.this, WelcomeActivity.class);
            startActivity(intent);
            finish(); // Prevents back navigation to splash
        }, 2000); // 2 seconds
    }
}