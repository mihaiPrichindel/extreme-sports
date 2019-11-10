package com.sda.service.DAO;

import com.sda.entity.Place;
import com.sda.hibernate_utils.HibernateUtil;
import com.sda.service.I_DAO.IPlaceDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class PlaceDAO implements IPlaceDAO {

    Session session;

    @Override
    public Place findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Place place = session.find(Place.class, id);
        session.close();
        return place;
    }

    @Override
    public List<Place> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Place> places = session.createQuery("from Place", Place.class).getResultList();
        session.close();
        return places;
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
            e.printStackTrace();
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
    public List findBestCostByDate(String sportName, LocalDate startDate, LocalDate endDate) {
        session = HibernateUtil.getSessionFactory().openSession();

        String query = "SELECT p.placeName, s.sportName, s.cost FROM Place p JOIN Sport s ON p.id = " +
                "s.place.id WHERE s.sportName = :sportName AND s.startDate < :startDate AND " +
                "s.endDate > :endDate ORDER BY s.cost asc";
        Query query1 = session.createQuery(query)
                .setParameter("sportName", sportName)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate);
        List<Object[]> bestPlaces = query1.getResultList();
        for(Object[] o:bestPlaces){
            System.out.println(o[0]);
        }
        session.close();
        return bestPlaces;
    }
}
