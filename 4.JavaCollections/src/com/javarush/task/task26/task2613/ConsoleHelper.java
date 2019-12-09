package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;


public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString()throws InterruptOperationException{

        String str = null;
        try {
            str = bis.readLine();
            if (str.toLowerCase().contains("exit")) {
                throw new InterruptOperationException();
            }
        } catch (IOException e){}
        return str;
    }
    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String userInput = null;

        while (true) {

            userInput = readString();
            if(userInput.length()==3){
                break;
            }else {
                writeMessage(res.getString("invalid.data"));
                writeMessage(res.getString("choose.currency.code"));
            }

        }

        return userInput.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), "conventional units"));
        String userInput = null;

        while (true) {

            userInput = readString();
            if(userInput.matches("^[1-9]\\d*\\s[1-9]\\d*")) {
                break;
            } else {
                writeMessage(res.getString("invalid.data"));
                writeMessage(String.format(res.getString("choose.denomination.and.count.format"), "conventional units"));
            }
        }

        return userInput.split(" ");
    }
    private static boolean isNotValidTwoNumbers(String twoNumbers) {
        return twoNumbers == null || ! twoNumbers.matches("^[+]?[1-9]\\d*[ ][+]?[1-9]\\d*");
    }
    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
//        writeOperationsCodeForUserInput();
        String userInput = null;

        while (true) {
            writeMessage(res.getString("invalid.data"));
            writeMessage("Enter code of operation from 1 to 4.");
            userInput = readString();
            if (userInput.matches("[1-4]")){
                break;
            }

        }

        return Operation.getAllowableOperationByOrdinal(Integer.parseInt(userInput));
    }
    public static void printExitMessage() {
        writeMessage("Good bye!");
    }
}
