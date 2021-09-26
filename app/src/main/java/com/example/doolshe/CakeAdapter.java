package com.example.doolshe;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class CakeAdapter extends FirebaseRecyclerAdapter<Products, CakeAdapter.myViewHolder> {



    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CakeAdapter(@NonNull FirebaseRecyclerOptions<Products> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Products model) {

        holder.itemNo.setText(model.getItemNo());
        holder.itemName.setText(model.getItemName());
        holder.price.setText(model.getPrice());
        holder.quantity.setText(model.getQuantity());


        Glide.with(holder.img.getContext())
                .load(model.getCurl())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

        holder.orderNow.setOnClickListener((view)->{

            Intent order = new Intent(holder.orderNow.getContext(), CustomerOrders.class);

            order.putExtra("itemName", model.getItemName());
            order.putExtra("price", model.getPrice());

            holder.orderNow.getContext().startActivity(order);
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView itemNo, itemName, price, quantity;
        Button orderNow;

        public myViewHolder(@NonNull View itemView){
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img1);
            itemNo = (TextView)itemView.findViewById(R.id.itemNotext);
            itemName = (TextView)itemView.findViewById(R.id.cakenametext);
            price = (TextView)itemView.findViewById(R.id.cpricetext);
            quantity = (TextView)itemView.findViewById(R.id.cquantitytext);
            orderNow = (Button)itemView.findViewById(R.id.btnOrderNow);

        }
    }
}
