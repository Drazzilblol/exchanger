package com.epam.training.pas;

import com.epam.training.pas.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceTest extends AbstractSpringTest {

    @Autowired
    private UserService userService;

    @Test
    public void salaryPaymentTest() {
        Assert.assertEquals("test",
                userService.getUserById(10).getUsername());

    }

}
