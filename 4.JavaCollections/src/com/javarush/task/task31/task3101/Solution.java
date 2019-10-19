package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
Проход по дереву файлов
*/
public class Solution {

//    public TreeSet<File> low50 = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        TreeSet<File> low50 = new TreeSet<>();
        for (String s : args)
            System.out.println(s);
        File path = new File(args[0]); //Путь к директории
        File resultFileAbsolutePath = new File(args[1]); //Файл с контекстом всех файлом <50
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        try (FileOutputStream fos = new FileOutputStream(allFilesContent)) {

            deepSearch(path, low50);
            TreeMap<String, File> fileAndPath = new TreeMap<>();
            for (File f : low50)
                fileAndPath.put(f.getName(), f);
            for (Map.Entry<String, File> pair : fileAndPath.entrySet()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(pair.getValue()));
                String s = "";
                while ((s = bufferedReader.readLine()) != null)
                    fos.write((s + "\n").getBytes());
                bufferedReader.close();
            }
        } catch (IOException e) {

        }
    }


    public static void deepSearch(File f, TreeSet<File> low50) {
        if (f.isDirectory()) {
            for (File ff : f.listFiles()) {
                deepSearch(ff, low50);
            }
        } else if (f.isFile()) {
            if (f.length() > 50)
                FileUtils.deleteFile(f);
            else
                low50.add(f);
        }
    }
}
