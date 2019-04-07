package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fNameFirst = reader.readLine();
        String fNameSecond = reader.readLine();
        reader.close();

        BufferedReader readerF1 = new BufferedReader(new InputStreamReader(new FileInputStream(fNameFirst)));

        while(readerF1.ready()){
            String s = readerF1.readLine();
            allLines.add(s);
        }
        readerF1.close();
        BufferedReader readerF2 = new BufferedReader(new InputStreamReader(new FileInputStream(fNameSecond)));
        while(readerF2.ready()){
            String s = readerF2.readLine();
            forRemoveLines.add(s);
        }
        readerF2.close();
        Solution sd = new Solution();
        sd.joinData();
    }

    public void joinData() throws CorruptedDataException {

        if(allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }else{
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
