package com.example.sketch_chain.ui.main;

import androidx.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainBindingAdapter {
    @BindingAdapter("image")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }
}
