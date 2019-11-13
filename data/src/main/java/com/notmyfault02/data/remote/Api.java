package com.notmyfault02.data.remote;

import com.notmyfault02.data.entity.RoomData;
import com.notmyfault02.data.entity.UserData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @GET("/user/info")
    Flowable<UserData> getUser();

    @GET("/user/rank")
    Flowable<List<UserData>> getRanking();

    @POST("/room")
    Flowable<Response<Object>> makeRoom(@Body RoomData body);

    @GET("/room/search")
    Flowable<RoomData> searchRoom(@Query("title") String roomName);

    @GET("/room/join")
    Flowable<RoomData> joinRoom(@Query("roomId") int roomId);

    @POST("/user/item")
    Flowable<Response<String>> buyItem(@Query("type") int item);

    @GET("/room")
    Flowable<ArrayList<RoomData>> getRoomList();

}
