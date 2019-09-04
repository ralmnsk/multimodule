package myapp;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

   @Autowired
    private SessionFactory sessionFactory;

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
        getCurrentSession().save(user);
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
