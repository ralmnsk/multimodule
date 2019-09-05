package myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Testing {
    public static void main(String[] args){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(UserDAOConfiguration.class);
        SessionFactory sf=(SessionFactory)ctx.getBean("sessionFactoryOne");
        System.out.println(sf.toString());
        sf.close();
    }
}
