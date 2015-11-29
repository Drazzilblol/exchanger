package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.CurrencyDao;
import com.epam.training.pas.models.Currency;
import com.epam.training.pas.services.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    private CurrencyDao currencyDao;

    @Override
    public List<Currency> getCurrencies() {
        return currencyDao.getCurrencies();
    }

    @Override
    public Currency getCurrencyById(Long id) {
        return currencyDao.getCurrencyById(id);
    }

    @Override
    public Long save(Currency currency) {
        LOGGER.info("Save currency {}", currency.getName());
        return currencyDao.save(currency);
    }

    @Override
    public void update(Currency currency) {
        LOGGER.info("Update currency {}", currency.getName());
        currencyDao.update(currency);
    }

    @Override
    public int delete(Long currencyId) {
        LOGGER.info("Delete currency with id = {}", currencyId);
        return currencyDao.delete(currencyId);
    }
}
