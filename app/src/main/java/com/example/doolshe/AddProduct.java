package com.example.doolshe;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProduct extends AppCompatActivity {

    EditText itemNo, itemName, price, quantity, details;

    Button btn_cakec, btn_caker, btn_cakeu, btn_caked;
    DatabaseReference dbref;
    Products products;

    private void clearControls(){
        itemNo.setText("");
        itemName.setText("");
        price.setText("");
        quantity.setText("");
        details.setText("");
    }

    public void deleteProduct(String itemNo) {
        dbref = FirebaseDatabase.getInstance().getReference().child("Products").child(String.valueOf(itemNo));
        dbref.removeValue();
        Toast.makeText(AddProduct.this, "Product deleted successfully", Toast.LENGTH_LONG).show();
        clearControls();
    }

    public void updateProduct(String itemNo, String itemName, String price, String quantity, String details){
        dbref = FirebaseDatabase.getInstance().getReference().child("Products").child(String.valueOf(itemNo));
        Products products = new Products(itemNo, itemName, price, quantity, details);
        dbref.setValue(products);
        Toast.makeText(AddProduct.this, "Product updated successfully", Toast.LENGTH_LONG).show();
        clearControls();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_add_product);

        itemNo = (EditText) findViewById(R.id.cakenoET);
        itemName = (EditText) findViewById(R.id.cakenameET);
        price = (EditText) findViewById(R.id.cakepriceET);
        quantity = (EditText) findViewById(R.id.cakequantityET);
        details = (EditText) findViewById(R.id.cakedetailsET);

        btn_cakec = (Button)findViewById(R.id.btn_cakec);
      //  btn_caker = (Button)findViewById(R.id.btn_caker);
        btn_cakeu = (Button)findViewById(R.id.btn_cakeu);
        btn_caked = (Button)findViewById(R.id.btn_caked);


        products = new Products();
        dbref = FirebaseDatabase.getInstance().getReference().child("Products");

        btn_cakec.setOnClickListener(view -> {

            products.setItemNo(itemNo.getText().toString().trim());
            String itemNo = products.getItemNo();

            products.setItemName(itemName.getText().toString().trim());
            String itemName = products.getItemName();

            products.setPrice(price.getText().toString().trim());
            String price = products.getPrice();

            products.setQuantity(quantity.getText().toString().trim());
            String quantity = products.getQuantity();


            products.setDetails(details.getText().toString().trim());
            String details = products.getDetails();

            dbref.push().getKey();
            Products products = new Products(itemNo, itemName, price, quantity, details);
            dbref.child(String.valueOf(itemNo)).setValue(products);
            Toast.makeText(AddProduct.this, "Product is submitted successfully", Toast.LENGTH_SHORT).show();
            clearControls();
        });
        btn_caked.setOnClickListener(view ->{
            products.setItemName(itemNo.getText().toString().trim());
            String itemNo=products.getItemNo();
            deleteProduct(itemNo);
        });

  /*      btn_cakeu.setOnClickListener(view -> {
            products.setItemName(itemNo.getText().toString().trim());
            String itemNo = products.getItemNo();
            String itemName = (products.getItemName());
            products.setItemName(itemName);
            String details = (products.getDetails());
        }); */

        btn_cakeu.setOnClickListener(view ->{

            products.setItemNo(itemNo.getText().toString().trim());
            String itemNo1 = products.getItemNo();
            String itemName1 = (itemName.getText().toString().trim());
            products.setItemName(itemName1);
            String price1 = (price.getText().toString().trim());
            products.setPrice(price1);
            String quantity1 = (quantity.getText().toString().trim());
            products.setQuantity(quantity1);
            String details1 = (details.getText().toString().trim());
            products.setDetails(details1);

            updateProduct(itemNo1, itemName1, price1, quantity1, details1);
        });

    }
}
