package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String typeCode = args[0];
        String inputFileName = args[1];
        String outputFileName = args[2];
        FileInputStream fileInputStream = new FileInputStream(inputFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
        switch (typeCode){
            case "-e":
                while(fileInputStream.available()>0){
                    int ch = fileInputStream.read()+1;
                    fileOutputStream.write(ch);
                }
                break;
            case "-d":
                while(fileInputStream.available()>0){
                    int ch = fileInputStream.read()-1;
                    fileOutputStream.write(ch);
                }
                break;
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

}
