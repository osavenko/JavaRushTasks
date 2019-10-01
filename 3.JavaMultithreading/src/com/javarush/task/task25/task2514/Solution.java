package com.javarush.task.task25.task2514;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {

            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);

        }
    }

    public static void main(String[] args) {
        YieldRunnable y1 = new YieldRunnable(1);
        YieldRunnable y2 = new YieldRunnable(2);
        YieldRunnable y3 = new YieldRunnable(3);
        YieldRunnable y4 = new YieldRunnable(4);

        List<YieldRunnable> list= new ArrayList<>();

        Collections.addAll(list, y1, y2, y3, y4);
        for (YieldRunnable y:list){
            y.run();
        }
    }
}
