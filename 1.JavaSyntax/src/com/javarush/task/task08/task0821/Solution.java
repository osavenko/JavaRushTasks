package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Карпов", "Игорь");
        map.put("Карпова", "Виктория");
        map.put("Лящин", "Игорь");
        map.put("Таранькин", "Станислав");
        map.put("Бычков", "Игорь");
        map.put("Бычков", "Олег");
        map.put("Окунев", "Иван");
        map.put("Судаков", "Иван");
        map.put("Судакова", "Виктория");
        map.put("Щукина", "Анна");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
