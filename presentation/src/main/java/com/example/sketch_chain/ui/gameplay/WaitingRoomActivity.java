package com.example.sketch_chain.ui.gameplay;

import android.os.Bundle;

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

    Fragment gmReadyFragment = new GmReadyFragment();
    Fragment normalReadyFragment = new NormalReadyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wating_room);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.wating_who_frame, gmReadyFragment);
        transaction.commit();
    }


}
