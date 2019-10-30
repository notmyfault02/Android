package com.newgram.domain.usecase;

import com.newgram.domain.base.UseCase;
import com.newgram.domain.entity.RoomEntity;
import com.newgram.domain.repository.RoomRepository;

import io.reactivex.Flowable;
import retrofit2.Response;

public class MakeRoomUseCase extends UseCase<RoomEntity, Response<Object>> {

    private RoomRepository repository;

    public MakeRoomUseCase(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flowable<Response<Object>> createSingle(RoomEntity data) {
        return repository.makeRoom(data);
    }

    private Flowable<Response<Object>> makeRoom(RoomEntity data) {
        return createSingle(data);
    }
}
