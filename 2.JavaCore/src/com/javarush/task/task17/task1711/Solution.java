package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length>0) {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        createPerson(args);
                    }
                    break;
                case "-u":
                    synchronized (allPeople) {
                        updatePerson(args);
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        deletePerson(args);
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        printPerson(args);
                    }
                    break;
            }
        }

    }
    public static void createPerson(String[] ar) throws ParseException {
        int numPerson = ar.length/3;
        for (int i = 1; i < (numPerson+1); i++) {
            String name = ar[i*3-2];
            String sex = ar[i*3-1];
            String date = ar[i*3];
            Date newDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);
            if(sex.equals("м")) allPeople.add(Person.createMale(name,newDate));
            else allPeople.add(Person.createFemale(name, newDate));

            System.out.println((allPeople.size()-1));

        }
    }
    public static void updatePerson(String[] ar) throws ParseException {
        int numPerson = ar.length/4;
        for (int i = 1; i < (numPerson+1); i++) {
            int id = Integer.parseInt(ar[i * 4 - 3]);
            String name = ar[i * 4 - 2];
            String sex = ar[i * 4 - 1];
            String date = ar[i * 4];
            Date newDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);

            Person p = allPeople.get(id);
            p.setName(name);
            p.setBirthDate(newDate);
            if(sex.equals("м")) p.setSex(Sex.MALE);
            else p.setSex(Sex.FEMALE);
            allPeople.set(id, p);

        }
    }
    public static void deletePerson(String[] ar){
        for (int i = 1; i < ar.length; i++) {
            int id = Integer.parseInt(ar[i]);
            Person p = allPeople.get(id);
            p.setBirthDate(null);
            p.setName(null);
            p.setSex(null);
            allPeople.set(id,p);
        }
    }
    public static void printPerson(String[] ar){
        for (int i = 1; i < ar.length; i++) {
            System.out.println(allPeople.get(Integer.parseInt(ar[i])));
        }
    }
}
