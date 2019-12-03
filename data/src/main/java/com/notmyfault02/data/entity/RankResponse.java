package com.notmyfault02.data.entity;

import java.util.ArrayList;

public class RankResponse {
    int code;
    ArrayList<RankUser> rankUsers;
    String msg;
    boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<RankUser> getRankUsers() {
        return rankUsers;
    }

    public void setRankUsers(ArrayList<RankUser> rankUsers) {
        this.rankUsers = rankUsers;
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

    public static class RankUser {
        ArrayList<String> authorities;
        int coin;
        int exp;

        public ArrayList<String> getAuthorities() {
            return authorities;
        }

        public void setAuthorities(ArrayList<String> authorities) {
            this.authorities = authorities;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public ArrayList<String> getRoles() {
            return roles;
        }

        public void setRoles(ArrayList<String> roles) {
            this.roles = roles;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        int idx;
        int level;
        String name;
        String password;
        String profileImage;
        ArrayList<String> roles;
        int score;
        String uid;
    }
}
