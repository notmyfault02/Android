package com.example.sketch_chain.ui.gameplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

public class DrawView extends View{
    private Paint paint;
    private float x, y, r = 5;

    private List<Pos> data;

    public DrawView(Context context) {
        super(context);

        paint = new Paint();
        paint.setColor(0xFFFFFF);
        paint.setStrokeWidth(12);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (Pos p : data) {
            canvas.drawCircle(p.getX(), p.getY(), r, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();

        Pos pos = new Pos(x, y);
        data.add(pos);

        invalidate();
        return true;
    }
}

class Pos {
    float x, y;

    Pos(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
