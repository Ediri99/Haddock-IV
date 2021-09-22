package com.example.doolshe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConfirmOrder extends AppCompatActivity {

    EditText cname, phoneNumber, address, date, payment, message;
    Button btnAdd, btnUpdate, btnDelete, btnView;
    DatabaseReference dbref;
    OrderDetails orderDetails;
    long maxid = 0;

    private void clearControls(){
        cname.setText("");
        phoneNumber.setText("");
        address.setText("");
        date.setText("");
        payment.setText("");
        message.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_confirm_order);

        cname = (EditText) findViewById(R.id.customerName);
        phoneNumber = (EditText) findViewById(R.id.customerPhoneNumber);
        address = (EditText) findViewById(R.id.customerDeliveryAddress);
        date = (EditText) findViewById(R.id.cusDeliveryDate);
        payment = (EditText) findViewById(R.id.paymentM);
        message = (EditText) findViewById(R.id.messageToSO);

        btnAdd = (Button)findViewById(R.id.btnAddOrder);
        btnUpdate = (Button)findViewById(R.id.btnUpdateOrder);
        btnDelete = (Button)findViewById(R.id.btnDeleteOrder);
        btnView = (Button)findViewById(R.id.btnShowOrder);

        /*a = (TextView)findViewById(R.id.txtCName);
        b = (TextView)findViewById(R.id.txtCPhone);
        c = (TextView)findViewById(R.id.txtDeliveryAddress);
        d = (TextView)findViewById(R.id.txtDeliveryDate);
        e = (TextView)findViewById(R.id.txtPayment);
        f = (TextView)findViewById(R.id.textSellerMessage);*/


        orderDetails = new OrderDetails();

        dbref = FirebaseDatabase.getInstance().getReference().child("OrderDetails");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                    maxid=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int phn = Integer.parseInt(phoneNumber.getText().toString().trim());
                orderDetails.setCname(cname.getText().toString().trim());
                orderDetails.setPhoneNumber(phn);
                orderDetails.setAddress(address.getText().toString().trim());
                orderDetails.setDate(date.getText().toString().trim());
                orderDetails.setPayment(payment.getText().toString().trim());
                orderDetails.setMessage(message.getText().toString().trim());

                dbref.child(String.valueOf(maxid++)).setValue(orderDetails);

                Toast.makeText(ConfirmOrder.this, "Order is submitted successfully", Toast.LENGTH_SHORT).show();
                clearControls();

            }
        });

        /*btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref=FirebaseDatabase.getInstance().getReference().child("OrderDetails").child(String.valueOf(maxid));
                dbref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String cusName = snapshot.child("cname").getValue().toString();
                        String pNo = snapshot.child("phoneNumber").getValue().toString();
                        String add = snapshot.child("address").getValue().toString();
                        String dDate = snapshot.child("date").getValue().toString();
                        String pay = snapshot.child("payment").getValue().toString();
                        String msg = snapshot.child("message").getValue().toString();

                        a.setText(cusName);
                        b.setText(pNo);
                        c.setText(add);
                        d.setText(dDate);
                        e.setText(pay);
                        f.setText(msg);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });*/



    }
}