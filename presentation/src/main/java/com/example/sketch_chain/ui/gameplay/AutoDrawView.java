package com.example.sketch_chain.ui.gameplay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
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
