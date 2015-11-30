package com.epam.training.pas;

import com.epam.training.pas.models.Account;
import com.epam.training.pas.services.AccountService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Drazz on 29.11.2015.
 */
public class AccountServiceTest extends AbstractSpringTest {


    @Autowired
    private AccountService accountService;

    @Test
    public void exchangeTest() {
        Account a1 = new Account();
        a1.setName("testAccount1");
        a1.setValue(100.0);
        a1.setCurrencyId(1l);
        a1.setUserId(2l);
        a1.setId(accountService.save(a1));

        Account a2 = new Account();
        a2.setName("testAccount2");
        a2.setValue(100.0);
        a2.setCurrencyId(3l);
        a2.setUserId(2l);
        a2.setId(accountService.save(a2));

        accountService.makeExchange(a1, a2, 100.0);

        Double value =accountService.getAccountById(a2.getId()).getValue();
        Assert.assertEquals(value, 200, 0.00001);
       // Assert.assertEquals(value, a2.getValue(), 0.00001);

        accountService.delete(a1.getId());
        accountService.delete(a2.getId());

    }

    @Test
    public void crudAccountTest() {
        Long generatedAccountId;

        Account a1 = new Account();
        a1.setName("testAccount");
        a1.setValue(100.0);
        a1.setCurrencyId(1l);
        a1.setUserId(2l);
        generatedAccountId = accountService.save(a1);
        a1.setId(generatedAccountId);
        Account a2 = accountService.getAccountById(generatedAccountId);
        Assert.assertEquals(a2, a1);

        a1.setName("updatedTestAccount");
        a1.setValue(150.0);
        a1.setCurrencyId(2l);
        accountService.update(a1);
        a2 = accountService.getAccountById(generatedAccountId);
        Assert.assertEquals(a2, a1);

        Assert.assertEquals(accountService.delete(generatedAccountId), 1);
    }

}