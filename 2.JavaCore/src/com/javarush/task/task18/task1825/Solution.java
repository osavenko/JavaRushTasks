package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> listFile = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = reader.readLine();
            if(s.equals("end")) break;
            listFile.add(s);
        }
        listFile.sort(String::compareTo);
        FileOutputStream fileOutputStream = new FileOutputStream(listFile.get(0).split(".part")[0]);
        Map<Integer, String> map = new HashMap<>();
        for (String s:listFile){
            map.put(Integer.parseInt(s.split("part")[1]),s);
        }
        List<Map.Entry<Integer,String>> list2 = new ArrayList<>(map.entrySet());
        list2.sort(Map.Entry.comparingByKey());
        for (Map.Entry<Integer, String> pair:list2){
            FileInputStream fileInputStream = new FileInputStream(pair.getValue());
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}
