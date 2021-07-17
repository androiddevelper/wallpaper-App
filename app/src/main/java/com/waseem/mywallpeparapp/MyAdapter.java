package com.waseem.mywallpeparapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder> {
    private ArrayList<String> list;

    public MyAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private Context context;
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.image_items, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull MyAdapter.viewHolder holder, int position) {

        Glide.with(context).load(list.get(position)).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Fulimage.class);
                intent.putExtra("TIMETRAVEL", list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public viewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
