/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 21/7/18
 */
package com.test.api.framework.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Database {

    private static SessionFactory sessionFactory;

    static {
        new Database();
    }

    private Database() {
        Configuration configuration = new Configuration();
        configuration.configure("database.cfg.xml");

        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
