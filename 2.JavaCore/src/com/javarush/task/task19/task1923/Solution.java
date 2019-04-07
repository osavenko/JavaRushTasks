package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        String fileIn = args[0];
        String fileOut = args[1];
        Scanner scanner = new Scanner(new FileReader(fileIn));
        while (scanner.hasNext()){
            String[] line = scanner.nextLine().split(" ");
            for (int i = 0; i < line.length; i++) {
                if(line[i].matches(".*?\\d+.*?")){
                    sb.append(line[i]+" ");
                }
            }
        }
        scanner.close();
        FileWriter writer = new FileWriter(fileOut);
        writer.write(sb.toString());
        writer.close();
    }
}
