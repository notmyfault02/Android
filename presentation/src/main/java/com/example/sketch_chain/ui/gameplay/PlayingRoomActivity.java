package com.example.sketch_chain.ui.gameplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sketch_chain.R;
import com.example.sketch_chain.adapter.InGameChatAdapter;
import com.example.sketch_chain.entity.Message;

import java.util.ArrayList;

public class PlayingRoomActivity extends AppCompatActivity {

    private ImageView outBtn;
    private TextView sendBtn;
    private ArrayList<Message> messages = new ArrayList<>();
    private InGameChatAdapter adapter;
    private EditText messageEt;
    private RecyclerView chatLayout;

    class Point {
        float x;
        float y;
        boolean check;
        int color;

        public Point(float x, float y, boolean check, int color) {
            this.x = x;
            this.y = y;
            this.check = check;
            this.color = color;
        }
    }

    class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint p = new Paint();
            p.setStrokeWidth(5);
            for(int i=1;i<points.size();i++) {
                p.setColor(points.get(i).color);
                if(!points.get(i).check)
                    continue;
                canvas.drawLine(points.get(i-1).x, points.get(i-1).y, points.get(i).x, points.get(i).y, p);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    points.add(new Point(x, y, false, color));
                case MotionEvent.ACTION_MOVE:
                    points.add(new Point(x, y, true, color));
                case MotionEvent.ACTION_UP :
                    break;
            }
            invalidate();
            return true;
        }
    }

    ArrayList<Point> points = new ArrayList<Point>();
    FrameLayout frameLayout;
    int color = Color.WHITE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_room);

        final MyView m = new MyView(getApplicationContext());
        frameLayout = findViewById(R.id.playing_draw_layout);
        frameLayout.addView(m);

        chatLayout = findViewById(R.id.ingame_chat_layout);

        adapter = new InGameChatAdapter(messages);

        chatLayout.setAdapter(adapter);
        chatLayout.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        outBtn = findViewById(R.id.out_room_iv);
        messageEt = findViewById(R.id.input_chat_et);
        sendBtn = findViewById(R.id.ingame_send_button_tv);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        outBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView roomName = findViewById(R.id.room_name_tv);
        roomName.setText(getIntent().getStringExtra("roomName"));
    }

    void addMessage(String username, String message) {
        messages.add(new Message(username, message));
        Log.d("sss", message);
        adapter.notifyItemInserted(messages.size()-1);
    }

    void sendMessage() {
        String message = messageEt.getText().toString();

        addMessage("", message);
        messageEt.setText("");

    }

}
