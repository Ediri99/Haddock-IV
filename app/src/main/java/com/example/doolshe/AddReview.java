package com.example.doolshe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddReview extends AppCompatActivity {
    EditText etCustomerName,etCustomerRating,etCusPhone;
    MultiAutoCompleteTextView mactCustomerComment;
    Button btnSubmitReview,btnUpdateReview,btnViewReview,btnDeleteReview;
    DatabaseReference dbReference;
    Reviews reviews;

    /*long maxid = 0;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_add_reviews);

        etCustomerName = (EditText) findViewById(R.id.etCustomerName);
        etCustomerRating = (EditText) findViewById(R.id.etCustomerRating);
        etCusPhone = (EditText) findViewById(R.id.etCusPhone);
        mactCustomerComment = (MultiAutoCompleteTextView) findViewById(R.id.mactCustomerComment);
        btnSubmitReview = (Button) findViewById(R.id.btnSubmitReview);
        btnUpdateReview = (Button) findViewById(R.id.btnUpdateReview);
        btnViewReview = (Button) findViewById(R.id.btnViewReview);
        btnDeleteReview = (Button) findViewById(R.id.btnDeleteReview);

        reviews = new Reviews();
        dbReference = FirebaseDatabase.getInstance().getReference().child("Reviews");

        btnSubmitReview.setOnClickListener(view -> {
            reviews.setcName(etCustomerName.getText().toString().trim());
            String customerName = reviews.getcName();

            Integer customerRating = Integer.parseInt(etCustomerRating.getText().toString());
            reviews.setRating(customerRating);

            reviews.setComment(mactCustomerComment.getText().toString());
            String customerComment = reviews.getComment();

            Integer customerPhoneNumber = Integer.parseInt(etCusPhone.getText().toString());
            reviews.set


            clearAll();

            dbReference.push().getKey();
            Reviews reviews = new Reviews(customerName,customerRating,customerComment);
            dbReference.child(customerName).setValue(reviews);
            Toast.makeText(AddReview.this, "Feedback Submitted Successfully.", Toast.LENGTH_LONG).show();
        });


        btnDeleteReview.setOnClickListener(view -> {
            reviews.setcName(etCustomerName.getText().toString().trim());
            String customerName = reviews.getcName();
            deleteReview(customerName);
        });


        btnViewReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference refref = FirebaseDatabase.getInstance().getReference().child("Reviews").child("Avishka");
                dbReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChildren()){
                            etCustomerName.setText(snapshot.child("cName").getValue().toString());
                            etCustomerRating.setText(snapshot.child("dbReference").getValue().toString());
                            mactCustomerComment.setText(snapshot.child("comment").getValue().toString());
                        }else{
                            Toast.makeText(AddReview.this,"Review not Found",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
    public void clearAll(){
        etCustomerName.setText("");
        etCustomerRating.setText("");
        mactCustomerComment.setText("");
    }

    public void deleteReview(String customerName){
        dbReference = FirebaseDatabase.getInstance().getReference().child("Reviews").child(customerName);
        dbReference.removeValue();
        Toast.makeText(AddReview.this,"Review deleted successfully",Toast.LENGTH_LONG).show();
        clearAll();
    }
}


