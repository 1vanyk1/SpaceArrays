package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Star extends ObjectBase{
    int layer;
    public Star(int x, int y, int alpha, int layer) {
        super(x, y, alpha);
        this.layer = layer;
    }

    public Star(int x, int y, int layer) {
        super(x, y, 256);
        this.layer = layer;
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(2);
        alpha += (int)(Math.random() * 11) - 5;
        if (alpha > 255) alpha = 255;
        if (alpha < 0) alpha = 0;
        paint.setAlpha(alpha);
        canvas.drawCircle(x, y, layer * 2, paint);
    }

    public void move(float dx, float dy, int width, int height) {
        x += dx * layer;
        y += dy * layer;
        if (x < 1) {
            x = x + width;
        }
        if (y > height) {
            y = 0;
        }
    }
}
