package ru.samsung.itschool.spacearrays;

abstract public class ObjectBase {
    private int x;
    private int y;
    private int alpha;

    public ObjectBase(int x, int y, int alpha) {
        this.x = x;
        this.y = y;
        this.alpha = alpha;
    }

    protected void setX(int x) {
        this.x = x;
    }

    protected void setY(int y) {
        this.y = y;
    }

    protected void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public ObjectBase(int x, int y) {
        this.x = x;
        this.y = y;
        this.alpha = 255;
    }

    protected int getX() {
        return x;
    }

    protected int getY() {
        return y;
    }

    protected int getAlpha() {
        return alpha;
    }
}
