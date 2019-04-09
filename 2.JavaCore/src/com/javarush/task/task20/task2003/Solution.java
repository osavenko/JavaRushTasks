package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    private Properties prop = new Properties();
    private String fileName;

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(this.fileName);
        load(inputStream);
        inputStream.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.clear();
        for(Map.Entry<String,String> pair:properties.entrySet()){
            prop.put(pair.getKey(),pair.getValue());
        }
        prop.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.load(inputStream);
        for(Map.Entry<Object, Object> p:prop.entrySet()){
            properties.put((String)p.getKey(),(String)p.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        sol.fillInPropertiesMap();

        FileOutputStream outputStream = new FileOutputStream(sol.fileName);
        sol.save(outputStream);
        outputStream.close();
    }
}
