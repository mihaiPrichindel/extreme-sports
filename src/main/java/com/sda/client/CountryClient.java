package com.sda.client;

import com.sda.controller.CountryController;

import java.util.Scanner;

public class CountryClient {

    private static CountryController countryController;

    public static void countryClient() {
        countryController = new CountryController();
        String input = null;
        while (!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            countryController.control(input);
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
