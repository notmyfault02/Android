package com.example.sketch_chain.di.module;

import android.content.Context;

import com.example.sketch_chain.di.app.SCApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    Context provideContext(SCApplication application) {
        return application.getApplicationContext();
    }
}
