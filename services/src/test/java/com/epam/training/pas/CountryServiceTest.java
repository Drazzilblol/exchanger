package com.epam.training.pas;

import com.epam.training.pas.models.Country;
import com.epam.training.pas.services.CountryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Drazz on 29.11.2015.
 */
public class CountryServiceTest extends AbstractSpringTest {

    @Autowired
    private CountryService countryService;

    private static Long generatedCountryId;

    @Test
    public void saveUserTest() {
        Country c = new Country();
        c.setName("Test Country");
        c.setCountryCode("TCO");
        generatedCountryId = countryService.save(c);
        c.setId(generatedCountryId);
        Assert.assertEquals(countryService.getCountryById(generatedCountryId), c);
    }

    @Test
    public void updateUserTest() {
        Country c = countryService.getCountryById(generatedCountryId);
        c.setName("Test Country Updated");
        c.setCountryCode("TCU");
        countryService.update(c);
        Assert.assertEquals(countryService.getCountryById(generatedCountryId), c);
    }

    @Test
    public void deleteAccountTest() {
        Assert.assertEquals(countryService.delete(generatedCountryId), 1);
    }

}
