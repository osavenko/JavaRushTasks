package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new MyThread1());
        threads.add(new MyThread2());
        threads.add(new MyThread3());
        threads.add(new MyThread4());
        threads.add(new MyThread5());
    }
    public static void main(String[] args) {
        for (Thread t: threads){
            t.start();
        }
    }
    public static class MyThread1 extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println("Бесконечное ура!");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class MyThread2 extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("Короткое ура");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                    break;
                }
            }
        }
    }
    public static class MyThread3 extends Thread{
        @Override
        public void run() {
            while (!isInterrupted()){
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class MyThread4 extends Thread implements Message{
        protected volatile boolean isRun;
        @Override
        public void showWarning() {
            if (isRun) isRun=false;

        }

        @Override
        public void run() {
            isRun = true;
            while (isRun){

            }
        }
    }
    public static class MyThread5 extends Thread{
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int summ = 0;
            while(true){
                try {
                    String s = null;

                    s = reader.readLine();
                    if (s.equals("N")) break;
                    try {
                        summ = summ + Integer.parseInt(s);
                    }catch(NumberFormatException e){

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(summ);

        }
    }

}