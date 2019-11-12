package com.sda.service;

import com.sda.entity.Place;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.logging.Logger;

public class PlaceDAO implements IPlaceDAO {
    private static final Logger logger = Logger.getLogger(IPlaceDAO.class.getName());
    Session session;

    @Override
    public List<Place> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Place> allPlaces = session.createQuery("from Place", Place.class).getResultList();
        session.close();
        return allPlaces;
    }

    @Override
    public String delete(Place place) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(place);
            transaction.commit();
            session.close();
            return "Success";
        } catch (Exception e) {
            logger.severe("could not delete place");
            return "Failed";
        }
    }

    @Override
    public void insert(Place place) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(place);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Place place) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(place);
        transaction.commit();
        session.close();
    }

    @Override
    public Place findById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Place place = session.find(Place.class, id);
        session.close();
        return place;
    }
}
