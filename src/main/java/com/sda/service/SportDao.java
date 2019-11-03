package com.sda.service;

import com.sda.entity.Sport;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class SportDao implements ISportDao {
    public List<Sport> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Sport> sport = session.createQuery("from Sport", Sport.class).getResultList();

        return sport;
    }

    public String delete(Sport sport) {
        return null;
    }

    public void insert(Sport sport) {

    }

    public void update(Sport sport) {

    }
}
