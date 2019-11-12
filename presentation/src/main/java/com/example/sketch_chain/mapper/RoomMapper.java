package com.example.sketch_chain.mapper;

import com.example.sketch_chain.entity.Room;
import com.notmyfault02.data.entity.RoomData;

public class RoomMapper {

    public static Room mapFrom(RoomData from) {
        Room room = new Room();
        room.setName(from.getName());
        room.setPassword(from.getPassword());
        room.setRoomId(from.getRoomId());
        room.setRound(from.getRound());
        room.setTime(from.getTime());
        return room;
    }

    public static RoomData mapTo(Room to) {
        RoomData data = new RoomData();
        data.setName(to.getName());
        data.setPassword(to.getPassword());
        data.setRound(to.getRound());
        data.setTime(to.getTime());
        return data;
    }
}
