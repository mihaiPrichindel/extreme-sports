import com.sda.entity.Sport;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    Session session;
    Transaction tx;
    public static void main(String[] args) {

        Main main = new Main();
        main.findAll();
    }
    public List findAll() {
        List<Sport> sports = new ArrayList<Sport>();
        try {
            startOperation();
            Query query = session.createQuery("FROM Sport");
            sports = query.getResultList();
        } catch (HibernateException e) {
            logger.severe("could not find any sports");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return sports;
    }
    private void startOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }
}

