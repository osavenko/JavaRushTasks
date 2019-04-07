package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fNameIn = reader.readLine();
        String fNameOut = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fNameIn);
        FileWriter fileWriter = new FileWriter(fNameOut);
        boolean odd = false;
        while (fileReader.ready()){
            int ch = fileReader.read();
            if(odd) fileWriter.write(ch);
            odd = !odd;
        }
        fileReader.close();
        fileWriter.close();
    }
}
