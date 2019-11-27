package com.notmyfault02.data;

import android.util.Log;

import com.notmyfault02.data.entity.RoomData;
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
    public void getRoom() {
        final RoomData.RoomList[] data = new RoomData.RoomList[1];
        api.getRoom("ㄹㄹㄹ").subscribe(
                body -> {
                    data[0] = body.getData();
                    Log.d("result", String.valueOf(data[0]));
                },
                throwable -> {
                    Log.d("ingame", throwable.getLocalizedMessage());
                }
        );
    }

    @After
    public void finish() {
        System.out.println("finish");
    }
}
