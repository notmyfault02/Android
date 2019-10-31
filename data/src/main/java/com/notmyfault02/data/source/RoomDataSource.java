package com.notmyfault02.data.source;

import com.notmyfault02.data.entity.RoomData;
import com.notmyfault02.data.remote.Api;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class RoomDataSource {
    private Api api;

    public Flowable<Response<Object>> makeRoom(RoomData data) {
        return api.makeRoom(data).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Flowable<RoomData> getSearchRoom(String query) {
        return api.searchRoom(query).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
