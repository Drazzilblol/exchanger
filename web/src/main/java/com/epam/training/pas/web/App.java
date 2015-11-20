package com.epam.training.pas.web;

import com.epam.training.pas.models.Account;
import com.epam.training.pas.models.User;
import com.epam.training.pas.services.AccountService;
import com.epam.training.pas.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Drazz on 16.11.2015.
 */

public class App {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
       // System.out.println(context.getBeanDefinitionNames()[2]);
        UserService userService =  context.getBean(UserService.class);
        AccountService accountService = context.getBean(AccountService.class);

        Account a = new Account();
        a.setName("test");
        a.setUserId(10);
        a.setValue(120000.0);
        a.setCurrencyId(1);

        accountService.save(a);


    }
}
