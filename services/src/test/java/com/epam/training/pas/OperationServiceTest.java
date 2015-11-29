package com.epam.training.pas;

import com.epam.training.pas.models.Operation;
import com.epam.training.pas.services.OperationService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Drazz on 29.11.2015.
 */
public class OperationServiceTest extends AbstractSpringTest {

    @Autowired
    private OperationService operationService;

    private static Long generatedOperationId;

    @Test
    public void saveUserTest() {
        Operation o = new Operation();
        o.setAccountFromId(2l);
        o.setAccountToId(3l);
        o.setCurrencyFromId(1l);
        o.setCurrencyToId(3l);
        o.setCurrencyBuy(100.0);
        o.setCurrencySell(15.3);
        generatedOperationId = operationService.save(o);
        o.setId(generatedOperationId);
        Assert.assertEquals(operationService.getOperationById(generatedOperationId), o);
    }

    @Test
    public void updateUserTest() {
        Operation o = operationService.getOperationById(generatedOperationId);
        Operation operation = new Operation();
        operation.setAccountFromId(8l);
        operation.setAccountToId(9l);
        operation.setCurrencyFromId(2l);
        operation.setCurrencyToId(4l);
        operation.setCurrencyBuy(150.0);
        operation.setCurrencySell(155.3);
        operationService.update(o);
        Assert.assertEquals(operationService.getOperationById(generatedOperationId), o);
    }

    @Test
    public void deleteAccountTest() {
        Assert.assertEquals(operationService.delete(generatedOperationId), 1);
    }
}
