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
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull SellerOrder model) {
        holder.customerName.setText(model.getOrderName());
        holder.orderName.setText(model.getItemName());
        holder.phoneNumber.setText(model.getPhoneNumber());
        holder.description.setText(model.getDescription());

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlesellerorders,parent,false);
        return new myViewHolder(view);
    }


    class myViewHolder extends RecyclerView.ViewHolder{


        TextView customerName, orderName, phoneNumber, description;

        public myViewHolder(@NonNull View itemView){
            super(itemView);

            customerName = (TextView)itemView.findViewById(R.id.sellerCustomerName);
            orderName= (TextView)itemView.findViewById(R.id.sellerOrderName);
            phoneNumber = (TextView)itemView.findViewById(R.id.sellerCustomerPhone);
            description = (TextView)itemView.findViewById(R.id.sellerDescription);
        }
    }
}
