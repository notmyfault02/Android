package com.example.sketch_chain.ui.makeroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.notmyfault02.data.repository.RoomRepository;

public class MakeRoomViewModel extends AndroidViewModel {


    MutableLiveData<String> roomName = new MutableLiveData<>();
    MutableLiveData<String> password = new MutableLiveData<>();
    MutableLiveData<Integer> round = new MutableLiveData<>();
    MutableLiveData<Integer> time = new MutableLiveData<>();

    private RoomRepository roomRepository = new RoomRepository();

    public MakeRoomViewModel(@NonNull Application application) {
        super(application);
    }

    void makeRoom() {
    }
}
