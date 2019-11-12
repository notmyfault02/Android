package com.notmyfault02.data.entity;

import java.util.List;

public class RoomData {
    private int roomId;
    private String name;
    private String password;
    private boolean secret = false;
    private int round;

    public void setTime(int time) {
        this.time = time;
    }

    private int time;

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
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

    public RoomData() {

    }

    public RoomData(int roomId, String name) {
        this.roomId = roomId;
        this.name = name;
        this.secret = false;
    }

    public RoomData(int roomId, String name, String password) {
        this.roomId = roomId;
        this.name = name;
        this.password = password;
        this.secret = true;
    }
}
