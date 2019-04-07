package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String s1 = url.substring(url.indexOf("?")+1,url.length());
        String[] arr1 = s1.split("&");
        String paramObj = null;
        double valueObj = 0.0;

        for (int i = 0; i<arr1.length;i++){
            if (arr1[i].contains("=")) {
                String paramName = arr1[i].substring(0,arr1[i].indexOf("="));
                System.out.print(paramName);
                if(paramName.equals("obj")) {
                    paramObj = "obj";

                    try {
                        valueObj = Double.parseDouble(arr1[i].substring(arr1[i].indexOf("=") + 1, arr1[i].length()));
                    }catch (Exception e){
                        paramObj = arr1[i].substring(arr1[i].indexOf("=") + 1, arr1[i].length());
                    }
                }
            } else{
                System.out.print(arr1[i]);
            }
            if (i<(arr1.length-1)) System.out.print(" ");
        }
        if((paramObj!=null)&&(paramObj.equals("obj"))){
            System.out.println();
            alert(valueObj);
        }else if ((paramObj!=null)&&(!paramObj.equals("obj"))) {
            System.out.println();
            alert(paramObj);
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
