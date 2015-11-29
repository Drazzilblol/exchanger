package com.epam.training.pas.services;

import com.epam.training.pas.models.Country;
import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface CountryService {
    public List<Country> geCountries();

    public Country getCountryById(int id);

    public void save(Country country);

    public void delete(int countryId);
}
