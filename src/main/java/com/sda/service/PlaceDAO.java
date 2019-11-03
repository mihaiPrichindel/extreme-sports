package com.sda.service;

import com.sda.entity.Place;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.Session;

public class PlaceDAO implements IPlaceDAO {


    @Override
    public Place findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Place place = session.find(Place.class, id);
        session.close();
        return place;
    }
}
