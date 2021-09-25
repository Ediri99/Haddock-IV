package com.example.doolshe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class AllReviews extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    Button btnAddReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_all_reviews);

        btnAddReview = (Button) findViewById(R.id.btnAddReview);
        btnAddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addNewReview = new Intent(AllReviews.this,AddReview.class);
                startActivity(addNewReview);
                /*finish();*/
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerReview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<Reviews> options =
                new FirebaseRecyclerOptions.Builder<Reviews>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Reviews"), Reviews.class)
                        .build();
        mainAdapter = new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }
}