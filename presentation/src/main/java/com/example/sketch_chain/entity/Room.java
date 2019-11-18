package com.example.sketch_chain.entity;

import java.util.ArrayList;

public class Room {
    int roomId;
    String name;
    String password;
    int round;
    int time;

    private int code;
    private ArrayList<RoomList> list;

    public ArrayList<RoomList> getList() {
        return list;
    }

    public void setList(ArrayList<RoomList> list) {
        this.list = list;
    }

    private String msg;
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class RoomList {
        private int allPeople;
        private int idx;
        private boolean isSecret;
        private String password;
        private int readyPeople;
        private String title;

        public RoomList() {

        }

        public RoomList(String title) {
            this.title = title;
        }

        public int getAllPeople() {
            return allPeople;
        }

        public void setAllPeople(int allPeople) {
            this.allPeople = allPeople;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public boolean isSecret() {
            return isSecret;
        }

        public void setSecret(boolean secret) {
            isSecret = secret;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getReadyPeople() {
            return readyPeople;
        }

        public void setReadyPeople(int readyPeople) {
            this.readyPeople = readyPeople;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public Room() {

    }

    public Room(String name) {
        this.name = name;
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
