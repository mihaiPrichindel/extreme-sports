package com.sda.hibernate_utils;

import com.sda.entity.Sport;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {

        Configuration configuration = createConfig();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static Configuration createConfig() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();

        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/extreme_sports?serverTimezone=UTC");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "@BoogieStreet");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Sport.class);

        return configuration;
    }
}
