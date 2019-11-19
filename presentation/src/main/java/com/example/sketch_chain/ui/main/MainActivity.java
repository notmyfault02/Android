package com.example.sketch_chain.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;

import com.example.sketch_chain.R;
import com.example.sketch_chain.databinding.ActivityMainBinding;
import com.example.sketch_chain.ui.login.LoginActivity;
import com.example.sketch_chain.ui.makeroom.MakeRoomActivity;
import com.example.sketch_chain.ui.showroom.ShowRoomActivity;
import com.example.sketch_chain.util.DataBindingActivity;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.notmyfault02.data.local.PrefHelper;

public class MainActivity extends DataBindingActivity<ActivityMainBinding> {

    private MainViewModel mainVm;

    private Long backPressedTime = 0l;

    private PrefHelper prefHelper = null;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainVm = ViewModelProviders.of(this).get(MainViewModel.class);

        prefHelper = PrefHelper.getInstance();
        prefHelper.init(this);

        binding.setViewmodel(mainVm);
        mainVm.getUser();
        mainVm.getProfile();

        Button logoutBtn = findViewById(R.id.main_logout_btn);
        logoutBtn.setOnClickListener( v -> {
            logout();
        });
    }

    public void onJoinClick(View view) {
        Intent intent = new Intent(getApplicationContext(), MakeRoomActivity.class);
        startActivity(intent);
    }

    public void goRoomList(View view) {
        Intent intent = new Intent(getApplicationContext(), ShowRoomActivity.class);
        startActivity(intent);
    }

    public void logout() {
        UserManagement.requestLogout(new LogoutResponseCallback() {
            @Override
            public void onCompleteLogout() {
                prefHelper.deleteToken();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
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
