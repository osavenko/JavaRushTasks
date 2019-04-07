package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        TreeMap<String,Double> treeMap = new TreeMap<>();
        String fileName = args[0];
        Scanner scan = new Scanner(new FileReader(fileName));
        while (scan.hasNext()){
            String[] line = scan.nextLine().split(" ");
            if(treeMap.containsKey(line[0])){
                treeMap.put(line[0],treeMap.get(line[0])+Double.parseDouble(line[1]));
            }else{
                treeMap.put(line[0],Double.parseDouble(line[1]));
            }
        }
        scan.close();
        double maximum = treeMap.values()
                .stream()
                .max(Double::compareTo)
                .get();
        treeMap.entrySet().stream()
                            .filter(x -> x.getValue()==maximum)
                            .forEach(x -> System.out.println(x.getKey()));

    }
}
