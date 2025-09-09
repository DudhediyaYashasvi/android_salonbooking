package com.snjb.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class OwnerLoginActivity extends AppCompatActivity {

    EditText etOwnerUsername, etOwnerPassword;
    Button btnOwnerLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login); // Connect with your XML

        etOwnerUsername = findViewById(R.id.etOwnerUsername);
        etOwnerPassword = findViewById(R.id.etOwnerPassword);
        btnOwnerLogin = findViewById(R.id.btnOwnerLogin);

        btnOwnerLogin.setOnClickListener(v -> {
            String username = etOwnerUsername.getText().toString().trim();
            String password = etOwnerPassword.getText().toString().trim();

            if (username.equals("owner") && password.equals("owner123")) {
                Toast.makeText(this, "Owner Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, OwnerDashboardActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid owner credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}