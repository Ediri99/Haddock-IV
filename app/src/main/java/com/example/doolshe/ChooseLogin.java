package com.example.doolshe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseLogin extends AppCompatActivity {

    Button loginAsCustomer;
    Button loginAsShopOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_choose_login);

        loginAsCustomer = (Button)findViewById(R.id.btnCustomerLoginAs);
        loginAsCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customerLogin = new Intent(ChooseLogin.this,CustomerLogin.class);
                startActivity(customerLogin);
                /*finish();*/
            }
        });

        loginAsShopOwner = (Button) findViewById(R.id.btnShopOwnerLoginAs);
        loginAsShopOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shopOwnerLogin = new Intent(ChooseLogin.this,ShopOwnerLogin.class);
                startActivity(shopOwnerLogin);
                /*finish();*/
            }
        });

    }
}