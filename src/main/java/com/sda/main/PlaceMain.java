package com.sda.main;

import com.sda.controller.PlaceController;

import java.util.Scanner;

public class PlaceMain {

    private static PlaceController placeController;

    public static void main(String[] args) {

        placeController = new PlaceController();
        String input = null;
        while (!"stop".equalsIgnoreCase(input)) {
            input = displayPlaceOptions();
            placeController.control(input);
        }
    }

    private static String displayPlaceOptions() {
        System.out.println("Choose between: create, update, delete, findAll, findBest");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
