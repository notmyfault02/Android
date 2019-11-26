package com.example.sketch_chain.ui.gameplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sketch_chain.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlayFragment extends Fragment {

    private FrameLayout frameLayout;

    ArrayList<Point> points = new ArrayList<>();
    int color = Color.WHITE;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MyView m = new MyView(getContext());
        frameLayout = (FrameLayout) getView().findViewById(R.id.play_draw_frame);
        frameLayout.addView(m);
        start();


    }

    private void start() {
        JSONObject userMessage = new JSONObject();
        try {
            userMessage.put("chatRoomId", ((InGameActivity) getActivity()).getIntent().getStringExtra("roomName"));
            userMessage.put("type", "START");
            userMessage.put("writer", ((InGameActivity) getActivity()).prefHelper.getName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((InGameActivity) getActivity()).mWebSocketClient.send(userMessage.toString());
    }
}
