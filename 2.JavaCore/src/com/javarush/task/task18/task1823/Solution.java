package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> fileList = new ArrayList<>();
        while (true){
            String s = reader.readLine();
            if (s.equals("exit")) break;
            fileList.add(s);
        }
        ArrayList<ReadThread> threadList = new ArrayList<>();
        for(String s:fileList){
            threadList.add(new ReadThread(s));
        }
        for (ReadThread tr:threadList){
            tr.start();
        }
        for (ReadThread tr:threadList){
            tr.join();
        }
    }

    public static class ReadThread extends Thread {
        protected String fileName;
        ArrayList<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream stream = new FileInputStream(fileName);
                while(stream.available()>0){
                    list.add((char)stream.read());
                }
                stream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (char ch:list){
                set.add(ch);
            }
            char maxChar =' ';
            int maxCol = 0;
            for (char ch:set){
                int curentCol = Collections.frequency(this.list,ch);
                if (curentCol>maxCol){
                    maxCol = curentCol;
                    maxChar = ch;
                }
            }
            synchronized (resultMap){
                resultMap.put(this.fileName,(int)maxChar);
            }
        }
    }
}
