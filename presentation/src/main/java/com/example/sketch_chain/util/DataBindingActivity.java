package com.example.sketch_chain.util;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class DataBindingActivity<T extends ViewDataBinding> extends DaggerAppCompatActivity {
    T binding;

    int layoutId;

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    private LifecycleOwner lifecycleOwner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, layoutId);
        binding.setLifecycleOwner(this);
    }
}
