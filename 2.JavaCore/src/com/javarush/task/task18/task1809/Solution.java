package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sFile1 = reader.readLine();
        String sFile2 = reader.readLine();
        FileInputStream fStreamIn = new FileInputStream(sFile1);
        FileOutputStream fStreamOut = new FileOutputStream(sFile2);

        byte[] data = new byte[fStreamIn.available()];

        int count = fStreamIn.read(data);
        fStreamIn.close();
        for (int i = 0; i < data.length/2; i++) {
            byte tmp = data[i];
            data[i] = data[count-i-1];
            data[count-i-1] = tmp;
        }
        fStreamOut.write(data);
        fStreamOut.flush();
        fStreamOut.close();
    }
}
