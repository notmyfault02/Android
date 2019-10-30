package com.example.sketch_chain.di.component;

import com.example.sketch_chain.di.app.SCApplication;
import com.example.sketch_chain.di.module.ActivityModule;
import com.example.sketch_chain.di.module.AppModule;
import com.example.sketch_chain.di.module.BuildersModule;
import com.example.sketch_chain.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        BuildersModule.class,
        NetworkModule.class,
        ActivityModule.class
})

public interface AppComponent extends AndroidInjector<SCApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<SCApplication>{}
}
