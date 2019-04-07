package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String param;
        try {
            param = reader.readLine();
            if (param.equals("helicopter")){
                result = new Helicopter();
            } else if(param.equals("plane")){
                int col = Integer.parseInt(reader.readLine());
                result = new Plane(col);
            }
        }catch (Exception e){
            try{
                reader.close();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }
}
