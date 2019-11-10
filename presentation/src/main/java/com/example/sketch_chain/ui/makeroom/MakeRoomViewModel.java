package com.example.sketch_chain.ui.makeroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MakeRoomViewModel extends AndroidViewModel {

    MutableLiveData<String> roomName = new MutableLiveData<>();
    MutableLiveData<String> password = new MutableLiveData<>();
    MutableLiveData<Integer> round = new MutableLiveData<>();
    MutableLiveData<Integer> time = new MutableLiveData<>();

    public MakeRoomViewModel(@NonNull Application application) {
        super(application);
    }
}
