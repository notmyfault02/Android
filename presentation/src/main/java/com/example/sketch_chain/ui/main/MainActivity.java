package com.example.sketch_chain.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sketch_chain.R;
import com.example.sketch_chain.databinding.ActivityMainBinding;
import com.example.sketch_chain.ui.makeRoom.MakeRoomActivity;
import com.example.sketch_chain.ui.showRoom.ShowRoomActivity;
import com.example.sketch_chain.util.DataBindingActivity;

public class MainActivity extends DataBindingActivity<ActivityMainBinding> {

    String imageUrl;
    String name;
    ImageView profileIv;
    TextView nameTv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageUrl = getIntent().getStringExtra("image_url");
        name = getIntent().getStringExtra("name");

        profileIv = findViewById(R.id.main_profile_iv);
        nameTv = findViewById(R.id.main_name_tv);

        nameTv.setText(getIntent().getStringExtra("name"));

        Glide.with(this)
                .load(imageUrl)
                .into(profileIv);
    }

    public void onJoinClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MakeRoomActivity.class);
        startActivity(intent);
    }

    public void goRoomList(View view) {
        Intent intent = new Intent(getApplicationContext(), ShowRoomActivity.class);
        startActivity(intent);
    }
}
