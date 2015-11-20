package com.epam.training.pas.web;

import com.epam.training.pas.services.UserService;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Homepage
 */
public class HomePage extends WebPage {

    public HomePage(final PageParameters parameters) {

        add(new BookmarkablePageLink("userList", UserList.class));
        add(new BookmarkablePageLink("newUser", AddUser.class));

    }
}
