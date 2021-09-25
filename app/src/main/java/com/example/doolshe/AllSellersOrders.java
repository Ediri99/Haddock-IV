package com.example.doolshe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
public class AllSellersOrders extends AppCompatActivity {

    RecyclerView recyclerView;
    SellerOrderAdapter sellerOrderAdapter ;
    Button OrderAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_all_sellers_orders);


        OrderAddBtn = (Button) findViewById(R.id.OrderAddBtn);
        OrderAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addNewReview = new Intent(AllSellersOrders.this,SellerOrderManagement.class);
                startActivity(addNewReview);
                /*finish();*/
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerReview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<SellerOrder> options =
                new FirebaseRecyclerOptions.Builder<SellerOrder>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("SellerOrder"), SellerOrder.class)
                        .build();
        sellerOrderAdapter = new SellerOrderAdapter(options);
        recyclerView.setAdapter(sellerOrderAdapter);


    }


    @Override
    protected void onStart() {
        super.onStart();
        sellerOrderAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sellerOrderAdapter.stopListening();

    }
}