package com.example.sketch_chain.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sketch_chain.databinding.ItemRoomBinding;
import com.example.sketch_chain.entity.Room;
import com.example.sketch_chain.ui.showroom.ShowRoomViewModel;

import java.util.ArrayList;

public class ShowRoomAdapter extends RecyclerView.Adapter<ShowRoomAdapter.ShowRoomViewHolder> {
    Context context;
    ShowRoomViewModel viewModel;

    public interface ItemClick {
        void onClick(View v,int position);
    }

    ItemClick itemClick = null;

    public ItemClick getItemClick() {
        return itemClick;
    }

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    ArrayList<Room.RoomList> roomList;

    public void setRoomList(ArrayList<Room.RoomList> roomList) {
        if (roomList == null) return;
        this.roomList = roomList;
        notifyDataSetChanged();
    }

    public ShowRoomAdapter(Context context, ShowRoomViewModel viewModel, ArrayList<Room.RoomList> roomList) {
        this.context = context;
        this.viewModel = viewModel;
        this.roomList = roomList;
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

        if(itemClick != null) {
            showRoomViewHolder.itemView.setOnClickListener( v -> {
                itemClick.onClick(v, i);
            });
        }
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
