package com.epam.training.pas;

import com.epam.training.pas.models.Margin;
import com.epam.training.pas.services.MarginService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * Created by Drazz on 30.11.2015.
 */
public class MarginServiceTest extends AbstractSpringTest {

    @Autowired
    private MarginService marginService;

    @Test
    public void crudMarginTest() {
        Long generatedMarginId;

        Margin m1 = new Margin();
        m1.setCurrencyId(1l);
        m1.setValue(0.20);
        m1.setCreationDate(new Timestamp((System.currentTimeMillis() / 1000)*1000));
        generatedMarginId = marginService.save(m1);
        m1.setId(generatedMarginId);
        Margin m2 = marginService.getMarginById(generatedMarginId);
        Assert.assertEquals(m2, m1);

        m1.setCurrencyId(1l);
        m1.setValue(0.30);
        marginService.update(m1);
        m2 = marginService.getMarginById(generatedMarginId);
        Assert.assertEquals(m2, m1);

        Assert.assertEquals(marginService.delete(generatedMarginId), 1);
    }

}
