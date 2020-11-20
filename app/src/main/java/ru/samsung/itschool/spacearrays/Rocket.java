package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Rocket extends ObjectBase implements Drawable, Moveable {
    private Bitmap rocketImage;
    private int vx;
    private int vy;

    public Rocket(int x, int y, int vx, int vy, Bitmap rocketImage) {
        super(x, y);
        this.rocketImage = rocketImage;
        this.vx = vx;
        this.vy = vy;
    }

    public Rocket(int x, int y, Bitmap rocketImage) {
        super(x, y);
        this.rocketImage = rocketImage;
        this.vx = 0;
        this.vy = 0;
    }

    public void draw(Canvas canvas, Paint paint) {
        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        matrix.postTranslate(getX(), getY());
        paint.setAlpha(getAlpha());
        canvas.drawBitmap(rocketImage, matrix, paint);
    }

    public void move(float dx, float dy, int width, int height) {
        setX(getX() + vx);
        setY(getY() + vy);
        if (getY() + rocketImage.getHeight() < 0) {
            setY(height);
        } else if (getY() > height) {
            setY(-rocketImage.getHeight());
        }
        if (getX() + rocketImage.getWidth() < 0) {
            setX(width);
        } else if (getX() > width) {
            setX(-rocketImage.getWidth());
        }
    }
}
