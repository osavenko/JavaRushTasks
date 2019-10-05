package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        String messge = null;
        boolean readed = false;
        while(!readed)
            try {
                messge = reader.readLine();
                readed = !readed;
            } catch (IOException e){
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        return messge;
    }
    public static int readInt(){
        boolean readed = false;
        int res = 0;
        while (!readed)
            try{
                res = Integer.parseInt(readString());
                readed = !readed;
            }catch (NumberFormatException ex){
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        return res;
    }

}
