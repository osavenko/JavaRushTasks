package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] array = s.toCharArray();
        if (array.length>0) {
            array[0] = Character.toUpperCase(array[0]);
            for (int i = 0; i < array.length; i++) {
                Character space = array[i];
                if(space.equals(' ')&&(i+1)<array.length) array[i+1] = Character.toUpperCase(array[i+1]);
            }
        }
        s = "";
        for(char c:array){
            s+=c;
        }
        System.out.println(s);
        //напишите тут ваш код
    }
}
