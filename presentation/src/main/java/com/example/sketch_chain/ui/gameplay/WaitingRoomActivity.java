package com.example.sketch_chain.ui.gameplay;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sketch_chain.R;
import com.example.sketch_chain.ui.GmReadyFragment;
import com.example.sketch_chain.ui.NormalReadyFragment;
import com.github.nkzawa.socketio.client.Socket;

public class WaitingRoomActivity extends AppCompatActivity {

    private Socket mSocket;
    private boolean allReady = false;
    private ImageView exit;

    Fragment gmReadyFragment = new GmReadyFragment();
    Fragment normalReadyFragment = new NormalReadyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wating_room);
        exit = findViewById(R.id.out_room_iv);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.wating_who_frame, normalReadyFragment);
        transaction.commit();
    }


}
