package com.epam.training.pas;

import com.epam.training.pas.models.User;
import com.epam.training.pas.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceTest extends AbstractSpringTest {

    @Autowired
    private UserService userService;

    private static Long generatedUserId;

    @Test
    public void saveUserTest() {
        User u = new User();
        u.setUsername("testUser");
        u.setPassword("testPassword");
        u.setUserProfileId(1l);
        u.setAdmin(false);
        generatedUserId = userService.save(u);
        u.setId(generatedUserId);
        Assert.assertEquals(userService.getUserById(generatedUserId), u);
    }

    @Test
    public void updateUserTest() {
        User u = userService.getUserById(generatedUserId);
        u.setUsername("updatedTestUser");
        u.setPassword("updatedTestPassword");
        u.setUserProfileId(1l);
        u.setAdmin(true);
        userService.update(u);
        Assert.assertEquals(userService.getUserById(generatedUserId), u);
    }

    @Test
    public void deleteAccountTest() {
        Assert.assertEquals(userService.delete(generatedUserId), 1);
    }

}
