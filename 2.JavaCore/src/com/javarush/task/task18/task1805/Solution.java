package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fName = scanner.nextLine();
        FileInputStream fStream = new FileInputStream(fName);
        HashSet<Character> set = new HashSet<>();
        while(fStream.available()>0){
            set.add((char)fStream.read());
        }
        fStream.close();
        ArrayList<Character> list = new ArrayList<>(set);
        Collections.sort(list);
        for (Character ch:list){
            System.out.print((int)ch.charValue()+" ");
        }
    }
}
