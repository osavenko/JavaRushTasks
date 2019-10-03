package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private List<Human> children = new ArrayList<>();
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    //protected int course;

    protected Size size;
    public class Size{
        public int height;
        public int weight;
    }

    public String getPosition(){
        return "Человек";
    }



    private BloodGroup bloodGroup;

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }
    public void addChild(Human child){
        children.add(child);
    }
    public void removeChild(Human child){
        children.remove(child);
    }
    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }


    public Human(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void live() {
/*
        if (isSoldier)
            fight();
*/
    }


    public int getId() {
        return id;
    }


    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public void printData() {
        System.out.println(getPosition()+": " + name);
    }
//    protected boolean isSoldier;
/*    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;*/
    /*    public void setChildren(List<Human> children) {
        this.children = children;
    }*/
/*    public void fight() {
    }*/
/*
    public int getCourse() {
        return course;
    }
*/
/*
    public Human(boolean isSoldier) {
        this.isSoldier = isSoldier;
        this.id = nextId;
        nextId++;
    }
*/
/*
    public void setId(int id) {
        this.id = id;
    }
*/

}