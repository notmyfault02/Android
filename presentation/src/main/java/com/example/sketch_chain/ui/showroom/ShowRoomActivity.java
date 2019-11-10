package com.example.sketch_chain.ui.showroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProviders;

import com.example.sketch_chain.R;
import com.example.sketch_chain.databinding.ActivityShowRoomBinding;
import com.example.sketch_chain.ui.SearchRoomActivity;
import com.example.sketch_chain.util.DataBindingActivity;

public class ShowRoomActivity extends DataBindingActivity<ActivityShowRoomBinding> {

    private ShowRoomViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_show_room;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(ShowRoomViewModel.class);
        binding.setViewModel(viewModel);
        //viewModel.getRoomList();
    }

    public void cancel(View view) {
        finish();
    }

    public void goSearch(View view) {
        Intent intent = new Intent(getApplicationContext(), SearchRoomActivity.class);
        startActivity(intent);
    }
}
