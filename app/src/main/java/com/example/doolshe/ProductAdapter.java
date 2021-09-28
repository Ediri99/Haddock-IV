package com.example.doolshe;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import de.hdodenhof.circleimageview.CircleImageView;


public class ProductAdapter extends FirebaseRecyclerAdapter<Products, ProductAdapter.myViewHolder> {



    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ProductAdapter(@NonNull FirebaseRecyclerOptions<Products> options) {super(options);}

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Products model) {

        holder.details.setText(model.getDetails());
        holder.itemName.setText(model.getItemName());
        holder.itemNo.setText(model.getItemNo());
        holder.price.setText(model.getPrice());
        holder.quantity.setText(model.getQuantity());

        holder.btnDeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemNo.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Delete the Product");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Products").child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.itemNo.getContext(), "Cancelled", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }


        });


        Glide.with(holder.img1.getContext())
                .load(model.getCurl())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img1);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img1;
        TextView details, itemName, itemNo, price, quantity;
        Button btnDeleteProduct ;

        public myViewHolder(@NonNull View itemView){
            super(itemView);
            img1 = (CircleImageView)itemView.findViewById(R.id.img1);
            details = (TextView)itemView.findViewById(R.id.productViewDetails);
            itemName = (TextView)itemView.findViewById(R.id.productViewName);
            itemNo = (TextView)itemView.findViewById(R.id.productViewNo);
            price = (TextView)itemView.findViewById(R.id.productViewPrice);
            quantity = (TextView)itemView.findViewById(R.id.productViewQuantity);
            btnDeleteProduct = (Button)itemView.findViewById(R.id.btnDeleteProduct);
        }
    }
}
