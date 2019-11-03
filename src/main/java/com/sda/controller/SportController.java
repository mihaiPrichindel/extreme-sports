package com.sda.controller;

import com.sda.entity.Sport;
import com.sda.service.ISportDao;
import com.sda.service.SportDao;

import java.util.List;
import java.util.Scanner;

public class SportController {
    private static ISportDao sportService = new SportDao();
    Scanner input = new Scanner(System.in);

    public void control(){
        findAllSports();
    }

    private void findAllSports() {
        List<Sport> allSports = sportService.findAll();
        allSports.stream()
                .forEach(System.out::println);
    }
}
