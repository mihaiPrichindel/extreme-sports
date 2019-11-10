package com.sda.service.I_DAO;

import com.sda.entity.Sport;

import java.util.List;

public interface ISportDAO {

    List<Sport> findAll();

    String delete(Sport sport);

    void insert(Sport sport);

    void update (Sport sport);

    Sport findById(Long id);

}
