import com.sda.entity.*;

import java.time.LocalDate;

public class Main {




    public static void main(String[] args) {
        System.out.println("heeey");

        Place place = new Place();
        City city = new City();
        Region region = new Region();
        Country country = new Country();

    Crud crud = new Crud();
    Crud.findAll().stream().forEach(System.out::println);

        Sport createdSport = new Sport();
        createdSport.setCost(5600D);
        createdSport.setSportName("inchiriere bentley");
        createdSport.setStartDate(LocalDate.of(2020, 03, 12));
        createdSport.setEndDate(LocalDate.of(2023, 05, 14));

        crud.create(createdSport);

    }





}

