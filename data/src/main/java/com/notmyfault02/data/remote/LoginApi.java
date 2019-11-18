package com.notmyfault02.data.remote;

import com.notmyfault02.data.entity.SigninResponse;
import com.notmyfault02.data.entity.SignupResponse;

import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginApi {
    @POST("/v1/signin")
    Flowable<SigninResponse> signIn(
            @Query("accessToken") String accessToken
    );

    @POST("/v1/signup")
    Flowable<SignupResponse> signUp (@Query("accessToken") String accessToken);
}
