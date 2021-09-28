package com.example.doolshe;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SellerOrderAdapter extends FirebaseRecyclerAdapter<SellerOrder,SellerOrderAdapter.myViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    public SellerOrderAdapter(@NonNull FirebaseRecyclerOptions<SellerOrder> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull SellerOrderAdapter.myViewHolder holder, int position, @NonNull SellerOrder model) {
        holder.customerName.setText(model.getOrderName());
        holder.orderName.setText(model.getItemName());
        holder.phoneNumber.setText(model.getPhoneNumber());
        holder.description.setText(model.getDescription());
        holder.totalAmount.setText(model.getOrderTotal());



        holder.deleteOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.phoneNumber.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Delete the Order");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("SellerOrder").child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.phoneNumber.getContext(), "Cancelled", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }


        });
    }
    @NonNull
    @Override
    public SellerOrderAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlesellerorders,parent,false);
        return new SellerOrderAdapter.myViewHolder(view);
    }


    class myViewHolder extends RecyclerView.ViewHolder{


        TextView customerName, orderName, phoneNumber, description,totalAmount;
        Button deleteOrderBtn;

        public myViewHolder(@NonNull View itemView){
            super(itemView);

            customerName = (TextView)itemView.findViewById(R.id.sellerCustomerName);
            orderName= (TextView)itemView.findViewById(R.id.sellerOrderName);
            phoneNumber = (TextView)itemView.findViewById(R.id.sellerCustomerPhone);
            description = (TextView)itemView.findViewById(R.id.sellerDescription);
            totalAmount = (TextView)itemView.findViewById(R.id.totalPricez);
            deleteOrderBtn = (Button)itemView.findViewById(R.id.deleteorderallbtn);


        }
    }
}
