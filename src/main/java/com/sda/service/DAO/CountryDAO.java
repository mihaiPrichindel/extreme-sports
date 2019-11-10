package com.sda.service.DAO;

import com.sda.entity.Country;
import com.sda.hibernate_utils.HibernateUtil;
import com.sda.service.I_DAO.ICountryDAO;
import org.hibernate.Session;

public class CountryDAO implements ICountryDAO {
    @Override
    public Country findCountryById(Long countryId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Country country = session.find(Country.class, countryId);
        session.close();
        return country;
    }
}
