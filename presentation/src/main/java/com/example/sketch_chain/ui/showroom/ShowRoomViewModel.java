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

    MutableLiveData<ArrayList<Room.RoomList>> items = new MutableLiveData<>();

    ArrayList<Room.RoomList> raw = new ArrayList<>();

    private RoomRepository roomRepository = new RoomRepository();

    public MutableLiveData<ArrayList<Room.RoomList>> getItems() {
        return items;
    }

    public ShowRoomViewModel(@NonNull Application application) {
        super(application);
    }


    void getRoomList() {
        roomRepository.getRoomList().subscribe( s -> {
            for(RoomData.RoomList roomEntity: s.getList()) {
                raw.add(RoomMapper.mapFrom(roomEntity));
            }
            items.setValue(raw);
            Log.d("showRoom", "okay");

        }, throwable -> {
            Log.d("showRoom", "getRoomList : " + throwable.getLocalizedMessage());
        });
    }
}
