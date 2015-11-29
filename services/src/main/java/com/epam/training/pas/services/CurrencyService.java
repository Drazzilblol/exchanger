package com.epam.training.pas.services;

import com.epam.training.pas.models.Currency;
import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface CurrencyService {
    public List<Currency> getCurrencies();

    public Currency getCurrencyById(int id);

    public void save(Currency currency);

    public void delete(int currencyId);
}
