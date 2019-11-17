package com.notmyfault02.data.repository;

import com.notmyfault02.data.entity.UserData;
import com.notmyfault02.data.remote.Api;
import com.notmyfault02.data.remote.RetrofitProvider;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {

    private Api retrofitProvider = RetrofitProvider.getApi();

    public Flowable<UserData> getUser() {
        return retrofitProvider.getUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Flowable<List<UserData>> getRanking() {
        return null;
    }
}
