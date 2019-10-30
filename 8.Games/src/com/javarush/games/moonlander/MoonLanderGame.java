package com.javarush.games.moonlander;
import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    private Rocket rocket;
    private GameObject landscape;

    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;

    private void createGameObjects(){
        rocket = new Rocket(WIDTH/2,0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
    }
    @Override
    public void initialize() {

        setScreenSize(WIDTH, HEIGHT);
        showGrid(false);
        createGame();
    }
    private void createGame(){
        createGameObjects();
        setTurnTimer(50);

        isLeftPressed = false;
        isRightPressed = false;
        isUpPressed = false;

        drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if(x<0||x>=WIDTH) return;
        if(y<0||y>=HEIGHT) return;
        super.setCellColor(x, y, color);
    }

    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.AQUA);
            }
        }
        landscape.draw(this);
        rocket.draw(this);
    }

    @Override
    public void onTurn(int step) {
        //super.onTurn(step);
        rocket.move();
        drawScene();
    }
}
