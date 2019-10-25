package com.example.sketch_chain.entity;

public class User {
    String name;
    String url;
    int level;
    int exp;
    int coin;
    public User(String name, String url, int level, int exp, int coin) {
        this.name = name;
        this.url = url;
        this.level = level;
        this.exp = exp;
        this.coin = coin;
    }
}
