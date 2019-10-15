package com.example.sketch_chain.di.module;

import com.example.sketch_chain.di.scope.ActivityScope;
import com.example.sketch_chain.ui.main.MainActivity;
import com.example.sketch_chain.ui.makeRoom.MakeRoomActivity;
import com.example.sketch_chain.ui.showRoom.SearchRoomActivity;
import com.example.sketch_chain.ui.showRoom.ShowRoomActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ActivityScope
    @ContributesAndroidInjector
    abstract SearchRoomActivity searchRoomActivity();

    @ActivityScope
    @ContributesAndroidInjector
    abstract ShowRoomActivity showRoomActivity();

    @ActivityScope
    @ContributesAndroidInjector
    abstract MakeRoomActivity makeRoomActivity();
}
