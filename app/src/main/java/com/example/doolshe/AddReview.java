package com.example.doolshe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
    Button btnSubmitReview,btnUpdateReview,btnDeleteReview;
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
        btnDeleteReview = (Button) findViewById(R.id.btnDeleteReview);
        LoadingDialog loadingDialog = new LoadingDialog(AddReview.this);

        reviews = new Reviews();
        dbReference = FirebaseDatabase.getInstance().getReference().child("Reviews");

        btnSubmitReview.setOnClickListener(view -> {

            try {
                if (TextUtils.isEmpty(etCustomerName.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Enter Your Name", Toast.LENGTH_LONG).show();
                else if (TextUtils.isEmpty(etCustomerRating.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Enter value between 1 to 5", Toast.LENGTH_LONG).show();
                else if (TextUtils.isEmpty(etCusPhone.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Enter valid phone number", Toast.LENGTH_LONG).show();
                else if (TextUtils.isEmpty(mactCustomerComment.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Enter Comment", Toast.LENGTH_LONG).show();
                else {
                    reviews.setcName(etCustomerName.getText().toString().trim());
                    String customerName = reviews.getcName();

                    reviews.setRating(etCustomerRating.getText().toString().trim());
                    String customerRating = reviews.getRating();

                    reviews.setcPhone(etCusPhone.getText().toString().trim());
                    String customerPhoneNumber = reviews.getcPhone();

                    reviews.setComment(mactCustomerComment.getText().toString().trim());
                    String customerComment = reviews.getComment();

                    clearAll();

                    dbReference.push().getKey();
                    Reviews reviews = new Reviews(customerName, customerRating, customerPhoneNumber, customerComment);
                    dbReference.child(String.valueOf(customerPhoneNumber)).setValue(reviews);

                    //loading animation
                    loadingDialog.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingDialog.dismissDialog();
                            Toast.makeText(AddReview.this, "Feedback Submitted Successfully.", Toast.LENGTH_LONG).show();

                        }
                    },3000);
                    //end loading animation

                }
            }
                catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(),"Invalid input",Toast.LENGTH_LONG).show();
            }
        });

        btnDeleteReview.setOnClickListener(view -> {
            try {
                if (TextUtils.isEmpty(etCusPhone.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Enter Your Phone Number", Toast.LENGTH_LONG).show();
                else {
                    reviews.setcPhone(etCusPhone.getText().toString().trim());
                    String cusphone = reviews.getcPhone();
                    deleteReview(cusphone);
                }
            }catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(),"Invalid input",Toast.LENGTH_LONG).show();
            }

        });

        btnUpdateReview.setOnClickListener(view -> {
            try {
                if (TextUtils.isEmpty(etCusPhone.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Enter Your Phone Number", Toast.LENGTH_LONG).show();
                else {
                    reviews.setcPhone(etCusPhone.getText().toString().trim());
                    String phoneNum = reviews.getcPhone();

                    String nameCus = etCustomerName.getText().toString();
                    reviews.setcName(nameCus);

                    String comment = mactCustomerComment.getText().toString();
                    reviews.setComment(comment);

                    String rating= etCustomerRating.getText().toString();
                    reviews.setRating(rating);
                    updateReview(nameCus, phoneNum, comment, rating);

                }

            }catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(),"Invalid input",Toast.LENGTH_LONG).show();
            }

        });
    }

    public void clearAll(){
        etCustomerName.setText("");
        etCustomerRating.setText("");
        etCusPhone.setText("");
        mactCustomerComment.setText("");
    }

    public void deleteReview(String phoneNumber){
        dbReference = FirebaseDatabase.getInstance().getReference().child("Reviews").child(phoneNumber);
        dbReference.removeValue();
        Toast.makeText(AddReview.this,"Review deleted successfully",Toast.LENGTH_LONG).show();
        clearAll();
    }

    public void updateReview(String cName,String cPhone,String comment,String rating){
        dbReference = FirebaseDatabase.getInstance().getReference().child("Reviews").child(String.valueOf(cPhone));
        Reviews reviews = new Reviews(cName, cPhone, comment, rating);
        dbReference.setValue(reviews);
        Toast.makeText(AddReview.this, "Review updated successfully", Toast.LENGTH_LONG).show();
        clearAll();
    }
}


