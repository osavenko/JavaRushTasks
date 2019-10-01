package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;

    }
    public int getX(){
        if(sections.size()>0){
            return sections.get(0).getX();
        }
        return 0;
    }
    public int getY(){
        if (sections.size()>0){
            return sections.get(0).getY();
        }
        return 0;
    }
    public void move(){

    }
    private SnakeDirection direction;
}
