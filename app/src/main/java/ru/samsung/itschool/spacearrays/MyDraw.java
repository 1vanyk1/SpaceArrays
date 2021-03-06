package ru.samsung.itschool.spacearrays;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyDraw extends View {
	Rocket[] rockets = new Rocket[1000];
	int count_of_rockets = 0;
	int count_of_stars = 200;
	boolean app_is_loaded = false;
	int width, height;
	boolean is_yellow = false;

	public MyDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
		appendRocket(new Rocket(500, 600, BitmapFactory.decodeResource(getResources(), R.drawable.rocket)));
		appendRocket(new Rocket(300, 400, 4, -4, BitmapFactory.decodeResource(getResources(), R.drawable.rocket)));
	}

	public void setColor(boolean is_yellow) {
		this.is_yellow = is_yellow;
	}

	public void setCount_of_stars(int count) {
		this.count_of_stars = count;
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		sky.setSize(w, h);
		this.width = w;
		this.height = h;
		sky.create(count_of_stars, is_yellow);
		app_is_loaded = true;
	}

	Paint paint = new Paint();
	int vx = 1, vy = -1;
	Sky sky = new Sky();

	public void appendRocket(Rocket rocket) {
		rockets[count_of_rockets] = rocket;
		count_of_rockets++;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if(app_is_loaded) {
			sky.draw(canvas, paint, -vx, -vy);
			this.drawRockets(canvas, paint);
		}
		invalidate();
	}

	protected void drawRockets(Canvas canvas, Paint paint) {
		for (int i = 0; i < count_of_rockets; i++) {
			rockets[i].draw(canvas, paint);
			rockets[i].move(-vx, -vy, width, height);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		sky.appendStar(new Star((int) event.getX(), (int) event.getY(), (int)(Math.random() * 5), true));
		return false;
	}
}
