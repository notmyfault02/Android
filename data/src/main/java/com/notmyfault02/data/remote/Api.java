package com.notmyfault02.data.remote;

import com.notmyfault02.data.entity.MakeRoomResponse;
import com.notmyfault02.data.entity.RankResponse;
import com.notmyfault02.data.entity.RoomData;
import com.notmyfault02.data.entity.UserData;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @GET("/v1/user")
    Flowable<UserData> getUser();

    @GET("/v1/users")
    Flowable<RankResponse> getRanking();

    @GET("/v1/rooms")
    Flowable<RoomData> getRoomList();

    @GET("/v1/room")
    Flowable<RoomData> getRoom(
            @Query("title") String title
    );

    @POST("/v1/room")
    Flowable<Response<Object>> makeRoom(
            @Query("title") String title,
            @Query("round") Integer round,
            @Query("limit") Integer limit
    );

    @POST("/v1/room/secret")
    Flowable<MakeRoomResponse> makeSecretRoom(
            @Query("title") String title,
            @Query("password") String password,
            @Query("round") int round,
            @Query("limit") int limit
    );

    @GET("/room/search")
    Flowable<RoomData> searchRoom(@Query("title") String roomName);

    @POST("/user/item")
    Flowable<Response<String>> buyItem(@Query("type") int item);

}
