package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<Character> list = new ArrayList<>();
        FileInputStream fStrim = new FileInputStream(s);
        while(fStrim.available()>0){
            list.add((char)fStrim.read());
        }
        fStrim.close();
        Map<Character,Integer> map = new HashMap<>();
        for (char c:list){
            if(!map.containsKey(c)){
                map.put(c, Collections.frequency(list,c));
            }
        }
        List<Map.Entry<Character,Integer>> list2 = new ArrayList(map.entrySet());
        list2.sort(Map.Entry.comparingByValue());
        int max = 0;
        for (int i = (list2.size()-1); i >= 0 ; i--) {
            if(i==(list2.size()-1)){
                max = list2.get(i).getValue();
                System.out.print((int)list2.get(i).getKey()+" ");
            } else if(max == list2.get(i).getValue()){
                System.out.print((int)list2.get(i).getKey()+" ");
            }
        }
    }
}
