package com.sda.controller;

import com.sda.entity.City;
import com.sda.entity.Place;
import com.sda.service.city.CityDAO;
import com.sda.service.city.ICityDAO;
import com.sda.service.place.IPlaceDAO;
import com.sda.service.place.PlaceDAO;
import com.sda.service.sport.IsportDAO;
import com.sda.service.sport.SportDAO;

import java.util.List;
import java.util.Scanner;

public class PlaceController {

    private static IsportDAO sportService = new SportDAO();
    private static IPlaceDAO placeService = new PlaceDAO();
    private static ICityDAO cityService = new CityDAO();

    public void control(String input) {

        if (input.equalsIgnoreCase("findAll")) {
            findAllPlaces();
        }
        if (input.equalsIgnoreCase("create")) {

            Scanner inputId = new Scanner(System.in);
            Scanner inputPlaceName = new Scanner(System.in);
            System.out.println("Enter city ID: ");
            Long cityId = inputId.nextLong();
            System.out.println();
            System.out.println("Enter new place name: ");
            String newPlaceName = inputPlaceName.nextLine();
            System.out.println();
            create(cityId, newPlaceName);
        }
        if (input.equalsIgnoreCase("delete")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the place you want to delete: ");
            Long longId = scanner.nextLong();
            delete(longId);
        }
        if (input.equalsIgnoreCase("update")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Place id:");
            Long longId = scanner.nextLong();
            System.out.println("Enter City name:");
            String city = scanner.nextLine();
            update(longId, city);
        }

    }

    private void findAllPlaces() {
        List<Place> allPlaces = placeService.findAll();
        allPlaces.stream()
                .forEach(System.out::println);
    }

    private void create(Long cityId, String newPlaceName) {
        City city = cityService.findById(cityId);
        Place place = new Place(newPlaceName, city);
        placeService.insert(place);
    }

    public void update(Long longId, String name) {
        Scanner input = new Scanner(System.in);
        Place place = placeService.findById(longId);
        name = input.nextLine();
        place.setPlaceName(name);
        placeService.update(place);
    }

    public void delete(Long longId) {
        Scanner input = new Scanner(System.in);
        Place place = placeService.findById(longId);
        String output = placeService.delete(place);
        System.out.println(output);
    }
}
