package com.example.sketch_chain.ui.showroom;

import android.arch.lifecycle.LiveData;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.sketch_chain.adapter.ShowRoomAdapter;
import com.example.sketch_chain.entity.Room;

import java.util.ArrayList;

public class ShowRoomBindingAdapter {

    @BindingAdapter("loadRoomList")
    public static void loadRoomList(RecyclerView recyclerView, LiveData<ArrayList<Room>> datas) {
        ShowRoomAdapter adapter = (ShowRoomAdapter)recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setRoomList(datas.getValue());
        }
    }

}
