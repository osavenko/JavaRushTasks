package com.javarush.games.snake;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;
import com.javarush.engine.cell.*;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u2B24";
    public boolean isAlive;
    private Direction direction;

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x,y));
        snakeParts.add(new GameObject(x+1,y));
        snakeParts.add(new GameObject(x+2,y));
        isAlive = true;
        direction = Direction.LEFT;
    }
    public void setDirection(Direction direction){
        boolean chDirection = true;
        if((direction == Direction.LEFT)&&(this.direction==Direction.RIGHT)){
            chDirection = false;
        }
        if((direction == Direction.RIGHT)&&(this.direction==Direction.LEFT)){
            chDirection = false;
        }
        if((direction == Direction.UP)&&(this.direction==Direction.DOWN)){
            chDirection = false;
        }
        if((direction == Direction.DOWN)&&(this.direction==Direction.UP)){
            chDirection = false;
        }
        if((this.direction == Direction.LEFT)&&(snakeParts.get(0).x==snakeParts.get(1).x)){
            chDirection = false;
        }
        if((this.direction == Direction.RIGHT)&&(snakeParts.get(0).x==snakeParts.get(1).x)){
            chDirection = false;
        }
        if((this.direction == Direction.UP)&&(snakeParts.get(0).y==snakeParts.get(1).y)){
            chDirection = false;
        }
        if((this.direction== Direction.DOWN)&&(snakeParts.get(0).y==snakeParts.get(1).y)){
            chDirection = false;
        }

        if (chDirection) {
            this.direction = direction;
        }
    }
    public void move(Apple apple, Apple badApple,ArrayList<Stone> listStones){
        //apple.isAlive = false;
        GameObject gO = createNewHead();

        if(gO.x<0||gO.y<0||gO.x>SnakeGame.HEIGHT-1|| gO.y>SnakeGame.WIDTH-1||checkStone(gO, listStones)) {
            isAlive = false;
        } else {
            if (!checkCollision(gO)) {
                snakeParts.add(0, gO);
                if(apple.x==gO.x&&apple.y==gO.y){
                    apple.isAlive = false;
                } else{
                    removeTail();
                }
                if(badApple.x==gO.x&&badApple.y==gO.y){
                    badApple.isAlive = false;
                }
            } else{
                this.isAlive = false;
            }
        }

    }
    private boolean checkStone(GameObject oG, ArrayList<Stone> list){
        for (Stone s:list){
            if(s.x==oG.x&&s.y==oG.y) return true;
        }
        return false;
    }
    public GameObject createNewHead(){
        GameObject gO = null;
        int currentX = snakeParts.get(0).x;
        int currentY = snakeParts.get(0).y;

        switch (direction){
            case UP:
                gO = new GameObject(currentX,currentY-1);
                break;
            case DOWN:
                gO = new GameObject(currentX,currentY+1);
                break;
            case LEFT:
                gO = new GameObject(currentX-1,currentY);
                break;
            case RIGHT:
                gO = new GameObject(currentX+1, currentY);
                break;
        }
        return  gO;
    }
    public void removeTail(){
        snakeParts.remove(snakeParts.size()-1);
    }
    public void draw(Game game){
        Color curentColor = isAlive?Color.DARKGREEN:Color.RED;

        String body = BODY_SIGN;
        int size = 40;
        int sizeBody = 30;

        if(snakeParts.size()==4){
            body = "\u2776";
            size = 45;
            sizeBody = size - 5;
        } else if (snakeParts.size()==5){
            body = "\u2777";
            size += 2;
            sizeBody = size - 5;
        } else if (snakeParts.size()==6){
            body = "\u2778";
            size += 2;
            sizeBody = size - 5;
        } else if (snakeParts.size()==7){
            body = "\u2779";
            size += 2;
            sizeBody = size - 5;
        } else if (snakeParts.size()==8){
            body = "\u277A";
            size += 2;
            sizeBody = size - 5;
        } else if (snakeParts.size()==9){
            body = "\u277B";
            size += 2;
            sizeBody = size - 5;
        } else if (snakeParts.size()==10){
            body = "\u277C";
            size += 2;
            sizeBody = size - 5;
        } else if (snakeParts.size()==11){
            body = "\u277D";
            size += 2;
            sizeBody = size - 5;
        } else if (snakeParts.size()==12){
            body = "\u277E";
            size += 2;
            sizeBody = size - 5;
        } else if (snakeParts.size()==13){
            body = "\u277F";
            size += 2;
            sizeBody = size - 5;
        } else if (snakeParts.size()>13){
            body = "\u2B24";
            size = 75;
            sizeBody = 50;
        }

        game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y,Color.NONE, HEAD_SIGN,curentColor, size);

        for (int i = 1; i < snakeParts.size(); i++) {
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y,Color.NONE,body,curentColor,sizeBody);
        }

    }
    public boolean checkCollision(GameObject gameObject){
        for(GameObject partSnake:snakeParts) {
            if (partSnake.x == gameObject.x && partSnake.y == gameObject.y) {
                return true;
            }
        }
        return false;
    }
    public int getLength(){
        return snakeParts.size();
    }
}
