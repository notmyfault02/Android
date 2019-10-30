package com.example.sketch_chain.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sketch_chain.R;
import com.example.sketch_chain.databinding.ActivityMainBinding;
import com.example.sketch_chain.ui.makeroom.MakeRoomActivity;
import com.example.sketch_chain.ui.showroom.ShowRoomActivity;
import com.example.sketch_chain.util.DataBindingActivity;

public class MainActivity extends DataBindingActivity<ActivityMainBinding> {

    private MainViewModel mainVm;

    private Long backPressedTime = 0l;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainVm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);
        binding.setViewModel(mainVm);
        mainVm.profile.setValue(getIntent().getStringExtra("image_url"));
        mainVm.userName.setValue(getIntent().getStringExtra("name"));
    }

    public void onJoinClick(View view) {
        Intent intent = new Intent(getApplicationContext(), MakeRoomActivity.class);
        startActivity(intent);
    }

    public void goRoomList(View view) {
        Intent intent = new Intent(getApplicationContext(), ShowRoomActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > backPressedTime + 2000) {
            backPressedTime = System.currentTimeMillis();
            Toast toast = Toast.makeText(this, "뒤로 버튼을 한번 더 누르면 종료됩니다", Toast.LENGTH_SHORT);

            toast.show();
            return;
        }
        if (System.currentTimeMillis() <= backPressedTime + 2000) {
            super.onBackPressed();
        }
    }


}
