package com.notmyfault02.data.remote;

import com.notmyfault02.data.local.PrefHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    private PrefHelper prefHelper;

    public TokenInterceptor(PrefHelper prefHelper) {
        this.prefHelper = prefHelper;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest;
        newRequest = chain.request()
                .newBuilder()
                .addHeader("Authorization", prefHelper.getToken())
                .build();
        return chain.proceed(newRequest);
    }
}
