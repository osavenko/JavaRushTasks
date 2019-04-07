package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fNameIn = fileNameReader.readLine();
        String fNameOut = fileNameReader.readLine();
        fileNameReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(fNameIn));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fNameOut));
        while (reader.ready()){
            char ch = (char)reader.read();
            if(ch=='.') ch = '!';
            writer.write(ch);
        }

        reader.close();
        writer.close();
    }
}
