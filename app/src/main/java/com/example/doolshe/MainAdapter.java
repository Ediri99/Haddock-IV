package com.example.doolshe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class MainAdapter extends FirebaseRecyclerAdapter<Reviews, MainAdapter.myViewHolder> {



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

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlereview,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{


        TextView cName, cPhone, comment, rating;

        public myViewHolder(@NonNull View itemView){
            super(itemView);

            cName = (TextView)itemView.findViewById(R.id.reviewViewName);
            cPhone = (TextView)itemView.findViewById(R.id.reviewViewRating);
            comment = (TextView)itemView.findViewById(R.id.reviewViewPhoneNumber);
            rating = (TextView)itemView.findViewById(R.id.reviewViewComment);
        }
    }
}
