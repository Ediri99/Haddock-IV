package com.example.doolshe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ChooseRegistration extends AppCompatActivity {

    Button registerAsCustomer;
    Button registerAsShopOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_choose_registration);

        registerAsCustomer = (Button)findViewById(R.id.btnRegisterAsCustomer);
        registerAsCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customerLogin = new Intent(ChooseRegistration.this,CustomerRegistration.class);
                startActivity(customerLogin);
                /*finish();*/
            }
        });

        registerAsShopOwner = (Button) findViewById(R.id.btnRegisterAsShopOwner);
        registerAsShopOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shopOwnerLogin = new Intent(ChooseRegistration.this,ShopOwnerRegistration.class);
                startActivity(shopOwnerLogin);
                /*finish();*/
            }
        });

    }
}