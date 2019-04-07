package com.javarush.task.task19.task1925;

/* 
Длинные слова
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
        Scanner scanner = new Scanner(new FileReader(args[0]));
        while (scanner.hasNext()){
            String word = scanner.next();
            if (word.length()>6) {
                if (sb.length() > 0) {
                    sb.append(",").append(word);
                } else {
                    sb.append(word);
                }
            }
        }
        scanner.close();
        FileWriter writer = new FileWriter(args[1]);
        writer.write(sb.toString());
        writer.close();
    }
}
