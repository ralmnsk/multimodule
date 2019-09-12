package service;


import dao.UserDAO;
import model.User;

public interface UserService {
    User findByName(String name);
    void saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    void setUserDAO(UserDAO userDAO);
}
