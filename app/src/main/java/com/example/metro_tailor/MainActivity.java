package com.example.metro_tailor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
