package com.epam.training.pas;

import com.epam.training.pas.models.Operation;
import com.epam.training.pas.services.OperationService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * Created by Drazz on 29.11.2015.
 */
public class OperationServiceTest extends AbstractSpringTest {

    @Autowired
    private OperationService operationService;

    @Test
    public void crudOperationTest() {
        Long generatedOperationId;

        Operation o1 = new Operation();
        o1.setAccountFromId(2l);
        o1.setAccountToId(3l);
        o1.setCurrencyFromId(1l);
        o1.setCurrencyToId(3l);
        o1.setCurrencyBuy(100.0);
        o1.setCurrencySell(15.3);
        o1.setDate(new Timestamp((System.currentTimeMillis() / 1000) * 1000));
        generatedOperationId = operationService.save(o1);
        o1.setId(generatedOperationId);
        Operation o2 = operationService.getOperationById(generatedOperationId);
        System.out.println(o1);
        System.out.println(o2);
        Assert.assertEquals(o2, o1);

       o1.setAccountFromId(8l);
        o1.setAccountToId(9l);
        o1.setCurrencyFromId(2l);
        o1.setCurrencyToId(4l);
        o1.setCurrencyBuy(150.0);
        o1.setCurrencySell(155.3);
        operationService.update(o1);
        o2 = operationService.getOperationById(generatedOperationId);
        Assert.assertEquals(o2, o1);

        Assert.assertEquals(operationService.delete(generatedOperationId), 1);
    }

}
