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

    Currency getCurrencyById(int id);

    void save(Currency currency);

    void delete(Currency currency);
}
