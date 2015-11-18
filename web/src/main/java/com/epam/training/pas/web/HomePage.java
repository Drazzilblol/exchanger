package com.epam.training.pas.web;

import com.epam.training.pas.services.AccountService;
import com.epam.training.pas.services.UserService;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;


	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        // System.out.println(context.getBeanDefinitionNames()[2]);
        UserService userService =  context.getBean(UserService.class);
      //  AccountService accountService = context.getBean(AccountService.class);

        // Add the simplest type of label
        add(new Label("message", userService.getUserById(10).getUsername()));

        // TODO Add your page's components here
    }
}
