package ir.maktab.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseAccess {
    public static SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}



