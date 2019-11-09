package com.example.sketch_chain.ui.showroom;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.sketch_chain.entity.Room;
import com.example.sketch_chain.mapper.RoomMapper;
import com.newgram.domain.entity.RoomEntity;
import com.newgram.domain.usecase.GetRoomListUseCase;

import java.util.ArrayList;

public class ShowRoomViewModel extends AndroidViewModel {
    private GetRoomListUseCase getRoomListUseCase;

    MutableLiveData<ArrayList<Room>> items = new MutableLiveData<>();

    ArrayList<Room> raw = new ArrayList<>();

    public MutableLiveData<ArrayList<Room>> getItems() {
        return items;
    }

    public ShowRoomViewModel(@NonNull Application application) {
        super(application);
    }

    public void setGetRoomListUseCase(GetRoomListUseCase getRoomListUseCase) {
        this.getRoomListUseCase = getRoomListUseCase;
    }

    void getRoomList() {
        getRoomListUseCase.getRoomList().subscribe( s -> {
            for(RoomEntity roomEntity: s) {
                raw.add(RoomMapper.mapFrom(roomEntity));
            }
            items.setValue(raw);
        }, throwable -> {
            Log.d("showRoom", "getRoomList : " + throwable);
        });
    }
}
