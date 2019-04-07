package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static{
        Scanner sc = new Scanner(System.in);
        firstFileName = sc.nextLine();
        secondFileName = sc.nextLine();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();

        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fullFilleName;
        private String fileContent;
        private ArrayList fileStrings = new ArrayList();
        @Override
        public void setFileName(String fullFileName) {
            this.fullFilleName = fullFileName;
        }

        @Override
        public String getFileContent() {
            fileContent = String.join(" ", fileStrings);
            return fileContent;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new FileReader(this.fullFilleName));
                while (br.ready()){
                    fileStrings.add(br.readLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
