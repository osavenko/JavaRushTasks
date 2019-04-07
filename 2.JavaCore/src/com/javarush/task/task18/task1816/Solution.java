package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Character> abc = new ArrayList<>();
        ArrayList<Character> fileList = new ArrayList<>();
        for (int i = 65; i < 91; i++) {
            abc.add((char)i);
        }
        for (int i = 97; i < 123; i++) {
            abc.add((char)i);
        }
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        while(fileInputStream.available()>0){
            fileList.add((char)fileInputStream.read());
        }
        fileInputStream.close();
        int count = 0;
        for (char ch:abc){
            if(Collections.frequency(fileList,ch)>0){
                count+=Collections.frequency(fileList,ch);
            }
/*            if(fileList.contains((char)ch)){
                count+=Collections.frequency(fileList,ch);
            }*/
        }
        System.out.println(count);
    }
}
