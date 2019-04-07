package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        String id = args[0];
        Scanner scan = new Scanner(new FileReader(fName));
        ArrayList<String> list = new ArrayList<>();
        while (scan.hasNext()){
            list.add(scan.nextLine());
        }
        scan.close();

        for (String s:list){
            if(s.startsWith(id+" ")) {
                System.out.println(s);
            }
        }
    }
}
