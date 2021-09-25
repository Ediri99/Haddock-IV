package com.example.doolshe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShopOwnerRegistration extends AppCompatActivity {

    EditText mobileNumber, shopName, location, ownerName, password;
    Button btnRegister;

    DatabaseReference dbref;
    ShopRegistration sr;

    /*private void clearControls(){
        mobileNumber.setText("");
        shopName.setText("");
        location.setText("");
        ownerName.setText("");
        password.setText("");
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_shop_owner_registration);

         mobileNumber = findViewById(R.id.tie_shopMobileNumber);
         shopName = findViewById(R.id.tie_shopname);
         location = findViewById(R.id.tie_shoplocation);
         ownerName = findViewById(R.id.tie_ownername);
         password = findViewById(R.id.tie_shopPassword);

         btnRegister = findViewById(R.id.btnSignupAsOwner);


        sr = new ShopRegistration();
        dbref = FirebaseDatabase.getInstance().getReference().child("ShopRegistration");

        btnRegister.setOnClickListener(view ->{

            sr.setMobileNumber(Integer.parseInt(mobileNumber.getText().toString()));
            Integer number = sr.getMobileNumber();

            sr.setShopName(shopName.getText().toString());
            String sname =sr.getShopName();

            sr.setLocation(location.getText().toString());
            String loc =sr.getLocation();

            sr.setOwnerName(ownerName.getText().toString());
            String oname =sr.getOwnerName();

            sr.setPassword(password.getText().toString());
            String pwd =sr.getPassword();

            dbref.push().getKey();
            ShopRegistration sr = new ShopRegistration(number, sname, loc, oname, pwd);
            dbref.child(String.valueOf(number)).setValue(sr);
            Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();

            Intent shopOwnerReg = new Intent(ShopOwnerRegistration.this, ShopOwnerDashboard.class);
            startActivity(shopOwnerReg);
        });

       /*sr = new ShopRegistration();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbref = FirebaseDatabase.getInstance().getReference().child("ShopRegistration");

                try {

                    if (TextUtils.isEmpty(shopName.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter your shop name: ", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(location.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter your location: ", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(ownerName.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter your name: ", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(password.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter a password: ", Toast.LENGTH_SHORT).show();
                    } else {
                sr.setMobileNumber(Integer.parseInt(mobileNumber.getText().toString().trim()));
                sr.setShopName(shopName.getText().toString().trim());
                sr.setLocation(location.getText().toString().trim());
                sr.setOwnerName(ownerName.getText().toString().trim());
                sr.setPassword(password.getText().toString().trim());


                dbref.push().setValue(sr);
                

                Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                clearControls();

                Intent shopOwnerReg = new Intent(ShopOwnerRegistration.this, ShopOwnerDashboard.class);
                startActivity(shopOwnerReg);
            }
        } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid contact number: ", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        /*DAOShopRegistration dao = new DAOShopRegistration();


        btnRegister.setOnClickListener(v->
        {

            ShopRegistration shopReg = new ShopRegistration(Integer.parseInt(mobileNumber.getText().toString()), shopName.getText().toString(), location.getText().toString(), ownerName.getText().toString(),  password.getText().toString());
            dao.add(shopReg).addOnSuccessListener(suc ->
            {
                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
                    {
                        Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                    });

            Intent shopOwnerReg = new Intent(ShopOwnerRegistration.this, ShopOwnerDashboard.class);
            startActivity(shopOwnerReg);
        });*/

    }
}