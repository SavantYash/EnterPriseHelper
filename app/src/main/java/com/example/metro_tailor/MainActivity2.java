package com.example.metro_tailor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button b1;
    String Company,Product,Number,Quantity,Rate,Total;
    EditText company,product,number,quantity,rate;
    TextView total;
    DBHelper db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            b1 = (Button) findViewById(R.id.btn1);
            db = new DBHelper(this);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    company = (EditText) findViewById(R.id.companyName);
                    product = (EditText) findViewById(R.id.productName);
                    number = (EditText) findViewById(R.id.Number);
                    quantity =(EditText) findViewById(R.id.Quantity);
                    rate =(EditText) findViewById(R.id.Rate);
                    total =(TextView) findViewById(R.id.total);

                    Company = String.valueOf(company.getText());
                    Product = String.valueOf(product.getText());
                    Number = String.valueOf(number.getText());
                    Quantity = String.valueOf(quantity.getText());
                    Rate = String.valueOf(rate.getText());

                    float t = Float.parseFloat(Quantity) * Float.parseFloat(Rate);
                    total.setText(String.valueOf(t));


                    db.AddData(Company,Product,Number,Quantity,Rate,String.valueOf(t));
                    Intent i = new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(i);
                }
            });
        }catch(Exception e)
        {
            Log.e("MainActivity2", "Error: " +e.getMessage());
        }
    }
}