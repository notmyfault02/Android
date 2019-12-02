package com.example.sketch_chain.ui.gameplay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class AutoDrawView extends View {
    Path drawPath = new Path();
    Paint drawPaint = new Paint();
    Paint canvasPaint = new Paint();
    Canvas drawCanvas = new Canvas();
    Bitmap canvasBitmap;

    public AutoDrawView(Context context) {
        super(context);
        setupDrawing();

//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    drawPaint.setColor(Color.WHITE);
//                    drawPaint.setStrokeWidth(5F);
//                    event(0f, 0f, "");
//                }
//            }
//        };
//        Thread t = new Thread(r);
//        t.start();

    }

    void setupDrawing() {
        drawPaint.setColor(Color.WHITE);
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
        canvas.drawBitmap(canvasBitmap, 0f, 0f, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    public boolean event(Float x, Float y, String eventName) {

        switch (eventName) {
            case "ACTION_DOWN":
                drawPath.moveTo(x, y);
                break;
            case "ACTION_MOVE":
                drawPath.lineTo(x, y);
                break;
            case "ACTION_UP":
                drawPath.lineTo(x, y);
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;

            default:
                return false;
        }
        invalidate();
        return true;
    }
}
