package com.sda.service;

import com.sda.entity.City;

import java.util.List;

public interface ICityDAO {

    List<City> findAll();

    String delete(City sport);

    void insert(City sport);

    void update(City sport);

    City findById(Long id);
}
