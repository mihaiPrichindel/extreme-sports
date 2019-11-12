package com.sda.controller;

import com.sda.entity.City;
import com.sda.entity.Place;
import com.sda.service.CityDAO;
import com.sda.service.ICityDAO;
import com.sda.service.IPlaceDAO;
import com.sda.service.PlaceDAO;

import java.util.List;
import java.util.Scanner;

public class PlaceController {

    private static IPlaceDAO placeService = new PlaceDAO();
    private static ICityDAO cityServices = new CityDAO();

    public void control(String input) {


        if (input.equalsIgnoreCase("findAll")) {
            findllPlaces();
        }
        if (input.equalsIgnoreCase("create")) {
            create();
        }
        if (input.equalsIgnoreCase("delete")) {
            Scanner scanner = new Scanner(System.in);
            Long longId = scanner.nextLong();
            delete(longId);
        }
        if (input.equalsIgnoreCase("update")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Place id: ");
            Long longId = scanner.nextLong();
            System.out.println("Insert new name: ");
            String placeName = scanner.next();
            System.out.println();
            update(longId, placeName);
        }
    }

    private void update(Long longId, String placeName) {
        Place place = placeService.findById(longId);
        place.setPlaceName(placeName);
        placeService.update(place);
    }

    private void findllPlaces() {
        List<Place> allPlaces = placeService.findAll();
        allPlaces.stream()
                .forEach(System.out::println);
    }


    public void delete(Long longId) {
        Place place = placeService.findById(longId);
        String output = placeService.delete(place);
        System.out.println(output);
    }

    public void create() {
        City city = cityServices.findById(1L);
        Place place = new Place("ski nautic", city);
        placeService.insert(place);
    }
}
