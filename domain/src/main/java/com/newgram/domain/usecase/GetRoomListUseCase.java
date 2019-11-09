package com.newgram.domain.usecase;

import com.newgram.domain.base.UseCase;
import com.newgram.domain.entity.RoomEntity;
import com.newgram.domain.repository.RoomRepository;

import java.util.ArrayList;

import io.reactivex.Flowable;
public class GetRoomListUseCase extends UseCase<Object ,ArrayList<RoomEntity>> {

    private RoomRepository roomRepository;

    public GetRoomListUseCase(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Flowable<ArrayList<RoomEntity>> createSingle(Object data) {
        return roomRepository.getRoomList();
    }

    public Flowable<ArrayList<RoomEntity>> getRoomList() {
        return createSingle(new Object());
    }
}
