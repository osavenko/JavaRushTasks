package com.javarush.task.task25.task2512;


import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> list = new ArrayList<>();
        Throwable throwable = e;
        while (throwable!=null){
            list.add(0, throwable);
            throwable = throwable.getCause();
        }
        list.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Throwable e =  new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        new Solution().uncaughtException(Thread.currentThread(), e);
    }
}
