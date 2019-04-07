package com.javarush.task.task18.task1804;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        reader.close();
        FileInputStream fStream = new FileInputStream(fName);
        ArrayList<Character> list = new ArrayList<>();
        while(fStream.available()>0) {
            list.add((char)fStream.read());
        }
        fStream.close();
        HashMap<Character,Integer> map = new HashMap();
        for(char ch:list){
            if(!map.containsKey(ch)){
                map.put(ch, Collections.frequency(list, ch));
            }
        }
        List<Map.Entry<Character,Integer>> list2 = new ArrayList(map.entrySet());
        list2.sort(Map.Entry.comparingByValue());
        int min = 0;
        for (int i = 0; i < list2.size(); i++) {
            if (i==0){
                min = list2.get(i).getValue();
                System.out.printf((int)list2.get(i).getKey()+" ");
            }else if(min == list2.get(i).getValue()){
                System.out.print((int)list2.get(i).getKey()+" ");
            }
        }

    }
}
