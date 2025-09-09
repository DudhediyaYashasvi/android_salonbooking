package com.snjb.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome); // ✅ Ensure this layout exists

        Button btnSignIn = findViewById(R.id.btnSignIn);
        Button btnSignUp = findViewById(R.id.btnSignUp);
        @SuppressLint("MissingInflatedId") Button btnOwnerLogin  = findViewById(R.id.btnOwnerLogin);

        // Go to Login screen
        btnSignIn.setOnClickListener(v -> {
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));

        });

        btnOwnerLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, OwnerLoginActivity.class));
        });


        // Go to SignUp screen
        btnSignUp.setOnClickListener(v -> {
            startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class));
        });
    }
}