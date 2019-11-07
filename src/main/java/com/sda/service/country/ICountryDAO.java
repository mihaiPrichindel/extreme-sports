package com.sda.service.country;

import com.sda.entity.Country;

import java.util.List;

public interface ICountryDAO {

    List<Country> findAll();

    Country findById(Long id);

    void insert(Country country);

    void update(Country country);

    String delete(Country country);
}
