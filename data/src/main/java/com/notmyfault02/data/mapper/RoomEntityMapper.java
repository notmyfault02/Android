package com.notmyfault02.data.mapper;

import com.newgram.domain.entity.RoomEntity;
import com.notmyfault02.data.entity.RoomData;

public class RoomEntityMapper {

    public static RoomEntity mapToEntity(RoomData data) {
        RoomEntity entity = new RoomEntity();
        entity.setRoomId(data.getRoomId());
        entity.setName(data.getName());
        entity.setPassword(data.getPassword());
        entity.setRound(data.getRound());
        entity.setTime(data.getTime());
        entity.setSecret(data.isSecret());

        return entity;
    }
}
