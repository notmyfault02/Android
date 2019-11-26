package com.example.sketch_chain.ui.gameplay;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;
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
import com.example.sketch_chain.util.JsonChanger;
import com.notmyfault02.data.local.PrefHelper;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class InGameActivity extends AppCompatActivity {

    private ArrayList<User> gamers = new ArrayList<>();
    private ArrayList<Message> messages = new ArrayList<>();
    private ArrayList<User> readys = new ArrayList<>();

    private WebSocketClient mWebSocketClient;

    private ImageView exit;
    private EditText chatEt;
    private TextView sendBtn;
    private TextView roomTv;

    private RecyclerView chatView;
    private RecyclerView userView;
    private FrameLayout frameLayout;
    private WaitingChatAdapter chatAdapter;
    private GamerListAdapter gamerListAdapter;

    private JsonChanger jsonChanger = new JsonChanger();

    private PrefHelper prefHelper = null;

    Fragment gmReadyFragment = new GmReadyFragment();
    Fragment normalReadyFragment = new NormalReadyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        //final MyView m = new DrawPad.MyView(getApplicationContext());
        //frameLayout = findViewById(R.id.play_draw_frame);
        //frameLayout.addView(m);
        prefHelper = PrefHelper.getInstance();
        prefHelper.init(this);

        roomTv = findViewById(R.id.room_name_tv);
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

        connectSocket();

        if (getIntent().getStringExtra("user") == "user") {
            replaceFragment(normalReadyFragment);
        } else {
            replaceFragment(gmReadyFragment);
        }

        roomTv.setText(getIntent().getStringExtra("roomName"));

        exit.setOnClickListener(v -> {
                finish();
        });

        sendBtn.setOnClickListener( v -> {
            sendMessage();
        });
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
                    userJoin.put("chatRoomId", getIntent().getStringExtra("roomName"));
                    userJoin.put("type", "JOIN");
                    userJoin.put("writer", prefHelper.getName());
                    mWebSocketClient.send(userJoin.toString());
                    messages.add(new Message(Message.TYPE_SYSTEM, prefHelper.getName(), prefHelper.getName() + "님이 입장했습니다."));
                    chatAdapter.notifyItemInserted(messages.size() -1);
                    addUser(prefHelper.getName());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onMessage(String s) {
                Message message = jsonChanger.messageToString(s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        messages.add(message);
//                        chatAdapter.notifyItemInserted(messages.size()-1);
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

    private void addMessage(String username, String message){
        messages.add(new Message(Message.TYPE_MESSAGE,username, message));
        JSONObject userMessage = new JSONObject();
        try {
            userMessage.put("chatRoomId", getIntent().getStringExtra("roomName"));
            userMessage.put("type", "CHAT");
            userMessage.put("message", message);
            userMessage.put("writer", username);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mWebSocketClient.send(userMessage.toString());
        chatAdapter.notifyItemInserted(messages.size()-1);
        scrollToBottom();
    }

    private void sendMessage() {
        String message = chatEt.getText().toString();
        addMessage(prefHelper.getName(), message);
        chatEt.setText("");
    }

    private void addUser(String username) {
        gamers.add(new User(username));
        gamerListAdapter.notifyDataSetChanged();
    }

    private void addReadyUser(String username) {
        readys.add(new User(username));
        gamerListAdapter.notifyDataSetChanged();
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

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.wating_who_frame, fragment).commit();
    }

    private void scrollToBottom() {
        chatView.scrollToPosition(chatAdapter.getItemCount() - 1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
