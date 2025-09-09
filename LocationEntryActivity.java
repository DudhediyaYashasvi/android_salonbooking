package com.snjb.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LocationEntryActivity extends AppCompatActivity {

    EditText etLocation;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_entry); // Make sure your XML is named location_entry.xml

        // Bind views
        etLocation = findViewById(R.id.etLocation);
        btnSearch = findViewById(R.id.btnSearch);

        // Handle button click
        btnSearch.setOnClickListener(v -> {
            String area = etLocation.getText().toString().trim();

            if (!area.isEmpty()) {
                // 🔁 Go to SalonListActivity and pass the area value
                Intent intent = new Intent(LocationEntryActivity.this, SalonListActivity.class);
                intent.putExtra("area", area);
                startActivity(intent);
            } else {
                Toast.makeText(LocationEntryActivity.this, "Please enter an area", Toast.LENGTH_SHORT).show();
            }
        });
    }
}