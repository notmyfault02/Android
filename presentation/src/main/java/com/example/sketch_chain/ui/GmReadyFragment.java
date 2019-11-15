package com.example.sketch_chain.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sketch_chain.R;
import com.example.sketch_chain.ui.gameplay.PlayingRoomActivity;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

public class GmReadyFragment extends Fragment {

    private Button startBtn;
    private TextView content;
    private boolean isAllReady = true;
    private Socket mSocket;

    public GmReadyFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gm_ready, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSocket = new SocketApplication().getSocket();

        //mSocket.on("user_ready", onReady);
        //mSocket.connect();

        startBtn = getView().findViewById(R.id.gm_start_btn);
        content = getView().findViewById(R.id.gm_ready_tv);

        if (isAllReady == true) {
            content.setText(R.string.gm_ready);
        } else {
            content.setText(R.string.gm_waiting);
        }

        startBtn.setOnClickListener(v -> {
            //mSocket.emit("start", "start");
            if (isAllReady == false) {
                Toast.makeText(getActivity().getApplicationContext(),"모두 준비상태여야 합니다.", Toast.LENGTH_SHORT).show();
            } else {
                //mSocket.emit("start", "start");
                Intent intent = new Intent(getContext(), PlayingRoomActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
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
