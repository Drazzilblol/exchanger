package com.epam.training.pas;

import com.epam.training.pas.models.UserProfile;
import com.epam.training.pas.services.UserProfileService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Drazz on 29.11.2015.
 */
public class UserProfileServiceTest extends AbstractSpringTest {


    @Autowired
    private UserProfileService userProfileService;

    private static Long generatedUserProfileId;

    @Test
    public void saveUserTest() {
        UserProfile up = new UserProfile();
        up.setFirstName("Andrew");
        up.setLastName("Ivanov");
        up.setPassportNumber("kh12345");
        up.setUserId(2l);
        up.setCountryId(1l);
        up.setEmail("pas@mail.ru");
        generatedUserProfileId = userProfileService.save(up);
        up.setId(generatedUserProfileId);
        Assert.assertEquals(userProfileService.getUserProfileById(generatedUserProfileId), up);
    }

    @Test
    public void updateUserTest() {
        UserProfile up = userProfileService.getUserProfileById(generatedUserProfileId);
        up.setFirstName("Ivan");
        up.setLastName("Andreev");
        up.setPassportNumber("kh5432");
        up.setUserId(2l);
        up.setCountryId(1l);
        up.setEmail("vna@mail.ru");
        userProfileService.update(up);
        Assert.assertEquals(userProfileService.getUserProfileById(generatedUserProfileId), up);
    }

    @Test
    public void deleteAccountTest() {
        Assert.assertEquals(userProfileService.delete(generatedUserProfileId), 1);
    }

}
