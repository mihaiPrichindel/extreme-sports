package com.sda.client;

import com.sda.controller.PlaceController;

import java.util.Scanner;

public class PlaceClient {


    private static PlaceController placeController;

    public static void placeClient() {
        placeController = new PlaceController();
        String input = null;
        while (!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            placeController.control(input);
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

