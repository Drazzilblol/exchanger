package com.epam.training.pas.web;

import com.epam.training.pas.models.User;
import com.epam.training.pas.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Drazz on 16.11.2015.
 */
@ContextConfiguration
public class App {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
       // System.out.println(context.getBeanDefinitionNames()[2]);
        UserService userService =  context.getBean(UserService.class);
        User u = new User();
        u.setUsername("test");
        u.setPassword("test");
        userService.save(u);
       // User us = userService.getUserById(1);
        userService.deleteById(11);

    }
}
