package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Что внутри папки?
*/
public class Solution {
    public static int countDir = 0;
    public static int countFile = 0;
    public static int totalSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputPath = reader.readLine();
        reader.close();

        if(!Files.isDirectory(Paths.get(inputPath))){
            System.out.println(inputPath+" - не папка");
            return;
        }
        Files.walkFileTree(Paths.get(inputPath), new Visitor());

        System.out.println("Всего папок - " + --countDir);
        System.out.println("Всего файлов - " + countFile);
        System.out.println("Общий размер - " + totalSize);
    }
    public static class Visitor extends SimpleFileVisitor{
        @Override
        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
            countFile++;
            totalSize+=attrs.size();
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
            countDir++;
            return FileVisitResult.CONTINUE;
        }
    }
}
