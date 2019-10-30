package com.example.sketch_chain.di.module;

import android.content.Context;

import com.example.sketch_chain.ui.main.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    Context context;

    @Provides
    MainViewModel mainViewModel() {
        return new MainViewModel();
    }
}
