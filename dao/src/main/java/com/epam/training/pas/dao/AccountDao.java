package com.epam.training.pas.dao;

import com.epam.training.pas.models.Account;
import com.epam.training.pas.models.Operation;

import java.util.List;

/**
 * Created by Drazz on 18.11.2015.
 */
public interface AccountDao {
    List<Account> geAccounts();

    Account getAccountById(int id);

    void save(Account account);

    void delete(Account account);
}
