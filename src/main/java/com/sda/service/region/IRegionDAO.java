package com.sda.service.region;

import com.sda.entity.Region;

import java.util.List;

public interface IRegionDAO {

    List<Region> findAll();

    Region findById(Long id);

    void insert(Region region);

    void update(Region region);

    String delete(Region region);
}
