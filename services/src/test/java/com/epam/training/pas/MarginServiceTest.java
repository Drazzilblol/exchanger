package com.epam.training.pas;

import com.epam.training.pas.models.Margin;
import com.epam.training.pas.services.MarginService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Drazz on 30.11.2015.
 */
public class MarginServiceTest extends AbstractSpringTest {

    @Autowired
    private MarginService marginService;

    private static Long generatedMarginId;

    @Test
    public void saveUserTest() {
        Margin m = new Margin();
        m.setCurrencyId(1l);
        m.setValue(0.20);
        generatedMarginId = marginService.save(m);
        m.setId(generatedMarginId);
        Assert.assertEquals(marginService.getMarginById(generatedMarginId), m);
    }

    @Test
    public void updateUserTest() {
        Margin m = new Margin();
        m.setCurrencyId(1l);
        m.setValue(0.30);
        marginService.update(m);
        Assert.assertEquals(marginService.getMarginById(generatedMarginId), m);
    }

    @Test
    public void deleteAccountTest() {
        Assert.assertEquals(marginService.delete(generatedMarginId), 1);
    }

}
