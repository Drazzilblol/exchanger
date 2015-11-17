package com.epam.training.pas.web;

import com.epam.training.pas.services.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Drazz on 16.11.2015.
 */
public class App {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
       // System.out.println(context.getBeanDefinitionNames()[2]);
        CustomerService customerService =  context.getBean(CustomerService.class);
        System.out.println(customerService.getUserById(4).getUsername());
    }
}
