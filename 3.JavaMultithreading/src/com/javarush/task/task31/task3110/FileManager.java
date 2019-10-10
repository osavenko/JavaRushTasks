package com.javarush.task.task31.task3110;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path rootPath;
    private List<Path> fileList;

    public List<Path> getFileList() {
        return fileList;

    }

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        fileList = new ArrayList<>();
        collectFileList(rootPath);
    }
    private void collectFileList(Path path) throws IOException {
        if(Files.isRegularFile(path)){
            Path rel = rootPath.relativize(path);
            fileList.add(rel);
        }else if(Files.isDirectory(path)){
            try(DirectoryStream<Path> ds = Files.newDirectoryStream(path)){
                for(Path path1:ds)
                    collectFileList(path1);
            }
        }
    }
}
