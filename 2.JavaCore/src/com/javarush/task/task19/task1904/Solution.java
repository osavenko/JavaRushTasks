package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person p;
            String currentLine = fileScanner.nextLine();

            Scanner sc = new Scanner(currentLine);

            String lastName = sc.next();
            String firstName = sc.next();
            String middleName = sc.next();
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
            Date birthDate = calendar.getTime();
            p = new Person(firstName, middleName, lastName,birthDate);

            return p;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
