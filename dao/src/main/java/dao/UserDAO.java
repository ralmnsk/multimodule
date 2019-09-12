package dao;


import model.User;
import org.hibernate.SessionFactory;

public interface UserDAO {
    User findByName(String name);
    void saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    void setSessionFactory(SessionFactory sessionFactory);
}
