package com.notmyfault02.data.repository;

import com.notmyfault02.data.entity.RoomData;
import com.notmyfault02.data.remote.Api;
import com.notmyfault02.data.source.RoomDataSource;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class RoomRepository implements RoomDataSource{

    private Api api;

    @Override
    public Flowable<Response<Object>> makeRoom(RoomData data) {
        return null;
    }

    @Override
    public Flowable<ArrayList<RoomData>> getRoomList() {
        return api.getRoomList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Flowable<RoomData> getSearchRoom(String query) {
        return api.searchRoom(query).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
//    @Override
//    public Flowable<ArrayList<RoomEntity>> getRoomList() {
//
//        return dataSource.getRoomList().map(roomData -> {
//            ArrayList<RoomEntity> roomDataList = new ArrayList<RoomEntity>();
//            for(RoomData data: roomData) {
//                roomDataList.add(RoomEntityMapper.mapToEntity(data));
//            }
//            return roomDataList;
//            }
//        );
//    }


//    @Override
//    public Flowable<RoomEntity> inGame() {
//        return null;
//    }

//    @Override
//    public Flowable<Response<Object>> makeRoom(RoomEntity data) {
//        return null;
//        //return dataSource.makeRoom().map(data -> RoomEntityMapper.mapToEntity(data));
//    }

//    @Override
//    public Flowable<RoomEntity> getSearchRoom(String query) {
//        return dataSource.getSearchRoom(query).map(data -> RoomEntityMapper.mapToEntity(data));
//    }
}
