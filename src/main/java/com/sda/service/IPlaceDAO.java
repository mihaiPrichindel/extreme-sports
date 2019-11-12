package com.sda.service;

import com.sda.entity.Place;

import java.util.List;

public interface IPlaceDAO {

    List<Place> findAll();

    String delete(Place place);

    void insert(Place place);

    void update(Place place);

    Place findById(Long id);
}
