package com.javarush.task.task24.task2413;

public class Ball extends BaseObject{
    private double speed;
    private double direction;
    private double dx;
    private double dy;
    private boolean isFrozen;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

/*    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }*/

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        this.isFrozen = true;
    }

    @Override
    void move() {
        if(isFrozen) return;
        this.setX(this.getX()+this.getDx());
        this.setY(this.getY()+this.getDy());
    }

    @Override
    void draw(Canvas canvas) {
        canvas.setPoint(this.getX(), this.getY(),'O');
    }
    void start(){
        isFrozen = false;
    }
}
