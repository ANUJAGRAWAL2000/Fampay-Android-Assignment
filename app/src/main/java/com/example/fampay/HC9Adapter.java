package com.example.fampay;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideApp;

import java.util.List;

public class HC9Adapter extends RecyclerView.Adapter<HC9Adapter.ViewHolder> {
    Context context;
    List<HC9Card> HC9CardList;

    public HC9Adapter(Context context, List<HC9Card> HC9CardList) {
        this.context = context;
        this.HC9CardList = HC9CardList;
    }

    @NonNull
    @Override
    public HC9Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.hc9,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HC9Adapter.ViewHolder holder, int position) {
        HC9Card HC9Card = HC9CardList.get(position);
        GlideApp.with(context).load(HC9Card.getURL())
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
                }).into(holder.ivHC9);
        ViewGroup.LayoutParams layoutParams = holder.ivHC9.getLayoutParams();
        layoutParams.width = (int) ((HC9Card.getRatio())*(layoutParams.height));
        holder.ivHC9.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return HC9CardList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivHC9;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHC9=itemView.findViewById(R.id.ivHC9);
        }
    }
}