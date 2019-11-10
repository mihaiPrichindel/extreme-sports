package com.sda.client;

import com.sda.controller.SearchController;

import java.util.Scanner;

public class ExtremeSportsClient {


    public static void ExtremeSportsClient() {

        String input = null;

        while (!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            ExtremeSportsClient extremeSportsClient = new ExtremeSportsClient();
            extremeSportsClient.control(input);
            if (input.equalsIgnoreCase("stop")) {
                System.exit(0);
            }
        }
    }


    private static String displayOptions() {
        System.out.println("Choose between: Country, Region, City, Place, Sport or Feeling lucky");
        System.out.println("If you wish to exit, press Stop.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void control(String input) {
        if (input.equalsIgnoreCase("Country")) {
            CountryClient.countryClient();
        }

        if (input.equalsIgnoreCase("Region")) {
            RegionClient.regionClient();
        }

        if (input.equalsIgnoreCase("City")) {
            CityClient.cityClient();
        }

        if (input.equalsIgnoreCase("Place")) {
            PlaceClient.placeClient();
        }

        if (input.equalsIgnoreCase("Sport")) {
            SportClient.sportClient();
        }

        if (input.equalsIgnoreCase("Feeling lucky")) {
            SearchController.feelingLucky();

        }


    }
}
