package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map =  new HashMap<>();

        map.put("Иванов", 700);
        map.put("Петров", 900);
        map.put("Сидоров", 300);
        map.put("Бычко", 550);
        map.put("Карасев", 900);
        map.put("Караськин",420);
        map.put("Трусковой", 100);
        map.put("Аниськин", 102);
        map.put("Пютрушин",114);
        map.put("Черный", 144);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){

            Map.Entry<String, Integer> pair = iterator.next();
            int sum = pair.getValue();
            if(sum<500) iterator.remove();
        }

    }

    public static void main(String[] args) {

    }
}