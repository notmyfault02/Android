package com.example.sketch_chain.entity;

import java.util.List;

public class Room {
    int roomId;
    String name;
    int password;
    boolean secret = false;
    int round;
    List<User> people;
    int time;

    public Room(int roomId, String name) {
        this.roomId = roomId;
        this.name = name;
        this.secret = false;
    }

    public Room(int roomId, String name, int password) {
        this.roomId = roomId;
        this.name = name;
        this.password = password;
        this.secret = true;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
