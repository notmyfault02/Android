package com.example.sketch_chain.ui.showroom;

import androidx.lifecycle.LiveData;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

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
