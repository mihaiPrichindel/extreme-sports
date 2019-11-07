package com.sda.controller;

import com.sda.entity.City;
import com.sda.entity.Place;
import com.sda.entity.Region;
import com.sda.service.city.CityDAO;
import com.sda.service.city.ICityDAO;
import com.sda.service.place.IPlaceDAO;
import com.sda.service.place.PlaceDAO;
import com.sda.service.region.IRegionDAO;
import com.sda.service.region.RegionDAO;
import com.sda.service.sport.IsportDAO;
import com.sda.service.sport.SportDAO;

import java.util.List;
import java.util.Scanner;

public class CityController {

    private static IsportDAO sportService = new SportDAO();
    private static IPlaceDAO placeService = new PlaceDAO();
    private static ICityDAO cityService = new CityDAO();
    private static IRegionDAO regionService = new RegionDAO();

    public void control(String input) {

        if (input.equalsIgnoreCase("findAll")) {
            findAllCities();
        }
        if (input.equalsIgnoreCase("create")) {

            Scanner inputId = new Scanner(System.in);
            Scanner inputCityName = new Scanner(System.in);
            System.out.println("Enter region ID: ");
            Long cityId = inputId.nextLong();
            System.out.println();
            System.out.println("Enter new city name: ");
            String newCityName = inputCityName.nextLine();
            System.out.println();
            create(cityId, newCityName);
        }
        if (input.equalsIgnoreCase("delete")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the city you want to delete: ");
            Long longId = scanner.nextLong();
            delete(longId);
        }
        if (input.equalsIgnoreCase("update")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter City id:");
            Long longId = scanner.nextLong();
            System.out.println("Enter City name:");
            String city = scanner.nextLine();
            update(longId, city);
        }

    }

    private void findAllCities() {
        List<City> allCities = cityService.findAll();
        allCities.stream()
                .forEach(System.out::println);
    }

    private void create(Long regionId, String newCityName) {
        Region region = regionService.findById(regionId);
        City city = new City(newCityName, region);
        cityService.insert(city);
    }

    public void update(Long longId, String name) {
        Scanner input = new Scanner(System.in);
        City city = cityService.findById(longId);
        name = input.nextLine();
        city.setCityName(name);
        cityService.update(city);
    }

    public void delete(Long longId) {

        City city = cityService.findById(longId);
        String output = cityService.delete(city);
        System.out.println(output);
    }
}



