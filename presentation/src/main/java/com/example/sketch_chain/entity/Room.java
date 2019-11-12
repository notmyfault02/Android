package com.example.sketch_chain.entity;

import java.util.List;

public class Room {
    int roomId;
    String name;
    String password;
    int round;
    int time;

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getTime() {
        return time;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTime(int time) {
        this.time = time;
    }

    List<User> people;

    public Room() {

    }

    public Room(String name, String password, int round, int time) {
        this.name = name;
        this.password = password;
        this.round = round;
        this.time = time;
    }

    public Room(int roomId, String name, String password, int round, int time) {
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
