package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ArrayList list = new ArrayList();
        while(true){
            String s = reader.readLine();
            if(s.equals("exit")) break;
            try{
                Integer i = Integer.parseInt(s);
                list.add(i);
            } catch (Exception e){
                try{
                    Double d = Double.parseDouble(s);
                    list.add(d);
                }catch (Exception e1){
                    list.add(s);
                }
            }
        }
        for(Object o:list){
            if (o instanceof String){
                print((String)o);
            } else if(o instanceof Double){
                print((Double)o);
            } else{
                int i = (Integer)o;
                if((i>0)&&(i<128)){
                    print((short)i);
                } else {
                    print(i);
                }
            }

        }

    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
