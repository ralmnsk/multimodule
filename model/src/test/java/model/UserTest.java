package model;

import mymodel.User;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getId() {
        User user=new User();
        user.setId(1L);
        assertThat(1L, is(user.getId()));
    }

    @Test
    public void setId() {
        User user=new User();
        user.setId(1L);
        user.setId(2L);
        assertThat(2L, is(user.getId()));
    }

    @Test
    public void getName() {
        User user=new User();
        user.setName("Spiderman");
        assertThat("Spiderman", is(user.getName()));
    }

    @Test
    public void setName() {
        User user=new User();
        user.setName("Batman");
        user.setName("Spiderman");
        assertThat("Spiderman", is(user.getName()));
    }

    @Test
    public void getPass() {
        User user=new User();
        user.setPass("Batman1");
        assertThat("Batman1", is(user.getPass()));
    }

    @Test
    public void setPass() {
        User user=new User();
        user.setPass("Batman1");
        user.setPass("Batman2");
        assertThat("Batman2", is(user.getPass()));
    }

    @Test
    public void getJoinDate() {
        User user=new User();
        Date date=new Date();
        user.setJoinDate(date);
        assertThat(date, is(user.getJoinDate()));
    }

    @Test
    public void setJoinDate() {
        User user=new User();
        Date date=new Date();
        Date date2=new Date();
        user.setJoinDate(date);
        user.setJoinDate(date2);
        assertThat(date2, is(user.getJoinDate()));
    }

    @Test
    public void getRole() {
        User user=new User();
        user.setRole("u");
        assertThat("u", is(user.getRole()));
    }

    @Test
    public void setRole() {
        User user=new User();
        user.setRole("h");
        user.setRole("u");
        assertThat("u", is(user.getRole()));
    }

    @Test
    public void toString1() {
        Date date=new Date();
        User user=new User("Spiderman", "pass",date,"u");
        user.setId(1L);
        assertThat("User{" +
                "id=" + "1" +
                ", name='" + "Spiderman" + '\'' +
                ", pass='" + "pass" + '\'' +
                ", joinDate=" + date +
                ", role='" + "u" + '\'' +
                '}', is(user.toString()));
    }
}