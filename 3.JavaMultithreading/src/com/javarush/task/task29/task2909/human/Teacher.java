package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends UniversityPerson {

    private int numberOfStudents;
    //private String university;

    public Teacher(String name, int age, University university, int numberOfStudents, String university1) {
        super(name, age, university);
        this.numberOfStudents = numberOfStudents;
//        this.university = university1;
    }
    public Teacher(String name, int age, int numberOfStudents){
        super(name, age, null);
        this.numberOfStudents = numberOfStudents;
    }
    public String getPosition(){
        return "Преподаватель";
    }

/*
    public Teacher(String name, int age, int numberOfStudents) {
        //super(false);
        super(name, age);

        this.name = name;
        this.age = age;

        this.numberOfStudents = numberOfStudents;
    }
*/




    public void live() {
        teach();
    }

    public void teach() {
    }

/*
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
*/

/*    public void printData() {
        System.out.println(getPosition()+": " + name);
    }*/
}