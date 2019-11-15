package com.example.sketch_chain.ui.makeroom;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

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

    private RadioGroup roundRadio;
    private RadioGroup timeRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_room);
        viewModel = ViewModelProviders.of(this).get(MakeRoomViewModel.class);

        roomName = findViewById(R.id.room_name_et);
        makingBtn = findViewById(R.id.making_confirm_btn);
        roundRadio = findViewById(R.id.makeroom_round_rg);
        timeRadio = findViewById(R.id.makeroom_time_rg);

        viewModel.round.setValue(1);
        viewModel.time.setValue(60);

        roundRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.round_one_rb:
                        viewModel.round.setValue(1);
                        break;

                    case R.id.round_three_rb:
                        viewModel.round.setValue(3);
                        break;
                    case R.id.round_five_rb:
                        viewModel.round.setValue(5);
                        break;
                    default:
                        break;
                }
            }
        });

        timeRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.time_60_rb:
                        viewModel.time.setValue(60);
                        break;
                    case R.id.time_90_rb:
                        viewModel.time.setValue(90);
                        break;
                    case R.id.time_120_rb:
                        viewModel.time.setValue(120);
                        break;
                    default:
                        break;
                }
            }
        });

        makingBtn.setOnClickListener(v -> {
            viewModel.makeRoom();
            Intent intent = new Intent(getApplicationContext(), WaitingRoomActivity.class);
            intent.putExtra("roomName", roomName.getText().toString());
            startActivity(intent);
            finish();
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
