package com.sda.service;

import com.sda.entity.Place;

import java.util.List;

public interface IPlaceDAO {

    List<Place> findAll();

    Place findById(Long id);

    void insert(Place place);

    void update(Place place);

    String delete(Place place);
}
