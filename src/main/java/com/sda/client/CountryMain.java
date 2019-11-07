package com.sda.client;

import com.sda.controller.CountryController;

import java.util.Scanner;

public class CountryMain {

    private static CountryController countryController;

    public static void main(String[] args) {
        countryController = new CountryController();
        String input = null;
        while (!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            countryController.control(input);
        }
    }

    private static String displayOptions() {
        System.out.println("Choose between: create, findAll, update, delete");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
