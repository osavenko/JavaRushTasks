package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        Scanner scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNext()){
            String sline = scanner.nextLine();
            String[] line = sline.split(" ");
            int count = 0;
            for (int i = 0; i < line.length; i++) {
                if(words.contains(line[i]))
                    count++;
            }
            if(count==2){
                System.out.println(sline);
            }
        }
        scanner.close();
    }
}
