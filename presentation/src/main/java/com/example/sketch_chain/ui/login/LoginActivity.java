package com.example.sketch_chain.ui.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sketch_chain.R;
import com.example.sketch_chain.ui.main.MainActivity;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;
import com.notmyfault02.data.local.PrefHelper;
import com.notmyfault02.data.remote.LoginApi;
import com.notmyfault02.data.remote.RetrofitProvider;

import java.security.MessageDigest;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;

    //kakao
    private SessionCallback callback;
    private LoginApi loginApi = RetrofitProvider.getLoginApi();
    private PrefHelper prefHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefHelper = PrefHelper.getInstance();
        prefHelper.init(this);
        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);
        Session.getCurrentSession().checkAndImplicitOpen();

        getAppKeyHash();
    }

    private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.e("Hash key", something);
            }
        } catch (Exception e) {
            Log.e("name not found", e.toString());

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data))
            return;

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private class SessionCallback implements ISessionCallback {
        @SuppressLint("CheckResult")
        @Override
        public void onSessionOpened() {
            if (prefHelper.getToken().isEmpty())
                signup();
            else login();

        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                Logger.e(exception);
            }
        }
    }
    private void redirectMainActivity() {
        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void signup() {
        Log.d("token", Session.getCurrentSession().getAccessToken());
        loginApi.signUp(Session.getCurrentSession().getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            prefHelper.setToken(body.getData());
                            login();
                        }, throwable -> {
                            Log.d("signup", throwable.getLocalizedMessage());
                            login();
                        }
                );
    }

    public void login() {
        loginApi.signIn(Session.getCurrentSession().getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( body -> {
                    prefHelper.setToken(body.getData());
                    redirectMainActivity();
                }, throwable -> {
                    Log.d("signin", throwable.getLocalizedMessage());
                });
    }
}
