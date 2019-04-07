package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        List<String> fList1 = new ArrayList<>();
        BufferedReader readerFile1 = new BufferedReader(new FileReader(fileName1));
        while (readerFile1.ready()) {
            fList1.add(readerFile1.readLine());
        }
        readerFile1.close();
        List<String> fList2 = new ArrayList<>();
        BufferedReader readerFile2 = new BufferedReader(new FileReader(fileName2));
        while (readerFile2.ready()) {
            fList2.add(readerFile2.readLine());
        }
        readerFile2.close();
        int index1 = 0;
        int index2 = 0;
        while (index1 < fList1.size() && index2 < fList2.size()) {
            if (fList1.get(index1).equals(fList2.get(index2))) {
                lines.add(new LineItem(Type.SAME, fList2.get(index2)));
                index1++;
                index2++;
            } else if (index1 + 1 < fList1.size() && fList1.get(index1 + 1).equals(fList2.get(index2))) {
                lines.add(new LineItem(Type.REMOVED, fList1.get(index1++)));
            } else if (index2 + 1 < fList2.size() && fList1.get(index1).equals(fList2.get(index2 + 1))) {
                lines.add(new LineItem(Type.ADDED, fList2.get(index2++)));
            }
        }
        if (fList1.size() > index1)
            lines.add(new LineItem(Type.REMOVED, fList1.get(index1)));
        if (fList2.size() > index2)
            lines.add(new LineItem(Type.ADDED, fList2.get(index2)));

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
