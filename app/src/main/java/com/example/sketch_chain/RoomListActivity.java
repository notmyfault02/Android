package com.example.sketch_chain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RoomListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);
    }

    public void cancel(View view) {
        finish();
    }
}
