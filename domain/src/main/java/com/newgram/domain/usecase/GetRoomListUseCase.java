package com.newgram.domain.usecase;

import com.newgram.domain.base.UseCase;
import com.newgram.domain.entity.RoomEntity;
import com.newgram.domain.repository.RoomRepository;

import java.util.List;

import io.reactivex.Flowable;
public class GetRoomListUseCase extends UseCase<Object ,List<RoomEntity>> {

    private RoomRepository roomRepository;

    public GetRoomListUseCase(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Flowable<List<RoomEntity>> createSingle(Object data) {
        return roomRepository.getRoomList();
    }

    private Flowable<List<RoomEntity>> getRoomList() {
        return createSingle(new Object());
    }
}
