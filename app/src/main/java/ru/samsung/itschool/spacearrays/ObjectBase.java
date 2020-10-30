package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class ObjectBase {
    int x;
    int y;
    int alpha;

    public ObjectBase(int x, int y, int alpha) {
        this.x = x;
        this.y = y;
        this.alpha = alpha;
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(2);
        paint.setAlpha(alpha);
        canvas.drawCircle(x, y, 10, paint);
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
