package com.snjb.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewBookingsActivity extends AppCompatActivity {

    private ListView bookingList;
    private ArrayList<String> bookingsDisplay;
    private ArrayAdapter<String> adapter;
    private DatabaseReference bookingsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bookings);

        // Initialize Firebase (required for some cases)
        FirebaseApp.initializeApp(this);

        bookingList = findViewById(R.id.bookingList);
        bookingsDisplay = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookingsDisplay);
        bookingList.setAdapter(adapter);

        // Firebase path to salon bookings
        bookingsRef = FirebaseDatabase.getInstance()
                .getReference("bookings")
                .child("salonId123");

        bookingsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                bookingsDisplay.clear();

                if (!snapshot.exists()) {
                    bookingsDisplay.add("No bookings found.");
                }

                for (DataSnapshot bookingSnap : snapshot.getChildren()) {
                    String name = bookingSnap.child("customerName").getValue(String.class);
                    String services = bookingSnap.child("services").getValue(String.class);
                    String time = bookingSnap.child("timeSlot").getValue(String.class);
                    String status = bookingSnap.child("status").getValue(String.class);

                    String bookingInfo = "👤 Name: " + name +
                            "\n💇 Services: " + services +
                            "\n🕒 Time: " + time +
                            "\n📌 Status: " + status;

                    bookingsDisplay.add(bookingInfo);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ViewBookingsActivity.this,
                        "Failed to load bookings: " + error.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}