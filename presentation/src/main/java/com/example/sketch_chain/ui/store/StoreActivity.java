package com.example.sketch_chain.ui.store;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.example.sketch_chain.R;
import com.example.sketch_chain.databinding.ActivityStoreBinding;
import com.example.sketch_chain.util.DataBindingActivity;

public class StoreActivity extends DataBindingActivity<ActivityStoreBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_store;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}