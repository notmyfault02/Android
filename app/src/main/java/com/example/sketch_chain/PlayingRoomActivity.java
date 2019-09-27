package com.example.sketch_chain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PlayingRoomActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_room);

        TextView roomName = findViewById(R.id.room_name_tv);
        roomName.setText(getIntent().getStringExtra("roomName"));
    }
}
