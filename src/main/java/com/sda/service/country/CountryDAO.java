package com.sda.service.country;

import com.sda.entity.City;
import com.sda.entity.Country;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CountryDAO implements ICountryDAO {

    Session session;
    Transaction tx;

    @Override
    public List<Country> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Country> allCountries = session.createQuery("FROM Country", Country.class).getResultList();
        session.close();
        return allCountries;
    }

    @Override
    public Country findById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Country country = session.find(Country.class, id);
        session.close();
        return country;
    }

    @Override
    public void insert(Country country) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(country);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Country country) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.update(country);
        tx.commit();
        session.close();
    }

    @Override
    public String delete(Country country) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.delete(country);
        tx.commit();
        session.close();
        return "Country deleted!";
    }
}
