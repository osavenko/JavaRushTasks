package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
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
        if(number==0){
            System.out.println("ноль");
        }else if(number>0){
            System.out.println("положительное "+tStr+" число");
        }else {
            System.out.println("отрицательное "+tStr+" число");
        }
    }
}
