package com.sda;

import com.sda.client.*;

import java.util.Scanner;

public class ExtremeSportsMain {


    public static void main(String[] args) {

        CountryMain countryMain = new CountryMain();
        RegionMain regionMain = new RegionMain();
        CityMain cityMain = new CityMain();
        PlaceMain placeMain = new PlaceMain();
        SportMain sportMain = new SportMain();

        String input = null;

        while (!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            ExtremeSportsMain extremeSportsMain = new ExtremeSportsMain();
            extremeSportsMain.control(input);
        }
    }


    private static String displayOptions() {
        System.out.println("Choose between: Country, Region, City, Place, Sport");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void control(String input) {
        if (input.equalsIgnoreCase("Country")) {
            CountryMain.main();
        }


    }
}
