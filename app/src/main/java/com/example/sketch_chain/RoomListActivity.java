package com.example.sketch_chain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class RoomListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);

        ImageView cancelBtn = findViewById(R.id.roomlist_cancel_iv);

    }

    public void cancel(View view) {
        finish();
    }
}
