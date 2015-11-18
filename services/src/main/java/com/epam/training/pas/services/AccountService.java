package com.epam.training.pas.services;

import com.epam.training.pas.models.Account;

import java.util.List;

/**
 * Created by Drazz on 18.11.2015.
 */
public interface AccountService {
    List<Account> getAccounts();

    Account getAccountById(int id);

    void save(Account account);

    void delete(Account account);

    void delete(int accountId);
}
