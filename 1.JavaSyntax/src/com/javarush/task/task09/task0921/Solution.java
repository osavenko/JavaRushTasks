package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args)  {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while(true) {
                int i = Integer.parseInt(reader.readLine());
                list.add(i);
            }
        }catch (Exception e){

        } finally {
            for (int i : list) {
                System.out.println(i);
            }
        }
    }
}
