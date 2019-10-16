package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws IOException{
        return reader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        ConsoleHelper.writeMessage("Выберите блюда. Для завершения наберите 'exit'.");
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        while (true){
            String dishToOrder = readString();
            if(dishToOrder.equalsIgnoreCase("exit")){
                break;
            }
            if(dishToOrder.isEmpty()){
                ConsoleHelper.writeMessage("Блюдо не выбрано!");
                continue;
            }
            boolean found = false;
            for(Dish dish:Dish.values()){
                if(dish.name().equalsIgnoreCase(dishToOrder)){
                    dishes.add(dish);
                    found=true;
                }
            }
            if(!found) ConsoleHelper.writeMessage("Блюдо не выбрано!");
        }
        return dishes;
    }
}
