package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        int rez = 0;
        if(!s.startsWith("0")) return s;
        else if(s.startsWith("0x")){
            rez = Integer.parseInt(s.substring(2),16);
        }else if(s.startsWith("0b")){
            rez = Integer.parseInt(s.substring(2), 2);
        }else{
            rez = Integer.parseInt(s,8);
        }
        return Integer.toString(rez);
    }
}
