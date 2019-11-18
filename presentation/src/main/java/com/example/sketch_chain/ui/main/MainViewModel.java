package com.example.sketch_chain.ui.main;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.notmyfault02.data.repository.UserRepository;

public class MainViewModel extends AndroidViewModel {
    MutableLiveData<String> userName = new MutableLiveData<>();
    MutableLiveData<String> profile = new MutableLiveData<>();
    MutableLiveData<Integer> coin = new MutableLiveData<>();
    MutableLiveData<Integer> exp = new MutableLiveData<>();
    MutableLiveData<Integer> level = new MutableLiveData<>();

    private UserRepository repository = new UserRepository();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getUserName() {
        return userName;
    }

    public MutableLiveData<String> getProfile() {
        return profile;
    }

    public MutableLiveData<Integer> getLevel() {
        return level;
    }

    public MutableLiveData<Integer> getCoin() {
        return coin;
    }

    public MutableLiveData<Integer> getExp() {
        return exp;
    }

    void getUser() {
        repository.getUser().subscribe( s -> {
            userName.setValue(s.getName());
            profile.setValue(s.getProfileImage());
            coin.setValue(s.getCoin());
            exp.setValue(s.getExp());
            level.setValue(s.getLevel());
        }, throwable -> {
            Log.d("getUser",throwable.getLocalizedMessage());
        });
    }

}
