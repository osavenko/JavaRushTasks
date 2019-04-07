package com.javarush.task.task19.task1911;

/* 
????? ???????
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        testString.printSomething();

        String resStr = outputStream.toString();

        StringBuffer sb = new StringBuffer(resStr.toUpperCase());

        System.setOut(consoleStream);
        System.out.println(sb);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
