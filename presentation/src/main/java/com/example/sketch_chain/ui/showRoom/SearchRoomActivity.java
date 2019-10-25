package com.example.sketch_chain.ui.showRoom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sketch_chain.R;

public class SearchRoomActivity extends AppCompatActivity {
    private Button searchBtn;
    private EditText searchEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_room);

        searchEt = findViewById(R.id.search_et);
        searchBtn = findViewById(R.id.search_confirm_btn);
        searchEt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) || (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_BACK)) {
                    if (searchEt.getText().toString().replace(" ", "").equals("")) {
                        searchBtn.setEnabled(false);
                    } else {
                        searchBtn.setEnabled(true);
                    }
                }
                return false;
            }
        });

    }

    public void cancel(View view) {
        finish();
    }
}
