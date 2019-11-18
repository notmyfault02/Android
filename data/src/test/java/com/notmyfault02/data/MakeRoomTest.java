package com.notmyfault02.data;

import android.util.Log;

import com.notmyfault02.data.remote.Api;
import com.notmyfault02.data.remote.RetrofitProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MakeRoomTest {
    private Api api;
    @Before
    public void initialize() {
        System.out.println("start");
        api = RetrofitProvider.getApi();

    }

    @Test
    public void makeRoom() {
        api.makeRoom("sss", 1, 60)
                .subscribe(
                body -> {
                    Log.d("makeroom", "okay: " + "" + body.getCode());
                }, throwable -> {
                    Log.d("makeroom", "error" + throwable.getLocalizedMessage());
                });
    }

    @After
    public void finish() {
        System.out.println("finish");
    }
}
