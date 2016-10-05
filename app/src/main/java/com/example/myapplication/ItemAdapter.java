package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Полина on 01.10.2016.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private ArrayList<Integer> cards;
    public Context mContext;
    public OnItemClick listener;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.image);
        }

    }

    public ItemAdapter(Context context, ArrayList<Integer> cards) {
        this.cards = cards;
        mContext = context;
    }

    public void setListener(OnItemClick listener) {
        this.listener = listener;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card, parent, false);
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(cards.get(listPosition)));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(cards.get(listPosition));
            }
        });
    }

    public int getItemCount() {
        return cards.size();
    }

}
