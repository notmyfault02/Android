package com.notmyfault02.data.remote;

import com.newgram.domain.entity.UserEntity;
import com.notmyfault02.data.entity.RoomData;
import com.notmyfault02.data.entity.UserData;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @GET("/user/info")
    Flowable<UserEntity> getUser();

    @GET("/user/rank")
    Flowable<List<UserData>> getRanking();

    @POST("/room")
    Flowable<Response<RoomData>> makeRoom(@Body RoomData body);

    @GET("/room/search")
    Flowable<RoomData> searchRoom(@Query("title") String roomName);

    @GET("/room/join")
    Flowable<RoomData> joinRoom(@Query("roomId") int roomId);

    @POST("/user/item")
    Flowable<Response<String>> buyItem(@Query("type") List<Integer> item);

}
