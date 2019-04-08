package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("d:\\objectJ.tmp", null);
            OutputStream outputStream = new FileOutputStream("d:\\objectJ.tmp");
            InputStream inputStream = new FileInputStream("d:\\objectJ.tmp");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User u1 = new User();
            u1.setFirstName(null);
            u1.setLastName("Savenko");
            u1.setMale(true);
            u1.setBirthDate(new Date(1977-1900,4,7));
            u1.setCountry(User.Country.UKRAINE);
            javaRush.users.add(u1);
            System.out.println(javaRush.toString());
            javaRush.save(outputStream);
            outputStream.flush();


            Scanner scanner = new Scanner(System.in);
            String sss = scanner.nextLine();




            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject);
            //outputStream.close();
            //inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            if(users.size()==0){
                writer.println("empty");
            }else{
                for(User user:users){
                    String fName = user.getFirstName()==null?"null":user.getFirstName();
                    String lName = user.getLastName()==null?"null":user.getLastName();


                    writer.println(fName+";"+lName+";"+user.getBirthDate().getTime()+";"+user.isMale()+";"+user.getCountry());
                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()){
                String line = reader.readLine();
                if(!"empty".equals(line)){
                   String[] userArray = line.split(";");
                   User u1 = new User();
                   u1.setFirstName(userArray[0].equals("null")?null:userArray[0]);
                   u1.setLastName(userArray[1].equals("null")?null:userArray[1]);
                   u1.setMale("true".equals(userArray[3])?true:false);
                   u1.setBirthDate(new Date(Long.parseLong(userArray[2])));
                   u1.setCountry(User.Country.valueOf(userArray[4]));
                   users.add(u1);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }

        @Override
        public String toString() {
            StringBuilder s=new StringBuilder();
            if(users.size()==0){
                return "Empty";
            }
            for (User u1:users){
                s.append("[").append(u1.getFirstName()).append(" ").append(u1.getLastName());
                s.append(", ").append(u1.isMale()?"Мужчина":"Женщина");
                s.append(", ").append(u1.getBirthDate());
                s.append(", ").append(u1.getCountry().getDisplayName());
                s.append("]");
            }
            return s.toString();
        }
    }
}
