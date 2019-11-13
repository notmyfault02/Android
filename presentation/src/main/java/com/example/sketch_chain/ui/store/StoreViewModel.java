package com.example.sketch_chain.ui.store;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.notmyfault02.data.remote.RetrofitProvider;

public class StoreViewModel extends AndroidViewModel {


    public StoreViewModel(@NonNull Application application) {
        super(application);
    }

    public void buyItem(int index) {
        RetrofitProvider.getApi().buyItem(index);
    }
}
