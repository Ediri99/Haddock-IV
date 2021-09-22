package com.example.doolshe;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
public class ShopViewCustomer extends AppCompatActivity {
    Button reviews, addOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_shop_view_customer);
        reviews = (Button) findViewById(R.id.btnReviews);
        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent addReview = new Intent(ShopViewCustomer.this,AddReview.class);
                //startActivity(addReview);
                /*finish();*/
            }
        });


        addOrder = (Button) findViewById(R.id.btnAddOrderCus);
        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addOrderCus = new Intent(ShopViewCustomer.this,ConfirmOrder.class);
                startActivity(addOrderCus);
                /*finish();*/
            }
        });
    }
}