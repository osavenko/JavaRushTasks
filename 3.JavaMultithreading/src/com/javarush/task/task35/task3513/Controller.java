package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    public int getScore(){
        return model.score;
    }
    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }
}
