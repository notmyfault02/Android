package com.example.sketch_chain.di.app;

import com.example.sketch_chain.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class SCApplication extends DaggerApplication {

    private static SCApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static synchronized SCApplication getInstance() {
        return instance;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
