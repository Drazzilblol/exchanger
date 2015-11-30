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

    @Test
    public void crudCountryTest() {
        Long generatedCountryId;

        Country c1 = new Country();
        c1.setName("Test Country");
        c1.setCountryCode("TCO");
        generatedCountryId = countryService.save(c1);
        c1.setId(generatedCountryId);
        Country c2 = countryService.getCountryById(generatedCountryId);
        Assert.assertEquals(c2, c1);

        c1.setName("Test Country Updated");
        c1.setCountryCode("TCU");
        countryService.update(c1);
        c2 = countryService.getCountryById(generatedCountryId);
        Assert.assertEquals(c2, c1);

        Assert.assertEquals(countryService.delete(generatedCountryId), 1);
    }

}
