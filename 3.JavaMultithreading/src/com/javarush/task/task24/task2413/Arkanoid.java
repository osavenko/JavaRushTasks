package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    private boolean isGameOver;

    static Arkanoid game;

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public static void main(String[] args) {

    }

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void run(){

    }
    public void move(){
        stand.move();
        ball.move();
    }
    public void draw(Canvas canvas){
        stand.draw(canvas);
        ball.draw(canvas);
        for (Brick b:bricks){
            b.draw(canvas);
        }
    }
    public void checkBricksBump(){
        Brick b1 = null;
        for(Brick b:bricks){
            if(ball.isIntersec((BaseObject) b)){
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                b1 = b;
                break;
            }
        }
        if(b1!=null)
            bricks.remove(b1);
    }
    public void checkStandBump(){
        if(ball.isIntersec((BaseObject) stand)){
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }
    public void checkEndGame(){
        if(ball.getY()>height) isGameOver = true;
    }
}
