package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        double g = convertEurToUsd(10, 1.25);
        double y = convertEurToUsd(15, 1.25);
        System.out.println(g);
        System.out.println(y);
    }

    public static double convertEurToUsd(int eur, double course) {
        return eur*course;
    }
}
