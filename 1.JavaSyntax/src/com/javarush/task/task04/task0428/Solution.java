package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());
        int countPlus = 0;
        if(number1>0){
            countPlus++;
        }
        if(number2>0){
            countPlus++;
        }
        if (number3>0){
            countPlus++;
        }
        System.out.println(countPlus);

    }
}
