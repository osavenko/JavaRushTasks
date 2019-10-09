package com.javarush.task.task31.task3110;

import java.nio.file.Paths;
import java.util.Scanner;

public class Archiver {
    public static void main(String[] args) {
        Scanner line = new Scanner(System.in);
        String fileName = line.nextLine();
        ZipFileManager zp = new ZipFileManager(Paths.get(fileName));
        String fileToZipp = line.nextLine();
        try {
            zp.createZip(Paths.get(fileToZipp));
        } catch (Exception e) {
         //   e.printStackTrace();
        }
    }
}
