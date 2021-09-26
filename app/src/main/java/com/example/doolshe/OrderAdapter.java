package com.example.doolshe;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;




public class OrderAdapter extends FirebaseRecyclerAdapter<OrderDetails, OrderAdapter.myViewHolder> {



    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public OrderAdapter(@NonNull FirebaseRecyclerOptions<OrderDetails> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull OrderAdapter.myViewHolder holder, int position, @NonNull OrderDetails model) {

        holder.cusNum.setText(model.getPhoneNumber());
        holder.cusName.setText(model.getCname());
        holder.itemName.setText(model.getItemName());
        holder.totPrice.setText(model.getPrice());
        holder.totQuantity.setText(model.getQuantity());


        /*holder.orderNow.setOnClickListener((view)->{

            Intent order = new Intent(holder.orderNow.getContext(), CustomerOrders.class);

            order.putExtra("itemName", model.getItemName());
            //order.putExtra("quantity", model.getQuantity());
            order.putExtra("price", model.getPrice());

            holder.orderNow.getContext().startActivity(order);
        });*/

    }

    @NonNull
    @Override
    public OrderAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent,false);
        return new OrderAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView itemName, totQuantity, totPrice, cusName, cusNum;


        public myViewHolder(@NonNull View itemView){
            super(itemView);

            cusNum = (TextView)itemView.findViewById(R.id.mobNorv);
            cusName = (TextView)itemView.findViewById(R.id.cusNamerv);
            itemName = (TextView)itemView.findViewById(R.id.cakenamerv);
            totPrice = (TextView)itemView.findViewById(R.id.totPricerv);
            totQuantity = (TextView)itemView.findViewById(R.id.totQtyRv);

        }
    }
}
