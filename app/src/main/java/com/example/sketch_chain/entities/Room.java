package com.example.sketch_chain.entities;

import java.util.List;

public class Room {
    int roomId;
    String name;
    int password;
    boolean secret = false;
    int round;
    List<User> people;
    int time;

    public Room(int roomId, String name) {
        this.roomId = roomId;
        this.name = name;
        this.secret = false;
    }

    public Room(int roomId, String name, int password) {
        this.roomId = roomId;
        this.name = name;
        this.password = password;
        this.secret = true;
    }
}
