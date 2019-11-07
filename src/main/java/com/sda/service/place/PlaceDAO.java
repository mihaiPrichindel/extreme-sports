package com.sda.service.place;

import com.sda.entity.Place;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlaceDAO implements IPlaceDAO {

    Session session;
    Transaction tx;


    @Override
    public List<Place> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Place> allPlaces = session.createQuery("FROM Place", Place.class).getResultList();
        session.close();
        return allPlaces;
    }

    @Override
    public Place findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Place place = session.find(Place.class, id);
        session.close();
        return place;
    }

    @Override
    public void insert(Place place) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(place);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Place place) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.update(place);
        tx.commit();
        session.close();
    }

    @Override
    public String delete(Place place) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.delete(place);
        tx.commit();
        session.close();
        return "Place deleted!";
    }
}
