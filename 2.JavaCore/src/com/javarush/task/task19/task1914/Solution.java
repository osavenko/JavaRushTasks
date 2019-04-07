package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        PrintStream newOutput = new PrintStream(byteArray);

        System.setOut(newOutput);

        testString.printSomething();

        System.setOut(consoleStream);

        String inStr = byteArray.toString().replaceAll("\\r\\n", "");
        String[] tokens = inStr.split(" ");
        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[2]);
        int c = 0;
        switch (tokens[1]) {
            case "-":
                c = a - b;
                break;
            case "+":
                c = a + b;
                break;
            case "*":
                c = a * b;
                break;
        }
        System.out.println(inStr + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

