package com.example.sketch_chain.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sketch_chain.R;

public class NormalReadyFragment extends Fragment {

    private Button readyBtn;
    private TextView content;
    private boolean isReady = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_normal_ready, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        readyBtn = getActivity().findViewById(R.id.normal_release_btn);
        content = getActivity().findViewById(R.id.normal_ready_tv);

        readyBtn.setOnClickListener(v -> {
            if (isReady != true) {
                isReady = true;
                //mSocket.emit("ready", "username");
                content.setText(R.string.normal_ready);
                readyBtn.setText("해제");

            } else {
                isReady = false;
                //mSocket.emit("notReady", "username");
                content.setText(R.string.normal_waiting);
                readyBtn.setText("준비");
            }
        });
    }
}
