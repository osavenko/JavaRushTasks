package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class Apple extends GameObject {
    private static final String APPLE_SIGN = "\uD83C\uDF4E";
    public boolean isAlive;
    public boolean isBadApple;
    public Apple(int x, int y) {
        super(x, y);
        isAlive = true;
        isBadApple = false;
    }
    public void draw(Game game){
        Color aColor = isBadApple?Color.BROWN:Color.YELLOWGREEN;
        if(isAlive)
            game.setCellValueEx(x, y, Color.NONE, APPLE_SIGN, aColor, 75);
    }
}
