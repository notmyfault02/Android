package com.example.sketch_chain.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MutableLiveData<String> userName = new MutableLiveData<>();
    MutableLiveData<String> profile = new MutableLiveData<>();

    public MutableLiveData<String> getUserName() {
        return userName;
    }

    public MutableLiveData<String> getProfile() {
        return profile;
    }
}
