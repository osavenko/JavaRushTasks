package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fNnameIn = reader.readLine();
        String fNameOut1 = reader.readLine();
        String fNameOut2 = reader.readLine();
        reader.close();

        FileInputStream fStreamRead = new FileInputStream(fNnameIn);
        FileOutputStream fStreamOut1 = new FileOutputStream(fNameOut1);
        FileOutputStream fStreamOut2 = new FileOutputStream(fNameOut2);

        int fSize = fStreamRead.available();
        byte[] bytes = new byte[fSize];
        int count = fStreamRead.read(bytes)+1;

        fStreamOut1.write(bytes,0,count/2);
        fStreamOut2.write(bytes,(count/2),count-(count/2)-1);

        fStreamOut1.flush();
        fStreamOut2.flush();

        fStreamOut1.close();
        fStreamOut2.close();
        fStreamRead.close();
    }
}
