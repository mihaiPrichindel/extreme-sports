package com.sda.controller;

import com.sda.entity.Place;
import com.sda.entity.Sport;
import com.sda.service.place.IPlaceDAO;
import com.sda.service.sport.IsportDAO;
import com.sda.service.place.PlaceDAO;
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

    private void update(Long longId, Double cost) {
        Sport sport= sportService.findById(longId);
        sport.setCost(cost);
        sportService.update(sport);
    }

    private void findAllSports() {
        List<Sport> allSports = sportService.findAll();
        allSports.stream()
                .forEach(System.out::println);
    }

    public void create (){
        Place place = placeService.findById(1L);
        Sport sport = new Sport("ski", new Double(200), LocalDate.of(2019,1,11), LocalDate.of(2019,05,11), place);
        sportService.insert(sport);
    }

    public void delete(Long longId){
        Sport sport = sportService.findById(longId);
        String output = sportService.delete(sport);
        System.out.println(output);
    }
}
