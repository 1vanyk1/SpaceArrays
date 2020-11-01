package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Rocket extends ObjectBase {
    Bitmap rocketImage;
    int vx;
    int vy;

    public Rocket(int x, int y, int vx, int vy, Bitmap rocketImage) {
        super(x, y, 255);
        this.rocketImage = rocketImage;
        this.vx = vx;
        this.vy = vy;
    }

    public Rocket(int x, int y, Bitmap rocketImage) {
        super(x, y, 255);
        this.rocketImage = rocketImage;
        this.vx = 0;
        this.vy = 0;
    }

    public void draw(Canvas canvas, Paint paint) {
        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        matrix.postTranslate(x, y);
        paint.setAlpha(alpha);
        canvas.drawBitmap(rocketImage, matrix, paint);
    }

    public void move(int width, int height) {
        x += vx;
        y += vy;
        if (y + rocketImage.getHeight() < 0) {
            y = height;
        } else if (y > height) {
            y = -rocketImage.getHeight();
        }
        if (x + rocketImage.getWidth() < 0) {
            x = width;
        } else if (x > width) {
            x = -rocketImage.getWidth();
        }
    }
}
