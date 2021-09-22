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
    Button myAccount;
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
                Intent shopOwnerLogin = new Intent(ShopOwnerDashboard.this, ShopOwnerMyShop.class);
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
    }
}

