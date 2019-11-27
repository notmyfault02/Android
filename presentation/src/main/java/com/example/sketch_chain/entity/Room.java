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
        private String leaderName;
        private String password;
        private int readyPeople;
        private String title;

        public RoomList() {

        }

        public RoomList(String title) {
            this.title = title;
        }

        public String getLeaderName() {
            return leaderName;
        }

        public void setLeaderName(String leaderName) {
            this.leaderName = leaderName;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
