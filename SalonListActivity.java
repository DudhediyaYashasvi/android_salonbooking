package com.snjb.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SalonListActivity extends AppCompatActivity {

    ListView listSalons;
    TextView tvArea;
    ArrayList<String> salonList;
    ArrayAdapter<String> salonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_list); // Make sure XML file exists

        // Bind views
        tvArea = findViewById(R.id.tvArea);
        listSalons = findViewById(R.id.listSalons);

        // ✅ Get area from intent
        String area = getIntent().getStringExtra("area");
        tvArea.setText("Salons in " + area);

        // Dummy salon data
        salonList = new ArrayList<>();
        salonList.add("Urban Cuts");
        salonList.add("Men's Lounge");
        salonList.add("Blades & Fades");

        // ✅ Use custom list item layout to set text color
        salonAdapter = new ArrayAdapter<>(this, R.layout.activity_salon_list, R.id.tvArea, salonList);
        listSalons.setAdapter(salonAdapter);

        // On item click → move to ServiceBookingActivity
        listSalons.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSalon = salonList.get(position);
            Intent intent = new Intent(SalonListActivity.this, ServiceBookingActivity.class);
            intent.putExtra("salon", selectedSalon);
            intent.putExtra("area", area); // Optional
            startActivity(intent);
        });
    }
}