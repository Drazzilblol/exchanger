package com.epam.training.pas.services;

import com.epam.training.pas.models.Currency;
import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface CurrencyService {
    List<Currency> getCurrencies();

    Currency getCurrencyById(Long id);

    Long save(Currency currency);

    void update(Currency currency);

    int delete(Long currencyId);
}
