package mygroup;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Creation Session Factory failed." +ex);
            throw new ExceptionInInitializerError();
        }

    }

    public static SessionFactory getSessionfactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionfactory().close();
    }
}
