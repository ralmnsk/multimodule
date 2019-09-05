package myapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("myapp")
public class UserServiceConfiguration {

    @Bean("userDAO")
    public UserDAO userDAO(){
        return new UserDAOImpl();
    }
}
