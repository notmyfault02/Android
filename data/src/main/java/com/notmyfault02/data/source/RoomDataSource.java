package com.notmyfault02.data.source;

import com.notmyfault02.data.entity.RoomData;

import java.util.ArrayList;

import io.reactivex.Flowable;
import retrofit2.Response;

public interface RoomDataSource {
    Flowable<Response<Object>> makeRoom(RoomData data);

    Flowable<RoomData> getSearchRoom(String query);

    Flowable<ArrayList<RoomData>> getRoomList();
}
