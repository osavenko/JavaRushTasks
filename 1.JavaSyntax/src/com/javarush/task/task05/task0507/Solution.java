package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double summ = 0.0;
        int count = 0;
        while(true){
            int i = Integer.parseInt(reader.readLine());
            if(i==-1) break;
            summ+=i;
            count++;
        }
        System.out.println(summ/count);
    }
}

