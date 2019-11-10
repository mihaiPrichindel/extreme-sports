package com.sda.service.search;

import com.sda.entity.Sport;

import java.time.LocalDate;
import java.util.List;

public interface ISearchDAO {

    List<Sport> findBest(String sportName, LocalDate startDate, LocalDate endDate);

}
