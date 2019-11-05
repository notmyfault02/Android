package com.example.sketch_chain.ui.showroom;

import android.arch.lifecycle.LiveData;
import android.databinding.BindingAdapter;

import com.example.sketch_chain.adapter.ShowRoomAdapter;
import com.example.sketch_chain.entity.Room;

import java.util.List;

public class ShowRoomBindingAdapter {

    @BindingAdapter("loadRoomList")
    public static void loadRoomList(LiveData<List<Room>> datas) {
        ShowRoomAdapter adapter;
    }
}
