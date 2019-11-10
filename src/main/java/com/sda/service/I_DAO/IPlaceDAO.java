package com.sda.service.I_DAO;

import com.sda.entity.Place;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IPlaceDAO {

    Place findById(Long countryId);

    List<Place> findAll();

    String delete(Place place);

    void insert(Place place);

    void update (Place place);

    List<Place> findBestCostByDate(String sportName, LocalDate startDate, LocalDate endDate);

}
