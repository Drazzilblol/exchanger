package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.CurrencyDao;
import com.epam.training.pas.models.Currency;
import com.epam.training.pas.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyDao currencyDao;

    @Override
    public List<Currency> getCurrencies() {
        return currencyDao.getCurrencies();
    }

    @Override
    public Currency getCurrencyById(int id) {
        return currencyDao.getCurrencyById(id);
    }

    @Override
    public void save(Currency currency) {
        currencyDao.save(currency);
    }

    @Override
    public void delete(int currencyId) {
        currencyDao.delete(currencyId);
    }
}
