package com.example.sketch_chain.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sketch_chain.R;
import com.example.sketch_chain.ui.showroom.ShowRoomActivity;

public class SearchRoomActivity extends AppCompatActivity {
    private Button searchBtn;
    private EditText searchEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_room);

        searchEt = findViewById(R.id.search_et);
        searchBtn = findViewById(R.id.search_confirm_btn);

        searchBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ShowRoomActivity.class);
            startActivity(intent);
            finish();
        });
        searchEt.setOnKeyListener((v, keyCode, event) ->  {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) || (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_BACK)) {
                    if (searchEt.getText().toString().replace(" ", "").equals("")) {
                        searchBtn.setEnabled(false);
                    } else {
                        searchBtn.setEnabled(true);
                    }
                }
                return false;
        });

    }

    public void cancel(View view) {
        finish();
    }
}
