package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Rocket extends ObjectBase {
    Bitmap rocketImage;

    public Rocket(int x, int y, Bitmap rocketImage) {
        super(x, y, 255);
        this.rocketImage = rocketImage;
    }

    public void draw(Canvas canvas, Paint paint) {
        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        matrix.postTranslate(x, y);
        paint.setAlpha(alpha);
        canvas.drawBitmap(rocketImage, matrix, paint);
    }
}
