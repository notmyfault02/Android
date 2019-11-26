package com.example.sketch_chain.ui.makeroom;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.notmyfault02.data.repository.RoomRepository;

public class MakeRoomViewModel extends AndroidViewModel {

    MutableLiveData<String> roomName = new MutableLiveData<>();
    MutableLiveData<String> password = new MutableLiveData<>();
    MutableLiveData<Integer> round = new MutableLiveData<>();
    MutableLiveData<Integer> time = new MutableLiveData<>();

    public MutableLiveData<String> getRoomName() {
        return roomName;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public MutableLiveData<Integer> getRound() {
        return round;
    }

    public MutableLiveData<Integer> getTime() {
        return time;
    }

    private RoomRepository roomRepository = new RoomRepository();

    public MakeRoomViewModel(@NonNull Application application) {
        super(application);
    }

    @SuppressLint("CheckResult")
    void makeRoom() {
        roomRepository.makeRoom(
                roomName.getValue(),
                getRound().getValue(),
                getTime().getValue()
        ).subscribe(
                body -> {
                    Log.d("makeroom", "okay: " + "" + body.raw());
                }, throwable -> {
                    Log.d("makeroom", "error: " + throwable.getMessage());
                });

    }

    void makeSecretRoom() {
        roomRepository.makeSecretRoom(
                roomName.getValue(),
                password.getValue(),
                round.getValue(),
                time.getValue()
        ).subscribe( s -> {
            Log.d("makeSecretRoom",  "" + s.getCode());
        }, throwable -> {
            Log.d("makeSecretRoom", "" + throwable.getLocalizedMessage());
        });
    }
}
