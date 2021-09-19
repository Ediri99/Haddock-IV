package com.example.doolshe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShopOwnerRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_shop_owner_registration);

        EditText mobileNumber = findViewById(R.id.tie_shopMobileNumber);
        EditText shopName = findViewById(R.id.tie_shopname);
        EditText location = findViewById(R.id.tie_shoplocation);
        EditText ownerName = findViewById(R.id.tie_ownername);
        EditText password = findViewById(R.id.tie_shopPassword);

        Button btnRegister = findViewById(R.id.btnSignupAsOwner);

        DAOShopRegistration dao = new DAOShopRegistration();
        btnRegister.setOnClickListener(v->
        {
            ShopRegistration shopReg = new ShopRegistration( shopName.getText().toString(), location.getText().toString(), ownerName.getText().toString(), Integer.parseInt(mobileNumber.getText().toString()), password.getText().toString());
            dao.add(shopReg).addOnSuccessListener(suc ->
            {
                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
                    {
                        Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                    });


            Intent shopOwnerReg = new Intent(ShopOwnerRegistration.this, ShopOwnerDashboard.class);
            startActivity(shopOwnerReg);
        });

    }
}