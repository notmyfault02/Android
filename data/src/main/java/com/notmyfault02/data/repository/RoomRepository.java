package com.notmyfault02.data.repository;

import com.notmyfault02.data.entity.RoomData;
import com.notmyfault02.data.remote.Api;
import com.notmyfault02.data.remote.RetrofitProvider;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class RoomRepository {

    private Api api = RetrofitProvider.getApi();

    public Flowable<Response<Object>> makeRoom(RoomData data) {
        return api.makeRoom(data).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Flowable<RoomData> getSearchRoom(String query) {
        return api.searchRoom(query).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Flowable<ArrayList<RoomData>> getRoomList() {
        return api.getRoomList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
