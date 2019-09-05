package myapp;


import mygroup.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


public class UserDAOImpl implements UserDAO {

   //@Autowired
    private SessionFactory sessionFactory=(SessionFactory)
           new AnnotationConfigApplicationContext(UserDAOConfiguration.class)
           .getBean("sessionFactoryOne");//= HibernateUtil.getSessionfactory();


    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public User findByName(String name) {
        Query query=getCurrentSession()
                .createQuery("from USRTAB where NAME = :paramName");
        query.setParameter("paramName", name);
        User userToFind= (User) query.list().get(0);
        return userToFind;
    }

    @Override
    public void saveUser(User user) {

        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
                session.save(user);
                transaction.commit();
    }

    @Override
    public void deleteUser(User user) {
        Query query=getCurrentSession()
                .createQuery("from USRTAB where NAME = :paramName");
        query.setParameter("paramName", user.getName());
        User userToUpdate= (User) query.list().get(0);
        if (user!=null){
            getCurrentSession().delete(userToUpdate);
        }
    }

    @Override
    public void updateUser(User user) {

        Query query=getCurrentSession()
                .createQuery("from USRTAB where NAME = :paramName");
        query.setParameter("paramName", user.getName());
        User userToUpdate= (User) query.list().get(0);
        if (user!=null){
            userToUpdate.setName(user.getName());
            userToUpdate.setPass(user.getPass());
            userToUpdate.setJoinDate(user.getJoinDate());
            userToUpdate.setRole(user.getRole());
            getCurrentSession().update(userToUpdate);
        }
    }
}
