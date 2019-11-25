package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int t = number%2;
        String tStr = t==0?"четное":"нечетное";
        if(number<10&&number>0){
            System.out.println(tStr+" однозначное число");
        } else if(number<100&&number>9){
            System.out.println(tStr+" двузначное число");
        } else if(number<1000&&number>99){
            System.out.println(tStr+" трехзначное число");
        }

    }
}
