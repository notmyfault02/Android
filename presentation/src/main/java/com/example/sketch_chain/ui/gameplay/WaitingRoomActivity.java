package com.example.sketch_chain.ui.gameplay;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sketch_chain.R;
import com.example.sketch_chain.adapter.GamerListAdapter;
import com.example.sketch_chain.adapter.WaitingChatAdapter;
import com.example.sketch_chain.entity.Message;
import com.example.sketch_chain.entity.User;
import com.example.sketch_chain.ui.GmReadyFragment;
import com.example.sketch_chain.ui.NormalReadyFragment;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class WaitingRoomActivity extends AppCompatActivity {

    private ArrayList<User> gamers = new ArrayList<User>();
    private ArrayList<Message> messages = new ArrayList<>();
    private ArrayList<User> readys = new ArrayList<>();

    private WebSocketClient mWebSocketClient;

    private ImageView exit;

    private EditText chatEt;
    private TextView sendBtn;

    private RecyclerView chatView;
    private RecyclerView userView;
    private WaitingChatAdapter chatAdapter;
    private GamerListAdapter gamerListAdapter;

    Fragment gmReadyFragment = new GmReadyFragment();
    Fragment normalReadyFragment = new NormalReadyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wating_room);

        exit = findViewById(R.id.out_room_iv);
        chatEt = findViewById(R.id.wating_input_chat_et);
        sendBtn = findViewById(R.id.send_button_tv);

        gamerListAdapter = new GamerListAdapter(gamers, readys);
        userView = findViewById(R.id.waiting_user_layout);
        userView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        userView.setAdapter(gamerListAdapter);

        chatAdapter = new WaitingChatAdapter(messages);
        chatView = findViewById(R.id.waiting_chat_layout);
        chatView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        chatView.setAdapter(chatAdapter);

        gamers.add(new User("dddd"));

        connectSocket();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (getIntent().getStringExtra("user") == "user") {
            transaction.replace(R.id.wating_who_frame, normalReadyFragment);
        } else {
            transaction.replace(R.id.wating_who_frame, gmReadyFragment);
        }
        transaction.commit();

        exit.setOnClickListener(v -> {
                finish();
        });

        sendBtn.setOnClickListener( v -> {
            sendMessage();
        });
    }

    private void addMessage(String username, String message){
        messages.add(new Message(username, message));
//        JSONObject userMessage = new JSONObject();
//        userMessage.put("name", username);
//        userMessage.put("message", message);
//        mWebSocketClient.send(userMessage.toString());
        chatAdapter.notifyItemInserted(messages.size()-1);
        scrollToBottom();
    }

    private void sendMessage() {
        String message = chatEt.getText().toString();
        addMessage("영래", message);
        chatEt.setText("");
    }

    private void removeUser(String username) {
        for (int i = gamers.size() - 1; i>=0;i--) {
            User user = gamers.get(i);
            gamers.remove(i);
            gamerListAdapter.notifyItemRemoved(i);
        }
    }

    private void removeReadyUser(String username) {
        for (int i = readys.size() - 1; i>=0;i--) {
            User user = readys.get(i);
            readys.remove(i);
            gamerListAdapter.notifyItemRemoved(i);
        }
    }

    private void addUser(String username) {
        gamers.add(new User(username));
        gamerListAdapter.notifyDataSetChanged();
    }

    private void addReadyUser(String username) {
        readys.add(new User(username));
        gamerListAdapter.notifyDataSetChanged();
    }

    private void scrollToBottom() {
        chatView.scrollToPosition(chatAdapter.getItemCount() - 1);
    }

    private void connectSocket() {
        URI uri;
        try {
            uri = new URI("ws://192.168.137.156:9000/ws/chat");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        mWebSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Opened");
                JSONObject userJoin = new JSONObject();
                try {
                    userJoin.put("username", "username");
                    mWebSocketClient.send(userJoin.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onMessage(String s) {
                final String message = s;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        EditText chatEt = findViewById(R.id.wating_input_chat_et);
                        JSONObject json = new JSONObject();
                        chatEt.setText(chatEt.getText() + "\n" + message);
                    }
                });
            }


            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Websocket", "Closed " + s);
            }
            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }

        };

        mWebSocketClient.connect();
    }

    private void sendJoin() throws JSONException {
        JSONObject user = new JSONObject();
        user.put("name", "name");
        mWebSocketClient.send(user.toString());
    }

}
