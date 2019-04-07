package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fNameIn = reader.readLine();
        String fNameOut = reader.readLine();
        reader.close();
        String outS = "";
        ArrayList<String> list = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fNameIn));
        while (fileReader.ready()){
            list.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }
        for (String s:list){
            boolean isD = true;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!Character.isDigit(ch)){
                    isD = false;
                    break;
                }
            }
            if (isD){
                if(outS.length()>0)outS+=" ";
                outS+=s;
            }
        }
        fileReader.close();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fNameOut));
        fileWriter.write(outS);
        fileWriter.close();

    }
}
