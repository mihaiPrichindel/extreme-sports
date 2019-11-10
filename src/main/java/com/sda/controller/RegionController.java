package com.sda.controller;

import com.sda.entity.Country;
import com.sda.entity.Region;
import com.sda.service.DAO.CountryDAO;
import com.sda.service.I_DAO.ICountryDAO;
import com.sda.service.I_DAO.IRegionDAO;
import com.sda.service.DAO.RegionDAO;

import java.util.List;
import java.util.Scanner;

public class RegionController {

    private static IRegionDAO regionService = new RegionDAO();
    private static ICountryDAO countryService = new CountryDAO();


    public void control(String userInput) {

        if (userInput.equalsIgnoreCase("findAll")) {
            findAllRegions();
        }
        if (userInput.equalsIgnoreCase("create")) {
            createRegion();
        }
        if (userInput.equalsIgnoreCase("update")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter region ID");
            Long inputID = scanner.nextLong();
            System.out.println("Insert new region name");
            String name = scanner.next();
            updateRegion(inputID, name);
        }
        if (userInput.equalsIgnoreCase("delete")) {
            Scanner scanner = new Scanner(System.in);
            Long idToDelete = scanner.nextLong();
            deleteRegion(idToDelete);
        }
    }

    private void findAllRegions() {
        List<Region> allRegions = regionService.findAllRegions();
        allRegions.stream()
                .forEach(c->{
                    System.out.println(c + ", " + c.getCountry());
                });
    }

    private void createRegion() {
        Country country = countryService.findCountryById(1L);

        Region region = new Region("Bavary", country);
        regionService.insertRegion(region);
    }

    private void updateRegion(Long longId, String name) {
        Region region = regionService.findRegionById(longId);
        region.setRegionName(name);
        regionService.updateRegion(region);
    }

    private void deleteRegion(Long regionToDeleteID) {
        Region region = regionService.findRegionById(regionToDeleteID);
        String output = regionService.deleteRegion(region);
        System.out.println(output);
    }
}
