package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.FileProperties;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.util.List;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager fileManager = getZipFileManager();
        ConsoleHelper.writeMessage( "Содержимое архива:");
        List<FileProperties> fileList = fileManager.getFilesList();
        for (FileProperties f:fileList){
            ConsoleHelper.writeMessage(f.toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
