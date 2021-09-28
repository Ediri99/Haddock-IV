package com.example.doolshe;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.doolshe.R;

public class ShopOwnerDashboard extends AppCompatActivity {

    Button myShop;
    Button myOrders;
    Button customerOrders;
    Button reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_shop_owner_dashboard);
        myShop = (Button) findViewById(R.id.btnMyShop);
        myShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shopOwnerLogin = new Intent(ShopOwnerDashboard.this, ProductList.class);
                startActivity(shopOwnerLogin);
            }
        });
        myOrders = (Button) findViewById(R.id.btnMyOrders);
        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shopOwnerLogin = new Intent(ShopOwnerDashboard.this, AllSellersOrders.class);
                startActivity(shopOwnerLogin);
            }
        });
        customerOrders= (Button) findViewById(R.id.btnCustomerOrders);
        customerOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shopOwnerLogin = new Intent(ShopOwnerDashboard.this, OrdersList.class);
                startActivity(shopOwnerLogin);
            }
        });

        reviews = (Button) findViewById(R.id.btnMyReveiws);
        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reviews = new Intent(ShopOwnerDashboard.this,AllReviews.class);
                startActivity(reviews);
                /*finish();*/
            }
        });
    }
}

