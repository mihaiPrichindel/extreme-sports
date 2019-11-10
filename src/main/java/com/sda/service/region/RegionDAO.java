package com.sda.service.region;

import com.sda.entity.Region;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegionDAO implements IRegionDAO {
    Session session;
    Transaction tx;

    @Override
    public List<Region> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Region> allRegions = session.createQuery("FROM Region", Region.class).getResultList();
        for (Region r : allRegions) {
            r.getCities().size();
        }
        session.close();
        return allRegions;
    }

    @Override
    public Region findById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Region region = session.find(Region.class, id);

        session.close();
        return region;
    }

    @Override
    public void insert(Region region) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(region);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Region region) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.update(region);
        tx.commit();
        session.close();
    }

    @Override
    public String delete(Region region) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.delete(region);
        tx.commit();
        session.close();
        return "Region deleted!";
    }

}
