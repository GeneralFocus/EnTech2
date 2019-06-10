package com.capriquota.entech.request;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.capriquota.entech.R;

public class RequestActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter1;
    Spinner meter_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        meter_type = findViewById(R.id.meter_type);
        String[] items = new String[]{"Post Paid Meter","Pre Paid Meter"};
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        meter_type.setAdapter(adapter1);
    }
}
