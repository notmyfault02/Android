package com.example.sketch_chain.ui.gameplay;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
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

    public static class DrawPoint {
        float x;
        float y;

        public DrawPoint(float x, float y) {
            this.x = x;
            this.y = y;
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

        DrawView drawView = new DrawView(getContext());
        AutoDrawView autoDrawViewView = new AutoDrawView(getContext());
        frameLayout = (FrameLayout) getView().findViewById(R.id.play_draw_frame);
        frameLayout.addView(drawView);
        frameLayout.addView(autoDrawViewView);
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

    private void sendDraw(Float x, Float y, String eventName) {
        JSONObject drawPath = new JSONObject();
        try {
            drawPath.put("chatRoomId", ((InGameActivity) getActivity()).getIntent().getStringExtra("roomName"));
            drawPath.put("type", "DRAW");
            //drawPath.put("type", eventName);
            drawPath.put("message", x.toString() + ", " + y.toString());
            drawPath.put("writer", ((InGameActivity) getActivity()).prefHelper.getName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((InGameActivity) getActivity()).mWebSocketClient.send(drawPath.toString());
    }
}
