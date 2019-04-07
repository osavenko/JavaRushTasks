package com.javarush.task.task19.task1921;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(args[0]));
        while (scanner.hasNext()){
            String[] line = scanner.nextLine().split(" ");
            if(line.length==4){
                String name = line[0];
                Date d = new Date(Integer.parseInt(line[3])-1900,Integer.parseInt(line[2])-1, Integer.parseInt(line[1]));
                PEOPLE.add(new Person(name,d));
            } else {
                String name = line[0]+" "+line[1]+" "+line[2];
                Date d = new Date(Integer.parseInt(line[5])-1900,Integer.parseInt(line[4])-1, Integer.parseInt(line[3]));
                PEOPLE.add(new Person(name,d));
            }
        }
        scanner.close();
        System.out.println(PEOPLE.stream().count());
        PEOPLE.stream().forEach( p -> System.out.println(p.getName()+" "+p.getBirthDate()));
    }
}
