package com.example.doolshe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerRegistration extends AppCompatActivity {

    EditText cusPhoneNumber, cusName, cusLocation, cusPassword;
    Button btnRegister;

    DatabaseReference dbref;
    CusRegistration cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_customer_registration);

        cusPhoneNumber = findViewById(R.id.tie_CuctomerPhoneNumber);
        cusName = findViewById(R.id.tiecusname);
        cusLocation = findViewById(R.id.tie_customerlocation);
        cusPassword = findViewById(R.id.tie_CustomerPassword);

        btnRegister = findViewById(R.id.btnSignupAsCus);

        cr = new CusRegistration();
        dbref = FirebaseDatabase.getInstance().getReference().child("CustomerRegistration");

        btnRegister.setOnClickListener(view ->{

            cr.setCustomerPhone(cusPhoneNumber.getText().toString());
            String phNum  = cr.getCustomerPhone();

            cr.setCustomerName(cusName.getText().toString());
            String cusName = cr.getCustomerName();

            cr.setCustomerLocation(cusLocation.getText().toString());
            String location  = cr.getCustomerLocation();

            cr.setCustomerPwd(cusPassword.getText().toString());
            String password  = cr.getCustomerPwd();


            dbref.push().getKey();
            CusRegistration cr = new CusRegistration(cusName, phNum,  location, password);
            dbref.child(String.valueOf(phNum)).setValue(cr);
            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();

            Intent cusReg = new Intent(CustomerRegistration.this, CakeList.class);
            startActivity(cusReg);
        });

    }

}