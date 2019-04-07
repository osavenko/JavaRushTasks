package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        PrintStream oldConsole = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream newConsole = new PrintStream(byteArray);
        System.setOut(newConsole);

        testString.printSomething();
        System.setOut(oldConsole);

        System.out.println(byteArray.toString());

        FileOutputStream outputStream = new FileOutputStream(fileName);
        outputStream.write(byteArray.toByteArray());
        outputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

