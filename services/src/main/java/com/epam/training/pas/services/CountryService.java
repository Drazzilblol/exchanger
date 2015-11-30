package com.epam.training.pas.services;

import com.epam.training.pas.models.Country;
import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface CountryService {
    List<Country> geCountries();

    Country getCountryById(Long id);

    Long save(Country country);

    void update(Country country);

    int delete(Long countryId);
}
