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

    @Test
    public void crudCurrencyTest() {
        Long generatedCurrencyId;

        Currency c1 = new Currency();
        c1.setName("test currency");
        c1.setCurrencyCode("TCU");
        c1.setSale(55.0);
        c1.setBuy(50.0);
        generatedCurrencyId = currencyService.save(c1);
        c1.setId(generatedCurrencyId);
        Currency c2 = currencyService.getCurrencyById(generatedCurrencyId);
        Assert.assertEquals(c2, c1);

        c1.setName("test currency updated");
        c1.setCurrencyCode("TCD");
        c1.setSale(155.0);
        c1.setBuy(150.0);
        currencyService.update(c1);
        c2 = currencyService.getCurrencyById(generatedCurrencyId);
        Assert.assertEquals(c2, c1);

        Assert.assertEquals(currencyService.delete(generatedCurrencyId), 1);
    }

}
