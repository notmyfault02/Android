package com.example.sketch_chain;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.RankingViewHolder> {
    Context context;

    public RankingAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull RankingViewHolder rankingViewHolder, int i) {

    }

    @NonNull
    @Override
    public RankingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ranking, viewGroup, false);
        return new RankingViewHolder(view);
    }

    class RankingViewHolder extends RecyclerView.ViewHolder {
        public RankingViewHolder(@NonNull View view) {
            super(view);
        }

    }
}
