package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = reader.readLine();
        String fName2 = reader.readLine();
        String fName3 = reader.readLine();

        FileOutputStream fileOutputStream = new FileOutputStream(fName1);

        FileInputStream fileInputStream1 = new FileInputStream(fName2);
        FileInputStream fileInputStream2 = new FileInputStream(fName3);


        byte[] f1Byte = new byte[fileInputStream1.available()];
        byte[] f2Byte = new byte[fileInputStream2.available()];

        fileInputStream1.read(f1Byte);
        fileInputStream2.read(f2Byte);

        fileInputStream1.close();
        fileInputStream2.close();

        fileOutputStream.write(f1Byte);
        fileOutputStream.flush();
        fileOutputStream.write(f2Byte);
        fileOutputStream.close();
    }
}
