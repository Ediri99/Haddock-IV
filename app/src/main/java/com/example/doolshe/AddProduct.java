package com.example.doolshe;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.UUID;

public class AddProduct extends AppCompatActivity {

    // request code
    private static final int PICK_IMAGE_REQUEST = 1;

    // views for button
    private Button mButtonChooseImage;

    // view for image view
    private ImageView mImageView;

    // Uri indicates, where the image will be picked from
    private Uri curl;

    // instance for firebase storage and StorageReference
    FirebaseStorage storage;
    StorageReference storageReference;

    EditText itemNo, itemName, price, quantity, details;

    Button btn_cakec, btn_cakeu, btn_caked;
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

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(
                Color.parseColor("#0F9D58"));
        actionBar.setBackgroundDrawable(colorDrawable);

        // initialise views
        mButtonChooseImage = findViewById(R.id.button_choose_image);
        mImageView = findViewById(R.id.image_view);

        // get the Firebase  storage reference
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        // on pressing ChooseImage SelectImage() is called
        mButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });


        itemNo = (EditText) findViewById(R.id.cakenoET);
        itemName = (EditText) findViewById(R.id.cakenameET);
        price = (EditText) findViewById(R.id.cakepriceET);
        quantity = (EditText) findViewById(R.id.cakequantityET);
        details = (EditText) findViewById(R.id.cakedetailsET);

        btn_cakec = (Button)findViewById(R.id.btn_cakec);
        btn_cakeu = (Button)findViewById(R.id.btn_cakeu);
        btn_caked = (Button)findViewById(R.id.btn_caked);


        products = new Products();
        dbref = FirebaseDatabase.getInstance().getReference().child("Products");

        btn_cakec.setOnClickListener(view -> {
            if(TextUtils.isEmpty(itemNo.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter the item No", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(itemName.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter the  item Name", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(price.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter the item Price", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(quantity.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter the quantity", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(details.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter the item details", Toast.LENGTH_SHORT).show();
            else {

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
                // with on pressing UploadImage btn_cakec()
                uploadImage();
                clearControls();
            }
        });
        btn_caked.setOnClickListener(view ->{
            products.setItemName(itemNo.getText().toString().trim());
            String itemNo=products.getItemNo();
            deleteProduct(itemNo);
        });


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
    // Select Image method
    private void SelectImage()
    {

        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    // Override onActivityResult method
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data)
    {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            curl = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                curl);
                mImageView.setImageBitmap(bitmap);
            }

            catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
    }

    // UploadImage method
    private void uploadImage()
    {
        if (curl != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            // Defining the child of storageReference
            StorageReference ref
                    = storageReference
                    .child(
                            "Products/"
                                    + UUID.randomUUID().toString());

            // adding listeners on upload
            // or failure of image
            ref.putFile(curl)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {

                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(AddProduct.this,
                                                    "Image Uploaded!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(AddProduct.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploaded "
                                                    + (int)progress + "%");
                                }
                            });
        }
    }
}
