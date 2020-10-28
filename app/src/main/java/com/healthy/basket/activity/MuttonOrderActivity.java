package com.healthy.basket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.healthy.basket.R;

public class MuttonOrderActivity extends AppCompatActivity {



    private int mini_qnt=500, qnt_price=300, res_qnt=1, res_price, tempqnt=500;
    TextView txt_quantity_display, txt_minus_qnt, txt_plus_qnt, txt_reserved_qnt, txt_reserved_price;
    CardView add_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_mutton);

        txt_quantity_display=findViewById(R.id.txt_AddToCart_qty);
        txt_minus_qnt=findViewById(R.id.txt_AddToCart_qtyMinus);
        txt_plus_qnt=findViewById(R.id.txt_AddToCart_qtyPlus);
        add_cart=findViewById(R.id.card_AddToCart_add);
        txt_reserved_qnt=findViewById(R.id.txt_Quantity);
        txt_reserved_price=findViewById(R.id.txt_AddToCart_amount);


        calculateRaji();

        txt_plus_qnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res_qnt++;
                tempqnt=tempqnt+mini_qnt;
                calculateRaji();
            }
        });
        txt_minus_qnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res_qnt--;
                tempqnt=tempqnt-mini_qnt;
                calculateRaji();
            }
        });

        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MuttonOrderActivity.this, "Rey Code Rayi Raa Mama...", Toast.LENGTH_LONG).show();


            }
        });


    }

    private void calculateRaji() {

        res_price=res_qnt*qnt_price;
        txt_reserved_price.setText("₹ "+res_price);
        txt_quantity_display.setText(new String(String.valueOf(res_qnt)));
        txt_reserved_qnt.setText(tempqnt+"gm");

    }

}