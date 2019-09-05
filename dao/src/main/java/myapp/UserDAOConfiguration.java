package myapp;

import mygroup.HibernateUtil;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("mygroup")
public class UserDAOConfiguration {

    @Bean("sessionFactoryOne")
    public SessionFactory sessionFactory(){
        return HibernateUtil.getSessionfactory();
    }

}
