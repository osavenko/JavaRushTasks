package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {

    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age,  double averageGrade) {
        super(name, age, null);
        this.averageGrade = averageGrade;
        this.beginningOfSession = beginningOfSession;
        this.endOfSession = endOfSession;
        this.course = course;
    }
    public String getPosition(){
        return "Студент";
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getCourse() {
        return course;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }




    public void incAverageGrade(double delta){
        setAverageGrade(getAverageGrade()+delta);
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }


    //    private String university;

/*
    public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            course = (int) value;
            return;
        }
    }*/
/*
    public void incAverageGradeBy01() {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02() {
        averageGrade += 0.2;
    }
*/

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

/*
    public Student(String name, int age, double averageGrade) {
        //super(false);
        super(name, age);

        this.name = name;
        this.age = age;

        this.averageGrade = averageGrade;
    }
*/


}