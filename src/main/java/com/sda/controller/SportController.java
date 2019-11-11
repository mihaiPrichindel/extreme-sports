package com.sda.controller;

import com.sda.entity.Sport;
import com.sda.service.place.IPlaceDAO;
import com.sda.service.place.PlaceDAO;
import com.sda.service.sport.IsportDAO;
import com.sda.service.sport.SportDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SportController {

    private static IsportDAO sportService = new SportDAO();
    private static IPlaceDAO placeService = new PlaceDAO();

    public void control(String input) {


        if (input.equalsIgnoreCase("findAll")) {
            findAllSports();
        }
        if(input.equalsIgnoreCase("create")){
            create();
        }
        if(input.equalsIgnoreCase("delete")){
            Scanner scanner = new Scanner(System.in);
            Long longId = scanner.nextLong();
            delete(longId);
        }
        if(input.equalsIgnoreCase("update")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Sport id:");
            Long longId = scanner.nextLong();
            System.out.println("Insert new cost:");
            Double cost = scanner.nextDouble();
            update(longId,cost);
        }
    }

    public void update(Long longId, Double cost) {
        Sport sport= sportService.findById(longId);
        sport.setCost(cost);
        sportService.update(sport);
    }

    public void findAllSports() {
        List<Sport> allSports = sportService.findAll();
        allSports.stream()
                .forEach(System.out::println);
    }

    public void create() {


        System.out.println("Enter new Sport name: ");
        Scanner createSport = new Scanner(System.in);
        String newSportName = createSport.nextLine();

        System.out.println("Enter new Sport cost: ");
        Double newSportCost = createSport.nextDouble();

        Scanner createSportDates = new Scanner(System.in);
        System.out.println("Start date? yyyy-mm-dd");
        String start = createSportDates.nextLine();
        LocalDate startDate = LocalDate.parse(start);

        System.out.println("End date? yyyy-mm-dd");
        String end = createSportDates.nextLine();
        LocalDate endDate = LocalDate.parse(end);

        System.out.println("For your new sport, enter place id: ");
        Long longId = createSport.nextLong();


        Sport createdSport = new Sport(newSportName, newSportCost, startDate, endDate, longId);
        sportService.insert(createdSport);
    }

    public void delete(Long longId){
        Sport sport = sportService.findById(longId);
        String output = sportService.delete(sport);
        System.out.println(output);
    }
}
