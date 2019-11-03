package com.sda.service;

import com.sda.entity.Place;

public interface IPlaceDAO {

    Place findById(Long id);
}
