package com.example.sketch_chain.ui.gameplay;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WaitingRoomActivity extends AppCompatActivity {

    private Socket mSocket;
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

//        SocketApplication app = (SocketApplication) getApplication();
//        mSocket = app.getSocket();
//        mSocket.on("user joined", onGamerJoined);
//        mSocket.on("new message", onNewMessage);
//        mSocket.on("ready user", onReady);
//        mSocket.on("user left", onGamerLefted);
//        mSocket.on("user notready", onNotReady);
//        mSocket.connect();

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

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.wating_who_frame, gmReadyFragment);
        transaction.commit();

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
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

    private Emitter.Listener onReady = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(() -> {
                JSONObject data = (JSONObject) args[0];
                String username = "";
                try {
                    username = data.getString("username");
                } catch (JSONException e) {
                    Log.e("waitingroom", e.getLocalizedMessage());
                }
                if (username == "" || username.isEmpty()) {

                } else {
                    addReadyUser(username);
                }
            });
        }
    };

    private Emitter.Listener onNotReady = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(() -> {
                JSONObject data = (JSONObject) args[0];
                String username = "";
                try {
                    username = data.getString("username");
                } catch (JSONException e) {
                    Log.e("error", e.getLocalizedMessage());
                }
                removeReadyUser(username);
            });
        }
    };

    private Emitter.Listener onGamerJoined = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    String username;
                    try {
                        username = data.getString("username");
                    } catch (JSONException e) {
                        Log.e("waitingroom", e.getMessage());
                        return;
                    }
                    addUser(username);

                }
            });
        }
    };

    private Emitter.Listener onGamerLefted = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    String username = "";
                    try {
                        username = data.getString("username");
                    } catch (JSONException e) {
                        Log.e("error", e.getLocalizedMessage());
                    }
                    removeUser(username);
                }
            });
        }
    };

    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(() -> {
                JSONObject data = (JSONObject) args[0];
                String username = "";
                String message = null;
                try {
                    username = data.getString("username");
                    message = data.getString("message");
                }catch (JSONException e) {
                    Log.e("waitingroom", e.getMessage());
                }
                addMessage(username, message);
            });
        }
    };

    private void scrollToBottom() {
        chatView.scrollToPosition(chatAdapter.getItemCount() - 1);
    }

}
