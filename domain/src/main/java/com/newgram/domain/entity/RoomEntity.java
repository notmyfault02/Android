package com.newgram.domain.entity;

import java.util.List;

public class RoomEntity {
    int roomId;
    String name;
    int password;
    boolean secret = false;
    int round;
    List<UserEntity> people;
    int time;

    public RoomEntity(int roomId, String name) {
        this.roomId = roomId;
        this.name = name;
        this.secret = false;
    }

    public RoomEntity(int roomId, String name, int password) {
        this.roomId = roomId;
        this.name = name;
        this.password = password;
        this.secret = true;
    }
}
