package com.example.fampay;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideApp;

import java.util.List;

public class HC5Adapter extends RecyclerView.Adapter<HC5Adapter.ViewHolder> {
    Context context;
    List<HC5Card> HC5CardList;

    public HC5Adapter(Context context, List<HC5Card> HC5CardList) {
        this.context = context;
        this.HC5CardList = HC5CardList;
    }

    @NonNull
    @Override
    public HC5Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.hc5,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HC5Adapter.ViewHolder holder, int position) {
        HC5Card HC5Card = HC5CardList.get(position);
        holder.ll.setBackgroundColor(Color.parseColor(HC5Card.getColor()));
        holder.tvCard.setText(HC5Card.getText());
        GlideApp.with(context).load(HC5Card.getURL())
                .override(200, 400)
                .error(R.drawable.ic_launcher_background)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, com.bumptech.glide.request.target.Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, com.bumptech.glide.request.target.Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                }).into(holder.ivCard);
    }

    @Override
    public int getItemCount() {
        return HC5CardList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvCard;
        ImageView ivCard;
        LinearLayout ll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ll=itemView.findViewById(R.id.llHC5);
            tvCard=itemView.findViewById(R.id.tvHC5);
            ivCard=itemView.findViewById(R.id.ivHC5);
        }
    }
}
