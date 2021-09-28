package com.example.doolshe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerOrders extends AppCompatActivity {


    Button calTotal, next;
    TextView itemName, price, totAmount;
    EditText quantity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_customer_orders);

        calTotal = (Button) findViewById(R.id.btnCalTot);
        next = (Button) findViewById(R.id.btnNext);
        itemName = (TextView) findViewById(R.id.etItemNameInput);
        price = (TextView) findViewById(R.id.etPriceInput);
        quantity = (EditText) findViewById(R.id.etQuantityInput);
        totAmount = (TextView) findViewById(R.id.etTotalAmount);

        String oitemName = getIntent().getStringExtra("itemName");
        String oprice = getIntent().getStringExtra("price");
        String oquantity = getIntent().getStringExtra("quantity");

        itemName.setText(oitemName);
        price.setText(oprice);
        quantity.setText(oquantity);

        calTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer qty = Integer.parseInt(quantity.getText().toString());
                Integer pr = Integer.parseInt(price.getText().toString());

                calctotalAmount(qty, pr);

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String iname = itemName.getText().toString();
                String iprice = totAmount.getText().toString();
                String iqty = quantity.getText().toString();
                Intent showDetails = new Intent(CustomerOrders.this, CustomerOrderDetails.class);

                showDetails.putExtra("itemName", iname);
                showDetails.putExtra("itemPrice", iprice);
                showDetails.putExtra("itemQuantity", iqty);

                startActivity(showDetails);
            }
        });
    }

    private void calctotalAmount(int qty, int pr){

        //qty = Integer.parseInt(quantity.getText().toString());

        int total = qty * pr;

        String totalString = Integer.toString(total);

        totAmount.setText(totalString);
    }
}

