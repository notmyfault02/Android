package com.example.sketch_chain.di.module;

import android.content.Context;

import com.example.sketch_chain.di.app.SCApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext(SCApplication application) {
        return application.getApplicationContext();
    }
}
