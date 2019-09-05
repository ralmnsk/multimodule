package myapp;

import java.sql.SQLException;
import java.util.Date;

import myapp.User;

import myapp.UserService;
import myapp.UserServiceImpl;
import mygroup.HibernateUtil;

public class Domain {
    private static final long ID=1L;
    private static final String NAME="Fuser";
    private static final String PASSWORD="pass2";
    private static final String ROLE="U";
    private static final Date JOININGDATE=new Date();

    public static void main(String[] a) throws SQLException{
        UserService userService=new UserServiceImpl();
        User user=new User(NAME, PASSWORD, JOININGDATE, ROLE);
        user.setId(1L);
        userService.saveUser(user);
        HibernateUtil.shutdown();
    }
}
