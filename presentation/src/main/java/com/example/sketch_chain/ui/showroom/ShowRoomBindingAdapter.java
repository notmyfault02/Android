package com.example.sketch_chain.ui.showroom;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sketch_chain.adapter.ShowRoomAdapter;
import com.example.sketch_chain.entity.Room;

import java.util.ArrayList;

public class ShowRoomBindingAdapter {

    @BindingAdapter("loadRoomList")
    public static void loadRoomList(RecyclerView recyclerView, LiveData<ArrayList<Room.RoomList>> datas) {
        ShowRoomAdapter adapter = (ShowRoomAdapter)recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setRoomList(datas.getValue());
        }
    }

    @BindingAdapter("isSecretRoom")
    public static void setSecretSetting(ImageView imageView, boolean isSecret) {
        if (isSecret == true) {
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.INVISIBLE);
        }
    }

}
