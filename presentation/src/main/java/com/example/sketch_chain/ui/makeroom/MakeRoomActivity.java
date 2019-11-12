package com.example.sketch_chain.ui.makeroom;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.lifecycle.ViewModelProviders;

import com.example.sketch_chain.R;
import com.example.sketch_chain.databinding.ActivityMakeRoomBinding;
import com.example.sketch_chain.ui.gameplay.WaitingRoomActivity;
import com.example.sketch_chain.util.DataBindingActivity;

public class MakeRoomActivity extends DataBindingActivity<ActivityMakeRoomBinding> {

    private MakeRoomViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_make_room;
    }

    private EditText roomName;
    private Button makingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_room);
        viewModel = ViewModelProviders.of(this).get(MakeRoomViewModel.class);

        roomName = findViewById(R.id.room_name_et);
        makingBtn = findViewById(R.id.making_confirm_btn);


        makingBtn.setOnClickListener(v -> {
            viewModel.makeRoom();
            Intent intent = new Intent(getApplicationContext(), WaitingRoomActivity.class);
            intent.putExtra("roomName", roomName.getText().toString());
            startActivity(intent);
        });

        roomName.setOnKeyListener((v, keyCode, event)  -> {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) || (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_BACK)) {
                    if (TextUtils.isEmpty(roomName.getText().toString())) {
                        makingBtn.setEnabled(false);
                    } else {
                        makingBtn.setEnabled(true);
                    }
                }
                return false;
        });
    }

    public void cancel(View view) {
        finish();
    }
}
