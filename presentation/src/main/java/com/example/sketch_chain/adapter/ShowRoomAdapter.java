package com.example.sketch_chain.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.sketch_chain.entity.Room;

import java.util.ArrayList;

public class ShowRoomAdapter extends RecyclerView.Adapter<ShowRoomAdapter.ShowRoomViewHolder> {

    private ArrayList<Room> roomList;

    @NonNull
    @Override
    public ShowRoomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
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
