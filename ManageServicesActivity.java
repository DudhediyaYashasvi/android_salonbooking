package com.snjb.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

class ManageServicesActivity extends AppCompatActivity {

    EditText editService;
    Button btnAddService;
    ListView serviceList;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_services);

        editService = findViewById(R.id.editService);
        btnAddService = findViewById(R.id.btnAddService);
        serviceList = findViewById(R.id.serviceList);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DataHolder.services);
        serviceList.setAdapter(adapter);

        btnAddService.setOnClickListener(v -> {
            String service = editService.getText().toString().trim();
            if (!service.isEmpty()) {
                DataHolder.services.add(service);
                adapter.notifyDataSetChanged();
                editService.setText("");
            }
        });
    }
}