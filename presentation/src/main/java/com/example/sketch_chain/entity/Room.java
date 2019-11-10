package com.example.sketch_chain.entity;

import java.util.List;

public class Room {
    int roomId;
    String name;
    int password;
    int round;

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getTime() {
        return time;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setTime(int time) {
        this.time = time;
    }

    List<User> people;
    int time;

    public Room() {

    }

    public Room(int roomId, String name, int round, int time) {
        this.roomId = roomId;
        this.name = name;
        this.round = round;
        this.time = time;
    }

    public Room(int roomId, String name, int password, int round, int time) {
        this.roomId = roomId;
        this.name = name;
        this.password = password;
        this.round = round;
        this.time = time;
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
