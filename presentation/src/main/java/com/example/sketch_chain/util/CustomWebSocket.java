package com.example.sketch_chain.util;

import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.NotYetConnectedException;

public class CustomWebSocket extends WebSocketClient{
    public static URI uri;
    {
        try {
            uri = new URI("ws://192.168.137.156:9000/ws/chat");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static CustomWebSocket getInstance() {
        if (instance == null) {
            instance = new CustomWebSocket(uri);
        }
        return instance;
    }

    private static CustomWebSocket instance = null;

    public interface MessageInterface {
        void open();
    }

    public MessageInterface getMessageInterface() {
        return messageInterface;
    }

    public void setMessageInterface(MessageInterface messageInterface) {
        this.messageInterface = messageInterface;
    }

    MessageInterface messageInterface = null;

    public CustomWebSocket(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void connect() {
        super.connect();
    }

    @Override
    public void send(String text) throws NotYetConnectedException {
        super.send(text);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        if (messageInterface == null) {
            messageInterface.open();
        }
    }

    @Override
    public void onMessage(String message) {
//        Message message = jsonChanger.messageToString(s);
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                      messages.add(message);
//                       chatAdapter.notifyItemInserted(messages.size()-1);
//            }
//        });
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        Log.i("Websocket", "Closed " + reason);
    }

    @Override
    public void onError(Exception ex) {
        Log.i("Websocket", "Error " + ex.getMessage());
    }

}
