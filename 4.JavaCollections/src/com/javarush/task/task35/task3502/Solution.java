package com.javarush.task.task35.task3502;

/* 
Знакомство с дженериками
*/

import java.util.List;

public class Solution <T1 extends List<Solution.SomeClass>> {
    public static class SomeClass <T3 extends Number> {
    }

    public static void main(String[] args) {

    }
}
