package com.example.doolshe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class ProductAdapter extends FirebaseRecyclerAdapter<Products, ProductAdapter.myViewHolder> {



    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ProductAdapter(@NonNull FirebaseRecyclerOptions<Products> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Products model) {

        holder.itemNo.setText(model.getItemNo());
        holder.itemName.setText(model.getItemName());
        holder.price.setText(model.getPrice());

        holder.details.setText(model.getDetails());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{


        TextView itemNo, itemName, price, details;

        public myViewHolder(@NonNull View itemView){
            super(itemView);

            itemNo = (TextView)itemView.findViewById(R.id.productViewNo);
            itemName = (TextView)itemView.findViewById(R.id.productViewName);
            price = (TextView)itemView.findViewById(R.id.productViewPrice);

            details = (TextView)itemView.findViewById(R.id.productViewDetails);
        }
    }
}
