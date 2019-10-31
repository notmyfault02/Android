package com.newgram.domain.entity;

import java.util.List;

public class RoomEntity {
    private int roomId;
    private String name;
    private int password;
    private boolean secret = false;
    private int round;
    private List<UserEntity> people;
    private int time;

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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public List<UserEntity> getPeople() {
        return people;
    }

    public void setPeople(List<UserEntity> people) {
        this.people = people;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public RoomEntity(){

    }

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
