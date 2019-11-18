package com.notmyfault02.data.remote;

import com.notmyfault02.data.local.PrefHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider {
    private static final String BASE_URL = "http://192.168.137.156:8080";

    private static final OkHttpClient.Builder builder = new OkHttpClient.Builder();

    public static Api getApi() {
        return getInstance().create(Api.class);
    }

    public static LoginApi getLoginApi() { return getLoginInstance().create(LoginApi.class);}

    public static Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder.addInterceptor(interceptor).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static Retrofit getLoginInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static final Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request newRequest;
            newRequest = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", PrefHelper.getInstance().getToken())
                    .build();
            return chain.proceed(newRequest);
        }
    };

}
