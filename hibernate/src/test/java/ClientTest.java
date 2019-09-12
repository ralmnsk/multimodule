import hiber.HibernateConfiguration;
import hiber.HibernateUtil;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.io.IOException;
import java.util.Date;

public class ClientTest {
    public static void main(String[] args) {
        User user=new User("name1", "password", new Date(), "role");
        HibernateConfiguration hc=new HibernateConfiguration();

        try {
            Session session=hc.sessionFactory().openSession();
            session.save(user);
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
