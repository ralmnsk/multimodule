package myapp;


public interface UserDAO {
    User findByName(String name);
    void saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
