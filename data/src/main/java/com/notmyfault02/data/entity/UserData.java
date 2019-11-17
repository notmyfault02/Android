package com.notmyfault02.data.entity;

import java.util.List;

public class UserData {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
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

    private int code;
    private Data data;
    private String msg;
    private boolean success;


    static class Data {
        int coin;
        int exp;
        int idx;
        int level;
        String name;
        String password;
        List<String> roles;
        int score;
        String uid;

    }


    public int getCoin() {
        return getData().coin;
    }

    public void setCoin(int coin) {
        this.getData().coin = coin;
    }

    public int getExp() {
        return getData().exp;
    }

    public void setExp(int exp) {
        this.getData().exp = exp;
    }

    public int getIdx() {
        return getData().idx;
    }

    public void setIdx(int idx) {
        this.getData().idx = idx;
    }

    public int getLevel() {
        return getData().level;
    }

    public void setLevel(int level) {
        this.getData().level = level;
    }

    public String getName() {
        return getData().name;
    }

    public void setName(String name) {
        this.getData().name = name;
    }

    public String getPassword() {
        return getData().password;
    }

    public void setPassword(String password) {
        this.getData().password = password;
    }

    public List<String> getRoles() {
        return getData().roles;
    }

    public void setRoles(List<String> roles) {
        this.getData().roles = roles;
    }

    public int getScore() {
        return getData().score;
    }

    public void setScore(int score) {
        this.getData().score = score;
    }

    public String getUid() {
        return getData().uid;
    }

    public void setUid(String uid) {
        this.getData().uid = uid;
    }
}
