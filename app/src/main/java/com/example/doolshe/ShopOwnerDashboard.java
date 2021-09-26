package com.example.doolshe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ShopOwnerDashboard extends AppCompatActivity {

    Button myShop;
    Button myOrders;
    Button myAccount;
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
                Intent shopOwnerLogin = new Intent(ShopOwnerDashboard.this, ShopOwnerMyOrders.class);
                startActivity(shopOwnerLogin);
            }
        });
        myAccount= (Button) findViewById(R.id.btnMyAccount);
        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shopOwnerLogin = new Intent(ShopOwnerDashboard.this, ShopOwnerProfile.class);
                startActivity(shopOwnerLogin);
            }
        });

     /*   reviews = (Button) findViewById(R.id.btnReviews);
        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addReview = new Intent(ShopOwnerDashboard.this,AllReviews.class);
                startActivity(addReview);
                /*finish();
            }
        });*/
    }
}

