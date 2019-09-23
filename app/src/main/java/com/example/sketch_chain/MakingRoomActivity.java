package com.example.sketch_chain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MakingRoomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_making_room);
    }

    public void cancel(View view) {
        finish();
    }
}
