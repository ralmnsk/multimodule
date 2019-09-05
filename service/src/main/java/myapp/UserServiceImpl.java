package myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDAO")
//    @Lazy
    private UserDAO userDAO; //=new UserDAOImpl();

//
//    public void setUserDAO(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }

    @Override
    public User findByName(String name) {
        return userDAO.findByName(name);
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}
