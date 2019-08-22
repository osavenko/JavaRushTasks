package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        byte[] buffer = null;
        Charset win = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        try(FileInputStream fis = new FileInputStream(args[0]);
            FileOutputStream fos = new FileOutputStream(args[1])){
            buffer = new byte[fis.available()];
            fis.read(buffer);
            String data = new String(buffer,win);
            buffer = data.getBytes(utf8);
            fos.write(buffer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
