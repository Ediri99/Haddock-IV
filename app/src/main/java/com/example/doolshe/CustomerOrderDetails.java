package com.example.doolshe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class CustomerOrderDetails extends AppCompatActivity {

    EditText cname, phoneNumber, address, date, payment, message;
    TextView itemName, quantity, price;

    Button btnAdd, btnUpdate, btnDelete;
    DatabaseReference dbref;
    OrderDetails orderDetails;
    //long maxid = 0;

    private void clearControls(){
        cname.setText("");
        phoneNumber.setText("");
        address.setText("");
        date.setText("");
        payment.setText("");
        message.setText("");
    }

    public void deleteOrder(String phNo) {
        dbref = FirebaseDatabase.getInstance().getReference().child("OrderDetails").child(String.valueOf(phNo));
        dbref.removeValue();
        Toast.makeText(CustomerOrderDetails.this, "Order deleted successfully", Toast.LENGTH_LONG).show();
        clearControls();
    }

    public void updateOrder(String iname, String iqty, String iprice, String cusname, String phNo, String add, String ddate, String pay, String msg){
        dbref = FirebaseDatabase.getInstance().getReference().child("OrderDetails").child(String.valueOf(phNo));
        OrderDetails orderDetails = new OrderDetails(iname, iqty, iprice, cusname, phNo, add, ddate, pay, msg);
        dbref.setValue(orderDetails);
        Toast.makeText(CustomerOrderDetails.this, "Order updated successfully", Toast.LENGTH_LONG).show();
        clearControls();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_customer_order_details);

        cname = (EditText) findViewById(R.id.customerName);
        phoneNumber = (EditText) findViewById(R.id.customerPhoneNumber);
        address = (EditText) findViewById(R.id.customerDeliveryAddress);
        date = (EditText) findViewById(R.id.cusDeliveryDate);
        payment = (EditText) findViewById(R.id.paymentM);
        message = (EditText) findViewById(R.id.messageToSO);
        itemName = (TextView) findViewById(R.id.ckDisplay);
        quantity = (TextView) findViewById(R.id.qtyDisplay);
        price = (TextView) findViewById(R.id.prDisplay);

        btnAdd = (Button)findViewById(R.id.btnAddOrder);
        btnUpdate = (Button)findViewById(R.id.btnUpdateOrder);
        btnDelete = (Button)findViewById(R.id.btnDeleteOrder);


        String oitemName = getIntent().getStringExtra("itemName");
        String oprice = getIntent().getStringExtra("itemPrice");
        String oquantity = getIntent().getStringExtra("itemQuantity");

        itemName.setText(oitemName);
        price.setText(oprice);
        quantity.setText(oquantity);

        orderDetails = new OrderDetails();
        dbref = FirebaseDatabase.getInstance().getReference().child("OrderDetails");

        btnAdd.setOnClickListener(view -> {


            if(TextUtils.isEmpty(cname.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter recipient's name", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(phoneNumber.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter the phone number", Toast.LENGTH_SHORT).show();

            else if(TextUtils.isEmpty(address.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter the delivery address", Toast.LENGTH_SHORT).show();

            else if(TextUtils.isEmpty(date.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter the delivery date", Toast.LENGTH_SHORT).show();

            else if(TextUtils.isEmpty(payment.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter the payment method", Toast.LENGTH_SHORT).show();
            else{

                orderDetails.setPhoneNumber(phoneNumber.getText().toString().trim());
                String phNo = orderDetails.getPhoneNumber();

                orderDetails.setItemName(itemName.getText().toString().trim());
                String iname = orderDetails.getItemName();

                orderDetails.setQuantity(quantity.getText().toString().trim());
                String iqty = orderDetails.getQuantity();

                orderDetails.setPrice(price.getText().toString().trim());
                String iprice = orderDetails.getPrice();

                orderDetails.setCname(cname.getText().toString().trim());
                String cusname = orderDetails.getCname();

                orderDetails.setAddress(address.getText().toString().trim());
                String add = orderDetails.getAddress();

                orderDetails.setDate(date.getText().toString().trim());
                String ddate = orderDetails.getDate();

                orderDetails.setPayment(payment.getText().toString().trim());
                String pay = orderDetails.getPayment();

                orderDetails.setMessage(message.getText().toString().trim());
                String msg = orderDetails.getMessage();


                dbref.push().getKey();
                OrderDetails orderDetails = new OrderDetails(iname, iqty, iprice, cusname, phNo, add, ddate, pay, msg);
                dbref.child(String.valueOf(phNo)).setValue(orderDetails);
                Toast.makeText(CustomerOrderDetails.this, "Order is submitted successfully", Toast.LENGTH_SHORT).show();
            }
            clearControls();

        });

        btnDelete.setOnClickListener(view ->{
            orderDetails.setPhoneNumber(phoneNumber.getText().toString().trim());
            String phNo=orderDetails.getPhoneNumber();
            deleteOrder(phNo);
        });

        btnUpdate.setOnClickListener(view ->{

            orderDetails.setPhoneNumber(phoneNumber.getText().toString().trim());
            String phNo = orderDetails.getPhoneNumber();

            String cusname = (cname.getText().toString().trim());
            orderDetails.setCname(cusname);

            String iname = (itemName.getText().toString().trim());
            orderDetails.setItemName(iname);

            String iqty = (quantity.getText().toString().trim());
            orderDetails.setQuantity(iqty);

            String iprice = (price.getText().toString().trim());
            orderDetails.setPrice(iprice);

            String add = (address.getText().toString().trim());
            orderDetails.setAddress(add);

            String ddate = (date.getText().toString().trim());
            orderDetails.setDate(ddate);

            String pay = (payment.getText().toString().trim());
            orderDetails.setPayment(pay);

            String msg = (message.getText().toString().trim());
            orderDetails.setMessage(msg);

            updateOrder(iname, iqty, iprice, cusname, phNo, add, ddate, pay, msg);
        });




    }


}