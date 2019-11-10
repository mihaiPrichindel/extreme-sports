package com.sda.service.I_DAO;

import com.sda.entity.Country;

public interface ICountryDAO {

    Country findCountryById(Long id);
}
