package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int allSize = fileInputStream.available();
        byte[] bytes = new byte[allSize];
        fileInputStream.read(bytes);
        int split = 0;
        for (byte ch:bytes){
            if (ch == 32){split++;}
        }

        float result = ((float)split/allSize)*100;
        System.out.printf("%.2f",result);
        fileInputStream.close();

    }
}
