package com.snjb.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceBookingActivity extends AppCompatActivity {

    TextView tvSalonName;
    CheckBox cbHaircut, cbFacial, cbBeard;
    EditText etTimeSlot;
    Button btnConfirmBooking;

    String salonName;
    String area; // optional: passed from previous activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_booking); // Make sure layout file exists

        // Bind UI
        tvSalonName = findViewById(R.id.tvSalonName);
        cbHaircut = findViewById(R.id.cbHaircut);
        cbFacial = findViewById(R.id.cbFacial);
        cbBeard = findViewById(R.id.cbBeard);
        etTimeSlot = findViewById(R.id.etTimeSlot);
        btnConfirmBooking = findViewById(R.id.btnConfirmBooking);

        // Get data from intent
        salonName = getIntent().getStringExtra("salon");
        area = getIntent().getStringExtra("area"); // optional use

        // Show salon name
        tvSalonName.setText("Booking at: " + salonName);

        // Confirm Booking Button Click
        btnConfirmBooking.setOnClickListener(v -> {
            StringBuilder services = new StringBuilder();

            if (cbHaircut.isChecked()) services.append("Haircut, ");
            if (cbFacial.isChecked()) services.append("Facial, ");
            if (cbBeard.isChecked()) services.append("Beard Trim, ");

            String timeSlot = etTimeSlot.getText().toString().trim();

            if (services.length() == 0 || timeSlot.isEmpty()) {
                Toast.makeText(this, "Please select at least one service and a time slot", Toast.LENGTH_SHORT).show();
                return;
            }

            // Remove last comma and space
            String finalServices = services.substring(0, services.length() - 2);

            // Build booking message
            String message = "Salon: " + salonName + "\n"
                    + "Area: " + area + "\n"
                    + "Services: " + finalServices + "\n"
                    + "Time: " + timeSlot;

            // Display simulated confirmation
            Toast.makeText(this, "Booking Confirmed!\n\n" + message, Toast.LENGTH_LONG).show();

            // 🔁 In real app: send this to Firebase or notify owner via backend
        });
    }
}