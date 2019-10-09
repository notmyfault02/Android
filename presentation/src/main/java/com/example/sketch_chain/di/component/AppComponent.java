package com.example.sketch_chain.di.component;

import com.example.sketch_chain.di.app.SCApplication;
import com.example.sketch_chain.di.module.AppModule;
import com.example.sketch_chain.di.module.BuildersModule;
import com.example.sketch_chain.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        BuildersModule.class,
        NetworkModule.class
})

public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(SCApplication application);
        AppComponent build();
    }

    void inject(SCApplication app);
}
