package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;

    public Model() {
        resetGameTiles();
    }
    void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i<FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }
    private List<Tile> getEmptyTiles(){
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i<FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++){
                if(gameTiles[i][j].isEmpty()) list.add(gameTiles[i][j]);
            }
        return list;
    }
    void addTile(){
        List<Tile> list = getEmptyTiles();
        if(list.size()>0) {
            list.get((int)(list.size()*Math.random())).value = Math.random() < 0.9 ? 2 : 4;
        }
    }
    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        Tile temp;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tiles[j].value == 0 && tiles[j + 1].value != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }
    private boolean mergeTiles(Tile[] tiles){
        boolean isChanged = false;
        for (int j = 0; j < 3; j++) {
            if (tiles[j].value != 0 && tiles[j].value == tiles[j + 1].value) {
                tiles[j].value = tiles[j].value * 2;
                tiles[j + 1].value = 0;
                if (tiles[j].value > maxTile) maxTile = tiles[j].value;
                score += tiles[j].value;
                isChanged = true;

            }
        }

        if (isChanged) {
            Tile temp;
            for (int j = 0; j < 3; j++) {
                if (tiles[j].value == 0 && tiles[j + 1].value != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                }
            }
        }

        return isChanged;
    }

}
