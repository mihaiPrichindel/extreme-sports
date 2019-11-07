package com.sda.service;

import com.sda.entity.City;

import java.util.List;

public interface ICityDAO {

    List<City> findAll();

    City findById(Long id);

    void insert(City city);

    void update(City city);

    String delete(City city);
}
