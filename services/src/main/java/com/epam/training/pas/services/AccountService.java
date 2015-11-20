package com.epam.training.pas.services;

import com.epam.training.pas.models.Account;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Drazz on 18.11.2015.
 */
public interface AccountService extends Serializable {
    List<Account> getAccounts();

    Account getAccountById(int id);

    void save(Account account);

    void delete(Account account);

    void delete(int accountId);
}
