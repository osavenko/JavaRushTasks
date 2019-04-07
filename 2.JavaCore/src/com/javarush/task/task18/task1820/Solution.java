package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fName1 = reader.readLine();
        String fName2 = reader.readLine();
        reader.close();

        Scanner scan = new Scanner(new FileReader(fName1));

        String str = scan.nextLine();

        String[] strArr = str.split(" ");

        scan.close();

        FileWriter fileWriter = new FileWriter(fName2);
        String str2 = "";
        for (int i = 0; i < strArr.length; i++) {
            int num = Math.round(Float.parseFloat(strArr[i]));
            str2 += num + " ";

        }
        fileWriter.write(str2);
        fileWriter.flush();
        fileWriter.close();
    }
}
