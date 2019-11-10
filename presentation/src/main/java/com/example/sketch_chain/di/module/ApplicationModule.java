package com.example.sketch_chain.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    @Singleton
    @Provides
    Context providesContext(Application application) {
        return application;
    }
}
