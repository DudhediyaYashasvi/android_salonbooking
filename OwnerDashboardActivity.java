package com.snjb.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OwnerDashboardActivity extends AppCompatActivity {

    Button btnViewBookings, btnManageServices, btnManageSlots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_owner_dashboard);

        // Handle edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons
        btnViewBookings = findViewById(R.id.btnViewBookings);
        btnManageServices = findViewById(R.id.btnManageServices);
        btnManageSlots = findViewById(R.id.btnManageSlots);

        // Navigate to ViewBookingsActivity
        btnViewBookings.setOnClickListener(v -> {
            startActivity(new Intent(OwnerDashboardActivity.this, OwnerDashboardActivity.class));
        });

        // Navigate to ManageServicesActivity
        btnManageServices.setOnClickListener(v -> {
            startActivity(new Intent(OwnerDashboardActivity.this, ManageServicesActivity.class));
        });

        // Navigate to ManageSlot Activity
        btnManageSlots.setOnClickListener(v -> {
            startActivity(new Intent(OwnerDashboardActivity.this, ManageSlot.class));
        });
    }
}