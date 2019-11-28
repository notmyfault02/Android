package com.example.sketch_chain.ui.gameplay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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

    public static class DrawPoint {
        float x;
        float y;

        public DrawPoint(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    class MyAnotherView extends View {
        Path drawPath = new Path();
        Paint drawPaint = new Paint();
        Paint canvasPaint = new Paint();
        Canvas drawCanvas = new Canvas();
        Bitmap canvasBitmap;

        public MyAnotherView(Context context) {
            super(context);
            setupDrawing();
        }

        void setupDrawing() {
            drawPaint.setColor(color);
            drawPaint.setAntiAlias(true);
            drawPaint.setStrokeWidth(5f);
            drawPaint.setStyle(Paint.Style.STROKE);
            drawPaint.setStrokeJoin(Paint.Join.ROUND);
            drawPaint.setStrokeCap(Paint.Cap.ROUND);
            canvasPaint = new Paint(Paint.DITHER_FLAG);

        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            drawCanvas = new Canvas(canvasBitmap);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            drawPaint.setStrokeWidth(5);
//            for(int i=1;i<points.size();i++) {
//                drawPaint.setColor(points.get(i).color);
//                if(!points.get(i).check)
//                    continue;
//                canvas.drawLine(points.get(i-1).x, points.get(i-1).y, points.get(i).x, points.get(i).y, p);
//                sendDraw(points.get(i).x, points.get(i).y);
//
//            }
            canvas.drawBitmap(canvasBitmap, 0f, 0f, canvasPaint);
            canvas.drawPath(drawPath, drawPaint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //sendDraw(x, y, "ACTION_DOWN");
                    drawPath.moveTo(x, y);
                    //points.add(new Point(x, y, false, color));
                    break;
                case MotionEvent.ACTION_MOVE:
                    //sendDraw(x, y, "ACTION_MOVE");
                    drawPath.lineTo(x, y);
                    //points.add(new Point(x, y, true, color));
                    break;
                case MotionEvent.ACTION_UP :
                    //sendDraw(x, y, "ACTION_UP");
                    drawPath.lineTo(x, y);
                    drawCanvas.drawPath(drawPath, drawPaint);
                    drawPath.reset();
                    break;
            }
            invalidate();
            return true;
        }
    }

    class MyView extends View {
        Path drawPath = new Path();
        Paint drawPaint = new Paint();
        Paint canvasPaint = new Paint();
        Canvas drawCanvas = new Canvas();
        Bitmap canvasBitmap;

        public MyView(Context context) {
            super(context);
            setupDrawing();
        }

        void setupDrawing() {
            drawPaint.setColor(color);
            drawPaint.setAntiAlias(true);
            drawPaint.setStrokeWidth(5f);
            drawPaint.setStyle(Paint.Style.STROKE);
            drawPaint.setStrokeJoin(Paint.Join.ROUND);
            drawPaint.setStrokeCap(Paint.Cap.ROUND);
            canvasPaint = new Paint(Paint.DITHER_FLAG);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(canvasBitmap, 0f, 0f, canvasPaint);
            canvas.drawPath(drawPath, drawPaint);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            drawCanvas = new Canvas(canvasBitmap);
        }

        boolean event(Float x, Float y, String eventName) {
            switch (eventName) {
                case "ACTION_DOWN":
                    drawPath.moveTo(x, y);
                    break;
                case "ACTION_MOVE":
                    drawPath.lineTo(x, y);
                case "ACTION_UP":
                    drawPath.lineTo(x, y);
                    drawCanvas.drawPath(drawPath, drawPaint);
                    drawPath.reset();
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

        MyView myView = new MyView(getContext());
        MyAnotherView anotherView = new MyAnotherView(getContext());
        frameLayout = (FrameLayout) getView().findViewById(R.id.play_draw_frame);
        frameLayout.addView(myView);
        frameLayout.addView(anotherView);
        start();

        if (!!((InGameActivity) getActivity()).prefHelper.getName().equals("turn"))
            frameLayout.setClickable(false);
        else
            frameLayout.setClickable(true);

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
