package com.example.sketch_chain.di.module;

import com.example.sketch_chain.di.scope.ActivityScope;
import com.example.sketch_chain.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();


}
