package com.sda.service;

import com.sda.entity.Place;
import com.sda.entity.Sport;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SportDAO implements IsportDAO {
    Session session;
    @Override
    public List<Sport> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Sport> sports = session.createQuery("from Sport", Sport.class).getResultList();
        session.close();
        return sports;
    }

    @Override
    public Sport findById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Sport sport = session.find(Sport.class, id);
   //     session.close();
        return sport;
    }

    @Override
    public String delete(Sport sport) {
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
          Transaction transaction = session.beginTransaction();
            session.delete(sport);
            session.flush();
            transaction.commit();
            session.close();
            return "Success";
        } catch (Exception e){
            e.printStackTrace();
            return "Failed";
        }
    }

    @Override
    public void insert(Sport sport) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(sport);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Sport sport) {

    }


}
