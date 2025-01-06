package com.example.EnterPriseHelper;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardView extends RecyclerView.ViewHolder {
    TextView company,product,number,quantity,rate,total;
    Button Del,Ready;

    public CardView(@NonNull View itemView) {
        super(itemView);
        company = itemView.findViewById(R.id.companyName);
        product = itemView.findViewById(R.id.productName);
        number = itemView.findViewById(R.id.number);
        quantity = itemView.findViewById(R.id.quantity);
        rate = itemView.findViewById(R.id.rate);
        total = itemView.findViewById(R.id.total);

            Del = itemView.findViewById(R.id.del);
            Ready = itemView.findViewById(R.id.ready);
    }
}
