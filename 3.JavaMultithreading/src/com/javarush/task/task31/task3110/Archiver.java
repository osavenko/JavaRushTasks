
package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Archiver {
    public static void main(String[] args) {
/*        Scanner line = new Scanner(System.in);
        String fileName = line.nextLine();
        ZipFileManager zp = new ZipFileManager(Paths.get(fileName));
        String fileToZipp = line.nextLine();
        try {
            zp.createZip(Paths.get(fileToZipp));
        } catch (Exception e) {
         //   e.printStackTrace();
        }
        try {
            new ExitCommand().execute();
        } catch (Exception e) {
            //e.printStackTrace();
        }*/
        Operation operation = null;
        do{
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                //e.printStackTrace();
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                //e.printStackTrace();
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }while (operation != Operation.EXIT);

    }
    public static Operation askOperation() throws IOException {
        int numOperation;
        ConsoleHelper.writeMessage("Выберите операцию:\n"+
        "\t0 - упаковать файлы в архив\n"+
        "\t1 - добавить файл в архив\n"+
        "\t2 - удалить файл из архива\n"+
        "\t3 - распаковать архив\n"+
        "\t4 - просмотреть содержимое архива\n"+
        "\t5 - выход");
        numOperation = ConsoleHelper.readInt();

    return Operation.values()[numOperation];
    }
}
