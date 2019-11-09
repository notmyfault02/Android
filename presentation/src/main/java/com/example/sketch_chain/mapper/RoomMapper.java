package com.example.sketch_chain.mapper;

import com.example.sketch_chain.entity.Room;
import com.newgram.domain.entity.RoomEntity;

public class RoomMapper {

    public static Room mapFrom(RoomEntity from) {
        Room room = new Room();
        room.setName(from.getName());
        room.setPassword(from.getPassword());
        room.setRoomId(from.getRoomId());
        room.setRound(from.getRound());
        room.setTime(from.getTime());
        return room;
    }
}
