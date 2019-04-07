package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String writeToFile = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        while(true){
            String s = reader.readLine();

            list.add(s);

            if(s.equals("exit")) break;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(writeToFile));
        for(String s:list){
            writer.write(s);
            writer.newLine();
        }
        writer.close();
    }
}
