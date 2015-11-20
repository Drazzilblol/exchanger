package com.epam.training.pas.web;

import com.epam.training.pas.models.User;
import com.epam.training.pas.services.UserService;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Drazz on 20.11.2015.
 */
public class AddUser extends WebPage {

    private TextField usernameInput;
    private TextField passwordInput;
    private String username = "";  // переменная для хранения текста, вводимого в поле ввода
    private String password = ""; // переменная для хранения текста, отображаемого в параграфе

    @SpringBean
    UserService userService;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public AddUser() {

        // ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        //   UserService userService =  context.getBean(UserService.class);
        Injector.get().inject(this);
        Form echoForm = new Form("echoForm");
        usernameInput = new TextField("usernameInput", new PropertyModel(this, "username"));
        passwordInput = new TextField("passwordInput", new PropertyModel(this, "password"));
        echoForm.add(usernameInput);
        echoForm.add(passwordInput);
        echoForm.add(new Button("sendButton") {
            @Override
            public void onSubmit() {
                User u = new User();
                u.setUsername(getUsername());
                u.setPassword(getPassword());
                userService.save(u);
            }
        });
        add(echoForm);

    }
}
