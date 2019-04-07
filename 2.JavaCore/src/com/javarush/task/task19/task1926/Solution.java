package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        Scanner scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            for (int i = line.length()-1; i >= 0; i--) {
                System.out.print(line.charAt(i));
            }
            System.out.println();
        }
        scanner.close();
    }
}
