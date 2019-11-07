package com.sda.client;

import com.sda.controller.CityController;

import java.util.Scanner;

public class CityMain {

    private static CityController cityController;

    public static void main(String[] args) {
        cityController = new CityController();
        String input = null;
        while (!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            cityController.control(input);
        }
    }

    private static String displayOptions() {
        System.out.println("Choose between: create, findAll, update, delete");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
