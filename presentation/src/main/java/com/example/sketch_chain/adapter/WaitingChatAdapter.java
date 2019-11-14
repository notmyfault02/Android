package com.example.sketch_chain.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sketch_chain.R;

public class WaitingChatAdapter extends RecyclerView.Adapter<WaitingChatAdapter.WaitingChatViewHolder> {

    @NonNull
    @Override
    public WaitingChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new WaitingChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaitingChatViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class WaitingChatViewHolder extends RecyclerView.ViewHolder {
        public WaitingChatViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
