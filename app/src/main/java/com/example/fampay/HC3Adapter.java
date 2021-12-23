package com.example.fampay;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class HC3Adapter extends RecyclerView.Adapter<HC3Adapter.ViewHolder> {
    Context context;
    List<HC3Card> HC3CardList;

    public HC3Adapter(Context context, List<HC3Card> HC3CardList) {
        this.context = context;
        this.HC3CardList = HC3CardList;
    }

    @NonNull
    @Override
    public HC3Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.hc3,parent,false);
        return new HC3Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HC3Adapter.ViewHolder holder, int position) {
        HC3Card HC3Card = HC3CardList.get(position);
        holder.tvCard.setText(HC3Card.getText());
        GlideApp.with(context).load(HC3Card.getURL())
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
        holder.button.setBackgroundColor(Color.parseColor(HC3Card.getBgColor()));
        holder.button.setText(HC3Card.getButtontext());
        holder.button.setTextColor(Color.parseColor(HC3Card.getTextColor()));
    }

    @Override
    public int getItemCount() {
        return HC3CardList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvCard,descCard;
        ImageView ivCard;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descCard=itemView.findViewById(R.id.descHC3);
            tvCard=itemView.findViewById(R.id.tvHC3);
            ivCard=itemView.findViewById(R.id.ivHC3);
            button=itemView.findViewById(R.id.buttonHC3);
        }
    }
}
