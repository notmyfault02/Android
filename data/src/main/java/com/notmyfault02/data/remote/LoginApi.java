package com.notmyfault02.data.remote;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginApi {
    @GET("/oauth/authorize")
    Flowable<Object> login(
            @Query("client_id") String appKey,
            @Query("redirect_uri") String redirectUri,
            @Query("response_type") String responseType
    );
}
