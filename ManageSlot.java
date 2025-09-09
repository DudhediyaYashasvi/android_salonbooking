package com.snjb.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ManageSlot extends AppCompatActivity {

    EditText editSlot;
    Button btnAddSlot;
    ListView slotList;

    ArrayAdapter<String> adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_slot);

        editSlot = findViewById(R.id.editSlot);
        btnAddSlot = findViewById(R.id.btnAddSlot);
        slotList = findViewById(R.id.slotList);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DataHolder.slots);
        slotList.setAdapter(adapter);

        btnAddSlot.setOnClickListener(v -> {
            String slot = editSlot.getText().toString().trim();
            if (!slot.isEmpty()) {
                DataHolder.slots.add(slot);
                adapter.notifyDataSetChanged();
                editSlot.setText("");
            }
        });
    }
}