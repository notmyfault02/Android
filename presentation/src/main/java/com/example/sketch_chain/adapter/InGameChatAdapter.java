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

public class InGameChatAdapter extends RecyclerView.Adapter<InGameChatAdapter.InGameChatViewHolder>{

    ArrayList<Message> messages;

    public InGameChatAdapter(ArrayList<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public InGameChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = -1;
        switch (viewType) {
            case 1:
                layout = R.layout.item_chat;
                break;
            case 2:
                layout = R.layout.item_answer;
                break;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new InGameChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InGameChatViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.bind(message.getUsername(), message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class InGameChatViewHolder extends RecyclerView.ViewHolder {
        TextView usernameView;
        TextView messageView;

        public InGameChatViewHolder(@NonNull View itemView) {
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
