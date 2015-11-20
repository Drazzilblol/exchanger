package com.epam.training.pas.web;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * Created by Drazz on 18.11.2015.
 */
public class WicketApplication extends WebApplication {

    public WicketApplication()
    {
    }

    public Class getHomePage()
    {
        return HomePage.class;
    }

    @Override
    protected void init()
    {

        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        mountPage("/new", AddUser.class);
    }



}