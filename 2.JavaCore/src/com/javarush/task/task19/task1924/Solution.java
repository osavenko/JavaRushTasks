package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.*;

import static java.lang.System.*;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        List<String> list = new ArrayList<>();
        String fileName = reader.readLine();
        reader.close();
        Scanner scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNext()){
            String[] str = scanner.nextLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                try {
                    int tmpI = Integer.parseInt(str[i]);
                    if(map.containsKey(tmpI)){
                        list.add(map.get(tmpI));
                    }else{
                        list.add(str[i]);
                    }
                } catch (NumberFormatException e){
                    list.add(str[i]);
                }
            }
        }
        scanner.close();
        list.stream().forEach(s -> out.println(s));
    }
}
