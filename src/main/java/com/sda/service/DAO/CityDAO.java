package com.sda.service.DAO;

import com.sda.entity.City;
import com.sda.hibernate_utils.HibernateUtil;
import com.sda.service.I_DAO.ICityDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAO implements ICityDAO {
    Session session;

    @Override
    public City findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        City city = session.find(City.class, id);
        session.close();
        return city;
    }

    @Override
    public List<City> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<City> cities = session.createQuery("from City", City.class).getResultList();
        session.close();
        return cities;
    }

    @Override
    public String delete(City city) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
            session.close();
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }
    }

    @Override
    public void insert(City city) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(City city) {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.update(city);
        transaction.commit();
        session.close();
    }
}
