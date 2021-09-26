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

public class AllReviewCustomer extends AppCompatActivity {
    RecyclerView recyclerViewCustomer;
    MainAdapterCustomer mainAdapterCustomer;
    Button btnAddReviewCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_all_review_customer);


        btnAddReviewCustomer = (Button)findViewById(R.id.btnAddReviewCustomer);
        btnAddReviewCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addReviewCustomer = new Intent(AllReviewCustomer.this,AddReview.class);
                startActivity(addReviewCustomer);
                /*finish();*/
            }
        });


        recyclerViewCustomer = (RecyclerView) findViewById(R.id.recyclerReviewCustomer);
        recyclerViewCustomer.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Reviews> options =
                new FirebaseRecyclerOptions.Builder<Reviews>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Reviews"), Reviews.class)
                        .build();
        mainAdapterCustomer = new MainAdapterCustomer(options);
        recyclerViewCustomer.setAdapter(mainAdapterCustomer);

    }
    @Override
    protected void onStart() {
        super.onStart();
        mainAdapterCustomer.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapterCustomer.stopListening();
    }
}