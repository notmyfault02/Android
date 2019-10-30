package com.newgram.domain.usecase;

import com.newgram.domain.base.UseCase;
import com.newgram.domain.entity.RoomEntity;
import com.newgram.domain.repository.RoomRepository;

import io.reactivex.Flowable;

public class GetSearchRoomUserCase extends UseCase<String, RoomEntity> {

    private RoomRepository repository;

    public GetSearchRoomUserCase(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flowable<RoomEntity> createSingle(String data) {
        return repository.getSearchRoom(data);
    }

    private Flowable<RoomEntity> getSearchRoom(String data) {
        return createSingle(data);
    }
}
