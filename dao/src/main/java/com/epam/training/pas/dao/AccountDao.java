package com.epam.training.pas.dao;

import com.epam.training.pas.models.Account;
import com.epam.training.pas.models.Operation;
import com.epam.training.pas.models.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Drazz on 18.11.2015.
 */
public interface AccountDao extends Serializable {
    List<Account> getAccounts();

    List<Account> getAccountsByUser(User user);

    Account getAccountById(int id);

    void save(Account account);

    void delete(int accountId);
}
