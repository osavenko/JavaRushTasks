package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread st0 = new SpecialThread();
        SpecialThread st1 = new SpecialThread();
        SpecialThread st2 = new SpecialThread();
        SpecialThread st3 = new SpecialThread();
        SpecialThread st4 = new SpecialThread();

        Thread t0 = new Thread(st0);
        //t0.start();
        Thread t1 = new Thread(st1);
        //t1.start();
        Thread t2 = new Thread(st2);
        //t2.start();
        Thread t3 = new Thread(st3);
        //t3.start();
        Thread t4 = new Thread(st4);
        //t4.start();

        list.add(t0);
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
