package com.sda.service.I_DAO;

import com.sda.entity.City;

import java.util.List;

public interface ICityDAO {

    List<City> findAll();

    String delete(City city);

    void insert(City city);

    void update (City city);

    City findById(Long id);
}
