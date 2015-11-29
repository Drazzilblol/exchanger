package com.epam.training.pas.services;

import com.epam.training.pas.models.Account;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Drazz on 18.11.2015.
 */
public interface AccountService extends Serializable {
    void makeExchange(Account from, Account to, Double value);

    List<Account> getAccounts();

    Account getAccountById(Long id);

    Long save(Account account);

    void update(Account account);

    int delete(Long accountId);
}
