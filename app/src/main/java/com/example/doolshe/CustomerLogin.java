package com.example.doolshe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerLogin extends AppCompatActivity {
    EditText customerPhoneNumber,customerPassword;
    Button customerLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_customer_login);

        customerPhoneNumber = findViewById(R.id.tieCustomerPhone);
        customerPassword = findViewById(R.id.tieCustomerPassword);
        customerLogin = findViewById(R.id.btnCustomerLogin);

        customerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customerPhoneNumber.getText().toString().equals("0772222222") && customerPassword.getText().toString().equals("customer")){
                    /*AlertDialog.Builder builder = new AlertDialog.Builder(
                            CustomerLogin.this
                    );
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Login Successful As Customer");
                    builder.setMessage("WELCOME TO THE CAKE KINGDOM!!");

                    builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();*/


                            Intent shopViewCustomer = new Intent(CustomerLogin.this,ShopViewCustomer.class);
                            startActivity(shopViewCustomer);
                            /*finish();*/


                }else{
                    Toast.makeText(getApplicationContext(),"Invalid username and Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}