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

public class CakeList extends AppCompatActivity {

    RecyclerView recyclerView;
    CakeAdapter cakeAdapter;
    Button reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_cake_list);



        reviews = (Button) findViewById(R.id.btnReviews);
        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addReviewCustomer = new Intent(CakeList.this,AllReviewCustomer.class);
                startActivity(addReviewCustomer);
                /*finish();*/
            }
        });



        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Products"), Products.class)
                        .build();
        cakeAdapter = new CakeAdapter(options);
        recyclerView.setAdapter(cakeAdapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        cakeAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cakeAdapter.stopListening();
    }
}