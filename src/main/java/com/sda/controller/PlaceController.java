package com.sda.controller;

import com.sda.entity.City;
import com.sda.entity.Place;
import com.sda.entity.Place;
import com.sda.service.DAO.CityDAO;
import com.sda.service.I_DAO.ICityDAO;
import com.sda.service.I_DAO.IPlaceDAO;
import com.sda.service.DAO.PlaceDAO;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PlaceController {

    private static IPlaceDAO placeService = new PlaceDAO();
    private static ICityDAO cityService = new CityDAO();

    public void control(String input) {


        if (input.equalsIgnoreCase("findAll")) {
            findAllPlaces();
        }
        if (input.equalsIgnoreCase("create")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert new place name:");
            String placeName = scanner.nextLine();
            create(placeName);
        }
        if (input.equalsIgnoreCase("delete")) {
            Scanner scanner = new Scanner(System.in);
            Long longId = scanner.nextLong();
            delete(longId);
        }
        if (input.equalsIgnoreCase("update")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Place id:");
            Long longId = scanner.nextLong();
            System.out.println("Insert new name:");
            String placeName = scanner.nextLine();
            update(longId, placeName);
        }
        if (input.equalsIgnoreCase("findBest")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter sport name:");
            String sportName = scanner.next();
            System.out.println("Insert start date");
            LocalDate startDate = LocalDate.parse(scanner.next());
            System.out.println("Insert end date");
            LocalDate endDate = LocalDate.parse(scanner.next());
            findBestCostByDate(sportName, startDate, endDate);
        }
    }

    private void update(Long longId, String placeName) {
        Place place = placeService.findById(longId);
        place.setPlaceName(placeName);
        placeService.update(place);
    }

    private void findAllPlaces() {
        List<Place> allPlaces = placeService.findAll();
        allPlaces.stream()
                .forEach(System.out::println);
    }

    public void create(String placeName) {
        City city = cityService.findById(1L);

        Place place = new Place(placeName, city);

        placeService.insert(place);
    }

    public void delete(Long longId) {
        Place place = placeService.findById(longId);
        String output = placeService.delete(place);
        System.out.println(output);
    }

    public void findBestCostByDate(String sportName, LocalDate startDate, LocalDate endDate){
        List<Place> bestPlaces = placeService.findBestCostByDate(sportName, startDate, endDate);
        bestPlaces.stream()
                .forEach(System.out::println);
    }
}
