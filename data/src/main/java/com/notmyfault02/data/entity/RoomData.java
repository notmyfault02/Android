package com.notmyfault02.data.entity;

import java.util.List;

public class RoomData {
    int roomId;
    String name;
    int password;
    boolean secret = false;
    int round;
    List<UserData> people;
    int time;

    public RoomData(int roomId, String name) {
        this.roomId = roomId;
        this.name = name;
        this.secret = false;
    }

    public RoomData(int roomId, String name, int password) {
        this.roomId = roomId;
        this.name = name;
        this.password = password;
        this.secret = true;
    }
}
