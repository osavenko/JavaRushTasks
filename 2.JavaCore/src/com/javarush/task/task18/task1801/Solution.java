package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        FileInputStream fSteam = new FileInputStream(fName);
        int max = Integer.MIN_VALUE;
        while(fSteam.available()>0){
            int ch = fSteam.read();
            if(ch>max) max=ch;
        }
        fSteam.close();
        System.out.println(max);
    }
}
