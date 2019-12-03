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

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.WaitingChatViewHolder> {

    ArrayList<Message> messages;

    public ChatAdapter(ArrayList<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public WaitingChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = -1;
        switch (viewType) {
            case Message.TYPE_MESSAGE:
                layout = R.layout.item_chat;
                break;
            case Message.TYPE_SYSTEM:
                layout = R.layout.item_system;
                break;
            case Message.TYPE_ANSWER:
                layout = R.layout.item_answer;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new WaitingChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaitingChatViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.setUserName(message.getWriter());
        holder.setMessage(message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    @Override
    public int getItemViewType(int position) {
        return messages.get(position).getmType();
    }

    class WaitingChatViewHolder extends RecyclerView.ViewHolder {
        TextView usernameView;
        TextView messageView;

        public WaitingChatViewHolder(@NonNull View itemView) {
            super(itemView);

            usernameView = itemView.findViewById(R.id.user_name_tv);
            messageView = itemView.findViewById(R.id.chat_content_tv);
        }

        void setUserName(String username) {
            if (null == usernameView) return;
            usernameView.setText(username);
        }

        void setMessage(String message) {
            if (null == messageView) return;
            messageView.setText(message);
        }
    }
}
