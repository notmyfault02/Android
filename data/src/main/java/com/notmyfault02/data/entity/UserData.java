package com.notmyfault02.data.entity;

public class UserData {
    String name;
    String url;
    int level;
    int exp;
    int coin;
    public UserData(String name, String url, int level, int exp, int coin) {
        this.name = name;
        this.url = url;
        this.level = level;
        this.exp = exp;
        this.coin = coin;
    }
}
