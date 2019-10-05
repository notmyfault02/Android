package com.example.sketch_chain.ui.makingroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sketch_chain.R;
import com.example.sketch_chain.ui.gameplay.PlayingRoomActivity;

public class MakingRoomActivity extends AppCompatActivity {

    private EditText roomName;
    private ImageView confirmIv;
    private TextView confirmTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_making_room);

        roomName = findViewById(R.id.room_name_et);
        confirmIv = findViewById(R.id.confirm_background_iv);
        confirmTv = findViewById(R.id.confirm_button_tv);

        confirmIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlayingRoomActivity.class);
                intent.putExtra("roomName", roomName.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void cancel(View view) {
        finish();
    }
}
