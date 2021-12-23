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

public class HC1Adapter extends RecyclerView.Adapter<HC1Adapter.ViewHolder> {
    Context context;
    List<HC1Card> HC1CardList;

    public HC1Adapter(Context context, List<HC1Card> HC1CardList) {
        this.context = context;
        this.HC1CardList = HC1CardList;
    }

    @NonNull
    @Override
    public HC1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.hc6,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HC1Adapter.ViewHolder holder, int position) {
        HC1Card HC1Card = HC1CardList.get(position);
        holder.tvCard.setText(HC1Card.getText());
        GlideApp.with(context).load(HC1Card.getURL())
                .override(100, 200)
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
//        holder.llHC1.setBackgroundColor(Color.parseColor(HC1Card.getBgColor()));
    }

    @Override
    public int getItemCount() {
        return HC1CardList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvCard;
        ImageView ivCard;
        LinearLayout llHC1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCard=itemView.findViewById(R.id.tvHC6);
            ivCard=itemView.findViewById(R.id.ivHC6);
            llHC1=itemView.findViewById(R.id.llHC1);
        }
    }
}
