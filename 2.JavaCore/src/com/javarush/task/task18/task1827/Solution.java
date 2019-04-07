package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
            if (args.length != 0 && args[0].equals("-c")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fileName = reader.readLine();

                FileReader fileReader = new FileReader(fileName);
                Scanner scanner = new Scanner(fileReader);
                ArrayList<String> fileList = new ArrayList<>();

                while (scanner.hasNext()) {
                    fileList.add(scanner.nextLine());
                }
                fileReader.close();

                int maxId = 0;
                for (String s:fileList) {
                    String lastString = s;

                    String lastIndex = lastString.substring(0, 8);
                    int id = Integer.parseInt(lastIndex.trim());
                    if (maxId<id) maxId = id;
                }

                FileWriter fileWriter = new FileWriter(fileName, true);
                Formatter frm = new Formatter();
                String productName = args[1];
                for (int i = 2; i < (args.length-2) ; i++) {
                    productName+=" "+args[i];
                }
                if(productName.length()>30){
                    productName = productName.substring(0,30);
                }
                String productPrice = args[args.length-2];
                String productCount = args[args.length-1];
                frm.format("%n%-8d%-30s%-8s%-4s", ++maxId, productName, productPrice, productCount);
                fileWriter.write(frm.toString());
                fileWriter.close();
            }
    }
}
