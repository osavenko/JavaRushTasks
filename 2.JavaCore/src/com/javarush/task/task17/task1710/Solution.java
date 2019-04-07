package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length>0) {
            switch (args[0]) {
                case "-c":
                    createPerson(args[1],args[2],args[3]);
                    break;
                case "-u":
                    updatePerson(args[1],args[2],args[3],args[4]);
                    break;
                case "-d":
                    deletePerson(args[1]);
                    break;
                case "-i":
                    printPerson(args[1]);
                    break;
            }
        }
    }
    public static void createPerson(String name, String sex, String date) throws ParseException {
        Date newDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);

        if(sex.equals("м")) allPeople.add(Person.createMale(name,newDate));

        else allPeople.add(Person.createFemale(name, newDate));
        System.out.println((allPeople.size()-1));
    }
    public static void updatePerson(String sId, String name, String sex, String date) throws ParseException{
        Date newDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);

        int id = Integer.parseInt(sId);
        if(id<allPeople.size()){
            Person p = allPeople.get(id);
            p.setBirthDate(newDate);
            p.setName(name);
            if(sex.equals("м")) p.setSex(Sex.MALE);
            else p.setSex(Sex.FEMALE);
            allPeople.set(id, p);
        }
    }
    public static void deletePerson(String s){
        int id = Integer.parseInt(s);
        if(id<allPeople.size()){
            Person p = allPeople.get(id);
            p.setBirthDate(null);
            p.setSex(null);
            p.setName(null);
            allPeople.set(id, p);
        }
    }
    public static void printPerson(String s){
        int id = Integer.parseInt(s);
        if (id<allPeople.size()) {
            Person p = allPeople.get(id);
            SimpleDateFormat fd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String printS = "";
            printS = p.getName();
            if (p.getSex()==Sex.MALE) printS+=" м";
            else printS+=" ж";
            printS+=" "+fd.format(p.getBirthDate());
            System.out.println(printS);
        }
    }
}
