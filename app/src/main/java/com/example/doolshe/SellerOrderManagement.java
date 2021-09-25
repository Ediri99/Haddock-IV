
package com.example.doolshe;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class SellerOrderManagement extends AppCompatActivity{

    EditText name_item_order,quantity_order,price_order,s_name, s_phone, s_address, s_description, s_payment;
    Button confirm_order_btn,edit_order_btn,view_order_btn,delete_order_btn;

    DatabaseReference bdref;
    SellerOrder sellerorder;

    public void clearAll(){
        name_item_order.setText("");
        quantity_order.setText("");
        price_order.setText("");
        s_name.setText("");
        s_phone.setText("");
        s_address.setText("");
        s_description.setText("");
        s_payment.setText("");


    }


    public void updateOrderSeller(String customerName,String phoneNumber, String homeAddress,String description, String paymentMethod, String itemName, String itemQuantity,String itemPrice ){

        bdref = FirebaseDatabase.getInstance().getReference().child("SellerOrder").child(phoneNumber);

        SellerOrder sellerorder = new SellerOrder(customerName, phoneNumber, homeAddress, description, paymentMethod,itemName,itemQuantity,itemPrice);

        bdref.setValue(sellerorder);

        Toast.makeText(SellerOrderManagement.this, "Order updated successfully", Toast.LENGTH_LONG).show();

        clearAll();

    }





    public void deleteOrderSeller(String s_phone){


        bdref = FirebaseDatabase.getInstance().getReference().child("SellerOrder").child(s_phone);

        bdref.removeValue();

        Toast.makeText(SellerOrderManagement.this, "Order deleted successfully", Toast.LENGTH_LONG).show();

        clearAll();

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_seller_order_management);

        confirm_order_btn = (Button) findViewById(R.id.confirm_order_btn);
        edit_order_btn = (Button) findViewById(R.id.edit_order_btn);
        view_order_btn = (Button) findViewById(R.id.view_order_btn);
        delete_order_btn = (Button) findViewById(R.id.delete_order_btn);


        price_order = (EditText) findViewById(R.id.price_order);
        quantity_order = (EditText) findViewById(R.id.quantity_order);
        name_item_order = (EditText) findViewById(R.id.name_item_order);
        s_name = (EditText) findViewById(R.id.s_name);
        s_phone = (EditText) findViewById(R.id.s_phone);
        s_address = (EditText) findViewById(R.id.s_address);
        s_description = (EditText) findViewById(R.id.s_description);
        s_payment = (EditText) findViewById(R.id.s_payment);


        sellerorder = new SellerOrder();
        bdref = FirebaseDatabase.getInstance().getReference().child("SellerOrder");


        confirm_order_btn.setOnClickListener(view -> {


            sellerorder.setOrderName(s_name.getText().toString().trim());
            String customerName = sellerorder.getOrderName();


            sellerorder.setPhoneNumber(s_phone.getText().toString().trim());
            String phoneNumber = sellerorder.getPhoneNumber();


            sellerorder.setHomeAddress(s_address.getText().toString().trim());
            String homeAddress = sellerorder.getHomeAddress();


            sellerorder.setDescription(s_description.getText().toString().trim());
            String description = sellerorder.getDescription();


            sellerorder.setOrderName(s_payment.getText().toString().trim());
            String paymentMethod = sellerorder.getOrderName();


            sellerorder.setItemName(name_item_order.getText().toString().trim());
            String itemName = sellerorder.getItemName();


            sellerorder.setItemQuantity(quantity_order.getText().toString().trim());
            String itemQuantity= sellerorder.getItemQuantity();

            sellerorder.setItemPrice(price_order.getText().toString().trim());
            String itemPrice= sellerorder.getItemPrice();







            clearAll();

            bdref.push().getKey();
            SellerOrder sellerorder = new SellerOrder(customerName,phoneNumber, homeAddress, description, paymentMethod,itemName,itemQuantity,itemPrice);
            bdref.child(String.valueOf(phoneNumber)).setValue(sellerorder);
            Toast.makeText(SellerOrderManagement.this, "Order Submitted Successfully.", Toast.LENGTH_LONG).show();



        });




        delete_order_btn.setOnClickListener(view ->{

            sellerorder.setPhoneNumber(s_phone.getText().toString().trim());

            String phoneNumber = sellerorder.getPhoneNumber();

            deleteOrderSeller(phoneNumber);


        });





        edit_order_btn.setOnClickListener(view ->{

            sellerorder.setOrderName(s_name.getText().toString().trim());
            String customerName = sellerorder.getOrderName();

            sellerorder.setPhoneNumber(s_phone.getText().toString().trim());
            String phoneNumber = sellerorder.getPhoneNumber();

            sellerorder.setHomeAddress(s_address.getText().toString().trim());
            String homeAddress = sellerorder.getOrderName();

            sellerorder.setDescription(s_description.getText().toString().trim());
            String description= sellerorder.getDescription();

            sellerorder.setPaymentMethod(s_payment.getText().toString().trim());
            String paymentMethod= sellerorder.getPaymentMethod();

            sellerorder.setItemName(name_item_order.getText().toString().trim());
            String itemName= sellerorder.getItemName();

            sellerorder.setItemQuantity(quantity_order.getText().toString().trim());
            String itemQuantity= sellerorder.getDescription();

            sellerorder.setItemPrice(price_order.getText().toString().trim());
            String itemPrice= sellerorder.getItemPrice();


            updateOrderSeller(customerName,phoneNumber, homeAddress, description, paymentMethod,itemName,itemQuantity,itemPrice);




        });




    }

}

