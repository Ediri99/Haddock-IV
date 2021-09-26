package com.example.doolshe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class MainAdapter extends FirebaseRecyclerAdapter<Reviews, MainAdapter.myViewHolder> {
    //public int quantity = 0;
    DatabaseReference dbReference;
    //private DatabaseReference mDatabase;
    Reviews reviews = new Reviews();
    EditText reviewViewPhoneNumber;


    /*public void deleteReview(String phoneNumber){
        dbReference = FirebaseDatabase.getInstance().getReference().child("Reviews").child(phoneNumber);
        dbReference.removeValue();
    }*/

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<Reviews> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Reviews model) {


        holder.cName.setText(model.getcName());
        holder.cPhone.setText(model.getcPhone());
        holder.comment.setText(model.getComment());
        holder.rating.setText(model.getRating());

        /*MASHA
        dbReference = getRef(position);
        final String myKey = dbReference.getKey();you can name the myKey whatever you want.


            holder.imageDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dbReference.child(myKey).removeValue();
                }
            });

        END */

        holder.btnDeleteReview.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.cPhone.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Deleted data cannot be recovered!");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Reviews").child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.cPhone.getContext(),"Cancelled", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }

           /* model.setcPhone(reviewViewPhoneNumber.getText().toString().trim());
            //String cPhone = model.getcPhone();
            deleteReview(model.getcPhone());

            Intent btnDeleteReview = new Intent(holder.btnDeleteReview.getContext(), AllReviews.class);
            holder.btnDeleteReview.getContext().startActivity(btnDeleteReview);*/
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlereview,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView cName, cPhone, comment, rating;
        Button btnDeleteReview;
        //ImageView imageDelete;

        public myViewHolder(@NonNull View itemView){
            super(itemView);
            cName = (TextView)itemView.findViewById(R.id.reviewViewName);
            cPhone = (TextView)itemView.findViewById(R.id.reviewViewRating);
            comment = (TextView)itemView.findViewById(R.id.reviewViewPhoneNumber);
            rating = (TextView)itemView.findViewById(R.id.reviewViewComment);
            btnDeleteReview = (Button)itemView.findViewById(R.id.btnDeleteReview);
            //imageDelete = itemView.findViewById(R.id.image_delete);

        }
    }


}
