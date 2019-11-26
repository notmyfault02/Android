package com.example.sketch_chain.util;

import com.example.sketch_chain.entity.Message;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonChanger {

    Gson gson = new Gson();
    JsonParser parser = new JsonParser();

    public Message messageToString(String s) {
        Object obj = parser.parse(s);
        JsonObject jsonObject = (JsonObject) obj;
        Message message = gson.fromJson(jsonObject, Message.class);
        return message;
    }
}
