package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
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
        int countMinus = 0;
 //       if(number1!=0){
            if(number1>0){
                countPlus++;
            }else if(number1<0){
                countMinus++;
            }
//        }
//        if(number2!=0) {
            if (number2 > 0) {
                countPlus++;
            } else if (number2 < 0) {
                countMinus++;
            }
//        }
//        if(number3!=0) {
            if (number3 > 0) {
                countPlus++;
            } else if (number3 < 0) {
                countMinus++;
            }
//        }
        System.out.println("количество отрицательных чисел: "+countMinus);
        System.out.println("количество положительных чисел: "+countPlus);
    }
}
