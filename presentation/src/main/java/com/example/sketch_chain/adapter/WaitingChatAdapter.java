package com.example.sketch_chain.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sketch_chain.R;
import com.example.sketch_chain.entity.Message;

import java.util.ArrayList;

public class WaitingChatAdapter extends RecyclerView.Adapter<WaitingChatAdapter.WaitingChatViewHolder> {

    ArrayList<Message> messages;

    public WaitingChatAdapter(ArrayList<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public WaitingChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new WaitingChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaitingChatViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.bind(message.getUsername(), message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class WaitingChatViewHolder extends RecyclerView.ViewHolder {
        TextView usernameView;
        TextView messageView;

        public WaitingChatViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameView = itemView.findViewById(R.id.user_name_tv);
            messageView = itemView.findViewById(R.id.chat_content_tv);
        }

        void bind(String username, String message) {
            usernameView.setText(username);
            messageView.setText(message);
        }
    }
}
