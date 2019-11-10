package com.sda.main;

import com.sda.controller.RegionController;

import java.util.Scanner;

public class RegionMain {

    private static RegionController regionController;

    public static void main(String[] args) {

        regionController = new RegionController();
        String input = null;
        while (!"stop".equalsIgnoreCase(input)) {
            input = displayRegionOptions();
            regionController.control(input);
        }
    }

    private static String displayRegionOptions() {
        System.out.println("Choose between: create, update, delete, findAll");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
