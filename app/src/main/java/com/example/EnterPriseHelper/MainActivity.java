package com.example.EnterPriseHelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rc;
    SingleTonData data;
    Button b;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            b = findViewById(R.id.button);

            data = SingleTonData.getInstance(this);
            // Initialize RecyclerView
            rc = findViewById(R.id.recyclelist);
            rc.setLayoutManager(new LinearLayoutManager(this));

            AdapterClass adc = new AdapterClass(this, data.getList());
            rc.setAdapter(adc);

            b.setOnClickListener(view -> {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            });


        }catch (Exception e)
        {
            Log.i("MainActivity1", "onCreate: "+ e.getMessage());
        }
    }
}
