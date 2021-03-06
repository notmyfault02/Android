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
import com.example.sketch_chain.adapter.ChatAdapter;
import com.example.sketch_chain.adapter.GamerListAdapter;
import com.example.sketch_chain.entity.Message;
import com.example.sketch_chain.entity.User;
import com.example.sketch_chain.util.JsonChanger;
import com.notmyfault02.data.entity.RoomData;
import com.notmyfault02.data.local.PrefHelper;
import com.notmyfault02.data.repository.RoomRepository;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class InGameActivity extends AppCompatActivity {

    private ArrayList<User> gamers = new ArrayList<>();
    private ArrayList<Message> messages = new ArrayList<>();
    private ArrayList<User> readys = new ArrayList<>();

    public WebSocketClient mWebSocketClient;

    //private PlayFragment playFragment;

    private ImageView exit;
    private EditText chatEt;
    private TextView sendBtn;
    private TextView roomTv;
    TextView timeTv;
    private String answer;

    private static int TIME = 60;
    private static int ROUND = 3;

    private int timerCount = TIME;
    private int roundCount = ROUND;

    private RecyclerView chatView;
    private RecyclerView userView;
    private ChatAdapter chatAdapter;
    private GamerListAdapter gamerListAdapter;

    private JsonChanger jsonChanger = new JsonChanger();

    AutoDrawView view;

    public String maker = "dkssud";
    RoomData.RoomList roomInfo;

    public PrefHelper prefHelper = null;

    Fragment gmReadyFragment = new GmReadyFragment();
    Fragment normalReadyFragment = new NormalReadyFragment();
    Fragment playFragment = new PlayFragment();

    private RoomRepository roomRepository = new RoomRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        connectSocket();

        view = new AutoDrawView(getApplicationContext());
        playFragment = new PlayFragment();

        prefHelper = PrefHelper.getInstance();
        prefHelper.init(this);

        roomTv = findViewById(R.id.room_name_tv);
        exit = findViewById(R.id.out_room_iv);
        chatEt = findViewById(R.id.wating_input_chat_et);
        sendBtn = findViewById(R.id.send_button_tv);
        timeTv = findViewById(R.id.timer_tv);

        initChatAdapter();
        initGamerAdapter();

        roomRepository.getRoom(getIntent().getStringExtra("roomName")).subscribe(
                s -> {
                    roomTv.setText(getIntent().getStringExtra("roomName"));
                    roomInfo = s.getData();
                    maker = roomInfo.getLeaderName();
                    //peopleTv.setText(roomInfo.getAllPeople());
                    //timerStart();

                    if (prefHelper.getName().equals(roomInfo.getLeaderName())) {
                        runOnUiThread(() -> {
                            replaceFragment(gmReadyFragment);
                        });
                    } else {
                        runOnUiThread(() -> {
                            replaceFragment(normalReadyFragment);
                        });
                    }

                }, throwable -> {
                    replaceFragment(gmReadyFragment);
                    Log.e("ingame", throwable.getLocalizedMessage());
                });

        exit.setOnClickListener(v -> {
            finish();
            mWebSocketClient.close();
        });

        sendBtn.setOnClickListener(v -> {
            sendMessage();
        });
    }

    private void connectSocket() {
        URI uri;
        try {
            uri = new URI("ws://192.168.43.39:9000/ws/chat");
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
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mWebSocketClient.send(userJoin.toString());
            }

            @Override
            public void onMessage(String s) {
                Log.d("messageType", s);
                Message message = jsonChanger.messageToString(s);
                switch (message.getType()) {
                    case "JOIN":
                        runOnUiThread(() -> {
                            addUser(message.getWriter());
                            messages.add(new Message(Message.TYPE_SYSTEM, message.getWriter(), message.getWriter() + "님이 입장했습니다."));
                            chatAdapter.notifyItemInserted(messages.size() - 1);
                        });
                        break;

                    case "CHAT":
                        runOnUiThread(() -> {
                            currectAnswer(message);
                            chatAdapter.notifyItemInserted(messages.size() - 1);
                        });
                        break;

                    case "START":
                            replaceFragment(playFragment);
                        break;

                    case "ACTION_DOWN":
                        runOnUiThread(() -> {
                            Float xDown = Float.parseFloat(message.getMessage().split(", ")[0]);
                            Float yDown = Float.parseFloat(message.getMessage().split(", ")[1]);
                            view.event(xDown, yDown, message.getType());
                        });
                        break;
                    case "ACTION_MOVE":
                        runOnUiThread(() -> {
                            Float xMove = Float.parseFloat(message.getMessage().split(", ")[0]);
                            Float yMove = Float.parseFloat(message.getMessage().split(", ")[1]);
                            view.event(xMove, yMove, message.getType());
                        });
                        break;
                    case "ACTION_UP":
                        runOnUiThread(() -> {
                            Float xUp = Float.parseFloat(message.getMessage().split(", ")[0]);
                            Float yUp = Float.parseFloat(message.getMessage().split(", ")[1]);
                            view.event(xUp, yUp, message.getType());
                        });
                        break;
                    case "WORD":
                        runOnUiThread(() -> {
                            answer = message.getMessage();
                        });
                        break;

                    case "NEXT":
                        runOnUiThread(() -> {

                        });
                    case "TURN":
                        runOnUiThread(() -> {
                            ((PlayFragment)playFragment).selectTurn(message);
                        });

                }

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

    private void addMessage(String username, String message) {
        //messages.add(new Message(Message.TYPE_MESSAGE,username, message));
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
        scrollToBottom();
    }

    private void sendMessage() {
        String message = chatEt.getText().toString();
        addMessage(prefHelper.getName(), message);
        chatEt.setText("");
    }

    private void addUser(String username) {
        gamers.add(new User(username));
        gamerListAdapter.notifyItemInserted(gamers.size()-1);
    }

    private void addReadyUser(String username) {
        readys.add(new User(username));
        gamerListAdapter.notifyDataSetChanged();
    }

    private void removeUser(String username) {
        for (int i = gamers.size() - 1; i >= 0; i--) {
            User user = gamers.get(i);
            gamers.remove(i);
            gamerListAdapter.notifyItemRemoved(i);
        }
    }

    private void removeReadyUser(String username) {
        for (int i = readys.size() - 1; i >= 0; i--) {
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
        runOnUiThread(() -> {
            chatView.scrollToPosition(chatAdapter.getItemCount()-1);
        });
    }

    private void initGamerAdapter() {
        runOnUiThread(() -> {
            gamerListAdapter = new GamerListAdapter(gamers, readys);
            userView = findViewById(R.id.waiting_user_layout);
            userView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            userView.setAdapter(gamerListAdapter);
        });
    }

    private void initChatAdapter() {
        chatAdapter = new ChatAdapter(messages);
        chatView = findViewById(R.id.waiting_chat_layout);
        chatView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        chatView.setAdapter(chatAdapter);
    }

    private void currectAnswer(Message message) {
        if (message.getMessage().equals(answer)) {
            messages.add(new Message(Message.TYPE_ANSWER, message.getWriter(), message.getWriter()));
            onNext(message.getWriter());
            scrollToBottom();
        } else {
            messages.add(message);
            chatAdapter.notifyItemInserted(messages.size() - 1);
            scrollToBottom();
        }
    }

    public void timerStart() {
        runOnUiThread(() -> {
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    while (true) {
                        timerCount--;
                        if (timerCount < 0) {
                            timerCount = TIME;
                            roundCount++;

                        }
                        timeTv.post(() -> {
                            timeTv.setText(timerCount);
                        });
                        if (timerCount == 0 && roundCount == ROUND - 1)
                            break;
                    }
                }
            };
            timer.schedule(timerTask,0,1000);
        });

    }

    public void onNext(String s) {
        JSONObject userMessage = new JSONObject();
        try {
            userMessage.put("chatRoomId", roomTv.getText().toString());
            userMessage.put("type", "NEXT");
            userMessage.put("writer", s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mWebSocketClient.send(userMessage.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
