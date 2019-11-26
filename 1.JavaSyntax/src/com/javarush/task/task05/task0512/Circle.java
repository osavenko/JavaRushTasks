package com.javarush.task.task05.task0512;

/* 
Создать класс Circle
*/

public class Circle {
    //напишите тут ваш код
    private int centerX;
    private int centerY;
    private int radius;
    private int width;
    private int color;

    public void initialize(int a, int b, int r) {
        centerX = a;
        centerY = b;
        radius = r;
    }
    public void initialize(int a, int b, int r, int w) {
        centerX = a;
        centerY = b;
        radius = r;
        width = w;
    }
    public void initialize(int a, int b, int r, int w, int c) {
        centerX = a;
        centerY = b;
        radius = r;
        width = w;
        color = c;
    }


    public static void main(String[] args) {

    }
}
