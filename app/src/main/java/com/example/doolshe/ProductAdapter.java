package com.example.doolshe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

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


   /*     Glide.with(holder.img.getContext())
                .load(model.getCurl())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);*/
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

       // CircleImageView img;
        TextView details, itemName, itemNo, price, quantity;

        public myViewHolder(@NonNull View itemView){
            super(itemView);
           // img = (CircleImageView)itemView.findViewById(R.id.img1);
            details = (TextView)itemView.findViewById(R.id.productViewDetails);
            itemName = (TextView)itemView.findViewById(R.id.productViewName);
            itemNo = (TextView)itemView.findViewById(R.id.productViewNo);
            price = (TextView)itemView.findViewById(R.id.productViewPrice);
            quantity = (TextView)itemView.findViewById(R.id.productViewQuantity);

        }
    }
}
