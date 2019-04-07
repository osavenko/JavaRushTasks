package com.javarush.games.snake;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class Stone extends GameObject {
    private static final String STONE_SIGN = "\u2622";

    public Stone(int x, int y) {
        super(x, y);
    }
    public void draw(Game game){
        game.setCellValueEx(x, y, Color.NONE, STONE_SIGN, Color.PALEVIOLETRED, 75);
    }
}
