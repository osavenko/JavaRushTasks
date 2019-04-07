package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fName = reader.readLine();
        reader.close();
        Scanner fReader =  new Scanner(new FileInputStream(fName));
        ArrayList<Integer> list = new ArrayList<>();
        while(fReader.hasNext()){
            Integer i = fReader.nextInt();
            list.add(i);
        }
        fReader.close();
        Collections.sort(list);
        for (Integer i:list){
            if(i%2==1){
                System.out.println(i);
            }
        }

    }
}
