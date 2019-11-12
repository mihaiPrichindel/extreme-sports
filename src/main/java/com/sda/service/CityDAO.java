package com.sda.service;

import com.sda.entity.City;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CityDAO implements ICityDAO {
    Session session;


    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public String delete(City sport) {
        return null;
    }

    @Override
    public void insert(City sport) {

    }

    @Override
    public void update(City sport) {

    }

    @Override
    public City findById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        City city = session.find(City.class, id);
        session.close();
        return (city);
    }
}
