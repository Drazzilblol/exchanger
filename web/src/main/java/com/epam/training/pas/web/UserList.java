package com.epam.training.pas.web;

import com.epam.training.pas.models.User;
import com.epam.training.pas.services.UserService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Drazz on 20.11.2015.
 */
public class UserList extends WebPage {
    public UserList(final PageParameters parameters) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = context.getBean(UserService.class);

        //  add(new Label("message", userService.getUserById(10).getUsername()));
        List<String> list = new ArrayList<>();
        for (User u : userService.getUsers()) {
            list.add(u.getId() + " " + u.getUsername() + " " + u.getPassword());
        }
        ListView listview = new ListView("listview", list) {
            protected void populateItem(ListItem item) {
                item.add(new Label("label", item.getModel()));
            }
        };
        add(listview);

    }
}
