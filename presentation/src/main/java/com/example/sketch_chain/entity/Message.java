package com.example.sketch_chain.entity;

public class Message {

    public static final int TYPE_MESSAGE = 0;
    public static final int TYPE_SYSTEM = 1;
    public static final int TYPE_ANSWER = 2;

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    private int mType;
    String chatRoomId;
    String writer;
    String type;
    String username;
    String message;

    public Message(int mType, String username, String message) {
        this.mType = mType;
        this.username = username;
        this.message = message;
    }

    public Message(int mType, String username) {
        this.mType = mType;
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
