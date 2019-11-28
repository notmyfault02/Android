package com.example.sketch_chain.ui.gameplay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class DrawView extends View {

    Path drawPath = new Path();
    Paint drawPaint = new Paint();
    Paint canvasPaint = new Paint();
    Canvas drawCanvas = new Canvas();
    Bitmap canvasBitmap;

    public DrawView(Context context) {
        super(context);
        setupDrawing();
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
