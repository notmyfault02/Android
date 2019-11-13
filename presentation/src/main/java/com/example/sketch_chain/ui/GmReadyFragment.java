package com.example.sketch_chain.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sketch_chain.R;
import com.example.sketch_chain.ui.gameplay.PlayingRoomActivity;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.notmyfault02.data.remote.SocketProvider;

import org.json.JSONException;
import org.json.JSONObject;

public class GmReadyFragment extends Fragment {

    private Button startBtn;
    private Socket mSocket;

    public GmReadyFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSocket = new SocketProvider().getSocket();

        mSocket.on("user_ready", onReady);
        mSocket.connect();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gm_ready, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        startBtn = getView().findViewById(R.id.gm_start_btn);

        startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), PlayingRoomActivity.class);
            startActivity(intent);
        });

    }

    private Emitter.Listener onReady = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    String username;
                    try {
                        username = data.getString("username");
                    } catch (JSONException e) {
                        Log.e("ready", e.getMessage());
                        return;
                    }
                }
            });
        }
    };
}
