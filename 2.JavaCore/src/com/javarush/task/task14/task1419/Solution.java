package com.javarush.task.task14.task1419;


import java.io.EOFException;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try{
            int i = Integer.parseInt("ZZZ");
        } catch (NumberFormatException e){
            exceptions.add(e);
        }


        try{
            String s = null;
            System.out.println(s.length());
        } catch (Exception e){
            exceptions.add(e);
        }

        try{
            String s = "tomos";
            char c = s.charAt(15);
        } catch (StringIndexOutOfBoundsException e){
            exceptions.add(e);
        }
        try{
            int[] a = new int[15];
            a[19] = 12;
        } catch (ArrayIndexOutOfBoundsException e){
            exceptions.add(e);
        }

        try {
            int a = 9;
            throw new IllegalArgumentException("My" + a);
        } catch (IllegalArgumentException e){
            exceptions.add(e);
        }
        try {
            int a = 9;
            throw new IndexOutOfBoundsException("My2" + a);
        } catch (IndexOutOfBoundsException e){
            exceptions.add(e);
        }
        try {
            int a = 9;
            throw new RuntimeException("My" + a);
        } catch (RuntimeException e){
            exceptions.add(e);
        }
        try {
            int a = 9;
            throw new EOFException();
        } catch (EOFException e){
            exceptions.add(e);
        }
        try {
            int a = 9;
            throw new NoSuchFieldException();
        } catch (NoSuchFieldException e){
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
