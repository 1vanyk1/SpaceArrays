package ru.samsung.itschool.spacearrays;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Boolean yellow_stars = getIntent().getBooleanExtra("yellow_stars", true);
        int count = getIntent().getIntExtra("count", 200);
        setContentView(R.layout.activity_main);
        MyDraw md = findViewById(R.id.myDraw1);
        md.setColor(yellow_stars);
        md.setCount_of_stars(count);
    }
}
