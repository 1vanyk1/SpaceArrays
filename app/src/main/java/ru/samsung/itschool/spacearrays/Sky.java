package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Sky {
    protected Star[] stars = new Star[100000];
    protected int count_of_stars = 0;
    protected int width, height;

    public Sky() {
        this.width = 1200;
        this.height = 2000;
    }

    public Sky(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void createSky(int count_of_stars, int maxX, int maxY) {
        stars = new Star[100000];
        this.count_of_stars = count_of_stars;
        for (int i = 0; i < count_of_stars; i++)
        {
            Star star = new Star((int)(Math.random() * maxX), (int)(Math.random() * maxY),
                    (int)(Math.random() * 256), (int)(Math.random() * 5), true);
            stars[i] = star;
        }
    }

    public void createSky(int count_of_stars) {
        this.createSky(count_of_stars, this.width, this.height);
    }

    public void appendStar(Star star) {
        stars[count_of_stars] = star;
        count_of_stars++;
    }

    private void drawStars(Canvas canvas, Paint paint, int vx, int vy) {
        for (int i = 0; i < count_of_stars; i++)
        {
            stars[i].draw(canvas, paint);
            stars[i].move(vx, vy, width, height);
        }
    }

    public void draw(Canvas canvas, Paint paint, int vx, int vy) {
        canvas.drawColor(Color.BLACK);
        this.drawStars(canvas, paint, vx, vy);
    }
}