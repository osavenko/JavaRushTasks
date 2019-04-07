package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        ArrayList<Character> list = new ArrayList<>();
        while(fileInputStream.available()>0){
            list.add((char)fileInputStream.read());
        }
        fileInputStream.close();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch:list){
            if(!map.containsKey(ch)){
                map.put(ch, Collections.frequency(list, ch));
            }
        }
        List<Map.Entry<Character,Integer>> list2 = new ArrayList(map.entrySet());
        list2.sort(Map.Entry.comparingByKey());
        for (Map.Entry<Character, Integer> pair:list2){
            System.out.println(pair.getKey()+" "+pair.getValue());
        }
    }
}
