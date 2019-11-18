package com.notmyfault02.data.remote;

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
    @GET("/v1/user")
    Flowable<UserData> getUser();

    @GET("/user/rank")
    Flowable<List<UserData>> getRanking();

    @GET("/v1/rooms")
    Flowable<RoomData> getRoomList();

    @POST("/v1/room")
    Flowable<Response<Object>> makeRoom(@Body String title);

    @POST("/v1/room/secret")
    Flowable<Response<Object>> makeSecretRoom(@Body String title);

    @GET("/room/search")
    Flowable<RoomData> searchRoom(@Query("title") String roomName);

    @POST("/user/item")
    Flowable<Response<String>> buyItem(@Query("type") int item);

}
