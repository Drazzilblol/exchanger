package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.AccountDao;
import com.epam.training.pas.models.Account;
import com.epam.training.pas.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Drazz on 16.11.2015.
 */
@Repository
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    @Override
    public Account getAccountById(int id) {
        return accountDao.getAccountById(id);
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(int accountId) {
        accountDao.delete(accountId);
    }
}
