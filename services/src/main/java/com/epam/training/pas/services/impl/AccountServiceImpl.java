package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.AccountDao;
import com.epam.training.pas.dao.CurrencyDao;
import com.epam.training.pas.dao.MarginDao;
import com.epam.training.pas.dao.OperationDao;
import com.epam.training.pas.models.Account;
import com.epam.training.pas.models.Currency;
import com.epam.training.pas.models.Operation;
import com.epam.training.pas.services.AccountService;
import com.epam.training.pas.services.MarginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Drazz on 16.11.2015.
 */
@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private MarginService marginService;
    @Autowired
    private CurrencyDao currencyDao;
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private OperationDao operationDao;


    @Override
    public void makeExchange(Account from, Account to, Double value) {

        Currency currencySell = currencyDao.getCurrencyById(from.getCurrencyId());
        Currency currencyBuy = currencyDao.getCurrencyById(to.getCurrencyId());
        Account bankTo = accountDao.getBankAccount(currencySell.getId());
        Account bankFrom = accountDao.getBankAccount(currencyBuy.getId());
        Double margin = marginService.calculateTotalMargin(marginService.getMarginsByCurrencyId(currencyBuy.getId()));
        Double sellCurrencyValue = (currencyBuy.getBuy() * (margin + 1) * value) / currencySell.getSale();

        bankTo.setValue(bankTo.getValue() + sellCurrencyValue);
        from.setValue(from.getValue() - sellCurrencyValue);
        bankFrom.setValue(bankFrom.getValue() - value);
        to.setValue(to.getValue() + value);
        LOGGER.info("Exchange: account {} -{}, account {} +{}", from.getName(), sellCurrencyValue, to.getName(), value);
        accountDao.update(from);
        accountDao.update(to);
        accountDao.update(bankTo);
        accountDao.update(bankFrom);

        Operation operation = new Operation();
        operation.setAccountFromId(from.getId());
        operation.setAccountToId(to.getId());
        operation.setCurrencyFromId(currencySell.getId());
        operation.setCurrencyToId(currencyBuy.getId());
        operation.setCurrencyBuy(value);
        operation.setCurrencySell(sellCurrencyValue);
        operationDao.save(operation);
    }

    @Override
    public List<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountDao.getAccountById(id);
    }

    @Override
    public Long save(Account account) {
        LOGGER.info("Save account {}", account.getName());
        return accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        LOGGER.info("Update account {}", account.getName());
        accountDao.update(account);
    }

    @Override
    public int delete(Long accountId) {
        LOGGER.info("Delete account with id = {}", accountId);
        operationDao.deleteByAccountId(accountId);
        return accountDao.delete(accountId);
    }
}
