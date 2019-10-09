package com.newgram.domain.entity;

public class UserEntity {
    String name;
    String url;
    int level;
    int exp;
    int coin;
    public UserEntity(String name, String url, int level, int exp, int coin) {
        this.name = name;
        this.url = url;
        this.level = level;
        this.exp = exp;
        this.coin = coin;
    }
}
