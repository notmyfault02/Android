package com.newgram.domain.repository;

import com.newgram.domain.entity.RoomEntity;

import java.util.ArrayList;

import io.reactivex.Flowable;
import retrofit2.Response;

public interface RoomRepository {
    Flowable<ArrayList<RoomEntity>> getRoomList();

    Flowable<RoomEntity> inGame();

    Flowable<Response<Object>> makeRoom(RoomEntity data);

    Flowable<RoomEntity> getSearchRoom(String query);
}