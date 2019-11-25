package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int OX = Integer.parseInt(reader.readLine());
        int OY = Integer.parseInt(reader.readLine());
        if(OX<0&&OY<0){
            System.out.println(3);
        } else if(OX>0&&OY>0){
            System.out.println(1);
        } else if(OX>0&&OY<0){
            System.out.println(4);
        } else if(OX<0&&OY>0){
            System.out.println(2);
        }
    }
}
