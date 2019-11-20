package com.example.sketch_chain.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.notmyfault02.data.remote.LoginApi;
import com.notmyfault02.data.remote.RetrofitProvider;

public class LoginViewModel extends AndroidViewModel {
    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    private LoginApi loginApi = RetrofitProvider.getLoginApi();

//    public void signup() {
//        Log.d("token", Session.getCurrentSession().getAccessToken());
//        loginApi.signUp(Session.getCurrentSession().getAccessToken())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe( body -> {
//                            prefHelper.setToken(body.getData());
//                            login();
//                        }, throwable -> { Log.d("signup", throwable.getLocalizedMessage());}
//                );
//    }

}
