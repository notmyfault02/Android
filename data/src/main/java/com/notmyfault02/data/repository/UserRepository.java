package com.notmyfault02.data.repository;

import com.notmyfault02.data.entity.RankResponse;
import com.notmyfault02.data.entity.UserData;
import com.notmyfault02.data.remote.Api;
import com.notmyfault02.data.remote.RetrofitProvider;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {

    private Api retrofitProvider = RetrofitProvider.getApi();

    public Flowable<UserData> getUser() {
        return retrofitProvider.getUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Flowable<RankResponse> getRanking() {

        return retrofitProvider.getRanking().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
