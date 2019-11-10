package com.sda.main;

import com.sda.controller.SportController;

import java.util.Scanner;

public class SportMain {
    private static SportController sportController;

    public static void main(String[] args) {
        sportController = new SportController();
        String input = null;
        while(!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            sportController.control(input);
        }
    }

    private static String displayOptions() {
        System.out.println("Choose between: create, findAll, update, delete");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }



}

