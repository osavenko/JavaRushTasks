package com.javarush.task.task12.task1204;

/* 
То ли птица, то ли лампа
*/

public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        //Напишите тут ваше решение
        String typeO = "";
        if(o instanceof Cat){
            typeO = "Кошка";
        } else if(o instanceof Dog){
            typeO = "Собака";
        } else if(o instanceof Bird){
            typeO = "Птица";
        } else if (o instanceof Lamp){
            typeO = "Лампа";
        }
        System.out.println(typeO);
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}
