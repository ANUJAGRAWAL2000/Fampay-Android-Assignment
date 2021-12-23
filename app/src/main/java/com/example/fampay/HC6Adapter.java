package com.example.fampay;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideApp;

import java.util.List;

public class HC6Adapter extends RecyclerView.Adapter<HC6Adapter.ViewHolder> {
    Context context;
    List<HC6Card> HC6CardList;

    public HC6Adapter(Context context, List<HC6Card> HC6CardList) {
        this.context = context;
        this.HC6CardList = HC6CardList;
    }

    @NonNull
    @Override
    public HC6Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.hc6,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HC6Adapter.ViewHolder holder, int position) {
        HC6Card HC6Card = HC6CardList.get(position);
        holder.tvCard.setText(HC6Card.getText());
        GlideApp.with(context).load(HC6Card.getURL())
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
    }

    @Override
    public int getItemCount() {
        return HC6CardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvCard;
        ImageView ivCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCard=itemView.findViewById(R.id.tvHC6);
            ivCard=itemView.findViewById(R.id.ivHC6);
        }
    }
}
