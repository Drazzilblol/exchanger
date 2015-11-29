package com.epam.training.pas.dao;

import com.epam.training.pas.models.Currency;
import com.epam.training.pas.models.Operation;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Drazz on 16.11.2015.
 */
public interface CurrencyDao extends Serializable {

    List<Currency> getCurrencies();

    Currency getCurrencyById(Long id);

    Long save(Currency currency);

    void update(Currency currency);

    int delete(Long currencyId);
}
