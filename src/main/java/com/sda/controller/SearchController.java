package com.sda.controller;

import com.sda.entity.Sport;
import com.sda.service.search.ISearchDAO;
import com.sda.service.search.SearchDAO;
import com.sda.service.sport.IsportDAO;
import com.sda.service.sport.SportDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SearchController {

    static SportController sportController = new SportController();
    private static ISearchDAO searchDAO = new SearchDAO();
    private static IsportDAO sportService = new SportDAO();
    Scanner input = new Scanner(System.in);
    //  String selection = input.nextLine();


    public static void feelingLucky() {
        sportController.findAllSports();

        System.out.println("What sport would you like to book?");
        Scanner select = new Scanner(System.in);
        String sportSelection = select.nextLine();

        System.out.println("Start date? yyyy-mm-dd");
        String startDate = select.nextLine();
        LocalDate strtD = LocalDate.parse(startDate);

        System.out.println("End date? yyyy-mm-dd");
        String endDate = select.nextLine();
        LocalDate endD = LocalDate.parse(endDate);

        List<Sport> availableSports = sportService.findAll();
        boolean isThatSportThere = availableSports.stream().allMatch(sport -> sport.getSportName().equalsIgnoreCase(sportSelection));
        if (isThatSportThere = true) {
            searchDAO.findBest(sportSelection, strtD, endD);
        } else {
            System.out.println("No matches found!");
        }
    }
}
