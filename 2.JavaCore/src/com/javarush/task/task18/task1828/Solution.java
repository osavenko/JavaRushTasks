package com.javarush.task.task18.task1828;

/* 
?????? 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if(args.length>0){
            ArrayList<String> list = new ArrayList();
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()){
                list.add(scanner.nextLine());
            }
            fileReader.close();
            switch (args[0]){
                case "-d":
                    String deleteId = args[1];
                    int delIndex = -1;
                    for(int i = 0;i < list.size();i++){
                        String curentId = list.get(i).substring(0,8).trim();
                        if (curentId.equals(deleteId)){
                            delIndex = i;
                            break;
                        }
                    }
                    if(delIndex>-1){
                        list.remove(delIndex);
                    }
                    FileWriter fileWriter = new FileWriter(fileName);
                    for (int i = 0; i < list.size();i++){
                        fileWriter.write(list.get(i));
                        if(i!=(list.size()-1)){
                            fileWriter.write(new Formatter().format("%n").toString());
                        }
                    }
                    fileWriter.close();
                    break;
                case "-u":

                    break;
            }
        }
    }
}
