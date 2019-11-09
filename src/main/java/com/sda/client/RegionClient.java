package com.sda.client;

import com.sda.controller.RegionController;

import java.util.Scanner;

public class RegionClient {

    private static RegionController regionController;

    public static void regionClient() {
        regionController = new RegionController();
        String input = null;
        while (!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            regionController.control(input);
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
