package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    abstract void draw(Canvas canvas);
    abstract void move();
    public boolean isIntersec(BaseObject baseObject){
        double distance = Math.sqrt(Math.pow((this.x - baseObject.x), 2)
                        + Math.pow((this.y - baseObject.y), 2));
        if (distance<(this.radius+baseObject.radius))
            return true;
        return false;
    }
}
