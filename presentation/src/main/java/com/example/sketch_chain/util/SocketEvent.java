package com.example.sketch_chain.util;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

public class SocketEvent {

    private URI uri;

    {
        try {
            uri = new URI("ws://192.168.137.156:9000/ws/chat");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public WebSocketClient mWebSocketClient = new WebSocketClient(uri) {
        @Override
        public void onOpen(ServerHandshake handshakedata) {

        }

        @Override
        public void onMessage(String message) {

        }

        @Override
        public void onClose(int code, String reason, boolean remote) {

        }

        @Override
        public void onError(Exception ex) {

        }
    };


    private void start(String s) {
        mWebSocketClient.send(s);
    }

    private void sendDraw(Float x, Float y, String eventName, String roomName, String name) {
        JSONObject drawPath = new JSONObject();
        try {
            drawPath.put("chatRoomId", roomName);
            drawPath.put("type", eventName);
            drawPath.put("message", x.toString() + ", " + y.toString());
            drawPath.put("writer", name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mWebSocketClient.send(drawPath.toString());
    }

    private void receiveDraw() {
        
    }

//    private void connectSocket() {
//        //mWebSocketClient = new WebSocketClient(uri) {
//            @Override
//            public void onOpen(ServerHandshake serverHandshake) {
//                Log.i("Websocket", "Opened");
//                JSONObject userJoin = new JSONObject();
//                try {
//                    userJoin.put("chatRoomId", getIntent().getStringExtra("roomName"));
//                    userJoin.put("type", "JOIN");
//                    userJoin.put("writer", prefHelper.getName());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                mWebSocketClient.send(userJoin.toString());
//                messages.add(new Message(Message.TYPE_SYSTEM, prefHelper.getName(), prefHelper.getName() + "님이 입장했습니다."));
//                chatAdapter.notifyItemInserted(messages.size() - 1);
//                addUser(prefHelper.getName());
//            }
//
//            @Override
//            public void onMessage(String s) {
//                Log.d("messageType", s);
//                Message message = jsonChanger.messageToString(s);
//                switch (message.getType()) {
//                    case "JOIN":
//                        runOnUiThread(() -> {
//                            addUser(message.getUsername());
//                            messages.add(message);
//                            chatAdapter.notifyItemInserted(messages.size() - 1);
//                        });
//                        break;
//
//                    case "CHAT":
//                        runOnUiThread(() -> {
//                            messages.add(message);
//                            chatAdapter.notifyItemInserted(messages.size() - 1);
//                        });
//                        break;
//
//                    case "START":
//                        replaceFragment(playFragment);
//                        break;
//
//                    case "ACTION_DOWN":
//                        Float xDown = Float.parseFloat(message.getMessage().split(", ")[0]);
//                        Float yDown = Float.parseFloat(message.getMessage().split(", ")[1]);
//                        view.event(xDown, yDown, message.getType());
//                        view.invalidate();
//                        break;
//                    case "ACTION_MOVE":
//                        Float xMove = Float.parseFloat(message.getMessage().split(", ")[0]);
//                        Float yMove = Float.parseFloat(message.getMessage().split(", ")[1]);
//                        view.event(xMove, yMove, message.getType());
//                        view.invalidate();
//                        break;
//                    case "ACTION_UP":
//                        Float xUp = Float.parseFloat(message.getMessage().split(", ")[0]);
//                        Float yUp = Float.parseFloat(message.getMessage().split(", ")[1]);
//                        view.event(xUp, yUp, message.getType());
//                        view.invalidate();
//                        break;
//                }
//
//            }
//
//            @Override
//            public void onClose(int i, String s, boolean b) {
//                Log.i("Websocket", "Closed " + s);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                Log.i("Websocket", "Error " + e.getMessage());
//            }
//
//        };
//        mWebSocketClient.connect();
//    }
}
