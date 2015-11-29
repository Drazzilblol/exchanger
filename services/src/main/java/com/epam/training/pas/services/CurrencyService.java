package com.epam.training.pas.services;

import com.epam.training.pas.models.Currency;
import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface CurrencyService {
    public List<Currency> getCurrencies();

    public Currency getCurrencyById(Long id);

    public Long save(Currency currency);

    public void update(Currency currency);

    public int delete(Long currencyId);
}
