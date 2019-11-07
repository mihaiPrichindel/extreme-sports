package com.sda.client;

import com.sda.controller.RegionController;

import java.util.Scanner;

public class RegionMain {

    private static RegionController regionController;

    public static void main(String[] args) {
        regionController = new RegionController();
        String input = null;
        while (!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            regionController.control(input);
        }
    }

    private static String displayOptions() {
        System.out.println("Choose between: create, findAll, update, delete");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
