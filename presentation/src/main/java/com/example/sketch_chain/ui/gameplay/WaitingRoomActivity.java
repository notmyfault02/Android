package com.example.sketch_chain.ui.gameplay;

import android.os.Bundle;
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
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;

import java.util.ArrayList;

public class WaitingRoomActivity extends AppCompatActivity {

    private ArrayList<User> gamers = new ArrayList<User>();
    private ArrayList<Message> messages = new ArrayList<>();
    private ArrayList<User> readys = new ArrayList<>();

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

        AsyncHttpClient.getDefaultInstance().websocket("", "my-protocol", new AsyncHttpClient.WebSocketConnectCallback() {
            @Override
            public void onCompleted(Exception ex, WebSocket webSocket) {
                if (ex != null) {
                    ex.printStackTrace();
                    return;
                }
                webSocket.send("a string");
                webSocket.send(new byte[10]);
                webSocket.setStringCallback(new WebSocket.StringCallback() {
                    public void onStringAvailable(String s) {
                        System.out.println("I got a string: " + s);
                    }
                });
                webSocket.setDataCallback(new DataCallback() {
                    public void onDataAvailable(DataEmitter emitter, ByteBufferList byteBufferList) {
                        System.out.println("I got some bytes!");
                        // note that this data has been read
                        byteBufferList.recycle();
                    }
                });
                }
            });

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

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.wating_who_frame, gmReadyFragment);
        transaction.commit();

        exit.setOnClickListener(v -> {
                finish();
        });

        sendBtn.setOnClickListener( v -> {
            sendMessage();
        });
    }

    private void addMessage(String username, String message) {
        messages.add(new Message(username, message));
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

}
