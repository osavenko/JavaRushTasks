package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses = new ArrayList<>();;
    public static void main(String[] args) {
        List<Horse> list = new ArrayList<>();
        Hippodrome hippodrome = null;
        Horse h1 = new Horse("Laska", 3, 0);
        Horse h2 = new Horse("Brown", 3, 0);
        Horse h3 = new Horse("Flower", 3,0);
        list.add(h1);
        list.add(h2);
        list.add(h3);

        hippodrome = new Hippodrome(list);
        game = hippodrome;

        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public Hippodrome() {
    }
    public void print(){
        for(Horse h:horses){
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public void move(){
        for(Horse h:horses){
            h.move();
        }
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public Horse getWinner(){
        double maxDistance = Double.MIN_VALUE;
        Horse hMax = null;
        for(Horse h:horses){
            if(h.getDistance()>maxDistance){
                maxDistance = h.getDistance();
                hMax = h;
            }
        }
        return hMax;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
}
