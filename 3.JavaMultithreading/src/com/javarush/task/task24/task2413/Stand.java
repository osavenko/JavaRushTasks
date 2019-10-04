package com.javarush.task.task24.task2413;

public class Stand extends BaseObject{
    private double speed;
    private double direction;

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }

    public Stand(double x, double y) {
        super(x, y, 3);
        this.speed = 1;
        this.direction = 0;
    }

    @Override
    void draw(Canvas canvas) {

    }

    @Override
    void move() {
        this.setX(this.getX()+(this.direction*this.speed));
    }
    void moveLeft(){ this.direction=-1;}
    void moveRight(){ this.direction=1;}
}
