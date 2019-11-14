package com.example.sketch_chain.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sketch_chain.R;
import com.example.sketch_chain.entity.User;

import java.util.ArrayList;

public class GamerListAdapter extends RecyclerView.Adapter<GamerListAdapter.GamerListViewHolder>{

    ArrayList<User> gamers;
    ArrayList<User> readys;

    public GamerListAdapter(ArrayList<User> gamers, ArrayList<User> readys) {
        this.gamers = gamers;
        this.readys = readys;
    }

    @NonNull
    @Override
    public GamerListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gamer, parent, false);
        return new GamerListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamerListViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return gamers.size();
    }

    class GamerListViewHolder extends RecyclerView.ViewHolder{


        public GamerListViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        void bind() {
            itemView.findViewById(R.id.item_word_tv);
        }
    }
}
