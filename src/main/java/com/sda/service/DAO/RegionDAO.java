package com.sda.service.DAO;

import com.sda.entity.Region;
import com.sda.hibernate_utils.HibernateUtil;
import com.sda.service.I_DAO.IRegionDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegionDAO implements IRegionDAO {

    Session session;

    @Override
    public List<Region> findAllRegions() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Region> regions = session.createQuery("from Region", Region.class).getResultList();
        regions.forEach(c-> c.getCountry());

        session.close();
        return regions;
    }

    @Override
    public String deleteRegion(Region region) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(region);
            transaction.commit();
            session.close();
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }
    }

    @Override
    public void insertRegion(Region region) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(region);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateRegion(Region region) {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.update(region);
        transaction.commit();
        session.close();
    }

    @Override
    public Region findRegionById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Region region = session.find(Region.class, id);
        session.close();
        return region;
    }
}
