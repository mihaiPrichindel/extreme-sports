package com.sda.service.city;

import com.sda.entity.City;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAO implements ICityDAO {

    Session session;
    Transaction tx;

    @Override
    public List<City> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<City> allCities = session.createQuery("FROM City", City.class).getResultList();
        session.close();
        return allCities;
    }

    @Override
    public City findById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        City city = session.find(City.class, id);
        session.close();
        return city;
    }

    @Override
    public void insert(City city) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(city);
        tx.commit();
        session.close();
    }

    @Override
    public void update(City city) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.update(city);
        tx.commit();
        session.close();
    }

    @Override
    public String delete(City city) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.delete(city);
        tx.commit();
        session.close();
        return "City deleted!";
    }
}