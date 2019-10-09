package com.javarush.task.task31.task3110;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }
    public void createZip(Path source) throws Exception{

        try(ZipOutputStream zip = new ZipOutputStream(Files.newOutputStream(zipFile))) {

            ZipEntry ze = new ZipEntry(source.getFileName().toString());
            zip.putNextEntry(ze);
            try (InputStream is = Files.newInputStream(source)) {
                while (is.available() > 0) {
                    zip.write(is.read());
                }
            }
        }

    }

}
