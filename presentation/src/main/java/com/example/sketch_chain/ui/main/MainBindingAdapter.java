package com.example.sketch_chain.ui.main;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sketch_chain.adapter.RankingAdapter;
import com.notmyfault02.data.entity.RankResponse;

import java.util.ArrayList;

public class MainBindingAdapter {
    @BindingAdapter("image")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @BindingAdapter("loadUsers")
    public static void loadUsers(RecyclerView recyclerView, LiveData<ArrayList<RankResponse.RankUser>> datas) {
        RankingAdapter adapter = (RankingAdapter)recyclerView.getAdapter();
        if (adapter != null) {
            //adapter.
        }
    }
}
