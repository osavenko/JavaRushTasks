package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(args[0],"rw");
        long pos = Long.parseLong(args[1]);
        if(pos>=file.length()){
            pos = file.length();
        }
        file.seek(pos);
        file.write(args[2].getBytes());
        file.close();
    }
}
