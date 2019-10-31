package com.newgram.domain.entity;

public class UserEntity {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    String name;

    public UserEntity() {
    }

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
