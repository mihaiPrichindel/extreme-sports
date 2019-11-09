import com.sda.client.SportClient;
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

public class DAO {

    private static final Logger logger = Logger.getLogger(SportClient.class.getName());
    private static Session session;
    private static Transaction tx;

    private static void startOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

    public static List findAll() {
        List<Sport> sports = new ArrayList<>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Sport");
            sports = query.list();
        } catch (HibernateException e) {
            logger.severe("could not find any sports");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return sports;
    }

    public void create(Sport sport) {
        try {
            startOperation();
            session.save(sport);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save sport");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(Sport sport) {
        try {
            startOperation();
            session.update(sport);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update sport " + sport);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Sport sport) {
        try {
            startOperation();
            session.delete(sport);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete sport " + sport);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
