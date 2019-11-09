package com.sda.client;

import com.sda.controller.SportController;

import java.util.Scanner;

public class SportClient {
    private static SportController sportController;

    public static void sportClient() {
        sportController = new SportController();
        String input = null;
        while(!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            sportController.control(input);
        }
    }

    private static String displayOptions() {
        System.out.println("Choose between: create, findAll, update, delete, go back");
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine();
        if (selection.equalsIgnoreCase("go back")) {
            ExtremeSportsClient.ExtremeSportsClient();
        }
        return selection;
    }


}

