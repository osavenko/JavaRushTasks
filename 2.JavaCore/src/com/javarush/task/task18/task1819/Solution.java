package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();


        FileInputStream fileInputStream = new FileInputStream(fileName1);
        byte[] bytes1 = new byte[fileInputStream.available()];
        fileInputStream.read(bytes1);
        fileInputStream.close();


        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        byte[] bytes2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(bytes2);
        fileInputStream2.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        fileOutputStream.write(bytes2);
        fileOutputStream.write(bytes1);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
