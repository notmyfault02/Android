package com.example.sketch_chain.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.sketch_chain.databinding.ItemRoomBinding;
import com.example.sketch_chain.entity.Room;
import com.example.sketch_chain.ui.showroom.ShowRoomViewModel;

import java.util.ArrayList;

public class ShowRoomAdapter extends RecyclerView.Adapter<ShowRoomAdapter.ShowRoomViewHolder> {
    Context context;
    ShowRoomViewModel viewModel;

    private ArrayList<Room> roomList;

    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
        notifyDataSetChanged();
    }

    public ShowRoomAdapter(Context context, ShowRoomViewModel viewModel) {
        this.context = context;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public ShowRoomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemRoomBinding binding = ItemRoomBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new ShowRoomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowRoomViewHolder showRoomViewHolder, int i) {
        showRoomViewHolder.bind();
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    class ShowRoomViewHolder extends RecyclerView.ViewHolder {
        ItemRoomBinding binding;

        public ShowRoomViewHolder(@NonNull ItemRoomBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind() {
            binding.setRoom(roomList.get(getAdapterPosition()));
            binding.setIndex(getAdapterPosition());
        }
    }
}
