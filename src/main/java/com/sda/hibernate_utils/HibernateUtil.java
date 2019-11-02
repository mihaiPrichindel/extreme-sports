package com.sda.hibernate_utils;

import com.sda.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // session factory
    public static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        // load up the config
        Configuration configuration = createConfig();

        // build service registry using prop in the config
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        // build the session factory from the service reg
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static Configuration createConfig() {
        Configuration configuration = new Configuration();

        // map with keys and values for properties, Properties class
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate?serverTimezone=UTC");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "SDAcad3m!2019");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        settings.put(Environment.SHOW_SQL, "true"); // when hib access show code written
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop"); // data def language, schema tables, alter & drop, hiber create data def,
        configuration.setProperties(settings);

        // add annotated class
        configuration.addAnnotatedClass(Country.class);
        configuration.addAnnotatedClass(Region.class);
        configuration.addAnnotatedClass(City.class);
        configuration.addAnnotatedClass(Place.class);
        configuration.addAnnotatedClass(Sport.class);



        return configuration;
    }
}
