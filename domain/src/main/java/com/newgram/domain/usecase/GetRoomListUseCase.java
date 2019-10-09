package com.newgram.domain.usecase;

import com.newgram.domain.base.UseCase;
import com.newgram.domain.entity.RoomEntity;
import com.newgram.domain.repository.RoomRepository;

import java.util.List;

public class GetRoomListUseCase extends UseCase<Integer, List<RoomEntity>> {

    public GetRoomListUseCase(RoomRepository roomRepository) {

    }
}
