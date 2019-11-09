package com.example.sketch_chain.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sketch_chain.R;
import com.example.sketch_chain.ui.gameplay.PlayingRoomActivity;

public class GmReadyFragment extends Fragment {

    private Button startBtn;

    public GmReadyFragment() {
        // Required empty public constructor
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

        startBtn = getView().findViewById(R.id.gm_start_btn);

        startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), PlayingRoomActivity.class);
            startActivity(intent);
        });

    }
}
