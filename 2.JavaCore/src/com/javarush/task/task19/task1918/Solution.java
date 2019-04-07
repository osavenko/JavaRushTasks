package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));

        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null){
            sb.append(line);
        }
        reader.close();

        String openTag = "<"+args[0];
        String closeTag = "</"+args[0]+">";

        // ищем все открывающие тэги и запоминаем их индексы расположения в строке
        List<Integer> openList = new ArrayList<>();
        int startIndex = 0;
        int index;
        while (true) {
            index = sb.indexOf(openTag, startIndex);
            if (index == -1) break;
            openList.add(index);
            startIndex = index+1;
        }

        // ищем все закрывающие тэги и запоминаем их индексы расположения в строке
        List<Integer> closeList = new ArrayList<>();
        startIndex = 0;
        while (true) {
            index = sb.indexOf(closeTag, startIndex);
            if (index == -1) break;
            closeList.add(index);
            startIndex = index+1;
        }

        // берем первый openTag и идем до closeTag, считаю openTag-и по пути (уровень вложенности)
        int closeID, openID, level = 0;
        while (openList.size() != 0) {
            for (int i = 0; i < openList.size(); i++) {
                if (openList.get(i) < closeList.get(0)) level++;
                else break;
            }
            for (int i = level-1; i >= 0; i--) {
                openID = openList.get(0);
                closeID = closeList.get(i);
                line = sb.substring(openID, closeID);
                System.out.println(line+closeTag);
                openList.remove(0);
                closeList.remove(i);
                level = 0;
                break;
            }
        }

       /* //String tag = "span";
        String tag = args[0];
        //String fileName = "d:\\index.html";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        String str = "";
        while(fileReader.ready()){
            int ch = fileReader.read();
            str+=(char)ch;
        }
        fileReader.close();

        Document document = Jsoup.parse(str.replaceAll("\"[\\n\\r]\"",""), "", Parser.xmlParser());
        Elements elements = document.select(tag);

        for(Element element:elements) {
            StringBuilder sb = new StringBuilder();
            sb.append("<").append(element.tagName());
            for (int i=0;i<element.attributes().size();i++){
                sb.append(" ").append(element.attributes().asList().get(i));
            }
            sb.append(">").append(element.text()).append("</").append(element.tagName()).append(">");

            System.out.println(sb);
        }
*/
    }
}
