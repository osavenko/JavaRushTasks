package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fName = bufferedReader.readLine();
        bufferedReader.close();


        FileReader fileReader = new FileReader(fName);
        String data = "";
        while (fileReader.ready()){
            int ch = fileReader.read();
            data+=(char)ch;
        }
        fileReader.close();
        String data2 = data.replaceAll("\\bworld\\b","");
        int count = (data.length()-data2.length())/5;
        System.out.println(count);
    }
}
