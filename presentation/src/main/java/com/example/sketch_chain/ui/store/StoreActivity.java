package com.example.sketch_chain.ui.store;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.sketch_chain.R;
import com.example.sketch_chain.databinding.ActivityStoreBinding;
import com.example.sketch_chain.util.DataBindingActivity;

public class StoreActivity extends DataBindingActivity<ActivityStoreBinding> {

    private StoreViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_store;
    }


    private LinearLayout item1;
    private LinearLayout item2;
    private LinearLayout item3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(StoreViewModel.class);

        item1 = findViewById(R.id.item1_layout);
        item2 = findViewById(R.id.item2_layout);
        item3 = findViewById(R.id.item3_layout);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.buyItem(1);
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.buyItem(2);
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.buyItem(3);
            }
        });
    }
}