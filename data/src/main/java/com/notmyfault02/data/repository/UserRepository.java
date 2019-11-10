package com.notmyfault02.data.repository;

import com.notmyfault02.data.entity.UserData;
import com.notmyfault02.data.remote.Api;
import com.notmyfault02.data.source.UserDataSource;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository implements UserDataSource {

    private Api api;

    @Override
    public Flowable<UserData> getUser() {
        return api.getUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Flowable<List<UserData>> getRanking() {
        return null;
    }
}
