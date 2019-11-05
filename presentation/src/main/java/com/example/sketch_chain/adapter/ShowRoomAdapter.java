package com.example.sketch_chain.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sketch_chain.R;
import com.example.sketch_chain.entity.Room;

import java.util.ArrayList;

public class ShowRoomAdapter extends RecyclerView.Adapter<ShowRoomAdapter.ShowRoomViewHolder> {
    Context context;

    private ArrayList<Room> roomList;

    public ShowRoomAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ShowRoomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_room, viewGroup, false);
        return new ShowRoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowRoomViewHolder showRoomViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ShowRoomViewHolder extends RecyclerView.ViewHolder {

        public ShowRoomViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
