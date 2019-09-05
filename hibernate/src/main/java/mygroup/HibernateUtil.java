package mygroup;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {
    private static final SessionFactory sessionFactory=buildSessionFactory();


    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");

            ServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties())
                            .build();
            System.out.println("Hibernate serviceRegistry created");

            SessionFactory sessionFactory =
                    configuration
                            .buildSessionFactory(serviceRegistry);
            System.out.println(sessionFactory.toString());
            return sessionFactory;
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
