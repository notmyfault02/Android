package com.example.sketch_chain.ui.showroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sketch_chain.R;
import com.example.sketch_chain.adapter.ShowRoomAdapter;
import com.example.sketch_chain.databinding.ActivityShowRoomBinding;
import com.example.sketch_chain.entity.Room;
import com.example.sketch_chain.ui.SearchRoomActivity;
import com.example.sketch_chain.ui.gameplay.InGameActivity;
import com.example.sketch_chain.util.DataBindingActivity;

import java.util.ArrayList;

public class ShowRoomActivity extends DataBindingActivity<ActivityShowRoomBinding> {

    private ShowRoomViewModel viewModel;
    private ShowRoomAdapter adapter;
    private ArrayList<Room.RoomList> roomList = new ArrayList<>();
    private RecyclerView roomView;
    private ImageView joinBtn;
    private String roomName;
    private TextView focusView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_show_room;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ShowRoomAdapter(getApplicationContext(), viewModel, roomList);
        joinBtn = findViewById(R.id.roomlist_join_btn);
        joinBtn.setEnabled(false);

        viewModel = ViewModelProviders.of(this).get(ShowRoomViewModel.class);
        binding.setViewModel(viewModel);
        roomView = findViewById(R.id.roomlist_rv);
        roomView.setAdapter(adapter);
        roomView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        viewModel.getRoomList();

        adapter.setItemClick(new ShowRoomAdapter.ItemClick() {
            @Override
            public void onClick(View v, int position) {
                v.findViewById(R.id.showroom_name_tv).setBackground(getDrawable(R.drawable.disactivation_button_background));

                focusView = v.findViewById(R.id.showroom_name_tv);
                roomName = focusView.getText().toString();
                joinBtn.setEnabled(true);
            }
        });

        joinBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, InGameActivity.class);
            intent.putExtra("roomName", roomName);
            startActivity(intent);
        });
    }

    public void cancel(View view) {
        finish();
    }

    public void goSearch(View view) {
        Intent intent = new Intent(getApplicationContext(), SearchRoomActivity.class);
        startActivity(intent);
    }
}
