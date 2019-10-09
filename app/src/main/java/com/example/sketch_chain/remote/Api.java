package com.example.sketch_chain.remote;

import com.example.sketch_chain.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Api {
    @GET("/getRanking")
    Call<List<User>> getRanking(@Header("x-access-token") String token);
}
