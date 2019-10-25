package com.example.sketch_chain.di.module;

import com.notmyfault02.data.local.PrefHelper;
import com.notmyfault02.data.remote.Api;
import com.notmyfault02.data.remote.TokenInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    String baseUrl = "";

    @Provides
    @Singleton
    OkHttpClient provideClient(PrefHelper prefHelper) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new TokenInterceptor(prefHelper))
                .build();
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }
}
