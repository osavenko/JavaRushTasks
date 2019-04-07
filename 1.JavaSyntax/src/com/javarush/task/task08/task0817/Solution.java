package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap();
        map.put("Карпов", "Игорь");
        map.put("Карпова", "Виктория");
        map.put("Лящин", "Игорь");
        map.put("Таранькин", "Станислав");
        map.put("Бычков", "Игорь");
        map.put("Щукин", "Олег");
        map.put("Окунев", "Иван");
        map.put("Судаков", "Иван");
        map.put("Судакова", "Виктория");
        map.put("Щукина", "Анна");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        ArrayList<String> list = new ArrayList<>();

        for(Map.Entry<String,String> pair:copy.entrySet()) {

            String name = pair.getValue();
            Boolean namePresent = false;
            if(list.size()==0){
                list.add(name);
            } else{
                for(String lName:list){
                    if (lName.equals(name)){
                        namePresent = true;
                    }
                }
            }

            if(namePresent){
                removeItemFromMapByValue(map,name);
            }else {
                list.add(name);
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
