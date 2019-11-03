package com.sda.service;

import com.sda.entity.Sport;
import java.util.List;

public interface ISportDao {

    List<Sport> findAll();

    String delete(Sport sport);

    void insert(Sport sport);

    void update(Sport sport);
}
