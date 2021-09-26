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
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainAdapterCustomer extends FirebaseRecyclerAdapter<Reviews, MainAdapterCustomer.myViewHolder> {
    DatabaseReference dbReference;
    Reviews reviews = new Reviews();
    EditText reviewViewPhoneNumber;


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapterCustomer(@NonNull FirebaseRecyclerOptions<Reviews> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Reviews model) {


        holder.cName.setText(model.getcName());
        holder.cPhone.setText(model.getcPhone());
        holder.comment.setText(model.getComment());
        holder.rating.setText(model.getRating());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlereviewcustomer,parent,false);
        return new myViewHolder(view);

    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView cName, cPhone, comment, rating;
        Button btnDeleteReview;

        public myViewHolder(@NonNull View itemView){
            super(itemView);
            cName = (TextView)itemView.findViewById(R.id.reviewViewNameCustomer);
            cPhone = (TextView)itemView.findViewById(R.id.reviewViewRatingCustomer);
            comment = (TextView)itemView.findViewById(R.id.reviewViewPhoneNumberCustomer);
            rating = (TextView)itemView.findViewById(R.id.reviewViewCommentCustomer);
        }
    }


}
