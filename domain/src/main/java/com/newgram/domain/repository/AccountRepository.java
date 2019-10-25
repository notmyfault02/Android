package com.newgram.domain.repository;

import java.util.HashMap;

import io.reactivex.Flowable;
import retrofit2.Response;

public interface AccountRepository {
    Flowable<Response<HashMap<String, String>>> login();


}
