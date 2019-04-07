package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if ((a>b)&&(a>c)) {
            if(b>c)
                System.out.println(a + " " + b + " " + c);
            else
                System.out.println(a + " " + c + " " + b);
        }
/*        if ((b>a)&&(a>c)) {
            System.out.println(a + " " + b + " " + c);
        }else {
            System.out.println(a + " " + b + " " + c);
            if ((a>b)&&(b>c)) {
                System.out.println(a + " " + b + " " + c);
            }else {
                System.out.println(a+" "+b+" "+c);

*/
            }
}
