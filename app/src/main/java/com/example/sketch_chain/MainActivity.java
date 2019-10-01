package com.example.sketch_chain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    String imageUrl;
    String name;
    ImageView profileIv;
    TextView nameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Intent intent = new Intent(getApplicationContext(),MakingRoomActivity.class);
        startActivity(intent);
    }

    public void goRoomList(View view) {
        Intent intent = new Intent(getApplicationContext(), RoomListActivity.class);
        startActivity(intent);
    }
}
