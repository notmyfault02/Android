package com.example.sketch_chain.ui.roomlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sketch_chain.R;

public class SearchRoomActivity extends AppCompatActivity {
    private Button searchBtn;
    private boolean mBtnClickToggle;
    private EditText searchEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_room);

        searchEt = findViewById(R.id.search_et);
        searchBtn = findViewById(R.id.search_confirm_btn);
        if (searchEt.getText().toString() == null) {
            searchBtn.setEnabled(false);
        } else {
            searchBtn.setEnabled(true);
        }
    }

    public void cancel(View view) {
        finish();
    }
}
