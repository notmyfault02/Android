package com.example.sketch_chain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MakingRoomActivity extends AppCompatActivity {

    private EditText roomName;
    private ImageView confirmIv;
    private TextView confirmTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
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
