package com.example.sketch_chain.di;

import android.content.Context;

import com.example.sketch_chain.SCApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    Context provideContext(SCApplication application) {
        return application.getApplicationContext();
    }
}
