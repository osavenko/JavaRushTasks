package com.javarush.task.task35.task3513;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame gamePlace = new JFrame();
        gamePlace.setTitle("2048");
        gamePlace.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gamePlace.setSize(450, 500);
        gamePlace.setResizable(false);

        gamePlace.add(controller.getView());

        gamePlace.setLocationRelativeTo(null);
        gamePlace.setVisible(true);
    }
}
