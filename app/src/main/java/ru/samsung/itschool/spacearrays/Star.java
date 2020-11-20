package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Star extends ObjectBase implements Drawable, Moveable {
    private int layer;
    private int colour;

    public Star(int x, int y, int alpha, int layer, int color) {
        super(x, y, alpha);
        this.layer = layer;
        this.colour = color;
    }

    public Star(int x, int y, int alpha, int layer, boolean not_yellow) {
        super(x, y, alpha);
        this.layer = layer;
        if (not_yellow) {
            Random r = new Random();
            Colors[] colors = Colors.values();
            this.colour = colors[(int)(Math.random() * (colors.length - 1))].getColor();
        } else {
            this.colour = Color.YELLOW;
        }
    }

    public Star(int x, int y, int alpha, int layer) {
        this(x, y, alpha, layer, Color.YELLOW);
    }

    public Star(int x, int y, int layer) {
        super(x, y);
        this.layer = layer;
        this.colour = Color.YELLOW;
    }

    public Star(int x, int y, int layer, boolean not_yellow) {
        this(x, y, 255, layer, not_yellow);
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(this.colour);
        paint.setStrokeWidth(2);
        setAlpha(getAlpha() + (int)(Math.random() * 11) - 5);
        if (getAlpha() > 255) setAlpha(255);
        if (getAlpha() < 0) setAlpha(0);
        paint.setAlpha(getAlpha());
        canvas.drawCircle(getX(), getY(), layer * 2, paint);
    }

    public void move(float dx, float dy, int width, int height) {
        setX((int)(getX() + dx * layer));
        setY((int)(getY() + dy * layer));
        if (getX() < 1) {
            setX(getX() + width);
        }
        if (getY() > height) {
            setY(0);
        }
    }
}
