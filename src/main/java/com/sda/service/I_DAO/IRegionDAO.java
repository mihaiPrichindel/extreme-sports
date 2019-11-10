package com.sda.service.I_DAO;

import com.sda.entity.Region;

import java.util.List;

public interface IRegionDAO {

    List<Region> findAllRegions();

    String deleteRegion(Region region);

    void insertRegion(Region region);

    void updateRegion(Region region);

    Region findRegionById(Long id);
}
