package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;


    private Stack<Integer> previousScores;
    private Stack<Tile[][]> previousStates;
    private boolean isSaveNeeded = true;

    // сохраняет состояние в стек
    private void saveState(Tile[][] field) {
        Tile[][] fieldToSave = new Tile[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                fieldToSave[i][j] = new Tile(field[i][j].value);
            }
        }
        previousStates.push(fieldToSave);
        int scoreToSave = score;
        previousScores.push(scoreToSave);
        isSaveNeeded = false;
    }

    // откат на один ход назад
    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            this.score = previousScores.pop();
            this.gameTiles = previousStates.pop();
        }
    }

    public Model() {
        resetGameTiles();
        this.previousScores = new Stack<Integer>();
        this.previousStates = new Stack<Tile[][]>();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
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
    public void left(){
        if (isSaveNeeded) saveState(this.gameTiles);
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }
    }
    public void up() {
        saveState(this.gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void right() {
        saveState(this.gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void down() {
        saveState(this.gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    // поворот матрицы на 90 градусов против часовой стрелки
    private void rotate() {
        int len = FIELD_WIDTH;
        for (int k = 0; k < len / 2; k++) // border -> center
        {
            for (int j = k; j < len - 1 - k; j++) // left -> right
            {

                Tile tmp = gameTiles[k][j];
                gameTiles[k][j] = gameTiles[j][len - 1 - k];
                gameTiles[j][len - 1 - k] = gameTiles[len - 1 - k][len - 1 - j];
                gameTiles[len - 1 - k][len - 1 - j] = gameTiles[len - 1 - j][k];
                gameTiles[len - 1 - j][k] = tmp;
            }
        }
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }
        return false;
    }
    public void randomMove() {
        switch (((int) (Math.random() * 100)) % 4) {
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }
    }
}
