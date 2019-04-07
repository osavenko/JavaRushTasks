package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scaner = new Scanner(System.in);
        String fName = scaner.nextLine();

        FileInputStream fStream = new FileInputStream(fName);
        int min = Integer.MAX_VALUE;
        while (fStream.available()>0){
            int sh = fStream.read();
            if (min>sh) min = sh;
        }
        fStream.close();
        System.out.println(min);
    }
}
