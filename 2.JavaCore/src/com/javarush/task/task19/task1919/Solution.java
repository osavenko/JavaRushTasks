package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        /*HashMap<String,Double>  map = new HashMap();
        String fileName = args[0];
        Scanner scan = new Scanner(new FileReader(fileName));
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] lineArr = line.split(" ");
            String name = lineArr[0];
            double summa = Double.parseDouble(lineArr[1]);
            if (map.containsKey(name)){
                double tmpSumma = map.get(name);
                map.remove(name);
                map.put(name,(tmpSumma+summa));
            }else{
                map.put(name,summa);
            }
        }
        scan.close();
        List<Map.Entry<String,Double>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (int i = (list.size()-1); i >=0; i--) {
            System.out.println(list.get(i).getKey()+" "+list.get(i).getValue());
        }*/
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
        treeMap.forEach((e,k)->System.out.println(e+" "+k));
    }
}
