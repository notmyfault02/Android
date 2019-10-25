package com.newgram.domain.repository;

import com.newgram.domain.entity.RoomEntity;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Response;

public interface RoomRepository {
    Flowable<List<RoomEntity>> getRoomList();

    Flowable<RoomEntity> inGame();

    Flowable<Response> makeRoom();
}