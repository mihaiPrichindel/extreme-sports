package com.sda.client;

import com.sda.controller.CityController;

import java.util.Scanner;

public class CityClient {

    private static CityController cityController;

    public static void cityClient() {
        cityController = new CityController();
        String input = null;
        while (!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            cityController.control(input);

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
