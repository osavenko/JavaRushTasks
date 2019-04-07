package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/
import java.util.ArrayList;
public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child00 = new Human();
        child00.name = "Дите1";
        child00.age = 10;
        child00.sex = true;

        Human child01 = new Human();
        child01.name = "Дите2";
        child01.age = 12;
        child01.sex = true;

        Human child02 = new Human();
        child02.name = "Дите3";
        child02.age = 15;
        child02.sex = false;

        Human mather = new Human();
        mather.name = "Mather";
        mather.age = 38;
        mather.sex = false;
        mather.children.add(child00);
        mather.children.add(child01);
        mather.children.add(child02);

        Human father = new Human();
        father.name = "Mather";
        father.age = 38;
        father.sex = false;
        father.children.add(child00);
        father.children.add(child01);
        father.children.add(child02);

        Human gMather00 = new Human();
        gMather00.name = "Mather00";
        gMather00.age = 65;
        gMather00.sex = false;
        gMather00.children.add(mather);

        Human gMather01 = new Human();
        gMather01.name = "Mather01";
        gMather01.age = 65;
        gMather01.sex = false;
        gMather01.children.add(father);

        Human gFather00 = new Human();
        gFather00.name = "gFather00";
        gFather00.age = 65;
        gFather00.sex = true;
        gFather00.children.add(mather);

        Human gFather01 = new Human();
        gFather01.name = "gFather01";
        gFather01.age = 65;
        gFather01.sex = true;
        gFather01.children.add(father);

        System.out.println(child00);
        System.out.println(child01);
        System.out.println(child02);
        System.out.println(mather);
        System.out.println(father);
        System.out.println(gFather00);
        System.out.println(gMather00);
        System.out.println(gFather01);
        System.out.println(gMather01);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
