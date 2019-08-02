package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        //{name=Ivanov, country=Ukraine, city=Kiev, age=null}
        map.put("name", "Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age",null);
        String rez = getQuery(map);
        System.out.println(rez);

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> param:params.entrySet()){
            if((param.getValue()!=null)&&(!param.getValue().isEmpty())) {
                if(sb.length()!=0)
                    sb.append(" and ");
                sb.append(param.getKey());
                sb.append(" = '");
                sb.append(param.getValue());
                sb.append("'");
            }
        }
        return sb.toString();
    }
}
