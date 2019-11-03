package com.sda.service;

import com.sda.entity.Sport;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SportDao implements IsportDAO {


    private static final Logger logger = Logger.getLogger(SportDao.class.getName());
    private static Session session;
    private static Transaction tx;

    private static void startOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();


    }

    @Override
    public List<Sport> findAll() {
        return null;
    }

    @Override
    public String delete(Sport sport) {
        return null;
    }

    @Override
    public void insert(Sport sport) {

    }

    @Override
    public void update(Sport sport) {

    }
}
