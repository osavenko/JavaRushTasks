package com.javarush.task.task19.task1910;

/* 
Пунктуация
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
            String currentStr = reader.readLine();
            writer.write(currentStr.replaceAll("\\p{Punct}",""));
        }
        reader.close();
        writer.close();
    }
}
