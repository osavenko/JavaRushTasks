package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();

        FileInputStream fStream = new FileInputStream(fName);
        int count = 0;
        while(fStream.available()>0){
            int ch = fStream.read();
            if(ch == 44) count++;
        }
        System.out.println(count);
        fStream.close();
    }
}
