package com.notmyfault02.data.remote;

import com.notmyfault02.data.entity.UserData;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Api {
    @GET("/getRanking")
    Flowable<List<UserData>> getRanking();
}
