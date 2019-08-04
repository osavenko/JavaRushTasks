package com.javarush.task.task22.task2210;

import java.util.*;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] strings = getTokens("level22.lesson13.task01", ".");
        Arrays.stream(strings).forEach(System.out::println);
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        List<String> list = new ArrayList<>();
        while ((st.hasMoreTokens())){
            list.add(st.nextToken());
        }
        //String[] strings = new String[list.size()];
        String[] strings = list.toArray(new String[0]);
        return strings;
    }
}
