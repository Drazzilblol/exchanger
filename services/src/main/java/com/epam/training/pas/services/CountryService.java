package com.epam.training.pas.services;

import com.epam.training.pas.models.Country;
import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface CountryService {
    public List<Country> geCountries();

    public Country getCountryById(Long id);

    public Long save(Country country);

    public void update(Country country);

    public int delete(Long countryId);
}
