package com.sda.controller;

import com.sda.entity.Place;
import com.sda.entity.Sport;
import com.sda.service.IPlaceDAO;
import com.sda.service.IsportDAO;
import com.sda.service.PlaceDAO;
import com.sda.service.SportDAO;

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
    }

    private void findAllSports() {
        List<Sport> allSports = sportService.findAll();
        allSports.stream()
                .forEach(System.out::println);
    }

    public void create (){
        Place place = placeService.findById(1L);
        Sport sport = new Sport("ski", new Double(200), LocalDate.of(2019, 10, 11),
                LocalDate.of(2019,05,11), place);

        sportService.insert(sport);
    }

    public void delete(Long longId){
        Sport sport = sportService.findById(longId);
        String output = sportService.delete(sport);
        System.out.println(output);
    }
}
