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

public class RegionController {

    private static IsportDAO sportService = new SportDAO();
    private static IPlaceDAO placeService = new PlaceDAO();
    private static ICityDAO cityService = new CityDAO();
    private static IRegionDAO regionService = new RegionDAO();
    private static ICountryDAO countryService = new CountryDAO();

    public void control(String input) {

        if (input.equalsIgnoreCase("findAll")) {
            findAllRegions();
        }
        if (input.equalsIgnoreCase("create")) {

            Scanner inputId = new Scanner(System.in);
            Scanner inputRegionName = new Scanner(System.in);
            System.out.println("Enter Country ID: ");
            Long countryId = inputId.nextLong();
            System.out.println();
            System.out.println("Enter new region name: ");
            String newRegionName = inputRegionName.nextLine();
            System.out.println();
            create(countryId, newRegionName);
        }
        if (input.equalsIgnoreCase("delete")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the region you want to delete: ");
            Long longId = scanner.nextLong();
            delete(longId);
        }
        if (input.equalsIgnoreCase("update")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Region id:");
            Long longId = scanner.nextLong();
            System.out.println("Enter Region name:");
            String region = scanner.nextLine();
            update(longId, region);
        }

    }

    private void findAllRegions() {
        List<Region> allRegions = regionService.findAll();
        allRegions.stream()
                .forEach(System.out::println);
    }

    private void create(Long countryId, String newRegionName) {
        Country country = countryService.findById(countryId);
        Region region = new Region(newRegionName, country);
        regionService.insert(region);
    }

    public void update(Long longId, String name) {
        Scanner input = new Scanner(System.in);
        Region region = regionService.findById(longId);
        name = input.nextLine();
        region.setRegionName(name);
        regionService.update(region);
    }

    public void delete(Long longId) {

        Region region = regionService.findById(longId);
        String output = regionService.delete(region);
        System.out.println(output);
    }
}



