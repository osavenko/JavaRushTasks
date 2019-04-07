package com.javarush.task.task01.task0134;

/* 
Набираем воду в бассейн
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getVolume(50, 25, 2));

    }

    public static long getVolume(int a, int b, int c) {
        //напишите тут ваш код
        return a * b * c * 1000;
    }
}