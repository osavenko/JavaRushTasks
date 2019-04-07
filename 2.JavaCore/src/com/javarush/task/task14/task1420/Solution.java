package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        int k = 0;
        try{
            i = Integer.parseInt(reader.readLine());
            k = Integer.parseInt(reader.readLine());
            if((i<=0)) throw  new Exception();
            if((k<=0)) throw  new Exception();
        } catch (Exception  e){
            System.out.println(e);
        }
        System.out.println(NOD(i,k));
    }
    public static int NOD(int i, int k){
        while (k !=0) {
            int tmp = i%k;
            i = k;
            k = tmp;
        }
        return i;
    }
}
