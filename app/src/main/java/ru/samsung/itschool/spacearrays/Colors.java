package ru.samsung.itschool.spacearrays;

import android.graphics.Color;

public enum Colors {
    RED(Color.RED), ORANGE(0xFFFFA500), YELLOW(Color.YELLOW), WHITE(Color.WHITE), CYAN(Color.CYAN), BLUE(Color.BLUE);
    private int color;
    Colors(int color) {
        this.color = color;
    }
    public int getColor(){ return color;}
}
