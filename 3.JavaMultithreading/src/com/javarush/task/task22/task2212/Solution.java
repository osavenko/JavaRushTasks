package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber==null) return false;
        if(telNumber=="") return false;
        if(telNumber.matches("\\w")) return false;
        if(telNumber.matches("\\+\\d{12}")) return true;
        if(telNumber.matches("\\+\\d{2}\\(\\d{3}\\)\\d{7}")) return true;
        if(telNumber.matches("\\+\\d{8}-\\d{2}-\\d\\d")) return true;
        if(telNumber.matches("\\d{6}-\\d{4}")) return true;
        return false;
    }

    public static void main(String[] args) {
        String tel1 = "+380501234567";
        String tel2 = "+38(050)1234567";
        String tel3 = "+38050123-45-67";
        String tel4 = "050123-4567";
        System.out.println(checkTelNumber(tel1));
        System.out.println(checkTelNumber(tel2));
        System.out.println(checkTelNumber(tel3));
        System.out.println(checkTelNumber(tel4));

    }
}
