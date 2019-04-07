package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream iStream = new FileInputStream(fileName);
        while(iStream.available()>0){
            int i = iStream.read();
            System.out.print((char)i);
        }
        reader.close();
        iStream.close();
    }
}