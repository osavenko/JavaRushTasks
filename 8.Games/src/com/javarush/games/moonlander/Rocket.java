package com.javarush.games.moonlander;

public class Rocket extends GameObject {
    private double speedY = 0;
    private double speedX = 0;

    private double boost = 0.05;

    public Rocket(double x, double y) {
        super(x, y, ShapeMatrix.ROCKET);
    }

    public void move(boolean isUpPressed, boolean isLeftPressed, boolean isRightPressed){
        if (isUpPressed){
            speedY-=boost;
            y+=speedY;
        }
        if(!isUpPressed){
            speedY+=boost;
            y+=speedY;
        }
        if(isLeftPressed){
            speedX-=boost;
            x+=speedX;
        }
        if(isRightPressed){
            speedX+=boost;
            x+=speedX;
        }

    }
}
