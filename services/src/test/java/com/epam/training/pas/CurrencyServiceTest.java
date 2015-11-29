package com.epam.training.pas;

import com.epam.training.pas.models.Currency;
import com.epam.training.pas.services.CurrencyService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Drazz on 29.11.2015.
 */
public class CurrencyServiceTest extends AbstractSpringTest {

    @Autowired
    private CurrencyService currencyService;

    private static Long generatedCurrencyId;

    @Test
    public void saveUserTest() {
        Currency c = new Currency();
        c.setName("test currency");
        c.setCurrencyCode("TCU");
        c.setSale(55.0);
        c.setBuy(50.0);
        generatedCurrencyId = currencyService.save(c);
        c.setId(generatedCurrencyId);
        Assert.assertEquals(currencyService.getCurrencyById(generatedCurrencyId), c);
    }

    @Test
    public void updateUserTest() {
        Currency c = currencyService.getCurrencyById(generatedCurrencyId);
        c.setName("test currency updated");
        c.setCurrencyCode("TCD");
        c.setSale(155.0);
        c.setBuy(150.0);
        currencyService.update(c);
        Assert.assertEquals(currencyService.getCurrencyById(generatedCurrencyId), c);
    }

    @Test
    public void deleteAccountTest() {
        Assert.assertEquals(currencyService.delete(generatedCurrencyId), 1);
    }

}
