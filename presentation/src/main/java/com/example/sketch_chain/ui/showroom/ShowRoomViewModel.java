package com.example.sketch_chain.ui.showroom;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.sketch_chain.entity.Room;
import com.example.sketch_chain.mapper.RoomMapper;
import com.notmyfault02.data.entity.RoomData;
import com.notmyfault02.data.repository.RoomRepository;

import java.util.ArrayList;

public class ShowRoomViewModel extends AndroidViewModel {

    MutableLiveData<ArrayList<Room>> items = new MutableLiveData<>();

    ArrayList<Room> raw = new ArrayList<>();

    private RoomRepository roomRepository = new RoomRepository();

    public MutableLiveData<ArrayList<Room>> getItems() {
        return items;
    }

    public ShowRoomViewModel(@NonNull Application application) {
        super(application);
    }


    void getRoomList() {
        roomRepository.getRoomList().subscribe( s -> {
            for(RoomData roomEntity: s) {
                raw.add(RoomMapper.mapFrom(roomEntity));
            }
            items.setValue(raw);
        }, throwable -> {
            Log.d("showRoom", "getRoomList : " + throwable);
        });
    }
}
