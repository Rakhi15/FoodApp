package com.healthy.basket.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.healthy.basket.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecyclerNew extends RecyclerView.Adapter<AdapterRecyclerNew.ViewHolder> {

    Context context;
    List<String> titles;
    List<String> images;
    List<String> quantity;
    List<String> mrp;
    List<String> price;

    LayoutInflater inflater;

    public AdapterRecyclerNew(Context ctx, List<String> titles, List<String> images, List<String> quantity, List<String> mrp, List<String> price){
        this.context=ctx;
        this.titles = titles;
        this.images = images;
        this.quantity=quantity;
        this.mrp=mrp;
        this.price=price;

        this.inflater = LayoutInflater.from(ctx);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));

        // holder.gridIcon.setImageResource(images.get(position));
        Picasso.with(context).load("https://healthybaskets.co/uploads/restaurant/"+images.get(position)).into(holder.gridIcon);
        holder.quantity.setText(quantity.get(position));
        holder.mrp.setText(mrp.get(position));
        holder.price.setText(price.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, quantity, mrp, price;
        ImageView gridIcon;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.productName);
            gridIcon = itemView.findViewById(R.id.productImg);
            quantity=itemView.findViewById(R.id.qnt_txt);
            mrp=itemView.findViewById(R.id.mrp_text);
            price=itemView.findViewById(R.id.price_new);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Clicked -> " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
