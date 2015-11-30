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

    @Test
    public void crudUserProfileTest() {
        Long generatedUserProfileId;

        UserProfile up1 = new UserProfile();
        up1.setFirstName("Andrew");
        up1.setLastName("Ivanov");
        up1.setPassportNumber("kh12345");
        up1.setUserId(2l);
        up1.setCountryId(1l);
        up1.setEmail("pas@mail.ru");
        generatedUserProfileId = userProfileService.save(up1);
        up1.setId(generatedUserProfileId);
        UserProfile up2 = userProfileService.getUserProfileById(generatedUserProfileId);
        Assert.assertEquals(up2, up1);

        up1.setFirstName("Ivan");
        up1.setLastName("Andreev");
        up1.setPassportNumber("kh5432");
        up1.setUserId(2l);
        up1.setCountryId(1l);
        up1.setEmail("vna@mail.ru");
        userProfileService.update(up1);
        up2 = userProfileService.getUserProfileById(generatedUserProfileId);
        Assert.assertEquals(up2, up1);

        Assert.assertEquals(userProfileService.delete(generatedUserProfileId), 1);
    }

}
