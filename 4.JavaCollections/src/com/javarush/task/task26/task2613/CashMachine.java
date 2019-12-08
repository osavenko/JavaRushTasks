package com.javarush.task.task26.task2613;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        String codeCurency = ConsoleHelper.askCurrencyCode();
        String[] nominaleCurency = ConsoleHelper.getValidTwoDigits(codeCurency);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(codeCurency);
        manipulator.addAmount(Integer.parseInt(nominaleCurency[0]),Integer.parseInt(nominaleCurency[1]));
        System.out.println(manipulator.getTotalAmount());
    }
}
