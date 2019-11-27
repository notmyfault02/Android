package com.notmyfault02.data.entity;

import java.util.ArrayList;

public class RoomData {
    private int code;

    public ArrayList<RoomList> getList() {
        return list;
    }

    public RoomList getData() {
        return data;
    }

    public void setList(ArrayList<RoomList> list) {
        this.list = list;
    }

    private ArrayList<RoomList> list;
    private RoomList data;
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

        public String getLeaderName() {
            return leaderName;
        }

        public void setLeaderName(String leaderName) {
            this.leaderName = leaderName;
        }

        private String leaderName;
        private String password;
        private int readyPeople;
        private String title;

        public void setAllPeople(int allPeople) {
            this.allPeople = allPeople;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public void setSecret(boolean secret) {
            isSecret = secret;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setReadyPeople(int readyPeople) {
            this.readyPeople = readyPeople;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getAllPeople() {
            return allPeople;
        }

        public int getIdx() {
            return idx;
        }

        public boolean isSecret() {
            return isSecret;
        }

        public String getPassword() {
            return password;
        }

        public int getReadyPeople() {
            return readyPeople;
        }

        public String getTitle() {
            return title;
        }
    }
}
