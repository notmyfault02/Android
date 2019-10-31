package com.notmyfault02.data.entity;

import java.util.List;

public class RoomData {
    private int roomId;
    private String name;
    private int password;
    private boolean secret = false;
    private int round;

    public int getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }

    public boolean isSecret() {
        return secret;
    }

    public int getRound() {
        return round;
    }

    public List<UserData> getPeople() {
        return people;
    }

    public int getTime() {
        return time;
    }

    private List<UserData> people;
    private int time;

    public RoomData() {

    }

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
