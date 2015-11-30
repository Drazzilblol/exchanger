package com.epam.training.pas;

import com.epam.training.pas.models.User;
import com.epam.training.pas.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceTest extends AbstractSpringTest {

    @Autowired
    private UserService userService;

    @Test
    public void crudUserTest() {
        Long generatedUserId;

        User u1 = new User();
        u1.setUsername("testUser");
        u1.setPassword("testPassword");
        u1.setUserProfileId(1l);
        u1.setAdmin(false);
        generatedUserId = userService.save(u1);
        u1.setId(generatedUserId);
        User u2 = userService.getUserById(generatedUserId);
        Assert.assertEquals(u2, u1);

        u1.setUsername("updatedTestUser");
        u1.setPassword("updatedTestPassword");
        u1.setUserProfileId(1l);
        u1.setAdmin(true);
        userService.update(u1);
        u2 = userService.getUserById(generatedUserId);
        Assert.assertEquals(u2, u1);

        Assert.assertEquals(userService.delete(generatedUserId), 1);
    }


}
