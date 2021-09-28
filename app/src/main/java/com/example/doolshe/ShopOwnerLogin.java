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

public class ShopOwnerLogin extends AppCompatActivity {
    EditText shopOwnerPhoneNumber,shopOwnerPassword;
    Button shopOwnerLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_shop_owner_login);

        shopOwnerPhoneNumber = findViewById(R.id.tieShopOwnerPhoneNumber);
        shopOwnerPassword = findViewById(R.id.tieShopOwnerPwd);
        shopOwnerLogin = findViewById(R.id.btnShopOwnerSignIn);

        shopOwnerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(shopOwnerPhoneNumber.getText().toString().equals("0777665545") && shopOwnerPassword.getText().toString().equals("admin")){

                            Intent dashboard = new Intent(ShopOwnerLogin.this,ShopOwnerDashboard.class);
                            startActivity(dashboard);
                            /*finish();*/


                    /*AlertDialog.Builder builder = new AlertDialog.Builder(
                            ShopOwnerLogin.this
                    );
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Login Successful");
                    builder.setMessage("WELCOME!");

                    builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();*/

                }else{
                    Toast.makeText(getApplicationContext(),"Invalid username and Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
    }
