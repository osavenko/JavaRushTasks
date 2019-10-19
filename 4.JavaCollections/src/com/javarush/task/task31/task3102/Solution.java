package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileList = new ArrayList<>();
        Stack<File> files = new Stack<>();
        files.push(new File(root));
        while(!files.isEmpty()){
            File file = files.pop();
            if(!file.exists()) continue;
            if(file.isDirectory()){
                for(File f:file.listFiles()){
                    files.push(f);
                }
            } else if(file.isFile()){
                fileList.add(file.getAbsolutePath());
            }

        }
        return fileList;
    }

    public static void main(String[] args) throws IOException {
        getFileTree("d:\\ivan").stream().forEach(System.out::println);
    }
}
