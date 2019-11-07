package com.sda.controller;

import com.sda.entity.City;
import com.sda.entity.Country;
import com.sda.entity.Region;
import com.sda.service.city.CityDAO;
import com.sda.service.city.ICityDAO;
import com.sda.service.country.CountryDAO;
import com.sda.service.country.ICountryDAO;
import com.sda.service.place.IPlaceDAO;
import com.sda.service.place.PlaceDAO;
import com.sda.service.region.IRegionDAO;
import com.sda.service.region.RegionDAO;
import com.sda.service.sport.IsportDAO;
import com.sda.service.sport.SportDAO;

import java.util.List;
import java.util.Scanner;

public class CountryController {

    private static IsportDAO sportService = new SportDAO();
    private static IPlaceDAO placeService = new PlaceDAO();
    private static ICityDAO cityService = new CityDAO();
    private static IRegionDAO regionService = new RegionDAO();
    private static ICountryDAO countryService = new CountryDAO();

    public void control(String input) {

        if (input.equalsIgnoreCase("findAll")) {
            findAllCountries();
        }
        if (input.equalsIgnoreCase("create")) {

            Scanner inputId = new Scanner(System.in);
            Scanner inputCountryName = new Scanner(System.in);
           /* System.out.println("Enter country ID: ");
            Long countryId = inputId.nextLong();
            System.out.println();*/
            System.out.println("Enter new country name: ");
            String newCountryName = inputCountryName.nextLine();
            System.out.println();
            create(/*countryId,*/ newCountryName);
        }
        if (input.equalsIgnoreCase("delete")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the country you want to delete: ");
            Long longId = scanner.nextLong();
            delete(longId);
        }
        if (input.equalsIgnoreCase("update")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Country id:");
            Long longId = scanner.nextLong();
            System.out.println("Enter Country name:");
            String country = scanner.nextLine();
            update(longId, country);
        }

    }

    private void findAllCountries() {
        List<Country> allCountries = countryService.findAll();
        allCountries.stream()
                .forEach(System.out::println);
    }

    private void create(String newCountryName) {
        // Country country = countryService.findById(countryId);
        Country country = new Country(newCountryName);
        countryService.insert(country);
    }

    public void update(Long longId, String name) {
        Scanner input = new Scanner(System.in);
        Country country = countryService.findById(longId);
        name = input.nextLine();
        country.setCountryName(name);
        countryService.update(country);
    }

    public void delete(Long longId) {

        Country country = countryService.findById(longId);
        String output = countryService.delete(country);
        System.out.println(output);
    }
}



