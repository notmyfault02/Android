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
import com.example.sketch_chain.adapter.WaitingChatAdapter;
import com.example.sketch_chain.entity.Message;
import com.example.sketch_chain.ui.GmReadyFragment;
import com.example.sketch_chain.ui.NormalReadyFragment;
import com.github.nkzawa.socketio.client.Socket;

import java.util.ArrayList;

public class WaitingRoomActivity extends AppCompatActivity {

    private Socket mSocket;
    private boolean allReady = false;
    private ArrayList<Message> messages = new ArrayList<>();

    private ImageView exit;

    private EditText chatEt;
    private TextView sendBtn;

    private RecyclerView chatView;
    private WaitingChatAdapter adapter;

    Fragment gmReadyFragment = new GmReadyFragment();
    Fragment normalReadyFragment = new NormalReadyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wating_room);
        exit = findViewById(R.id.out_room_iv);
        chatEt = findViewById(R.id.wating_input_chat_et);
        sendBtn = findViewById(R.id.send_button_tv);

        adapter = new WaitingChatAdapter(messages);
        chatView = findViewById(R.id.waiting_chat_layout);
        chatView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        chatView.setAdapter(adapter);

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

    void addMessage(String username, String message) {
        messages.add(new Message(username, message));
        Log.d("sss", message);
        adapter.notifyItemInserted(messages.size()-1);
    }

    void sendMessage() {
        String message = chatEt.getText().toString();
            addMessage("영래", message);
        chatEt.setText("");

    }


}
