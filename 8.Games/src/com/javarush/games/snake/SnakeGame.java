package com.javarush.games.snake;
import com.javarush.engine.cell.*;

import java.util.ArrayList;

public class SnakeGame extends Game{
    private Snake snake;
    private Apple apple;
    private Apple badApple;
    private int turnDelay;
    private int score;
    private boolean isGameStopped;
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL = 28;
    private ArrayList<Stone> stones = new ArrayList<>();

    @Override
    public void onKeyPress(Key key) {
        //super.onKeyPress(key);
        switch (key){
            case RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
            case LEFT:
                snake.setDirection(Direction.LEFT);
                break;
            case DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case UP:
                snake.setDirection(Direction.UP);
                break;
            case SPACE:
                if(isGameStopped) createGame();
                break;
        }
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple, badApple, stones);
        if (!apple.isAlive){
            createNewApple();
            score+=5;
            setScore(score);
            turnDelay-=10;
            setTurnTimer(turnDelay);
        }
        if (!badApple.isAlive){
            createNewBadApple();
            createNewStone();
            score-=5;
            setScore(score);
            turnDelay-=15;
            setTurnTimer(turnDelay);
        }
        if (!snake.isAlive){
            gameOver();
        }
        if(snake.getLength()>GOAL){
            win();
        }
        drawScene();
    }

    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    private void createGame(){
        snake = new Snake(WIDTH/2,HEIGHT/2);
        //apple = new Apple(5,5);
        createNewApple();
        createNewBadApple();
        turnDelay = 300;
        score = 0;
        setScore(score);
        isGameStopped = false;
        stones.clear();
        drawScene();
        setTurnTimer(turnDelay);
    }
    private void gameOver(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.ANTIQUEWHITE,"Печалька", Color.BLACK,75);
    }
    private void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.ANTIQUEWHITE,"Крутяк",Color.YELLOWGREEN, 75);
    }
    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(j,i, Color.BEIGE, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
        for (Stone st:stones){
            st.draw(this);
        }
        badApple.draw(this);
    }
    private void createNewApple(){
        do{
        apple = new Apple(getRandomNumber(HEIGHT), getRandomNumber(WIDTH));
        } while (snake.checkCollision(apple));
    }
    private void createNewBadApple(){
        do{
            badApple = new Apple(getRandomNumber(HEIGHT), getRandomNumber(WIDTH));
        } while (snake.checkCollision(badApple));
        badApple.isBadApple = true;
    }
    private void createNewStone(){
        boolean state = false;
        do{
            Stone st = new Stone(getRandomNumber(HEIGHT),getRandomNumber(WIDTH));
            state = false;
            if (st.x == apple.x&&st.y== apple.y) state = true;
            if (st.x == badApple.x&&st.y== badApple.y) state = true;
            for (Stone sElement:stones){
                if (st.x == sElement.x&&st.y== sElement.y) state = true;
                break;
            }
            if (!state)
                state = snake.checkCollision((GameObject)st);
            if (!state)
                stones.add(st);
        }while (state);

    }
}
