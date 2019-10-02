package com.example.sketch_chain.ui.gameplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.sketch_chain.R;

public class PlayingRoomActivity extends AppCompatActivity {

    FrameLayout stage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_room);

        stage = (FrameLayout) findViewById(R.id.room_action_framelayout);

        DrawView drawView = new DrawView(this);
        stage.addView(drawView);

        TextView roomName = findViewById(R.id.room_name_tv);
        roomName.setText(getIntent().getStringExtra("roomName"));
    }

}
