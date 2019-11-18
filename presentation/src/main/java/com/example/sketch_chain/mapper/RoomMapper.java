package com.example.sketch_chain.mapper;

import com.example.sketch_chain.entity.Room;
import com.notmyfault02.data.entity.RoomData;

public class RoomMapper {

    public static Room.RoomList mapFrom(RoomData.RoomList from) {
        Room.RoomList room = new Room.RoomList();
        room.setIdx(from.getIdx());
        room.setTitle(from.getTitle());
        room.setAllPeople(from.getAllPeople());
        room.setPassword(from.getPassword());
        room.setReadyPeople(from.getReadyPeople());
        room.setSecret(from.isSecret());

        return room;
    }

    public static RoomData mapTo(Room to) {
        RoomData data = new RoomData();
//        data.setName(to.getName());
//        data.setPassword(to.getPassword());
//        data.setRound(to.getRound());
//        data.setTime(to.getTime());
        return data;
    }

    public static RoomData.RoomList mapTo(Room.RoomList to) {
        RoomData.RoomList room = new RoomData.RoomList();
        room.setIdx(to.getIdx());
        room.setTitle(to.getTitle());
        room.setAllPeople(to.getAllPeople());
        room.setPassword(to.getPassword());
        room.setReadyPeople(to.getReadyPeople());
        room.setSecret(to.isSecret());
        return room;
    }
}
